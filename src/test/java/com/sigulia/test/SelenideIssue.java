package com.sigulia.test;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class SelenideIssue {

    SelenideElement searchInput = $(".header-search-input");
    String nameRepository = "DoraSigulia/DemoQA_Sigulia",
            namePage = "Issue",
            numberIssue = "#2";


    @Test
    public void testGithubIssue () {
        SelenideLogger.addListener("allure", new AllureSelenide());
        open("https://github.com/");
        searchInput.click();
        searchInput.sendKeys(nameRepository);
        searchInput.submit();
        $(linkText(nameRepository)).click();
        $(partialLinkText(namePage)).click();
        $(withText(numberIssue)).click();


    }
}

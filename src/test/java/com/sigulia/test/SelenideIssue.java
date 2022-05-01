package com.sigulia.test;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class SelenideIssue {

    SelenideElement searchInput = $(".header-search-input");
    String  nameWebsite = "https://github.com/",
            nameRepository = "DoraSigulia/DemoQA_Sigulia",
            namePage = "Issue",
            numberIssue = "#2";


    @Test
    public void testGithubIssueListener () {
        SelenideLogger.addListener("allure", new AllureSelenide());
        open(nameWebsite);
        searchNameRepository(nameRepository);
        $(linkText(nameRepository)).click();
        $(partialLinkText(namePage)).click();
        $(withText(numberIssue)).click();

    }

    @Test
    public void testGithubIssueLambda () {
        SelenideLogger.addListener("allure", new AllureSelenide());
        step("Открываем главную страницу" + nameWebsite, () -> {
            open(nameWebsite);
        });
        step("Находим репозиторий " + nameRepository, () -> {
            searchNameRepository(nameRepository);
        });
        step("Переходим на репозиторий " + nameRepository, () -> {
            $(linkText(nameRepository)).click();
        });
        step("Переходим на вкладку " + namePage, () -> {
            $(partialLinkText(namePage)).click();
        });
        step("Переходим на " + namePage + " с номером" + numberIssue, () -> {
            $(withText(numberIssue)).click();
        });
    }

    private void searchNameRepository(String nameRepository) {
        searchInput.click();
        searchInput.sendKeys(nameRepository);
        searchInput.submit();
    }

}

package com.sigulia.pages;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.nio.charset.StandardCharsets;

public class WebSteps {

    GithubPages githubTest = new GithubPages();

    @Step("Открываем главную страницу {nameWebsite}")
    public void openPage (String nameWebsite) {
        githubTest.openPage(nameWebsite);
        attachScreenshot();
        attachPageSource();
    }

    @Step("Находим и переходим на репозиторий {nameRepository}")
    public void searchNameRepository (String nameRepository) {
        githubTest.searchNameRepository(nameRepository);
        attachScreenshot();
        attachPageSource();
    }

    @Step("Переходим на вкладку {namePage}")
    public void clickOnIssue (String namePage) {
        githubTest.clickOnIssue(namePage);
        attachScreenshot();
        attachPageSource();
    }

    @Step("Проверяем наличие Issue с номером {numberIssue}")
    public void visibleNumberIssue(String numberIssue) {
        githubTest.visibleNumberIssue(numberIssue);
        attachScreenshot();
        attachPageSource();
    }

    @Attachment(value = "Скриншот", type = "image/png", fileExtension = "png")
    public byte[] attachScreenshot () {
        return ((TakesScreenshot)WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }

    @Attachment(value = "PageSource", type = "text/html", fileExtension = "html")
    public byte[] attachPageSource () {
        return WebDriverRunner.getWebDriver().getPageSource().getBytes(StandardCharsets.UTF_8);
    }

}

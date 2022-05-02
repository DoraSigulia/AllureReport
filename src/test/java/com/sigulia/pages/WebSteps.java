package com.sigulia.pages;

import io.qameta.allure.Step;

public class WebSteps {

    GithubPages githubTest = new GithubPages();

    @Step("Открываем главную страницу {nameWebsite}")
    public void openPage (String nameWebsite) {
        githubTest.openPage(nameWebsite);
    }

    @Step("Находим и переходим на репозиторий {nameRepository}")
    public void searchNameRepository (String nameRepository) {
        githubTest.searchNameRepository(nameRepository);
    }

    @Step("Переходим на вкладку {namePage}")
    public void clickOnIssue (String namePage) {
        githubTest.clickOnIssue(namePage);
    }

    @Step("Проверяем наличие Issue с номером {numberIssue}")
    public void visibleNumberIssue(String numberIssue) {
        githubTest.visibleNumberIssue(numberIssue);
    }
}

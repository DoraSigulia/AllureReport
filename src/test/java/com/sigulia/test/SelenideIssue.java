package com.sigulia.test;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.sigulia.pages.GithubPages;
import com.sigulia.pages.WebSteps;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static io.qameta.allure.Allure.step;


public class SelenideIssue {

    String  nameWebsite = "https://github.com/",
            nameRepository = "DoraSigulia/DemoQA_Sigulia",
            namePage = "Issue",
            numberIssue = "#2";

    GithubPages githubTest = new GithubPages();

    @Test
    @Owner("sigulia")
    @Feature("Задачи в репозитории")
    @Story("Тест с применением Listener, проверка наличия Issue #2")
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Чистый Selenide (с Listener)")
    @Link(value = "Github", url = "https://github.com/")
    public void testGithubIssueListener () {
        SelenideLogger.addListener("allure", new AllureSelenide());
        githubTest.openPage(nameWebsite)
                .searchNameRepository(nameRepository)
                .clickOnIssue(namePage)
                .visibleNumberIssue(numberIssue);
    }

    @Test
    @Owner("sigulia")
    @Feature("Задачи в репозитории")
    @Story("Тест с применением Lambda, проверка наличия Issue #2")
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Лямбда шаги через step (name, () -> {})")
    @Link(value = "Github", url = "https://github.com/")
    public void testGithubIssueLambda () {
        SelenideLogger.addListener("allure", new AllureSelenide());
        step("Открываем главную страницу" + nameWebsite, () -> {
            githubTest.openPage(nameWebsite);
        });
        step("Находим и переходим на репозиторий " + nameRepository, () -> {
            githubTest.searchNameRepository(nameRepository);
        });
        step("Переходим на вкладку " + namePage, () -> {
            githubTest.clickOnIssue(namePage);
        });
        step("Проверяем наличие Issue с номером" + numberIssue, () -> {
            githubTest.visibleNumberIssue(numberIssue);
        });
    }

    @Test
    @Owner("sigulia")
    @Feature("Задачи в репозитории")
    @Story("Тест с применением аннотаций, проверка наличия Issue #2")
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Шаги с аннотацией @Step")
    @Link(value = "Github", url = "https://github.com/")
    public void testGithubIssueAnnotation () {
        SelenideLogger.addListener("allure", new AllureSelenide());
        WebSteps steps = new WebSteps();
        steps.openPage(nameWebsite);
        steps.searchNameRepository(nameRepository);
        steps.clickOnIssue(namePage);
        steps.visibleNumberIssue(numberIssue);
    }
}

package com.sigulia.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class GithubPages {

    SelenideElement searchInput = $(".header-search-input");


    public GithubPages openPage (String nameWebsite) {
        open(nameWebsite);
        return this;
    }

    public GithubPages searchNameRepository (String nameRepository) {
        searchInput.click();
        searchInput.sendKeys(nameRepository);
        searchInput.submit();
        $(linkText(nameRepository)).click();
        return this;
    }


    public GithubPages clickOnIssue (String namePage) {
        $(partialLinkText(namePage)).click();
        return this;
    }

    public GithubPages visibleNumberIssue(String numberIssue) {
        $(withText(numberIssue)).shouldBe(Condition.visible);
        return this;
    }
}

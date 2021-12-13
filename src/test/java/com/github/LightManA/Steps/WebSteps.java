package com.github.LightManA.Steps;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

// WebSteps Это один из аналогов Page Object
public class WebSteps {

    @Step("Openning main page ")
    public void openMainPage() {
        open("https://github.com");
    }

    @Step("Find репозиторий {repository}")
    public void searchForRepository(String repository) {
        $(".header-search-input").click(); // делаем поле поиска активным
        $(".header-search-input").sendKeys(repository);
        $(".header-search-input").submit();
    }

    @Step("Переходим в репозиторий {repository}")
    public void goToRepository(String repository) {
        $(linkText(repository)).click();
    }

    @Step("Открываем Tab Issues ")
    public void openIssueTab() {
        $(partialLinkText("Pull requests")).click();
    }

    @Step("Проверяем что существует Issue с номером {number}")
    public void shouldSeeIssueWithNumber(int number) {
        $(withText("#" + number)).should(Condition.visible);
    }

}

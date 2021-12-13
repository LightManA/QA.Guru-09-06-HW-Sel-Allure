package com.github.LightManA;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class L06Sel_Allure_StepLambdaExample {

    private static final String REPOSITORY = "LightManA/QAGuru-09-GitTrain";
    private static final Integer ISSUE_NUMBER = 2;

    @Test
    public void testingGithub() {

        step("Openning main page ", () -> {
            open("https://github.com");
        });

        step("Find репозиторий " + REPOSITORY, () -> {
            $(".header-search-input").click(); // делаем поле поиска активным
            $(".header-search-input").sendKeys(REPOSITORY);
            $(".header-search-input").submit();
        });

        step("Переходим в репозиторий " + REPOSITORY, () -> {
            $(linkText("LightManA/QAGuru-09-GitTrain")).click();
        });

        step("Открываем Tab Issues " + REPOSITORY, () -> {
            $(partialLinkText("Pull requests")).click();
        });

        step("Проверяем что существует Issue с номером " + ISSUE_NUMBER, () -> {
            $(withText("#" + ISSUE_NUMBER)).should(Condition.visible);
        });

    }

}

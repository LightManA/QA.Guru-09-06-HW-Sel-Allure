package com.github.LightManA;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class L06Selenide_AllureReportExample {

    @Test
    public void testingGithub() {
        open("https://github.com");
        $(".header-search-input").click(); // делаем поле поиска активным
        $(".header-search-input").sendKeys("LightManA/QAGuru-09-GitTrain");
        $(".header-search-input").submit();

        $(linkText("LightManA/QAGuru-09-GitTrain")).click();
        $(partialLinkText("Pull requests")).click();

        // Поиск на странице пулл реквестов номера #2
        $(withText("#2")).should(Condition.visible);

    }

}

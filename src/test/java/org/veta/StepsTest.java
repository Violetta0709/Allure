package org.veta;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

public class StepsTest {
    public static final String REPOSITORY = "eroshenkoam/allure-example";
    public static final int ISSUE = 80;

    @Test
    public void testLambdaStep() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("открываем главную страницу", () -> open("https://github.com"));
        step("ищем репозиторий" + REPOSITORY, () -> {
            $(".header-search-input").click();
            $(".header-search-input").sendKeys(REPOSITORY);
            $(".header-search-input").submit();
        });
        step("кликаем по ссылке репозитория" + REPOSITORY, () -> $(linkText(REPOSITORY)).click());
        step("открываем tab Issues", () -> $("#issues-tab").click());
        step("проверяем наличие Issue" + ISSUE, () -> {
            $(Selectors.withText("#" + ISSUE)).should(Condition.exist);
        });
    }
}

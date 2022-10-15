package org.veta;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LabelsTest {
    public static final String REPOSITORY = "eroshenkoam/allure-example";
    public static final int ISSUE = 80;

    @Test
    @Feature("Issue в репозитории")
    @Story("Создание issue")
    @Owner("Veta")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "Testing", url = "https://testing.github.com")
    @DisplayName("Создание Issue для авторизованного пользователя")
    public void testStaticLabels() {

    }

    @Test

    public void testDynamicLabels() {
        Allure.getLifecycle().updateTestCase
                (t -> t.setName("Создание Issue для авторизованного пользователя"));
        Allure.feature("Issue в репозитории");
        Allure.story("Создание issue");
        Allure.label("owner","Veta");
        Allure.label("severity", SeverityLevel.CRITICAL.value());
        Allure.link("Testing","https://testing.github.com");

    }
}

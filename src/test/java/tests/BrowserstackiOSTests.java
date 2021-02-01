package tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.appium.java_client.MobileBy.AccessibilityId;

public class BrowserstackiOSTests extends TestBase {

    @Feature("iOS Test")
    @Story("Search Test")
    @Tag("ios")
    @Test
    @DisplayName("Successful search in ios platform")
    public void iOSTets() {

        open();
        $(AccessibilityId("Text Button")).click();
        $(AccessibilityId("Text Input")).setValue("hello@browserstack.com").pressEnter();
        $(AccessibilityId("Text Output")).shouldHave(text("hello@browserstack.com"));
    }
}
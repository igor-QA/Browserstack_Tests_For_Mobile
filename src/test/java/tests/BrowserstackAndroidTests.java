package tests;

import com.codeborne.selenide.CollectionCondition;
import io.appium.java_client.MobileBy;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import static com.codeborne.selenide.Selenide.*;
import static io.appium.java_client.MobileBy.AccessibilityId;
import static org.openqa.selenium.By.className;

public class BrowserstackAndroidTests extends TestBase {

    @Feature("Android Test")
    @Story("Search Test")
    @Tag("android")
    @Test
    @DisplayName("Successful search in wikipedia android app ")
    public void abndroidTets() {
            open();
            $(AccessibilityId("Search Wikipedia")).click();
            $(MobileBy.id("org.wikipedia.alpha:id/search_src_text")).setValue("BrowserStack");
            $$(className("android.widget.TextView")).shouldBe(CollectionCondition.sizeGreaterThan(0));
    }
}

package tests;

import com.codeborne.selenide.Configuration;
import drivers.CustomMobileDriver;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.RemoteWebDriver;

import static com.codeborne.selenide.WebDriverRunner.closeWebDriver;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static com.codeborne.selenide.logevents.SelenideLogger.addListener;
import static helpers.AttachmentsHelper.attachAsText;
import static helpers.AttachmentsHelper.attachPageSource;
import static helpers.AttachmentsHelper.attachScreenshot;
import static helpers.AttachmentsHelper.attachVideo;
import static helpers.BrowserstackHelper.getBSPublicLink;

public class TestBase {

    @BeforeAll
    public static void init() { addListener("allure", new AllureSelenide()
                                .savePageSource(true)
                                .screenshots(true));
        Configuration.browser = CustomMobileDriver.class.getName();
        Configuration.timeout = 10000;
        Configuration.startMaximized = false;
        Configuration.browserSize = null;
    }

    @AfterEach
    public void addAttachmentsAndCloseDriver() {
        String sessionId = ((RemoteWebDriver) getWebDriver()).getSessionId().toString();

        attachScreenshot("Last screenshot");
        attachPageSource();
        attachAsText("Browserstack build link", getBSPublicLink(sessionId));

        closeWebDriver();

        attachVideo(sessionId);
    }
}
package drivers;

import com.codeborne.selenide.WebDriverProvider;
import config.ConfigHelper;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import javax.annotation.Nonnull;
import java.net.MalformedURLException;
import java.net.URL;

import static config.ConfigHelper.*;

public class CustomMobileDriver implements WebDriverProvider {

    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull DesiredCapabilities caps) {
        caps.setCapability("browserstack.user", getUsername());
        caps.setCapability("browserstack.key", getKey());
        caps.setCapability("app", getApp());

        switch (ConfigHelper.getPlatform()) {
            case IOS:
                return getIOSDriver(caps);
            case ANDROID:
                return getAndroidDriver(caps);
            default:
                throw new UnsupportedOperationException("No such platform");
        }
    }

    public WebDriver getAndroidDriver(@Nonnull DesiredCapabilities caps) {
        caps.setCapability("device", "Google Pixel 3");
        caps.setCapability("os_version", "9.0");

        caps.setCapability("project", "Android Test Project");
        caps.setCapability("build", "Java Android");
        caps.setCapability("name", "android_tests");

        return new AndroidDriver(getBrowserstackUrl(), caps);

    }

    public WebDriver getIOSDriver(@Nonnull DesiredCapabilities caps) {
        caps.setCapability("device", "iPhone XS");
        caps.setCapability("os_version", "12");

        caps.setCapability("project", "IOS Test Project");
        caps.setCapability("build", "Java iOS");
        caps.setCapability("name", "ios_tests");

        return new IOSDriver(getBrowserstackUrl(), caps);
    }

    private URL getBrowserstackUrl() {
        try {
            return new URL(ConfigHelper.getBrowserstackURL());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
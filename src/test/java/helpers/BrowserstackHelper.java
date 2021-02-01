package helpers;

import config.ConfigHelper;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class BrowserstackHelper {

    public static String getBrowserstackVideoUrl(String sessionId) {
        return getResponse(sessionId).path("automation_session.video_url");
    }

    public static String getBSPublicLink(String sessionId) {
        return getResponse(sessionId).path("automation_session.public_url");
    }

    private static Response getResponse(String sessionId) {
        return given()
                .auth().basic(ConfigHelper.getUsername(), ConfigHelper.getKey())
                .when()
                .get("https://api-cloud.browserstack.com/app-automate/sessions/" + sessionId + ".json")
                .then()
                .statusCode(200)
                .extract()
                .response();
    }
}
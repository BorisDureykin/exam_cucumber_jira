package objects.steps.api_all_request_respone;

import io.qameta.allure.Step;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class RequestSpecificationAllTests {

    @Step("Составляем RequestSpecification сайта: \"{url}\"")
    public static RequestSpecification requestSpecificationAllTests(String url) {

        return given()
                .baseUri(url)
                .header("Language", "en")
                .header("Content-Type", "application/json")
                .log()
                .uri()
                .filter(new AllureRestAssured());

    }

}

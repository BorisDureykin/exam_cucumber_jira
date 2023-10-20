package objects.steps.api_edu_jira;

import io.qameta.allure.Step;
import io.restassured.specification.RequestSpecification;

import java.util.Base64;

import static objects.steps.api_all_request_respone.RequestSpecificationAllTests.requestSpecificationAllTests;
import static util.Config.getConfigValue;

public class BaseAuthorizationRequest {

    @Step("Создаем RequestSpecification с Basic Authorization")
    static RequestSpecification baseAuthorizationRequest() {

        RequestSpecification request = requestSpecificationAllTests(getConfigValue("UrlIfellowJira"));

        String loginPasword = getConfigValue("login") + ":" + getConfigValue("password");

        byte[] encodeLoginPassword = Base64.getEncoder().encode(loginPasword.getBytes());

        String byteLoginPassword = new String(encodeLoginPassword);

        request = request
                .header("Authorization", "Basic " + byteLoginPassword);

        return request;

    }

}

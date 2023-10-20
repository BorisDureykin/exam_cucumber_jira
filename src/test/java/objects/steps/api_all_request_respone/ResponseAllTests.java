package objects.steps.api_all_request_respone;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static hooks.WebHooks.saveMessage;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ResponseAllTests {

    @Step("Выполняем запрос с параметрами: bodyValue = \"{bodyValue}\",endpoint = \"{endpoint}\", Метод = \"{method}\". Cверяем Response по statusCode = \"{statusCode}\", и схемой = \"{pathSchema}\"")
    public static Response responseGet(RequestSpecification request, String bodyValue, String endpoint, String method, String statusCode, String pathSchema) {

        RequestSpecification modifiedRequest = request;

        if (bodyValue != null) {
            modifiedRequest = modifiedRequest.body(bodyValue);
        }
        if (endpoint != null) {
            modifiedRequest = modifiedRequest.basePath(endpoint);
        }

        Response response;
        switch (method.toUpperCase()) {
            case "GET":
                response = modifiedRequest.get();
                break;
            case "POST":
                response = modifiedRequest.post();
                break;
            case "PUT":
                response = modifiedRequest.put();
                break;
            case "DELETE":
                response = modifiedRequest.delete();
                break;
            default:
                throw new IllegalArgumentException("HTTP method задан не верно: " + method);
        }
        responseNotNull(response);

        statusCodeCheck(response, statusCode);

        if (pathSchema != null) {

            pathSchemaCheck(response, pathSchema);
        }
        return response;
    }

    @Step("Проверяем ответ на наличие значения и выводим ответ")
    public static void responseNotNull(Response response) {

        assertNotNull(response, "Ответ (response) равен null");

        Allure.addAttachment("API Response", "application/json", response.asString());
    }

    @Step("Проверяем statusCode")
    public static void statusCodeCheck(Response response, String statusCode) {

        int intStatusCode = Integer.parseInt(statusCode);

        int actualStatusCode = response.getStatusCode();

        String message = "Ожидаемый StatusCode: " + intStatusCode + " Полученный StatusCode: " + actualStatusCode;

        saveMessage("Сверяем полученный статус код с ожидаемым", message);

        response
                .then()
                .statusCode(intStatusCode);
    }

    @Step("Сверяем полученный Json со схемой")
    public static void pathSchemaCheck(Response response, String pathSchema) {

        String message = "Сверяем полученный Json со схемой: " + pathSchema;

        saveMessage("Сверяем полученный Json", message);

        response
                .then()
                .assertThat()
                .body(matchesJsonSchemaInClasspath(pathSchema));
    }
}


package objects.steps.api_edu_jira;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.Тогда;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import objects.steps.api_all_request_respone.ResponseAllTests;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import static hooks.WebHooks.saveMessage;
import static objects.steps.api_all_request_respone.RequestSpecificationAllTests.requestSpecificationAllTests;
import static util.Config.getConfigValue;


public class AuthorizationSessionId extends ResponseAllTests {
    private static String keyUrl;
    private static String keyLogin;
    private static String keyPassword;
    private static String endpoint;
    private static String method;
    private static String statusCode;
    private static String keyPathSchema;
    @Дано("Параметры авторизации на сайте:")
    public void setDataTable(DataTable table) {
        List<Map<String, String>> parameters = table.asMaps(String.class, String.class);
        Map<String, String> params = parameters.get(0);
        keyUrl = params.get("keyUrl");
        keyLogin = params.get("keyLogin");
        keyPassword = params.get("keyPassword");
        endpoint = params.get("endpoint");
        method = params.get("method");
        statusCode = params.get("statusCode");
        keyPathSchema = params.get("keyPathSchema");
    }

    @Тогда("Авторизуемся на сайте")
    public static void authorizationSessionId () {

        try {
            String login = keyLogin;
            if (Objects.equals(keyLogin, "login")) {
                login = getConfigValue(keyLogin);
            }
            String password = keyPassword;
            if (Objects.equals(keyPassword, "password")) {
                password = getConfigValue(keyPassword);
            }
            String pathSchema = keyPathSchema;
            if (Objects.equals(keyPathSchema, "нет")) {
                pathSchema = null;
            }

            RequestSpecification request = requestSpecificationAllTests(getConfigValue(keyUrl));

            String body = new String(Files.readAllBytes(Paths.get("src/test/resources/ifellow_edu_jira/bodyAutorization.json")));

            body = body.replace("login", login);

            body = body.replace("userPassword", password);

            Response response = responseGet(request, body, endpoint, method, statusCode, pathSchema);

            int statusCode1 = response.getStatusCode();

            if (statusCode1 == 200) {
                String responseBody = response.getBody().asString();

                JSONObject jsonObject = new JSONObject(responseBody);

                String sesionId = jsonObject.getJSONObject("session").getString("value");

                String message = "Успешная авторизация sesionId: " + sesionId;

                saveMessage("Успешная авторизация", message);
            } else {

                String message = "Авторизация не удалась не верные логин или пароль";

                saveMessage("Не авторизованы", message);
            }
        } catch (IOException e) {

            e.printStackTrace();
        }
    }
}

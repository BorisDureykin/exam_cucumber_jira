package objects.steps.api_edu_jira;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.Когда;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import objects.steps.api_all_request_respone.ResponseAllTests;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

import static hooks.WebHooks.saveMessage;
import static objects.steps.api_edu_jira.BaseAuthorizationRequest.baseAuthorizationRequest;

public class CreateIssueApi {
    public static String issueIdApi;
    private static String endpoint;
    private static String method;
    private static String statusCode;
    private static String pathSchema;
    @Дано("Параметры создания задачи:")
    public void setDataTable(DataTable table) {
        List<Map<String, String>> parameters = table.asMaps(String.class, String.class);
        Map<String, String> params = parameters.get(0);

        endpoint = params.get("endpoint");
        method = params.get("method");
        statusCode = params.get("statusCode");
        pathSchema = params.get("pathSchema");
    }
    @Когда("Создаем задач в проекте")
    public static String createIssueApi() {

        try {
            RequestSpecification request =  baseAuthorizationRequest();

            String body = new String(Files.readAllBytes(Paths.get("src/test/resources/ifellow_edu_jira/bodyCreateIssue.json")));

            Response response = ResponseAllTests.responseGet(request, body, endpoint, method, statusCode, pathSchema);

            String responseBody = response.getBody().asString();

            issueIdApi = new JSONObject(responseBody).getString("id");

            String message = "Создана задач с ID: " + issueIdApi ;

            saveMessage("ID задачи", message);

        } catch (IOException e) {

            e.printStackTrace();
        }
        return "Ошибка Создания body.";
    }
}

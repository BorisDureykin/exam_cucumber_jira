package objects.steps.api_edu_jira;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.Тогда;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import objects.steps.api_all_request_respone.ResponseAllTests;
import org.json.JSONObject;

import java.util.List;
import java.util.Map;

import static hooks.WebHooks.saveMessage;
import static java.lang.Integer.valueOf;
import static objects.steps.api_edu_jira.BaseAuthorizationRequest.baseAuthorizationRequest;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class GoToProjectCountIssueApi extends ResponseAllTests {

    public static String countIssueApi;

    public static String projectKey;
    private static String nameCoToProject;
    private static String endpoint;
    private static String method;
    private static String statusCode;
    private static String pathSchema;

    @Тогда("Получаем ключ продукта")
    public static void getProjectKey() {
        RequestSpecification request = baseAuthorizationRequest();
        endpoint = endpoint + nameCoToProject;

        Response response = responseGet(request, null, endpoint, method, statusCode, pathSchema);

        String responseBody = response.getBody().asString();

        projectKey = new JSONObject(responseBody).optString("key", null);

        assertNotNull(projectKey, "Не удалось получить ключ проекта.");
    }

    @Тогда("Получаем количество задач в проекте API")
    public static void getCountIssuesInProjectApi() {

        String jqlQuery = "project=" + projectKey + " AND resolution = Unresolved";

        RequestSpecification request = baseAuthorizationRequest();

        request
                .queryParam("fields", "id")
                .queryParam("maxResults", "0")
                .queryParam("jql", jqlQuery);

        Response response = responseGet(request, null, endpoint, method, statusCode, pathSchema);

        String responseBody = response.getBody().asString();

        countIssueApi = String.valueOf(valueOf(new JSONObject(responseBody).getInt("total")));

        String message = "Количество задач в проекте: " + projectKey + " Составляет: " + countIssueApi;

        saveMessage("Количество задач в проекте: " + projectKey, message);

        assertNotNull(countIssueApi, "Нет значения в количестве задач.");
    }

    @Дано("Параметры получения ключа проекта:")
    public void setDataTable(DataTable table) {

        List<Map<String, String>> parameters = table.asMaps(String.class, String.class);

        Map<String, String> params = parameters.get(0);

        nameCoToProject = params.get("nameCoToProject");
        endpoint = params.get("endpoint");

        method = params.get("method");

        statusCode = params.get("statusCode");

        pathSchema = params.get("pathSchema");
    }

    @Дано("Параметры получения колмчества задач в проекте:")
    public void setDataTable1(DataTable table) {

        List<Map<String, String>> parameters = table.asMaps(String.class, String.class);

        Map<String, String> params = parameters.get(0);

        endpoint = params.get("endpoint");

        method = params.get("method");

        statusCode = params.get("statusCode");

        pathSchema = params.get("pathSchema");
    }
}

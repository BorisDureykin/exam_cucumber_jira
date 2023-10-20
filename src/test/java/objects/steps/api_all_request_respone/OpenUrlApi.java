package objects.steps.api_all_request_respone;

import io.cucumber.java.ru.Когда;

import static objects.steps.api_all_request_respone.RequestSpecificationAllTests.requestSpecificationAllTests;
import static objects.steps.api_all_request_respone.ResponseAllTests.responseGet;
import static util.Config.getConfigValue;

public class OpenUrlApi {


    @Когда("Открываем {string}, c endpoint = {string},  method = {string} сверяем statusCode = {string} и  pathSchema = {string}")
    public static void openUrlApi(String keyUrl, String endpoint, String method, String statusCode, String pathSchema) {

        String url = getConfigValue(keyUrl);

        responseGet(requestSpecificationAllTests(url), null, endpoint, method, statusCode, pathSchema);
    }
}

package objects.steps.gui_edu_jira.for_all;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static hooks.WebHooks.saveScreenshot;
import static org.junit.jupiter.api.Assertions.*;

public class AssertionUtils {

    @Step("Сверяем значения: \"{expected}\" и: \"{actual}\" , в случае ошибки выводим: \"{message}\"")
    public static void assertEqualUtil(String expected, String actual, String message) {

        try {

            assertEquals(expected, actual, message);

        } catch (AssertionError e) {

            saveScreenshot(message);

            throw e;
//            step("Шаг провален: " + message, Status.FAILED);
        }
    }

    @Step("Сверяем значения: \"{expected}\" и: \"{actual}\" , в случае ошибки выводим: \"{message}\"")
    public static void assertTrueContains(String expected, String actual, String message) {
        try {

            assertTrue(actual.contains(expected), message);

        } catch (AssertionError e) {

            saveScreenshot(message);

            throw e;
        }
    }

    @Step("Проверяем видимость: \"{element}\" , в случае отсутствия выводим: \"{message}\"")
    public static void assertTrueVisible(SelenideElement element, String message) {

        try {

            element.shouldBe(Condition.visible);

            assertTrue(element.is(Condition.visible), message);

        } catch (AssertionError e) {

            saveScreenshot(message);

            throw e;
        }
    }
    @Step("Проверяем на наличие значения : \"{value}\" , в случае отсутствия выводим: \"{message}\"")
    public static void assertNotNullUtil(String value, String message) {

        try {

            assertNotNull(value,  message);

        } catch (AssertionError e) {

            saveScreenshot(message);

            throw e;
        }
    }
}

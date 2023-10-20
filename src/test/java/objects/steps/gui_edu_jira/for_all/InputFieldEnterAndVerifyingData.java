package objects.steps.gui_edu_jira.for_all;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.jetbrains.annotations.NotNull;

import static hooks.WebHooks.saveScreenshot;
import static objects.steps.gui_edu_jira.for_all.AssertionUtils.assertEqualUtil;
import static objects.steps.gui_edu_jira.for_all.AssertionUtils.assertTrueVisible;


public class InputFieldEnterAndVerifyingData {

    @Step("Дожидаемся отображения поля ввода: \"{elementName}\" и вводим: \"{valueElement}\"")
    public static void inputFieldEnterAndVerifyingData(@NotNull SelenideElement element, String valueElement, String elementName, char key) {

        assertTrueVisible(element, "Поле ввода " + elementName + " Не отображается или не активно.");

        element.sendKeys(valueElement);

        assertEqualUtil(valueElement, element.getValue(), "В поле " + elementName + " Введено неверное значение.");

        if (key == '1') {

            element.pressEnter();
        }
        saveScreenshot("Дожидаемся отображения поля ввода: " + elementName + " и вводим: " + valueElement);
    }
}

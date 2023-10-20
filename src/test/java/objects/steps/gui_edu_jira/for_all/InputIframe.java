package objects.steps.gui_edu_jira.for_all;


import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.switchTo;
import static hooks.WebHooks.saveScreenshot;
import static objects.elements.CreateIssueForm.iframeInput;
import static objects.elements.CreateIssueForm.iframeInputField;
import static objects.steps.gui_edu_jira.for_all.AssertionUtils.assertEqualUtil;

public class InputIframe {

    @Step("Дожидаемся отображения iFrame: \"{name}\" и вводим в поле ввода: \"{valueText}\"")
    public static void inputIframe(String name, String valueText) {

        switchTo().frame(iframeInput(name));

        iframeInputField.shouldBe(Condition.enabled).setValue(valueText);

        assertEqualUtil(valueText, iframeInputField.getOwnText(), "В iFrame " + name + " Введено неверное значение.");

        saveScreenshot("Дожидаемся отображения iFrame: " +name+ " и вводим в поле ввода: "+valueText);

        switchTo().defaultContent();
    }

}

package objects.steps.gui_edu_jira.for_all;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.jetbrains.annotations.NotNull;

import static hooks.WebHooks.saveScreenshot;
import static objects.steps.gui_edu_jira.for_all.AssertionUtils.assertTrueVisible;

public class ButtonCheckVisibilityClick {

    @Step("Дожидаемся отображения кнопки \"{elementName}\" и нажимаем на неё")
    public static void buttonCheckVisibilityClick(@NotNull SelenideElement element, String elementName) {

        assertTrueVisible(element, elementName + " не отражается на странице или не кликабельна.");

        element.click();

        saveScreenshot("Дожидаемся отображения кнопки: \""+elementName+"\" и нажимаем на неё");
    }
}

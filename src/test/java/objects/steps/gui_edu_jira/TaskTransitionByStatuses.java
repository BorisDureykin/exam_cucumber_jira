package objects.steps.gui_edu_jira;

import io.cucumber.java.ru.И;
import objects.elements.EdujiraIfellowRuSecureDashboard;

import static com.codeborne.selenide.Selenide.open;
import static objects.steps.gui_edu_jira.for_all.AssertionUtils.assertEqualUtil;
import static objects.steps.gui_edu_jira.for_all.ButtonCheckVisibilityClick.buttonCheckVisibilityClick;
import static objects.steps.gui_edu_jira.for_all.InputIframe.inputIframe;
import static util.Config.getConfigValue;

public class TaskTransitionByStatuses extends EdujiraIfellowRuSecureDashboard {

    @И("Переводим созданную задачу по статусам GUI")
    public static void taskTransitionByStatuses() {

        String  url = getConfigValue("issueUrl") + CreateIssue.issueKey;
        open(url);

        buttonCheckVisibilityClick(inWorkButton, "В работе");
        buttonCheckVisibilityClick(closeButton, "closeButton");

        buttonCheckVisibilityClick(businessProcessButton, "Бизнес процесс");
        buttonCheckVisibilityClick(executedButton, "Исполнено");
        inputIframe("Комментарий", "Комментарий Задачи 'Исполнено'");
        buttonCheckVisibilityClick(executedButtonForm, "Исполнено На форме Исполнено");
        buttonCheckVisibilityClick(closeButton, "closeButton");

        buttonCheckVisibilityClick(businessProcessButton, "Бизнес процесс");
        buttonCheckVisibilityClick(confirmedButton, "Подтверждено");
        inputIframe("Комментарий", "Комментарий Задачи 'Подтверждено'");
        buttonCheckVisibilityClick(confirmedButtonForm, "Подтверждено На форме Подтверждено");
        buttonCheckVisibilityClick(closeButton, "closeButton");

        assertEqualUtil("Готово", issueStatus.getOwnText(), "Не верный статус задачи");
    }
}

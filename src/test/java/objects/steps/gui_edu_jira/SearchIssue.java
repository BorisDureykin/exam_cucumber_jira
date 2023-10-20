package objects.steps.gui_edu_jira;

import io.cucumber.java.ru.Затем;
import io.cucumber.java.ru.И;
import objects.elements.EdujiraIfellowRuSecureDashboard;

import static hooks.WebHooks.saveScreenshot;
import static objects.steps.gui_edu_jira.for_all.AssertionUtils.assertEqualUtil;
import static objects.steps.gui_edu_jira.for_all.AssertionUtils.assertTrueVisible;
import static objects.steps.gui_edu_jira.for_all.ButtonCheckVisibilityClick.buttonCheckVisibilityClick;
import static objects.steps.gui_edu_jira.for_all.InputFieldEnterAndVerifyingData.inputFieldEnterAndVerifyingData;

public class SearchIssue extends EdujiraIfellowRuSecureDashboard {

    @Затем("Производим поиск задачи {string}")
    public static void searchIssue(String taskName) {

        inputFieldEnterAndVerifyingData(searchInput, taskName, "Поиск", '1');

        buttonCheckVisibilityClick(issueLink, "issueLink");
    }

    @И("Сверяем поле 'затронуты версии', ожидаемое значение: {string}")
    public static void checkAffectedIssue(String affectedVersion) {

        assertTrueVisible(issueVersions, "Не отображается  поле 'затронуты версии'");

        String actualVersion = issueVersions.getOwnText();

        assertEqualUtil(affectedVersion, actualVersion, "Ошибка заполнения поля 'затронуты версии'");

        saveScreenshot("Сверяем поле 'затронуты версии', ожидаемое значение: " + affectedVersion);
    }


    @Затем("Сверяем статус задачи с ожидаемым: {string}")
    public static void checkStatusIssue(String issuesStatus) {

        assertTrueVisible(issueStatus, "Не отображается  поле 'статус задачи'");

        String actualStatus = issueStatus.getOwnText();

        assertEqualUtil(issuesStatus, actualStatus, "Не верный статус задачи");

        saveScreenshot("Сверяем статус задачи, ожидаемое значение: "+issuesStatus);
    }
}

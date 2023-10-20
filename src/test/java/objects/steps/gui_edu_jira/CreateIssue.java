package objects.steps.gui_edu_jira;

import com.codeborne.selenide.Condition;
import io.cucumber.java.ru.Затем;
import objects.elements.EdujiraIfellowRuSecureDashboard;

import static hooks.WebHooks.saveScreenshot;
import static objects.elements.CreateIssueForm.*;
import static objects.steps.gui_edu_jira.for_all.AssertionUtils.*;
import static objects.steps.gui_edu_jira.for_all.ButtonCheckVisibilityClick.buttonCheckVisibilityClick;
import static objects.steps.gui_edu_jira.for_all.InputFieldEnterAndVerifyingData.inputFieldEnterAndVerifyingData;
import static objects.steps.gui_edu_jira.for_all.InputIframe.inputIframe;

public class CreateIssue extends EdujiraIfellowRuSecureDashboard {

    public static String issueKey;

    @Затем("Создаем задачу с типом Ошибка и темой {string} и получаем номер созданной задачи")
    public static void createIssue(String inputTopic) {

        buttonCheckVisibilityClick(createBatton, "Create Button");
        assertTrueVisible(issueTypeSelect, "Не отображаестя селектор Тип Задачи.");
        issueTypeSelect.doubleClick();
        inputFieldEnterAndVerifyingData(issueTypeSelect, "Ошибка", "Тип Задачи", '1');
        inputFieldEnterAndVerifyingData(issueSummary, inputTopic, "Тема", '0');
        inputIframe("Описание", "Описание Задачи");
        buttonCheckVisibilityClick(versionSelector, "Исправить в версиях");
        prioritetSelector.doubleClick();
        inputFieldEnterAndVerifyingData(prioritetSelector, "Highest", "Приоритет", '1');
        buttonCheckVisibilityClick(markSlectorClik, "Метки");
        buttonCheckVisibilityClick(markSlector, "Предложения");
        buttonCheckVisibilityClick(markSlectorClik, "Метки");
        buttonCheckVisibilityClick(markSlector, "Предложения");
        inputIframe("Окружение", "Окружение Задачи");
        buttonCheckVisibilityClick(touchedVersionsSelector, "Затронуты версии");
        buttonCheckVisibilityClick(relatedTagsSlector, "Связанные задачи");
        buttonCheckVisibilityClick(issueSlectorClik, "Задача селектор");
        buttonCheckVisibilityClick(issueSlector, "Выбор 3 Задачи");
        buttonCheckVisibilityClick(assignMeButton, "Назначить меня");
        buttonCheckVisibilityClick(createIssueButton, "Create Issues Button");

        if (inputTopic.isEmpty()){
            assertTrueVisible(summaryDescriptionError, "Не отображаестя предупреждение.");
            assertTrueContains("Вы должны определить тему по запросу.", summaryDescriptionError.getOwnText(), "Сообщение не верно.");
            saveScreenshot("Проверка ошибки создания задачи и вывод сообщения об ошибке: 'Вы должны определить тему по запросу.'");

        }else {
            assertTrueVisible(returnIssueKey, "Не отображаестя сообщение об успешном создании задачи.");
            String newIssueKey = returnIssueKey.shouldBe(Condition.visible).getOwnText();
            String target = " - " + inputTopic;
            issueKey = newIssueKey.replace(target, "");
            assertNotNullUtil(issueKey, "Нет номера задачи.");
            saveScreenshot("Создана задача №: " + issueKey);
        }
    }
}

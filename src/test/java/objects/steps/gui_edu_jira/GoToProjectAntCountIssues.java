package objects.steps.gui_edu_jira;

import io.cucumber.java.ru.Затем;
import io.cucumber.java.ru.Тогда;
import objects.elements.EdujiraIfellowRuSecureDashboard;

import static hooks.WebHooks.saveScreenshot;
import static objects.elements.EdujiraIfellowRuProjectsTestIssues.allIssues;
import static objects.elements.EdujiraIfellowRuProjectsTestIssues.countIssues;
import static objects.steps.api_edu_jira.GoToProjectCountIssueApi.countIssueApi;
import static objects.steps.gui_edu_jira.for_all.AssertionUtils.*;
import static objects.steps.gui_edu_jira.for_all.ButtonCheckVisibilityClick.buttonCheckVisibilityClick;


public class GoToProjectAntCountIssues extends EdujiraIfellowRuSecureDashboard {

    private static String newCountIssuesGui;

    @Затем("Заходим в проект {string}")
    public static void goToProjectAntCountIssues(String nameCoToProject) {

        buttonCheckVisibilityClick(goToProjectButton, "Project Button");

        buttonCheckVisibilityClick(goToProjectLink, "Project Link");

        buttonCheckVisibilityClick(allIssues, "Задачи");
    }

    @Затем("Выводим количество задач в проекте {string}")
    public static void countIssues(String nameCoToProject) {

        assertTrueVisible(countIssues, "Количество задач не отображается.");

        newCountIssuesGui = countIssues.getOwnText().replace("1 из ", "");

        assertNotNullUtil(newCountIssuesGui,  "Нет значения в количестве задач.");

        saveScreenshot("Получение количества задач в проекте: " + nameCoToProject);
    }

    @Тогда("Сравниваем количество задач в проекте {string} полученное по API и отображаемое на экране")
    public static void comparingCountIssues(String nameCoToProject) {

        assertEqualUtil(countIssueApi, newCountIssuesGui, "Количество задач в проекте: "+ nameCoToProject +"Составляет: "+ countIssueApi+", Отображается : "+ newCountIssuesGui);
    }
}



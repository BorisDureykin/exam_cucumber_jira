package objects.steps.gui_edu_jira;

import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.То;
import objects.elements.EdujiraIfellowRuSecureDashboard;

import static hooks.WebHooks.saveScreenshot;
import static objects.steps.gui_edu_jira.for_all.AssertionUtils.assertEqualUtil;
import static objects.steps.gui_edu_jira.for_all.AssertionUtils.assertTrueVisible;
import static objects.steps.gui_edu_jira.for_all.ButtonCheckVisibilityClick.buttonCheckVisibilityClick;
import static util.Config.getConfigValue;

public class ProfileIn extends EdujiraIfellowRuSecureDashboard {

    @Когда("Заходим в профиль")
    public static void profileIn() {

        buttonCheckVisibilityClick(profileBatton, "profileButton");

        buttonCheckVisibilityClick(profileLink, "profileLink");
    }

    @То("Сверяем имя профиля с {string}")
    public static void checkProfileIn(String keyLogin) {

        String login = getConfigValue(keyLogin);

        assertTrueVisible(nameUser, "Не отображается имя пользователя");

        assertEqualUtil(nameUser.getOwnText(), login, "Неверное имя пользователя, ожидаемое значение: "+login);

        saveScreenshot("Сверяем имя пользователя, ожидаемое значение:  " + login);
    }
}

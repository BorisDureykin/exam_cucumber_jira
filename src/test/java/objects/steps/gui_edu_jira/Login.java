package objects.steps.gui_edu_jira;

import io.cucumber.java.ru.То;
import io.cucumber.java.ru.Тогда;
import objects.elements.EdujiraIfellowRuLogin;

import java.util.Objects;

import static hooks.WebHooks.saveScreenshot;
import static objects.steps.gui_edu_jira.for_all.AssertionUtils.assertTrueContains;
import static objects.steps.gui_edu_jira.for_all.AssertionUtils.assertTrueVisible;
import static objects.steps.gui_edu_jira.for_all.ButtonCheckVisibilityClick.buttonCheckVisibilityClick;
import static objects.steps.gui_edu_jira.for_all.InputFieldEnterAndVerifyingData.inputFieldEnterAndVerifyingData;
import static util.Config.getConfigValue;

public class Login extends EdujiraIfellowRuLogin {

    @Тогда("Вводим {string} вводим {string} и нажимаем Войти")
    public static void authorization(String keyLogin, String keyPassword) {

        String login = keyLogin;

        if(Objects.equals(keyLogin, "login")){

            login = getConfigValue(keyLogin);
        }
        String password =keyPassword;

        if(Objects.equals(keyPassword, "password")){

            password = getConfigValue(keyPassword);
        }

        inputFieldEnterAndVerifyingData(inputLogin, login, "Имя пользователя", '0');

        inputFieldEnterAndVerifyingData(inputPassword, password, "Пароль", '0');

        buttonCheckVisibilityClick(battonLogin, "Войти");
    }

    @То("Проверяем сообщение о неверной авторизации")
    public static void invalidAuthorization() {

        assertTrueVisible(userNameError, "Не отображаестя предупреждение.");

        assertTrueContains(userNameError.getOwnText(), "Извините, имя пользователя или пароль неверны - пожалуйста, попробуйте еще раз.", "Сообщение не верно.");

        saveScreenshot("Проверка ошибки авторизации и вывод сообщения об ошибке: 'Извините, имя пользователя или пароль неверны - пожалуйста, попробуйте еще раз.'");
    }
}

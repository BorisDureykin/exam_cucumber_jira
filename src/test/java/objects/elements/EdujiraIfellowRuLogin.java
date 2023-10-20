package objects.elements;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class EdujiraIfellowRuLogin {
    public static SelenideElement titlePage = $x("//head/title");

    public static SelenideElement bodyPage = $x("//body");


    public static SelenideElement inputLogin = $x("//input[@id='login-form-username' and @name='os_username']");

    public static SelenideElement inputPassword = $x("//input[@id='login-form-password' and @name='os_password']");

    public static SelenideElement battonLogin = $x("//input[@id='login' and @value='Войти']");

    public static SelenideElement userNameError = $x(" //div[@id='usernameerror']/p");


}

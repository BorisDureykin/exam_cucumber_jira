package objects.elements;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class EdujiraIfellowRuSecureDashboard {
    public static SelenideElement profileBatton = $x("//a[@id='header-details-user-fullname' and contains(@title, 'Пользовательский профиль для')]");

    public static SelenideElement profileLink = $x("//li/a[contains(text(),'Профиль')]");

    public static SelenideElement goToProjectButton = $x("//a[contains(text(),'Проекты') and @aria-controls = 'browse_link-content']");

    public static SelenideElement goToProjectLink = $x("//a[contains(text(),'Test (TEST)')]");

    public static SelenideElement createBatton = $x("//a[@id='create_link' and contains(text(),'Создать')]");

    public static SelenideElement searchInput = $x("//input[@id='quickSearchInput']");

    public static SelenideElement issueLink = $x("//a[@id='key-val']");

    public static SelenideElement issueStatus = $x("//span[@id='status-val']//following-sibling::span");

    public static SelenideElement issueVersions = $x("//span[@id='versions-val' and @title='Нажмите, чтобы изменить']");

    public static SelenideElement inWorkButton = $x("//a[@id='action_id_21']/span[contains(text(),'В работе')]");

    public static SelenideElement businessProcessButton = $x("//span[contains(text(),'Бизнес-процесс')]//ancestor::a");

    public static SelenideElement closeButton = $x("//div[contains(text(),' был обновлен.')]/button[@aria-label='Закрыть']");

    public static SelenideElement executedButton = $x("//span[contains(text(),'Исполнено')]//ancestor::a");

    public static SelenideElement executedButtonForm = $x("//input[@id='issue-workflow-transition-submit' and @value='Исполнено']");

    public static SelenideElement confirmedButton = $x("//span[contains(text(),'Подтверждено')]//ancestor::a");

    public static SelenideElement confirmedButtonForm = $x("//input[@value='Подтверждено' and @id='issue-workflow-transition-submit']");

    public static SelenideElement nameUser = $x("//dt[contains(text(),'Полное имя:')]//following-sibling::dd");
}

package objects.elements;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class CreateIssueForm {

    public static SelenideElement issueTypeSelect = $x("//div[@id='issuetype-single-select']/input");

    public static SelenideElement issueSummary = $x(" //input[@id='summary' and @name='summary']");

    public static SelenideElement versionSelector = $x("//label[contains(text(),'Исправить в версиях')]//following-sibling::select//descendant::option[@value='10000']");

    public static SelenideElement prioritetSelector = $x("//input[@aria-label='Приоритет']");

    public static SelenideElement markSlectorClik = $x("//div[@id='labels-multi-select']/span");

    public static SelenideElement markSlector = $x("(//ul[@id='предложения']/li/a)[2]");

    public static SelenideElement touchedVersionsSelector = $x("//label[contains(text(),'Затронуты версии')]//following-sibling::select//descendant::option[@value='10000']");

    public static SelenideElement relatedTagsSlector = $x("//select[@id='issuelinks-linktype']/option[@value='duplicates']");

    public static SelenideElement issueSlectorClik = $x("//div[@id='issuelinks-issues-multi-select']/span");

    public static SelenideElement issueSlector = $x("(//ul[@id='поиск-по-истории']//a)[3]");

    public static SelenideElement assignMeButton = $x("//button[contains(text(),'Назначить меня')]");

    public static SelenideElement createIssueButton = $x("//input[@id='create-issue-submit' and @value='Создать']");

    public static SelenideElement returnIssueKey = $x("//div[contains(text(),'Запрос ')]/a");

    public static SelenideElement summaryDescriptionError = $x("//div[@id='summary-description-error']");


    public static SelenideElement iframeInput(String text) {
        return $x("//label[contains(text(),'" + text + "')]//following-sibling::div//iframe");
    }

    public static SelenideElement iframeInputField = $x("//body[@id='tinymce']/p");
}


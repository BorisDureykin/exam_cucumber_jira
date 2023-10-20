package objects.elements;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class EdujiraIfellowRuProjectsTestIssues {

    public static SelenideElement allIssues = $x("//span[contains(text(),'Задачи')]/ancestor::a[@class='aui-nav-item ']");

    public static SelenideElement countIssues = $x("//div[@class='pager']/div[@class='showing']/span[contains(text(),'1 из')]");
}

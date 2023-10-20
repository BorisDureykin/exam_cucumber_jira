package hooks;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.qameta.allure.Attachment;
import io.qameta.allure.selenide.AllureSelenide;
import org.openqa.selenium.OutputType;

public class WebHooks {

    @Before
    public void allureSelenideListener() {
        String listenerName = "Allureselenide";
        if(SelenideLogger.hasListener(listenerName)) {
            SelenideLogger.addListener(listenerName,
                    (new AllureSelenide()
                            .screenshots(true)
                            .savePageSource(false)));
        }
    }
    @Attachment(value = "{nameScreenshot}", type = "image/png")
    public static byte[] saveScreenshot(String nameScreenshot) {
        return Selenide.screenshot(OutputType.BYTES);
    }

    @Attachment(value = "{nameMessage}", type = "text/plain")
    public static String saveMessage(String nameMessage ,String message) {
        return message;
    }


    @After
    public void afterClass() {

//        saveScreenshot("Screenshot After Test ");
        WebDriverRunner.closeWebDriver();
        SelenideLogger.removeListener("Allureselenide");
    }
}

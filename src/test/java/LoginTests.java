import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeOptions;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginTests {

    @Test
    void successfulLoginTest() {
        Configuration.browserCapabilities = new ChromeOptions().addArguments("--remote-allow-origins=*");
        Configuration.holdBrowserOpen = true;
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver\\chromedriver.exe");
        open("https://qa.guru/cms/system/login");

        $(".login-form").shouldHave(text("Войти"));
        $(By.name("email")).setValue("111");
        $(By.name("password")).setValue("222");




    }
}

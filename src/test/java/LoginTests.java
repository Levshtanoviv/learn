import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginTests extends TestBase {

    @Test
    void successfulLoginTest() {

        open("https://qa.guru/cms/system/login");

        $(".login-form").shouldHave(text("Войти"));
        $(By.name("email")).setValue("111");
        $(By.name("password")).setValue("222");
    }
}

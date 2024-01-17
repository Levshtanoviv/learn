package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginTests extends TestBase {

    @BeforeEach
    void setUp() {
        open("https://qa.guru/cms/system/login");
    }

    @Test
    void successfulLoginTest() {
        $(".login-form").shouldHave(text("Войти"));
        $(By.name("email")).setValue("pansergpanin@yandex.ru");
        $(By.name("password")).setValue("SergPan22031996").pressEnter();
        $(".main-header__login").click();

        $(".logined-form").shouldHave((text("Здравствуйте, Сергей")));
    }

    @CsvFileSource(resources = "/loginParam.csv")
    @ParameterizedTest(name = "Негативный и позитивный тесты")
    @Tags({@Tag("BLOCKER"), @Tag("UI_TEST")})
    void negativeAndPositiveLoginTest(String login, String password) {
        $(".login-form").shouldHave(text("Войти"));
        $(By.name("email")).setValue(login);
        $(By.name("password")).setValue(password).pressEnter();
        $(".main-header__login").click();

        $(".logined-form").shouldHave((text("Здравствуйте, Сергей")));
    }


}

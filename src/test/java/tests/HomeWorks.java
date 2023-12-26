package tests;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;
import page.RegistrationPage;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class HomeWorks extends TestBase {
    @Test
    void searchExampleCodeFromJUnit_L3() {
        open("https://github.com/selenide/selenide");

        $("#wiki-tab").click();
//        $("#wiki-pages-box ul").$("li button").click();
//        $("#wiki-pages-box").shouldHave(text("SoftAssertions"));
        $("#wiki-pages-filter").setValue("SoftAssertions");
        $(byText("SoftAssertions")).click();
        $("#user-content-3-using-junit5-extend-test-class").parent().sibling(0).hover();
    }

    @Test
    void loadingWebSite_L4() {
        SelenideElement title = $("#hero-section-brand-heading");

        open("https://github.com/selenide/selenide");
        $(byText("Solutions")).hover();
        $(byText("Enterprise")).click();
        title.shouldHave(text("The AI-powered developer platform."));
    }

    @Test
    void DaD_L4() {
        open("https://the-internet.herokuapp.com/drag_and_drop");

        SelenideElement recA = $("#column-a");
        SelenideElement recB = $("#column-b");

        var coordinateA = recA.getRect();
        var coordinateB = recB.getRect();
        var x = coordinateB.x - coordinateA.x;
        var y = coordinateB.y - coordinateA.y;

        actions().moveToElement($(recA)).clickAndHold().moveByOffset(x, y).release().perform();

//        $(recA).dragAndDropTo($(recB));
        $(recB).shouldHave(text("A"));
        $(recA).shouldHave(text("B"));
    }

    @Test
    public void PracticeFormTest() {
        RegistrationPage registrationPage = new RegistrationPage();

        registrationPage.openPage()
                .setFirstName("Иван")
                .setLastName("Петров")
                .setUserEmail("ivpet@mail.ru")
                .setGender()
                .setUserNumber("89279998562")
                .setDateOfBirth("22", "March", "1996")
                .setSubjects("Commerce")
                .setHobbies("Music")
                .uploadFile(new File("src/test/resources/1.pdf"))
                .setCurrentAddress("Moskva")
                .setStateAndCity("3", "Uttar Pradesh")
                .setStateAndCity("4", "Agra")
                .submitBtn();

        registrationPage.verifyModalAppears()
                        .verifyResult("Student Name", "Иван Петров");
    }
}

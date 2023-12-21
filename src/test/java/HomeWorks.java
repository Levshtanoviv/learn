import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class HomeWorks extends TestBase{
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

        open("/selenide/selenide");
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

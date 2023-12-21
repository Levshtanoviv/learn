import com.codeborne.selenide.selector.ByText;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import javax.xml.xpath.XPath;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class lesson3 extends TestBase{
    @Test
    void searchExampleCodeFromJUnit() {
        open("https://github.com/selenide/selenide");

        $("#wiki-tab").click();
//        $("#wiki-pages-box ul").$("li button").click();
//        $("#wiki-pages-box").shouldHave(text("SoftAssertions"));
        $("#wiki-pages-filter").setValue("SoftAssertions");
        $(byText("SoftAssertions")).click();
        $("#user-content-3-using-junit5-extend-test-class").parent().sibling(0).hover();
    }
}

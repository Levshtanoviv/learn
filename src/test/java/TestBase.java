import com.codeborne.selenide.Configuration;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestBase {

    @BeforeAll
    static void setup() {

        WebDriverManager.chromedriver().setup();

        Configuration.browserCapabilities = new ChromeOptions().addArguments("--remote-allow-origins=*");
        Configuration.holdBrowserOpen = true;
        //System.setProperty("webdriver.chrome.driver", "D:\\chromedriver\\chromedriver.exe");
        Configuration.pageLoadTimeout = 60000;

        String browserVersion = System.getProperty("browserVersion", "120.0.6099.110");
        Configuration.browserVersion = browserVersion;
    }
}
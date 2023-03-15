package Lesson03;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.Objects;

public class WebDriverTest {
    WebDriver webDriver;
    @BeforeClass
    public void beforeClass() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
    }
    @AfterClass
    public void afterClass() {
        webDriver.quit();
    }
    @Test
    public void test() {

        String expectedTitle = "General Motors: Pushing the Limits of Transportation & Technology";
       // String url = "https://gm.com";
        String url = "https://google.com";

        webDriver.manage().window().maximize();
        webDriver.get(url);
        webDriver.navigate().refresh();
        String title = webDriver.getTitle();

        if (Objects.equals(title, expectedTitle)) {
            System.out.println("Pass");
        } else {
            System.out.println("fail");
        }
    }
}

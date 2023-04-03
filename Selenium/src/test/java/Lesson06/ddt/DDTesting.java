package Lesson06.ddt;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class DDTesting {

    String url = "Https://www.wikipedia.org/";
    WebDriver webDriver;

    @BeforeClass
    public void beforeClass() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.get(url);

    }

    @AfterClass
    public void afterClass() {
        webDriver.quit();
    }

    @Test(dataProvider = "data-search", dataProviderClass = DataProviderSource.class)
    public void test01ExternalFile(String prompt, String expectedString) {
        String searchFieldId = "searchInput";
        String searchButtonXpath = "//*[@id=\"search-form\"]/fieldset/button/i";
        String resultId = "firstHeading";

        webDriver.findElement(By.id(searchFieldId)).sendKeys(prompt);
        webDriver.findElement(By.xpath(searchButtonXpath)).sendKeys();
        WebElement result = webDriver.findElement(By.id(resultId));
        assertEquals(result.getText(), expectedString);
    }

    @AfterMethod
    public void returns() {
        webDriver.get(url);
    }
}

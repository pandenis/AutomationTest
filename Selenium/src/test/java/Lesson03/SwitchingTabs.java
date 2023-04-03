package Lesson03;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SwitchingTabs  {

    WebDriver webDriver;

    @BeforeClass
    public void beforeClass() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        String url = "https://atidcollege.co.il/Xamples/ex_switch_navigation.html";
        webDriver.manage().window().maximize();
        webDriver.get(url);
    }

    @AfterClass
    public void afterClass() {
        webDriver.quit();
    }

    @Test()
    public void test01_Alert() {
        String expectedText = "This is my alert";

        String alertButtonId = "btnAlert";

        WebElement alertButton = webDriver.findElement(By.id(alertButtonId));
        alertButton.click();

        Alert popup = webDriver.switchTo().alert();
        String actualText = popup.getText();

        popup.accept();

        Assert.assertEquals(expectedText, actualText, "Alert Text is not equal");

    }

    @Test
    public void test02_Prompt() {

    }


}

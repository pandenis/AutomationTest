package Lesson05;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class AssertEx1 {
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
    public void testBMI() {

        String url = "https://atidcollege.co.il/Xamples/bmi/";

        String expectedResult = "24";
        String textWeight = "85";
        String textHeight = "180";

        webDriver.manage().window().maximize();
        webDriver.get(url);

        String fieldxPathWeight = "//*[@id=\"weight\"]";
        String fieldxPatHeight = "//*[@id=\"hight\"]";
        String buttonCalculateBMI = "//*[@id=\"calculate_data\"]";
        String fielsxPath = "//*[@id=\"bmi_result\"]";

        WebElement fieldWeight = webDriver.findElement(By.xpath(fieldxPathWeight));
        WebElement fieldHeight = webDriver.findElement(By.xpath(fieldxPatHeight));
        WebElement buttonBMI = webDriver.findElement(By.xpath(buttonCalculateBMI));
        WebElement fieldYourBMI = webDriver.findElement(By.xpath(fielsxPath));

        fieldWeight.sendKeys(textWeight);
        fieldHeight.sendKeys(textHeight);
        buttonBMI.click();
        String actualResult = fieldYourBMI.getAttribute("value");


            assertEquals(expectedResult, actualResult, "The value is wrong!");



    }
}

package Lesson03;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Waitings {

    WebDriver webDriver;

    @BeforeClass
    public void beforeClass() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        String url = "https://atidcollege.co.il/Xamples/ex_synchronization.html";
        webDriver.manage().window().maximize();
        webDriver.get(url);
    }

    @AfterClass
    public void afterClass() {
        webDriver.quit();
    }

    @Test
    public void test01_explicit() {
        String id = "rendered";
        WebElement button = webDriver.findElement(By.id(id));
        button.click();
        //String condition = "My Rendered Element After Fact!";
        String idEx = "finish2";
       // String idEx = "finish3";

        int waitTime = 4;

        WebDriverWait wait = new WebDriverWait(webDriver, waitTime);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id(idEx)));

        Assert.assertTrue(webDriver.findElement(By.id(idEx)).isDisplayed());

    }

    public void test02_sleep() {
        String id = "btn";
        webDriver.findElement(By.id(id));

    }
}

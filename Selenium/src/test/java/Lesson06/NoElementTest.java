package Lesson06;

import com.google.common.util.concurrent.Uninterruptibles;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import java.util.concurrent.TimeUnit;

public class NoElementTest {

    WebDriver webDriver;

    @BeforeClass
    public void beforeClass() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String url = "https://atidcollege.co.il/Xamples/ex_synchronization.html";
        webDriver.get(url);

    }

    @AfterClass
    public void afterClass() {
        webDriver.quit();
    }

    @Test
    public void test01NoElement() {
        String buttonId = "btn";
        String checkboxId = "checkbox";

        webDriver.findElement(By.id(buttonId)).click();
        Uninterruptibles.sleepUninterruptibly(5, TimeUnit.SECONDS);
        Assert.assertEquals(webDriver.findElement(By.id(checkboxId)), false);


    }
}

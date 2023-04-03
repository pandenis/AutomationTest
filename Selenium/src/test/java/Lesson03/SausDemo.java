package Lesson03;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SausDemo {

    WebDriver webDriver;

    @BeforeClass
    public void beforeClass() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        String url = "https://www.saucedemo.com/";
        webDriver.manage().window().maximize();
        webDriver.get(url);
    }

    @AfterClass
    public void afterClass() {
        webDriver.quit();
    }

    @Test
    public void test01_login() {
        String usernameId = "user-name";
        String passwordId = "password";
        String buttonId = "login-button";

        String username = "standard_user";
        String password = "secret_sauce";

        WebElement usernameField = webDriver.findElement(By.id(usernameId));
        WebElement passwordField = webDriver.findElement(By.id(passwordId));
        WebElement button = webDriver.findElement(By.id(buttonId));

        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        button.click();

        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        String elementId = "//*[@id=\"inventory_item_price\"]";
        for (WebElement element : webDriver.findElements(By.id(elementId))) {
            System.out.println(element);
        }


        webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);




    }
}

package Lesson03;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class ActionsEx {

    WebDriver webDriver;

    @BeforeClass
    public void beforeClass() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        String url = "https://atidcollege.co.il/Xamples/ex_actions.html";
        webDriver.manage().window().maximize();
        webDriver.get(url);
    }

    @AfterClass
    public void afterClass() {
        webDriver.quit();
    }

    @Test
    public void test01_dropped() {
        WebElement draggable = webDriver.findElement(By.id("draggable"));
        WebElement droppable = webDriver.findElement(By.id("droppable"));

        Actions action = new Actions(webDriver);

        action.dragAndDrop(draggable, droppable).build().perform();

    }

    @Test
    public void test02_items() {
        String xpath = "//ol[@id='select_items']/li";
        List<WebElement> webElements = webDriver.findElements(By.xpath(xpath));
        Actions action = new Actions(webDriver);
        action.clickAndHold(webElements.get(1))
                .clickAndHold(webElements.get(2))
                .build().perform();
    }

    @Test
    public void test03_doubleClick() {
        String id = "dbl_click";
        WebElement element = webDriver.findElement(By.id(id));
        Actions action = new Actions(webDriver);
        action.doubleClick(element)
                .build().perform();

        String expected = "Hello World";

        Assert.assertEquals(webDriver.findElement(By.id("demo")).getText(), expected);



    }
}

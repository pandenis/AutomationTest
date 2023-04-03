package Lesson06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ExternalFilesExample {



    String url = ExternalFileGetter.getData("URL");
    String weight = ExternalFileGetter.getData("WEIGHT");
    String height = ExternalFileGetter.getData("HEIGH");
    String expectedBMI = ExternalFileGetter.getData("EXPECTED_BMI");
    String expectedMean = ExternalFileGetter.getData("EXPECTED_MEANS");


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

    @Test
    public void test01ExternalFile() {
        String weighId = "weight";
        String heightId = "hight";
        String calculate = "calculate_data";
        String bmiResultID = "bmi_result";

        webDriver.findElement(By.id(weighId)).sendKeys(weight);
        webDriver.findElement(By.id(heightId)).sendKeys(height);
        webDriver.findElement(By.id(calculate)).click();

        Assert.assertEquals(webDriver.findElement(By.id(bmiResultID)).getText(), expectedBMI);
    }
}

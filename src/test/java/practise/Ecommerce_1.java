package practise;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.pbClass1;

import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Ecommerce_1 extends base {

//    @Test
//    public void getName() throws IOException, InterruptedException {
//        service = startServer();
//        AndroidDriver<AndroidElement> driver = setUp("generalApp");
//
//        pbClass1 pb = new pbClass1(driver);
//
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        driver.findElementById("com.androidsample.generalstore:id/btnLetsShop").click();
//        String toast = driver.findElementByXPath("//android.widget.Toast[1]").getAttribute("name");
//        System.out.println(toast);
//        Assert.assertTrue(toast.equals("Please enter your name"));
//
//        service.stop();
//    }

    @Test
    public void cloudGetName() throws IOException, InterruptedException {

        AndroidDriver<AndroidElement> driver = cloudCapabilities("generalApp");

        pbClass1 pb = new pbClass1(driver);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElementById("com.androidsample.generalstore:id/btnLetsShop").click();
        String toast = driver.findElementByXPath("//android.widget.Toast[1]").getAttribute("name");
        System.out.println(toast);
        Assert.assertTrue(toast.equals("Please enter your name"));
        driver.quit();
    }
}
package practise;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pageObjects.pbClass1;

import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Ecommerce_2 extends base {

//    @Test
//    public void openYoutube() throws IOException, InterruptedException {
//        service=startServer();
//        AndroidDriver<AndroidElement> driver = setUp("generalApp");
//
//        pbClass1 pb = new pbClass1(driver);
//
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        pb.nameField.sendKeys("Hello");
//        driver.hideKeyboard();
//        driver.findElementById("com.androidsample.generalstore:id/btnLetsShop").click();
//        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Jordan Lift Off\"))");
//        int count = driver.findElementsById("com.androidsample.generalstore:id/productImage").size();
//        System.out.println(count);
//
//        for(int i=0; i<count;i++){
//            String name = driver.findElementsById("com.androidsample.generalstore:id/productName").get(i).getText();
//            System.out.println(name);
//            if(name.equals("Jordan Lift Off")){
//                System.out.println("inside if");
//                driver.findElementsByAndroidUIAutomator("text(\"ADD TO CART\")").get(i).click();
//                break;
//            }
//        }
//        driver.findElementById("com.androidsample.generalstore:id/appbar_btn_cart").click();
//        driver.findElementByClassName("android.widget.CheckBox").click();
//        driver.findElementById("com.androidsample.generalstore:id/btnProceed").click();
//        Thread.sleep(7000);
//        Set<String> context = driver.getContextHandles();
//        for(String contextnames : context){
//            System.out.println(contextnames);
//        }
//        driver.context("WEBVIEW_com.androidsample.generalstore");
//        WebElement click = driver.findElementByXPath("//input");
//        click.sendKeys("Hello");
//        driver.findElementByXPath("//input").sendKeys(Keys.ENTER);
//        //driver.pressKey(new KeyEvent(AndroidKey.BACK));
//        //driver.findElementByPartialLinkText("https://www.youtube.com").click();
//        driver.navigate().back();
//        driver.navigate().back();
//        Thread.sleep(3000);
//
//        service.stop();
//    }

    @Test
    public void cloudOpenYoutube() throws IOException, InterruptedException {

        AndroidDriver<AndroidElement> driver = cloudCapabilities("generalApp");

        pbClass1 pb = new pbClass1(driver);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        pb.nameField.sendKeys("Hello");
        driver.hideKeyboard();
        driver.findElementById("com.androidsample.generalstore:id/btnLetsShop").click();
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Jordan Lift Off\"))");
        int count = driver.findElementsById("com.androidsample.generalstore:id/productImage").size();
        System.out.println(count);

        for(int i=0; i<count;i++){
            String name = driver.findElementsById("com.androidsample.generalstore:id/productName").get(i).getText();
            System.out.println(name);
            if(name.equals("Jordan Lift Off")){
                System.out.println("inside if");
                driver.findElementsByAndroidUIAutomator("text(\"ADD TO CART\")").get(i).click();
                break;
            }
        }
        driver.findElementById("com.androidsample.generalstore:id/appbar_btn_cart").click();
        driver.findElementByClassName("android.widget.CheckBox").click();
        driver.findElementById("com.androidsample.generalstore:id/btnProceed").click();
        Thread.sleep(7000);
        Set<String> context = driver.getContextHandles();
        for(String contextnames : context){
            System.out.println(contextnames);
        }
        driver.context("WEBVIEW_com.androidsample.generalstore");
        WebElement click = driver.findElementByXPath("//input");
        click.sendKeys("Hello");
        driver.findElementByXPath("//input").sendKeys(Keys.ENTER);
        //driver.pressKey(new KeyEvent(AndroidKey.BACK));
        //driver.findElementByPartialLinkText("https://www.youtube.com").click();
        driver.navigate().back();
        driver.navigate().back();
        Thread.sleep(3000);

        driver.quit();

    }


}

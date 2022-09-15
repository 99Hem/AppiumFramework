package practise;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.URL;
import java.util.Properties;

public class base {

    public static AppiumDriverLocalService service;

    public static AppiumDriverLocalService startServer(){
        boolean flag = checkIfServerIsRunning(4723);
        if(!flag) {
            service = AppiumDriverLocalService.buildDefaultService();
            service.start();
        }
        return service;
    }

    public static void startEmulator() throws IOException, InterruptedException {
        System.out.println(System.getProperty("user.dir"));
        Runtime.getRuntime().exec("C:\\Users\\dt234148\\IdeaProjects\\AppiumFramework\\src\\main\\java\\resources\\StartEmulator.bat");
        Thread.sleep(16000);
    }

    public static boolean checkIfServerIsRunning(int port){

        boolean isServerRunning = false;
        ServerSocket serverSocket;
        try{
            serverSocket = new ServerSocket(port);
            serverSocket.close();
        }catch (Exception e){
            isServerRunning = true;
        }finally {
            serverSocket = null;
        }
        return isServerRunning;
    }

//    public static AndroidDriver<AndroidElement> setUp(String appName) throws IOException, InterruptedException {
//
//
//        AndroidDriver<AndroidElement> driver;
//
//        FileInputStream fis = new FileInputStream("C:\\Users\\dt234148\\IdeaProjects\\AppiumFramework\\src\\main\\java\\practise\\global.properties");
//        Properties prop = new Properties();
//        prop.load(fis);
//
//
//        //setting path to the app under test
//        File appDir = new File("src");
//        File app = new File(appDir, (String) prop.get(appName));
//
//        //setting up the emulator and automation framework uiautomator2
//        DesiredCapabilities cap = new DesiredCapabilities();
//        //startEmulator();
//        cap.setCapability(MobileCapabilityType.DEVICE_NAME, "HemEmulator");
//        cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
//        cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
//
//        //setting the port number for appium server
//        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),cap);
//
//        return driver;
//
//    }

    public static AndroidDriver<AndroidElement> cloudCapabilities(String appName) throws IOException, InterruptedException {


        AndroidDriver<AndroidElement> driver;

        FileInputStream fis = new FileInputStream("C:\\Users\\dt234148\\IdeaProjects\\AppiumFramework\\src\\main\\java\\practise\\global.properties");
        Properties prop = new Properties();
        prop.load(fis);


        DesiredCapabilities cap = new DesiredCapabilities();

        cap.setCapability("browserstack.user", "hemshah_QTqSYE");
        cap.setCapability("browserstack.key", "CnShUjqanQsNtyfyJEGw");
        if(appName.equalsIgnoreCase("generalApp"))
        {
            cap.setCapability("app", "bs://81a0f87ab3ca76c2049b314bed20452842e69661");
        }
        cap.setCapability("device", "Google Pixel 3");
        cap.setCapability("os_version", "9.0");

        cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");

        //setting the port number for appium server
        driver = new AndroidDriver(new URL("http://hub.browserstack.com/wd/hub"),cap);

        return driver;

    }
}

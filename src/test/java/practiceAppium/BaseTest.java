package practiceAppium;
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;


public class BaseTest {

    public AppiumDriverLocalService serviceBuilder;
    public AndroidDriver driver;

    @BeforeClass
    public void configureAppium() throws MalformedURLException {

        //to start the server

        serviceBuilder = new AppiumServiceBuilder().withAppiumJS(new File("//opt//homebrew//lib//node_modules//appium")).withIPAddress("127.0.0.1").usingPort(4723).build();

        serviceBuilder.start();

        //capabilities

        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("Alisha_Phone");
        options.setApp("/Users/alisharaizada/Desktop/AppiumBasicsForAndroid/src/test/java/resources/ApiDemos-debug.apk");

        //Android Driver
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"),options);

        //global timeouts - implicit wait
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)) ;
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public void LongPress(WebElement ele){

        ((JavascriptExecutor) driver).executeScript("mobile: longClickGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) ele).getId(), "duration",2000
        ));

    }

    public void Landscape(int a, int b, int c){

        DeviceRotation landscape= new DeviceRotation(a,b,c);
        driver.rotate(landscape);

    }

    public void SwipeLeft(WebElement ele){

        ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) ele).getId(), "direction","left","percent", 0.50
        ));

    }

    public void Drag_Drop(WebElement ele, int X, int Y){

        ((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) ele).getId(),
                "endX", X,
                "endY", Y
        ));

    }



    @AfterClass
    public void tearDown(){
        driver.quit();
        serviceBuilder.stop();
    }
}

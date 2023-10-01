package practiceAppium;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class Scroll extends BaseTest{

    @Test
    public void ScrollTest() throws InterruptedException {

        driver.findElement(AppiumBy.accessibilityId("Views")).click();

        //GoogleEngine class UiScrollable to

        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"));"));



    }

}

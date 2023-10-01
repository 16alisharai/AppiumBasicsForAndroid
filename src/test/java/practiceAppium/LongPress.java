package practiceAppium;
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;


public class LongPress extends BaseTest {

    @Test
    public void longPress() throws InterruptedException {

        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Expandable Lists")).click();
        driver.findElement(AppiumBy.accessibilityId("1. Custom Adapter")).click();
        WebElement element= driver.findElement(By.xpath("//android.widget.TextView[@text ='People Names']"));
        LongPress(element);
        Thread.sleep(2000);
        List<WebElement> items= driver.findElements(AppiumBy.className("android.widget.TextView"));
        String sample_menu= items.get(0).getText();
        Assert.assertEquals(sample_menu, "Sample menu");
        Assert.assertTrue(items.get(0).isDisplayed());


    }
}

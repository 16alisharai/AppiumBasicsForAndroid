package practiceAppium;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Landscape extends BaseTest {
    @Test
    public void turnToLanscapeMode() {

        driver.findElement(AppiumBy.accessibilityId("Preference")).click();
        driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"3. Preference dependencies\"]")).click();
        driver.findElement(By.className("android.widget.CheckBox")).click();

        //landscape
        Landscape(0,0,90);

        driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
        String alertTitle= driver.findElement(By.id("android:id/alertTitle")).getText();
        Assert.assertEquals(alertTitle,"WiFi settings");
        driver.findElement(By.id("android:id/edit")).sendKeys("Alisha wifi");
        driver.findElements(AppiumBy .className("android.widget.Button")).get(1).click();

    }
}

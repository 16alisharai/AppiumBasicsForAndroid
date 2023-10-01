package practiceAppium;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SetGetClipboard extends BaseTest{
    @Test
    public void myFirstTest() {

        driver.findElement(AppiumBy.accessibilityId("Preference")).click();
        driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"3. Preference dependencies\"]")).click();
        driver.findElement(By.className("android.widget.CheckBox")).click();
        driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
        String alertTitle= driver.findElement(By.id("android:id/alertTitle")).getText();
        Assert.assertEquals(alertTitle,"WiFi settings");

        //set Clipboard text
        driver.setClipboardText("Alisha wifi");
        driver.findElement(By.id("android:id/edit")).sendKeys(driver.getClipboardText());

        driver.findElements(AppiumBy .className("android.widget.Button")).get(1).click();

    }

}

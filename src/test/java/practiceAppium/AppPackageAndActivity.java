package practiceAppium;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AppPackageAndActivity extends BaseTest {


    //on emulator first open the required page
    //then go to terminal and give below commands to know about package and activity
    //adb devices
    //adb shell dumpsys window | grep -E 'mCurrentFocus'
    //o/p-   mCurrentFocus=Window{4ce2afe u0 io.appium.android.apis/io.appium.android.apis.preference.PreferenceDependencies}
    //anything before / is a package name
    //app will be deprecated in future


    @Test
    public void directOpenPreferencePage(){

        Activity activity = new Activity("io.appium.android.apis","io.appium.android.apis.preference.PreferenceDependencies");
        driver.startActivity(activity);

        driver.findElement(By.className("android.widget.CheckBox")).click();
        driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
        String alertTitle= driver.findElement(By.id("android:id/alertTitle")).getText();
        Assert.assertEquals(alertTitle,"WiFi settings");
        driver.findElement(By.id("android:id/edit")).sendKeys("Alisha wifi");
        driver.findElements(AppiumBy.className("android.widget.Button")).get(1).click();
    }

}

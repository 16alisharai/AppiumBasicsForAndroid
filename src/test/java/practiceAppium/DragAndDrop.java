package practiceAppium;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DragAndDrop extends BaseTest {

    @Test
    public void dragAndDropTest() {

        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();
        WebElement source= driver.findElement(By.id("io.appium.android.apis:id/drag_dot_1"));
        Drag_Drop(source,623,557);
        Assert.assertEquals(driver.findElement(By.id("io.appium.android.apis:id/drag_result_text")).getText(),"Dropped!");

    }

}

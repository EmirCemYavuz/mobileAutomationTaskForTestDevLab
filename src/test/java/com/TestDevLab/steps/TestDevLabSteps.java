package com.TestDevLab.steps;

import com.TestDevLab.utils.Driver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.NoSuchElementException;
import static io.appium.java_client.touch.WaitOptions.waitOptions;

public class TestDevLabSteps {

    public static void click(By by){
        Driver.getDriver().findElement(by).click();
    }

    public static void waitUntilElementClickable(By by) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 20);
        try {
            wait.until(ExpectedConditions.elementToBeClickable(by));
        } catch (NoSuchElementException e) {
            System.out.println(e);
            throw new RuntimeException(e);
        }
    }

    public static void slide(String direction) {
        int sWidth = (int) Driver.getDriver().manage().window().getSize().width;
        int sHeight = (int) Driver.getDriver().manage().window().getSize().height;
        TouchAction action = new TouchAction(Driver.getDriver());
        switch (direction) {
            case "right":
                action
                        .press(PointOption.point((int) (0.10 * sWidth), (int) (0.25 * sHeight)))
                        .waitAction(waitOptions(Duration.ofMillis(500)))
                        .moveTo(PointOption.point((int) (0.90 * sWidth), (int) (0.25 * sHeight)))
                        .release()
                        .perform();

                break;
            case "left":
                action
                        .press(PointOption.point((int) (0.90 * sWidth), (int) (0.25 * sHeight)))
                        .waitAction(waitOptions(Duration.ofMillis(500)))
                        .moveTo(PointOption.point((int) (0.10 * sWidth), (int) (0.25 * sHeight)))
                        .release()
                        .perform();

                break;

            case "up":
                action
                        .press(PointOption.point(540, 1200))
                        .waitAction(waitOptions(Duration.ofMillis(500)))
                        .moveTo(PointOption.point(540, 600))
                        .release()
                        .perform();
                break;

            case "down":
                action
                        .press(PointOption.point((int) (0.50 * sWidth), (int) (0.25 * sHeight)))
                        .waitAction(waitOptions(Duration.ofMillis(500)))
                        .moveTo(PointOption.point((int) (0.50 * sWidth), (int) (0.85 * sHeight)))
                        .release()
                        .perform();
                break;

            default:
                break;
        }
    }
}

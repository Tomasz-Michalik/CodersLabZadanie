package PageObject;

import org.openqa.selenium.*;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class CartPage {
    private WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(css = "a[class='btn btn-primary']")
    WebElement btnProceed;
    @FindBy(css = "button.btn.btn-primary.continue.float-xs-right")
    WebElement btnContinue1;
    @FindBy(css = "button[value='1'][name='confirmDeliveryOption']")
    WebElement btnContinue2;
    @FindBy(css = "#payment-option-1")
    WebElement payByCheckInput;
    @FindBy(css = "div > label.js-terms")
    WebElement checkBox;
    @FindBy(css = ".btn.btn-primary.center-block")
    WebElement finishButton;

    public void cartOptions() throws InterruptedException {
        btnProceed.click();
        Thread.sleep(1500);
        btnContinue1.click();
        Thread.sleep(1500);
        btnContinue2.click();
        Thread.sleep(500);
        payByCheckInput.click();
        checkBox.click();
        finishButton.click();
    }
    public String captureScreen() {
        String path;
        try {
            WebDriver augmentedDriver = new Augmenter().augment(driver);
            File source = ((TakesScreenshot)augmentedDriver).getScreenshotAs(OutputType.FILE);
            path = "C:\\Users\\micha\\CodersLab\\CodersLabZadanie\\src\\main\\resources\\screenshots\\" + source.getName();
            FileUtils.copyFile(source, new File(path));
        }
        catch(IOException e) {
            path = "Failed to capture screenshot: " + e.getMessage();
        }
        return path;
    }
}

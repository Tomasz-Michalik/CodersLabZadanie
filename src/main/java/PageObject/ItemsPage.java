package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ItemsPage {
    private WebDriver driver;

    public ItemsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#group_1")
    Select dropdownSize;

    @FindBy(css = "#quantity_wanted")
    WebElement quantityInput;

    @FindBy(css = ".btn.btn-primary.add-to-cart")
    WebElement addButton;

    @FindBy(css = "a[class='btn btn-primary']")
    WebElement proceedButton;

    public void addToCart(String size, int quantity) throws InterruptedException {
        Select drpdwnSize = new Select(driver.findElement(By.cssSelector("#group_1")));
        drpdwnSize.selectByVisibleText(size);
        quantityInput.clear();quantityInput.sendKeys(String.valueOf(quantity));
        addButton.click();
        Thread.sleep(2500);
        proceedButton.click();
    }
}

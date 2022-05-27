package PageObject;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class LoginPage {
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(css = "input[class='form-control']")
    WebElement email;

    @FindBy(css = "input[name='password']")
    WebElement password;

    @FindBy(css = "#submit-login")
    WebElement signInButton;

    @FindBy(css = "div.no-account>a")
    WebElement noAccButton;

    @FindBy(name = "s")
    WebElement searchItems;

    @FindBy(css = "div.thumbnail-container")
    List<WebElement> itemsList;

    public void logIn() {
        email.sendKeys("test@test.tm");
        password.sendKeys("12345");
        signInButton.click();
    }
    public void searchSweater() {
        searchItems.sendKeys("Hummingbird Printed Sweater", Keys.ENTER);
        itemsList.get(0).click();
    }

    public void noAccClick() {
        noAccButton.click();
    }
}

import PageObject.CartPage;
import PageObject.HomePage;
import PageObject.ItemsPage;
import PageObject.LoginPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class BuyingItemsTests {


    public static WebDriver driver;

    @BeforeEach
    void setUp(){
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://mystore-testlab.coderslab.pl/index.php");
    }

    @Test
    void buyingTest() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        ItemsPage itemsPage = new ItemsPage(driver);
        CartPage cartPage = new CartPage(driver);
        homePage.signIn();
        loginPage.logIn();
        loginPage.searchSweater();
        itemsPage.addToCart("M", 10);
        Thread.sleep(1000);
        cartPage.cartOptions();
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,100)");
        cartPage.captureScreen();

    }


    @AfterEach
    void tearDown() {driver.quit();}
}

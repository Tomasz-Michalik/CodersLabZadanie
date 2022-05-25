package CucumberTests;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class LoginAndAddressSteps {

    private WebDriver driver;

    @Given("Otwórz przeglądarkę na stronie logowania")
    public void openLoginPage() {
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://mystore-testlab.coderslab.pl/index.php?controller=authentication&back=my-account");
    }
    @And("Wpisuję email i hasło")
    public void wpisujęEmailIHasło() {
        driver.findElement(By.cssSelector("input[class='form-control']")).sendKeys("test@test.tm");
        driver.findElement(By.cssSelector("input[name='password']")).sendKeys("12345");

    }
    @And("Klikam Sign in")
    public void klikamSignIn() {
        driver.findElement(By.cssSelector("#submit-login")).click();
    }


    @And("Klika w zakładke ADDRESSES")
    public void klikaWZakładkeADDRESSES() {
        driver.findElement(By.cssSelector("#addresses-link")).click();
    }

    @And("Klika w + Create new address")
    public void klikaWCreateNewAddress() {
        driver.findElement(By.cssSelector("div.addresses-footer > a")).click();
    }


    @When("^Wypełnia (.*), (.*), (.*), (.*), (.*)")
    public void wypełnia(String alias, String address, String city, String zipcode,  String phone) {
        driver.findElement(By.cssSelector("input[name='phone']")).sendKeys(phone);
        driver.findElement(By.cssSelector("input[name='alias']")).sendKeys(alias);
        driver.findElement(By.cssSelector("input[name='address1']")).sendKeys(address);
        driver.findElement(By.cssSelector("input[name='city']")).sendKeys(city);
        driver.findElement(By.cssSelector("input[name='postcode']")).sendKeys(zipcode);
        WebElement country = driver.findElement(By.cssSelector("select[name='id_country']"));
        country.click();country.sendKeys( Keys.ARROW_DOWN, Keys.ENTER );
    }

    @And("Klika w przycisk Save")
    public void klikaWPrzyciskSave() {
        driver.findElement(By.cssSelector("button[class='btn btn-primary float-xs-right']")).click();
    }

    @Then("Sprawdzi podany adres")
    public void sprawdziPodanyAdres() {
        List<WebElement> addressess = driver.findElements(By.cssSelector("div.address-body"));
        Assertions.assertTrue(addressess.get(1).isEnabled());
    }

    @And("Usuń powyższy adress klikając delete")
    public void usuńPowyższyAdressKlikającDelete() {
        driver.findElement(By.xpath("(//span[contains(text(),'Delete')])[2]")).click();
    }

    @And("Sprawdź czy powyższy adres został usunięty")
    public void sprawdźCzyPowyższyAdresZostałUsunięty() {
        Assertions.assertTrue(driver.findElement(By.cssSelector("article[role='alert']")).isDisplayed());
    }

    @And("Zamknie przeglądarkę")
    public void zamkniePrzeglądarkę() {
        driver.quit();
    }

}

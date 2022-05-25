package CucumberTests;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/Cucumber/Features/login-and-address.feature",
        plugin = {"pretty","html:out"})
public class LoginAndAddressTests {
}

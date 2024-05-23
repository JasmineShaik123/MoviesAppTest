package StepDefinations;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import pages.loginPage;
public class TestTheLoginPageUI {private WebDriver driver;
private loginPage loginPageImported;

    @Given("I am on the login page")
    public void iAmOnTheLoginPage() {
        // Setup the WebDriver and navigate to the login page
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\LENOVO\\Downloads\\chromedriver-win32 (5)\\chromedriver-win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://qamoviesapp.ccbp.tech");
        loginPageImported = new loginPage(driver);
    }

    @When("Website logo is displayed or not")
    public void getTheLogoIsDisplayed(){
        WebElement logoEl = driver.findElement(By.cssSelector("img.login-website-logo"));
        logoEl.isDisplayed();
    }

    @And("Whether the heading text login is correct or not")
    public void getTheHeadingText(){
        WebElement h1El = driver.findElement(By.cssSelector("h1.sign-in-heading"));
        String actualTxt = h1El.getText();
        Assert.assertEquals(actualTxt, "Login", "LoginMessage Not Displayed");
        //Assert.assertEquals(loginPage.getTheLoginTextHeading(), "Login", "Login Heading text is mismatched");
    }

    @And("Whether the Username label text is correct or not")
    public void getTheUsernameLabelText(){
        WebElement userLabel = driver.findElement(By.xpath("//label[text()='USERNAME']"));
        String label1 = userLabel.getText();
        Assert.assertEquals(label1, "USERNAME", "Userlabel Not Displayed");
        //Assert.assertEquals(loginPage.getTheLabelAtIndex(0), "USERNAME", "Username text is mismatched");
    }

    @And("Whether the Password label text is correct or not")
    public void getThePasswordLabelText(){
        WebElement passwordLabel = driver.findElement(By.xpath("//label[text()='PASSWORD']"));
        String label2 = passwordLabel.getText();
        Assert.assertEquals(label2, "PASSWORD", "Passwordlabel Not Displayed");
        //Assert.assertEquals(loginPage.getTheLabelAtIndex(1), "PASSWORD", "Password text is mismatched");
    }

    @And("Whether the Login text Of login button is correct or not")
    public void getTheLoginButtonText(){
        WebElement btnEl = driver.findElement(By.cssSelector("button.login-button"));
        btnEl.submit();
        //Assert.assertEquals(loginPage.getTheLoginButtonText(), "Login", "Login button text is mismatched");
    }

    @Then("close the driver")
    public void closeTheBrowser(){
        driver.quit();
    }
}

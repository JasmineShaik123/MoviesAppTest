package StepDefinations;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.loginPage;

import java.time.Duration;

public class TestTheLoginPageFunctionalities { private WebDriver driver;
        private loginPage loginPageImported;

        @Given("I am on the Login page")
        public void iAmOnTheLoginPage() {
            // Setup the WebDriver and navigate to the login page
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\LENOVO\\Downloads\\chromedriver-win32 (5)\\chromedriver-win32\\chromedriver.exe");
            driver = new ChromeDriver();
            driver.get("https://qamoviesapp.ccbp.tech");
            loginPageImported = new loginPage(driver);
        }
        @When("Test the login with empty input fields")
        public void testTheLoginWithEmptyInputFields(){
            loginPageImported.loginToApplication("","" );
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            String expctdMsg ="*Username or password is invalid";

            //btnEl.click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("error-message")));
            WebElement errMsg = driver.findElement(By.className("error-message"));
            System.out.println(errMsg.getText());
            Assert.assertEquals(errMsg.getText(),expctdMsg,"emptyfields not displayed");
            driver.navigate().refresh();
        }
        @When("Test the login with empty USERNAME")
        public void testTheLoginWithEmptyUSERNAME(){
            loginPageImported.loginToApplication("rahul","" );
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            String expctdMsg ="*Username or password is invalid";

            //btnEl.click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("error-message")));
            WebElement errMsg = driver.findElement(By.className("error-message"));
            System.out.println(errMsg.getText());
            Assert.assertEquals(errMsg.getText(),expctdMsg,"emptyfields not displayed");
            driver.navigate().refresh();
        }
        @When("Test the login with an empty PASSWORD")
        public void testTheLoginWithEmptyPASSWORD(){
            loginPageImported.loginToApplication("","rahul@2021" );
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            String expctdMsg ="*Username or password is invalid";

            //btnEl.click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("error-message")));
            WebElement errMsg = driver.findElement(By.className("error-message"));
            System.out.println(errMsg.getText());
            Assert.assertEquals(errMsg.getText(),expctdMsg,"emptyfields not displayed");
            driver.navigate().refresh();
        }
        @When("Test the login with invalid credentials")
        public void testTheLoginWithInvalidCredentials(){
            loginPageImported.loginToApplication("rahul","rahul@2020" );
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            String xpctdMsg ="*username and password didn't match";

            //btnEl.click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("error-message")));
            WebElement errMsg1 = driver.findElement(By.className("error-message"));
            System.out.println(errMsg1.getText());
            Assert.assertEquals(errMsg1.getText(),xpctdMsg,"inputfields are not matched");
            driver.navigate().refresh();
        }
        @When("Test the login with valid CREDENTIALS")
        public void testTheLoginWithValidCREDENTIALS(){
            loginPageImported.loginToApplication("rahul","rahul@2021" );
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            String expctdUrl ="https://qamoviesapp.ccbp.tech/";

            //btnEl.click();
            //loginPageImported.loginToApplication("rahul","rahul@2021" );
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button.search-empty-button")));
            String actlUrl= driver.getCurrentUrl();
            System.out.println(actlUrl);
            Assert.assertEquals(actlUrl,expctdUrl,"emptyfields not displayed");
            driver.navigate().refresh();
        }
        @Then("close the driver1")
        public void closeTheDriver(){
            driver.quit();
        }


}

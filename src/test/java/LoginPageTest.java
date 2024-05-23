import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import pages.loginPage;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class LoginPageTest {

    public WebDriver driver;
    loginPage loginPageImported;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\LENOVO\\Downloads\\chromedriver-win32 (5)\\chromedriver-win32\\chromedriver.exe");
        driver = new ChromeDriver();
        //driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.get("https://qamoviesapp.ccbp.tech");
        loginPageImported = new loginPage(driver);
    }


    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test(priority = 1)
    public void testTheLoginPageUI() {

        WebElement logoEl = driver.findElement(By.cssSelector("img.login-website-logo"));
        //String actualUrl = ;
        System.out.println(logoEl.isDisplayed());

        WebElement h1El = driver.findElement(By.cssSelector("h1.sign-in-heading"));
        String actualTxt = h1El.getText();
        Assert.assertEquals(actualTxt, "Login", "LoginMessage Not Displayed");


        WebElement userLabel = driver.findElement(By.xpath("//label[text()='USERNAME']"));
        String label1 = userLabel.getText();
        Assert.assertEquals(label1, "USERNAME", "Userlabel Not Displayed");

        WebElement passwordLabel = driver.findElement(By.xpath("//label[text()='PASSWORD']"));
        String label2 = passwordLabel.getText();
        Assert.assertEquals(label2, "PASSWORD", "Passwordlabel Not Displayed");

        WebElement btnEl = driver.findElement(By.cssSelector("button.login-button"));
        btnEl.submit();
        System.out.println(btnEl.isEnabled());


    }

    @Test(priority = 2)
    public void testTheLoginFunctionalities(){
        /*WebElement userEl = driver.findElement(By.id("usernameInput"));
        WebElement psswrdEl = driver.findElement(By.id("passwordInput"));
        WebElement btnEl = driver.findElement(By.className("login-button"));*/
        loginPageImported.loginToApplication("","" );
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        String expctdMsg ="*Username or password is invalid";

        //btnEl.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("error-message")));
        WebElement errMsg = driver.findElement(By.className("error-message"));
        System.out.println(errMsg.getText());
        Assert.assertEquals(errMsg.getText(),expctdMsg,"emptyfields not displayed");


        loginPageImported.loginToApplication("rahul","" );
        //String expctdMsg1 ="*Username or password is invalid";
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("error-message")));
        WebElement errMsg1 = driver.findElement(By.className("error-message"));
        System.out.println(errMsg1.getText());
        Assert.assertEquals(errMsg1.getText(),expctdMsg,"emptyfields not displayed");
        //userEl.clear();



        loginPageImported.loginToApplication("","rahul2021" );
        //String expctdMsg2 ="*Username or password is invalid";
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("error-message")));
        WebElement errMsg2 = driver.findElement(By.className("error-message"));
        System.out.println(errMsg2.getText());
        Assert.assertEquals(errMsg2.getText(),"*Username or password is invalid","emptyfields not displayed");
       /* psswrdEl.clear();
        //wait.until(ExpectedConditions.urlToBe("https://qamoviesapp.ccbp.tech"));

        userEl.sendKeys("rahul");
        psswrdEl.sendKeys("rahul2020");
        btnEl.click();*/
        loginPageImported.loginToApplication("rahul","rahul@2020" );
        String expctdMsg3 ="*Username or password is invalid";
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("error-message")));
        WebElement errMsg3 = driver.findElement(By.className("error-message"));
        System.out.println(errMsg3.getText());
        Assert.assertEquals(errMsg3.getText(),"*username and password didn't match","emptyfields not displayed");

       // userEl.clear();
        //psswrdEl.clear();


        /*userEl.sendKeys("rahul");
        psswrdEl.sendKeys("rahul@2021");
        btnEl.click();*/
        loginPageImported.loginToApplication("rahul","rahul@2021" );
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button.search-empty-button")));
        String actlUrl= driver.getCurrentUrl();
        System.out.println(driver.getCurrentUrl());
        Assert.assertEquals(actlUrl,"https://qamoviesapp.ccbp.tech/","emptyfields not displayed");


    }
}




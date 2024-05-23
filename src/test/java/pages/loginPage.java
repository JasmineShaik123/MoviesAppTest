package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class loginPage { private WebDriver driver;
    private By usernameInput = By.id("usernameInput");
    private By passwordInput = By.id("passwordInput");
    private By loginButton = By.className("login-button");
    private By errorMessage = By.className("error-message");

    WebDriverWait wait;

    public loginPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(6));
        //PageFactory.initElements(driver,this);
    }

    /*@FindBy(how= How.ID,using = "usernameInput")
    WebElement usernameEl;

    @FindBy(how= How.ID,using = "passwordInput")
    WebElement passwrdEl;

    @FindBy(how= How.CLASS_NAME,using = "login-button")
    WebElement loginButtonEl;

    @FindBy(how= How.CLASS_NAME,using = "error-message")
    WebElement errorMessageEl;*/



    public void enterUserName(String username){
        driver.findElement(usernameInput).sendKeys(username);
    }

    public void enterPassword(String password){
        driver.findElement(passwordInput).sendKeys(password);
    }

    public void submitButton(){
        driver.findElement(loginButton).click();
    }

    public void loginToApplication(String username,String password ){
        enterUserName(username);
        enterPassword(password);
        submitButton();
    }
    public String getErrorMsg(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage));
        WebElement errorMessageEl = driver.findElement(errorMessage);
        return errorMessageEl.getText();
    }

}

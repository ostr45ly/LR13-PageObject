import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Created by oliva on 24.04.2017.
 */
public class LoginPage {


    private  WebDriver driver;
    private  WebDriverWait wait;
    //@FindBy (id="login-form-username");
    //WebElenent userName;
    By usernameLocator = By.id("login-form-username");
    By passwordLocator = By.id("login-form-password");
    By loginButtonLocator = By.id("login-form-submit");

   //SearchResultsPage seatcherror=new SearchResultsPage(driver);

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        wait=new WebDriverWait(driver,30);
        //	PageFactory.initElements(driver,this);
    }

    public LoginPage typeUsername(String username) {
        wait.withMessage("could not find the "+usernameLocator).until(ExpectedConditions.visibilityOfElementLocated(usernameLocator));
        driver.findElement(usernameLocator).click();
        driver.findElement(usernameLocator).clear();
        driver.findElement(usernameLocator).sendKeys(username);
        return this;
    }


    public LoginPage typePassword(String password) {
        wait.withMessage("could not find the "+passwordLocator).until(ExpectedConditions.visibilityOfElementLocated(passwordLocator));
        driver.findElement(passwordLocator).click();
        driver.findElement(passwordLocator).clear();
        driver.findElement(passwordLocator).sendKeys(password);
        return this;
    }

    public LoginPage clickOnLogin() {
        driver.findElement(loginButtonLocator).click();
        return this;
    }

    public LoginPage open(String url) {
        driver.get(url);
        return this;
    }
}

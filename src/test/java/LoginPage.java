import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Created by oliva on 24.04.2017.
 */
public class LoginPage {


    //@FindBy (id="login-form-username");
    //WebElenent userName;
    By usernameLocator = By.id("login-form-username");
    By passwordLocator = By.id("login-form-password");
    By loginButtonLocator = By.id("login-form-submit");

    private  WebDriver driver;
    private  WebDriverWait wait;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        wait=new WebDriverWait(driver,30);
        //	PageFactory.initElements(driver,this);
    }

    public LoginPage typeUsername(String username) {
        //userName.clear();
        //userName.sendKeys(username);
        driver.findElement(usernameLocator).clear();
        driver.findElement(usernameLocator).sendKeys(username);
        return this;
    }

    public void waitForSeachResults(){
       // wait.withMessage("could not find the slowly loading text").util(ExpectedConditions.visibilityOfElementLocated(usernameLocator));
    }

    public LoginPage typePassword(String password) {
        driver.findElement(passwordLocator).sendKeys(password);
        return this;
    }

    public LoginPage clickOnLogin() {
        driver.findElement(loginButtonLocator).click();
        return this;
    }

    public LoginPage open() {
        driver.get("http://soft.it-hillel.com.ua:8080/login.jsp");
        return this;
    }
}

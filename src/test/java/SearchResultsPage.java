import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by oliva on 25.04.2017.
 */
public class SearchResultsPage {
    WebDriver driver;
    WebDriverWait wait;

    public SearchResultsPage(WebDriver driver) {
        this.driver = driver;
        wait=new WebDriverWait(driver,30);
    }
    public void waitForSeachResults(){

       wait.withMessage("could not find the login-form-username").until(ExpectedConditions.visibilityOfElementLocated(By.id("login-form-username")));
    }
    public void waitForSeachResultsCreate(){
       // wait.withMessage("could not find the create_link").until(ExpectedConditions.visibilityOfElementLocated(By.id("create_link")));
    }
}

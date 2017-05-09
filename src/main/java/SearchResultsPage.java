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
        this.wait=new WebDriverWait(driver,5);
    }
    public void waitForSeachResults(){
       wait.withMessage("could not find the login-form-username").until(ExpectedConditions.visibilityOfElementLocated(By.id("login-form-username")));
      //  wait.withMessage("could not find the login-form-username").until(ExpectedConditions.invisibilityOfElementLocated(By.id("login-form-usernam"))); // чтобы не падал тест
    }

}

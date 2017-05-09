import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by oliva on 25.04.2017.
 */
public  class HeaderPage {
    By createMenu = By.id("create_link");        // button create task
    By issuesMenu = By.id("find_link");         // find issues  jira
    By projectMenu = By.id("browse_link");     //find project  jira
    By searchMenu= By.id("quickSearchInput"); //find SearchInput   task jira


    private final WebDriver driver;
    private WebDriverWait wait;

    public HeaderPage(WebDriver driver) {
        this.driver = driver;
    }

    public HeaderPage findSearch (){
     //   wait.withMessage("could not find the "+searchMenu).until(ExpectedConditions.visibilityOfElementLocated(searchMenu));
        driver.findElement(searchMenu);
        return this;
    }

    public HeaderPage searchTask (String searchTask){
        WebElement element = driver.findElement(searchMenu);
        driver.findElement(searchMenu).click();
        driver.findElement(searchMenu).clear();
        driver.findElement(searchMenu).sendKeys(searchTask);
        driver.findElement(searchMenu).submit();
        return this;
    }

    public HeaderPage clickCreate() {
        driver.findElement(createMenu).click();
        return this;
    }

    public HeaderPage clickProject() {
        driver.findElement(projectMenu).click();
        return this;
    }

    public HeaderPage createIssues() {
        driver.findElement(issuesMenu).click();
        return this;
    }
}
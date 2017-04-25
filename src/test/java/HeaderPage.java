import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by oliva on 25.04.2017.
 */
public class HeaderPage {
    By createMenu = By.id("create_link");
    By issuesMenu = By.id("find_link");
    By projectMenu = By.id("browse_link");

    private final WebDriver driver;

    public HeaderPage(WebDriver driver) {
        this.driver = driver;
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

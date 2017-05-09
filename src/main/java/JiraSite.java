import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by oliva on 25.04.2017.
 */
public class JiraSite {

    private final WebDriver driver;

    public JiraSite(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage loginPage() { return new LoginPage(driver); }
    public HeaderPage headerpage () { return new HeaderPage(driver);  }
    public NewIssuesPage  newissuesPage () { return new NewIssuesPage(driver);  }
    public SearchResultsPage  searchResultsPage () { return new SearchResultsPage(driver);  }


}

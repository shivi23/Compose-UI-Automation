import com.composeui.config.config.TestConfiguration;
import com.composeui.webpages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by a627563 on 19-02-2017.
 */
public class Test1 
{
    WebDriver driver;
    LoginPage loginPage;
    @BeforeClass
    public  void testSetup()
    {
        driver = TestConfiguration.getDriver();
      //  driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        loginPage = new LoginPage(driver);
    }

    @Test
    public void check_Login_functionality_for_valid_credentials()
    {
        loginPage.doLogin(TestConfiguration.getValue("application.user"),TestConfiguration.getValue("application.password"));
    }

}
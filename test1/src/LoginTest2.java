import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginTest2 {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        baseUrl = "http://2gis.ru/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void invalidLoginPassPairTest() throws Exception {
        driver.get(baseUrl + "/novosibirsk/zoom/11");
        driver.findElement(By.cssSelector("div.tools__btn.tools__account")).click();
        driver.findElement(By.cssSelector("input.auth__formFieldInput.auth__formFieldEmail")).clear();
        driver.findElement(By.cssSelector("input.auth__formFieldInput.auth__formFieldEmail")).sendKeys("ololo@trololo.com");
        driver.findElement(By.cssSelector("input.auth__formFieldInput.auth__formFieldPassword")).clear();
        driver.findElement(By.cssSelector("input.auth__formFieldInput.auth__formFieldPassword")).sendKeys("hil'");
        driver.findElement(By.cssSelector("button.auth__formSubmitBtn.auth__formLoginSubmitBtn")).click();
        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("div.auth__formSubmitValidation")
                        , "Неверный логин или пароль"));

    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

}

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

public class LoginTest {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        baseUrl = "http://2gis.ru/";
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    public void invalidEmailTest() throws Exception {
        driver.get(baseUrl + "/novosibirsk/zoom/11");
        driver.findElement(By.cssSelector("div.tools__btn.tools__account")).click();
        driver.findElement(By.cssSelector("input.auth__formFieldInput.auth__formFieldEmail")).clear();
        driver.findElement(By.cssSelector("input.auth__formFieldInput.auth__formFieldEmail")).sendKeys("ololo");
        driver.findElement(By.cssSelector("input.auth__formFieldInput.auth__formFieldPassword")).clear();
        driver.findElement(By.cssSelector("input.auth__formFieldInput.auth__formFieldPassword")).sendKeys("trololo");
        driver.findElement(By.cssSelector("button.auth__formSubmitBtn.auth__formLoginSubmitBtn")).click();
        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("div.auth__formSubmitValidation")
                , "Указанный e-mail некорректен"));
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

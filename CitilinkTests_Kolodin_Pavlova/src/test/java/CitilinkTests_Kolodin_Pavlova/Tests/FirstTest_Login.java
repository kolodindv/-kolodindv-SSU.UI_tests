package CitilinkTests_Kolodin_Pavlova.Tests;

import CitilinkTests_Kolodin_Pavlova.Pages.LoginPage;
import org.junit.*;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.opera.OperaDriver;
//import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class FirstTest_Login {
    private static WebDriver driver;
    /**
     * осуществление первоначальной настройки
     */
    @BeforeClass
    public static void setup() {
        //определение пути до драйвера и его настройка
        //
        System.setProperty("webDriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
        driver = new ChromeDriver();
        //окно на полный экран
        driver.manage().window().maximize();
        //задержка -> 10 сек.
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //получение ссылки на страницу входа из файла настроек
        driver.get(ConfProperties.getProperty("LoginPage"));
    }

    @Test
    public void Profile_test() throws InterruptedException {
        Authorization authorization = new Authorization(driver);
        authorization.checkSiteVersion(LoginPage.ver_Bt);

        authorization.logIn(LoginPage.login, LoginPage.pass);
        driver.findElement(LoginPage.prfl_Bt).click();

        Assert.assertEquals(driver.findElement(LoginPage.prflName).getText(), "Мой профиль");
        driver.findElement(LoginPage.prfl_Bt).click();

        authorization.logOut();
    }

    @AfterClass
    static public void tearDown() {
        driver.quit();
    }
}

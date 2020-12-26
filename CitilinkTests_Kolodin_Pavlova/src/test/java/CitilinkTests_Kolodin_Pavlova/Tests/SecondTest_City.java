package CitilinkTests_Kolodin_Pavlova.Tests;

import CitilinkTests_Kolodin_Pavlova.Pages.LoginPage;
import CitilinkTests_Kolodin_Pavlova.Pages.ProfilePage;
import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.theories.suppliers.TestedOn;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

@RunWith(DataProviderRunner.class)
public class SecondTest_City {
    private static WebDriver driver;
    /**
     * осуществление первоначальной настройки
     */
    @BeforeClass
    public static void setup() {
        //определение пути до драйвера и его настройка        /
        System.setProperty("webDriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
        driver = new ChromeDriver();
        //окно на полный экран
        driver.manage().window().maximize();
        //задержка -> 10 сек.
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //получение ссылки на страницу входа из файла настроек
        driver.get(ConfProperties.getProperty("LoginPage"));
    }

    @DataProvider
    static public Object[][] target_city(){
        return new Object[][]{
                {"саратов"},
        };
    }

    @Test
    @UseDataProvider("target_city")
    public void CitySelection_Test(String city) throws InterruptedException {
        Authorization authorization = new Authorization(driver);
        WebDriverWait wt_time = new WebDriverWait(driver, 10);

        authorization.checkSiteVersion(LoginPage.ver_Bt);
        authorization.logIn(LoginPage.login, LoginPage.pass);

        WebElement city_Bt = wt_time.until(ExpectedConditions.visibilityOfElementLocated(ProfilePage.city_Bt));
        city_Bt.click();
        wt_time.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(String.format("a[data-search='%s']", city)))).click();

        city_Bt = wt_time.until(ExpectedConditions.visibilityOfElementLocated(ProfilePage.city_Bt));
        String startPage_сity = city_Bt.getText();

        wt_time.until(ExpectedConditions.visibilityOfElementLocated(LoginPage.prfl_Bt)).click();
        wt_time.until(ExpectedConditions.visibilityOfElementLocated(ProfilePage.dlvr_Bt)).click();

        String address = wt_time.until(ExpectedConditions.visibilityOfElementLocated(ProfilePage.dlvr_address)).getText();
        String dlvr_сity = address.substring(0, address.indexOf(','));

        Assert.assertEquals(startPage_сity, dlvr_сity);

        authorization.logOut();
        wt_time.until(ExpectedConditions.visibilityOfElementLocated(ProfilePage.logo_pict)).click();
    }

    @AfterClass
    static public void tearDown() {
        driver.quit();
    }
}




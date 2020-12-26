package CitilinkTests_Kolodin_Pavlova.Tests;

import CitilinkTests_Kolodin_Pavlova.Pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Authorization {
    WebDriver driver;

    public Authorization(WebDriver webDriver){
        driver = webDriver;
    }

    public void checkSiteVersion(By path){
        WebDriverWait wt_time = new WebDriverWait(driver, 5);
        try {
            wt_time.until(ExpectedConditions.visibilityOfElementLocated(path)).click();
        } catch (Exception ignored) { }
    }

    public void logIn(String login, String password) throws InterruptedException {
        WebDriverWait wt_time = new WebDriverWait(driver, 10);

        wt_time.until(ExpectedConditions.visibilityOfElementLocated(LoginPage.openLogF_Bt)).click();
        wt_time.until(ExpectedConditions.visibilityOfElementLocated(LoginPage.log_Box)).sendKeys(login);
        wt_time.until(ExpectedConditions.visibilityOfElementLocated(LoginPage.pass_Box)).sendKeys(password);
        Thread.sleep(10000);

        wt_time.until(ExpectedConditions.visibilityOfElementLocated(LoginPage.signIn_Bt)).click();
    }

    public void logOut(){
        WebDriverWait wt_time = new WebDriverWait(driver, 10);
        driver.findElement(LoginPage.prfl_Bt).click();

        wt_time.until(ExpectedConditions.visibilityOfElementLocated(LoginPage.logOut_Bt)).click();
    }


}
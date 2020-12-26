package CitilinkTests_Kolodin_Pavlova.Pages;
import org.openqa.selenium.By;

public class ProfilePage {
    public static final By city_Bt = By.cssSelector("button[class='js--CitiesSearch-trigger MainHeader__open-text TextWithIcon']");

    public static final By dlvr_Bt = By.cssSelector("a[href='https://www.citilink.ru/profile/delivery/']");
    public static final By dlvr_address = By.cssSelector("span[class='pseudo expandable_control']");

    public  static final By logo_pict = By.cssSelector("svg[class='Logo__svg']");
}

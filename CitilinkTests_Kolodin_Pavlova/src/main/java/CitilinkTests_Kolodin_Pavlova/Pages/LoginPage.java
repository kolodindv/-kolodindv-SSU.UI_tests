package CitilinkTests_Kolodin_Pavlova.Pages;

import org.openqa.selenium.By;

public class LoginPage {
    public static final String login = "grid.test@yandex.ru";
    public static final String pass= "hochusdat2020";

    public static final By ver_Bt = By.cssSelector("button[class='site-version-switcher__button']");

    public static final By openLogF_Bt = By.cssSelector("div[class='Popup__button AuthPopup__popup__popup-button']");
    public static final By log_Box = By.cssSelector("input[name='login']");
    public static final By pass_Box = By.cssSelector("input[name='pass']");

    public static final By signIn_Bt = By.cssSelector("button[class='SignIn__button js--SignIn__action_sign-in  Button jsButton Button_theme_primary Button_size_m Button_full-width']");
    public static final By logOut_Bt = By.cssSelector("a[class='UserMenu__menu-link UserMenu__menu-link_logout']");

    public static final By prfl_Bt = By.cssSelector("div[class='HeaderMenu__buttons  HeaderMenu__buttons_user']");
    public static final By prflName = By.cssSelector("a[class='UserMenu__menu-link']");
}

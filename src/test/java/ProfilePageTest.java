import com.UserOperations;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import com.pages.LoginPage;
import com.pages.MainPage;
import com.pages.ProfilePage;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

import static com.codeborne.selenide.Selenide.page;
import static org.junit.Assert.assertTrue;

public class ProfilePageTest extends BaseTest {

    public Map userData;
    UserOperations userOperations = new UserOperations();
    String login;
    String password;


    @Before
    public void setUp() {
        userData = userOperations.register();
        this.login = userData.get("email").toString();
        this.password = userData.get("password").toString();
        browserSetUp();
    }

    @Test
    @DisplayName("transition from the personal account by clicking on the logo")
    public void logoClickTest() {
        String expectedUrl = "https://stellarburgers.nomoreparties.site/";
        LoginPage loginPage = page(LoginPage.class);
        MainPage mainPage = page(MainPage.class);
        ProfilePage profilePage = page(ProfilePage.class);
        Selenide.open(loginPage.URL);
        loginPage
                .loginUser(login, password);
        mainPage
                .tapOnPersonalAccount();
        profilePage
                .tapLogo();
        assertTrue("transition did not occur to the main page by clicking logo",  mainPage.makeOrderButtonVisible());
    }

    @Test
    @DisplayName("transition from the main page by clicking personal account")
    public void personalAccountTest() {
        String expectedUrl = "https://stellarburgers.nomoreparties.site/";
        LoginPage loginPage = page(LoginPage.class);
        MainPage mainPage = page(MainPage.class);
        ProfilePage profilePage = page(ProfilePage.class);
        Selenide.open(loginPage.URL);
        loginPage
                .loginUser(login, password);
        mainPage
                .tapAccountButton();

        assertTrue("transition did not occur to the personal account from main page", profilePage.visibleLogoutButton());
    }

    @Test
    @DisplayName("transition from the personal account by clicking on the constructor")
    public void constructorClickTest() {
        String expectedUrl = "https://stellarburgers.nomoreparties.site/";
        LoginPage loginPage = page(LoginPage.class);
        MainPage mainPage = page(MainPage.class);
        ProfilePage profilePage = page(ProfilePage.class);
        Selenide.open(loginPage.URL);
        loginPage
                .loginUser(login, password);
        mainPage
                .tapAccountButton();
        profilePage
                .clickConstructorButton();
        assertTrue("transition did not occur to the main page by clicking personal account", mainPage.makeOrderButtonVisible());
    }

    @Test
    @DisplayName("logout in personal account")
    public void logoutTest() {
        String expectedUrl = "https://stellarburgers.nomoreparties.site/";
        LoginPage loginPage = page(LoginPage.class);
        MainPage mainPage = page(MainPage.class);
        ProfilePage profilePage = page(ProfilePage.class);
        Selenide.open(loginPage.URL);
        loginPage
                .loginUser(login, password);
        mainPage
                .tapAccountButton();
        profilePage
                .tapLogoutButton();
        assertTrue("incorrect logout",loginPage.authorizedButton());
    }

    @After
    public void tearDown() {
        userOperations.delete();
        WebDriverRunner.closeWebDriver();
    }
}



import com.UserOperations;
import com.pages.*;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

import static com.codeborne.selenide.Selenide.*;
import static org.junit.Assert.assertTrue;

public class LoginTest extends BaseTest{
    UserOperations userOperations;
    MainPage mainPage = open(MainPage.BASE_URL, MainPage.class);
    LoginPage loginPage = page(LoginPage.class);
    RegistrationPage registrationPage = page(RegistrationPage.class);
    PasswordRecoverPage passwordRecoverPage = page(PasswordRecoverPage.class);

    @Before
    public void setUp() {
        userOperations = new UserOperations();
    }

    @Test
    @DisplayName("login Enter button on main page")
    public void loginEnterButton() {
        Map<String, String> testData = userOperations.register();
        mainPage
                .tapAuthorizedButton();
        loginPage
                .setEmail(testData.get("email"))
                .setPassword(testData.get("password"))
                .authorized();
        assertTrue("failed to log in", mainPage.makeOrderButtonVisible());
    }

    @Test
    @DisplayName("login Enter personal account")
    public void loginPersonalAccount() {
        Map<String, String> testData = userOperations.register();
        mainPage
                .tapAccountButton();
        loginPage
                .setEmail(testData.get("email"))
                .setPassword(testData.get("password"))
                .authorized();
        assertTrue("failed to log in personal account", mainPage.makeOrderButtonVisible());
    }

    @Test
    @DisplayName("login authorization new user")
    public void loginFromRegistrationPage() {
        Map<String, String> testData = userOperations.register();
        mainPage
                .tapAuthorizedButton();
        registrationPage
                .tapAuthorizedLink();
        registrationPage
                .setName(testData.get("name"))
                .setEmail(testData.get("email"))
                .setPassword(testData.get("password"));
        loginPage
                .clickRegister();
        assertTrue("failed authorization new user", mainPage.tapOnPersonalAccount());
    }

    @Test
    @DisplayName("login recovery link")
    public void loginFromPasswordRecoverPage() {
        Map<String, String> testData = userOperations.register();
        mainPage
                .tapAuthorizedButton();
        passwordRecoverPage
                .tapRecoverLink();
        loginPage
                .setEmail(testData.get("email"));
        passwordRecoverPage
                .tapRecoverButton();
        assertTrue("failed enter in recovery link", passwordRecoverPage.titleRecoverName());
    }

    @After
    public void deleteUser() {
        userOperations.delete();
        webdriver().driver().close();
    }
}

import com.pages.LoginPage;
import com.pages.MainPage;
import com.pages.RegistrationPage;
import io.qameta.allure.junit4.DisplayName;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static org.junit.Assert.assertTrue;

public class AuthorizationTest extends BaseTest {

    public static final String EMAIL_POSTFIX = "@gmail.com";
    String email = RandomStringUtils.randomAlphabetic(10) + EMAIL_POSTFIX;
    String password = RandomStringUtils.randomAlphabetic(10);
    String passwordIncorrect = RandomStringUtils.randomAlphabetic(5);
    String name = RandomStringUtils.randomAlphabetic(10);
    MainPage mainPage = open(MainPage.BASE_URL, MainPage.class);
    LoginPage loginPage = page(LoginPage.class);
    RegistrationPage registrationPage = page(RegistrationPage.class);

    @Test
    @DisplayName("correct authorization")
    public void correctRegistration() {
        mainPage
                .tapAuthorizedButton();
        registrationPage
                .tapAuthorizedLink();
        registrationPage
                .setName(name)
                .setEmail(email)
                .setPassword(password)
                .clickLoginLink();
        assertTrue("not transaction to the authorization page!", mainPage.tapOnPersonalAccount());
    }

    @Test
    @DisplayName("error authorization")
    public void invalidRegistration() {
        mainPage
                .tapAuthorizedButton();
        registrationPage
                .tapAuthorizedLink();
        registrationPage
                .setName(name)
                .setEmail(email)
                .setPassword(passwordIncorrect)
                .clickLoginLink();
        assertTrue("transaction to the authorization page", loginPage.checkErrorPasswordText());
    }
}



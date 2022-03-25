import com.codeborne.selenide.WebDriverRunner;
import com.pages.MainPage;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static org.junit.Assert.assertTrue;

public class ConstructorTest {

    @Test
    @DisplayName("transaction buns section")
    public void openBunListTest() {
    MainPage mainPage = page(MainPage.class);
    open(mainPage.BASE_URL);
    assertTrue("section buns didn't open", mainPage.switchOnBuns());
    assertTrue("not correct buns name button", mainPage.getTextBunsButton());
}
    @Test
    @DisplayName("transaction sauce section")
    public void openSauceListTest() {
        MainPage mainPage = page(MainPage.class);
        open(mainPage.BASE_URL);
        assertTrue("section sauce didn't open", mainPage.switchOnSauce());
        assertTrue("not correct sauce name button", mainPage.getTextSauceButton());
    }
    @Test
    @DisplayName("transaction filling section")
    public void openFillingListTest() {
        MainPage mainPage = page(MainPage.class);
        open(mainPage.BASE_URL);
        assertTrue("section filling didn't open", mainPage.switchOnFilling());
        assertTrue("not correct fillig name button", mainPage.getTextFillingButton());
    }
    @After
    public void TearDown() {
        WebDriverRunner.closeWebDriver();
    }
}

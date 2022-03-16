import com.codeborne.selenide.WebDriverRunner;
import com.pages.MainPage;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

public class ConstructorTest {

    @Test
    @DisplayName("transaction buns section")
    public void openBunListTest() {
    MainPage mainPage = page(MainPage.class);
    open(mainPage.BASE_URL);
    Assert.assertTrue("section buns didn't open", mainPage.switchOnBuns());
}
    @Test
    @DisplayName("transaction sauce section")
    public void openSauceListTest() {
        MainPage mainPage = page(MainPage.class);
        open(mainPage.BASE_URL);
        Assert.assertTrue("section sauce didn't open", mainPage.switchOnSauce());
    }
    @Test
    @DisplayName("transaction filling section")
    public void openFillingListTest() {
        MainPage mainPage = page(MainPage.class);
        open(mainPage.BASE_URL);
        Assert.assertTrue("section filling didn't open", mainPage.switchOnFilling());
    }
    @After
    public void TearDown() {
        WebDriverRunner.closeWebDriver();
    }
}

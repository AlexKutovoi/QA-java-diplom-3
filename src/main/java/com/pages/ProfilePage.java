package com.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.Selenide.sleep;

public class ProfilePage {

    public static final String URL = "https://stellarburgers.nomoreparties.site/account/profile";
    //logout button
    @FindBy(how = How.XPATH,using = "//*[contains(text(),'Выход')]")
    private SelenideElement logoutButton;

    //main logo
    @FindBy(how = How.XPATH, using = "//div[contains(@class,'logo')]")
    private SelenideElement mainLogoButton;

    // constructor button
    @FindBy(how = How.XPATH, using = "//p[text()='Конструктор']")
    private SelenideElement constructorButton;

    @Step("Клик по кнопке Конструктор")
    public MainPage clickConstructorButton() {
        constructorButton.click();
        return page(MainPage.class);
    }
    @Step("tap on logo")
    public MainPage tapLogo() {
        mainLogoButton.click();
        return page(MainPage.class);
    }
    @Step("tap on logout button")
    public LoginPage tapLogoutButton() {
        logoutButton.click();
        sleep(1500);
        return page(LoginPage.class);
    }
    @Step("visible logout button")
    public boolean visibleLogoutButton() {
        logoutButton.shouldBe(visible);

        return true;
    }
}

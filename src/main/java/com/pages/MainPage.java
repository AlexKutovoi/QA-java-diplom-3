package com.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.page;

public class MainPage {

    public final static String BASE_URL = "https://stellarburgers.nomoreparties.site/";

    //buns button
    @FindBy(how = How.XPATH, using = "//*[@class='text text_type_main-medium mb-6 mt-10' and text()='Булки']")
    private SelenideElement bunsButton;

    //sauce button
    @FindBy(how = How.XPATH, using = "//div[contains(@class,'tab_tab__1SPyG')][2]")
    private SelenideElement sauceButton;

    //filling button
    @FindBy(how = How.XPATH, using = "//div[contains(@class,'tab_tab__1SPyG')][3]")
    private SelenideElement fillingButton;

    //set order
    @FindBy(how = How.XPATH, using = "//button[contains(text(),'Оформить заказ')]")
    private SelenideElement setOrder;

    //personal account
    @FindBy(how = How.XPATH, using = "(//*[contains(@class,'AppHeader_header__link__3D_hX')])[3]")
    private SelenideElement accountButton;

    //authorized button
    @FindBy(how = How.XPATH, using = "//button[text()='Войти в аккаунт']")
    private SelenideElement authorized;

    //метод нажатия на кнопку "войти в аккуант"
    public LoginPage tapAuthorizedButton() {
        authorized.click();
        return page(LoginPage.class);
    }

    @Step("tap personal button")
    public LoginPage tapAccountButton() {
        accountButton.click();
        return page(LoginPage.class);
    }

    @Step("switch buns")
    public boolean switchOnBuns() {

        bunsButton.click();
        return true;
    }

    @Step("switch sauce")
    public boolean switchOnSauce() {

        sauceButton.click();
        return true;
    }

    @Step("switch filling")
    public boolean switchOnFilling() {

        fillingButton.click();
        return true;
    }

    @Step("tap set order")
    public MainPage tapOnOrderButton() {
        setOrder.click();
        return page(MainPage.class);
    }

    @Step("visible personal account button")
    public boolean tapOnPersonalAccount(){
        accountButton.shouldBe(visible, enabled);
        return true;
    }

    @Step("visible order button")
    public boolean makeOrderButtonVisible() {
        setOrder.shouldBe(visible, enabled);
        return true;
    }

    @Step("get text buns")
    public boolean setTextBuns() {
        bunsButton.shouldHave(exactText("Булки"));
        return true;
    }

    @Step("get text sauce")
    public boolean setTextSauce() {
        sauceButton.shouldHave(exactText("Соусы"));
        return true;
    }

    @Step("get text filling")
    public boolean setTextFilling() {
        fillingButton.shouldHave(exactText("Начинки"));
        return true;
    }

}




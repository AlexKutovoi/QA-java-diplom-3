package com.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.Selenide.sleep;

public class LoginPage {

    public static final String URL = "https://stellarburgers.nomoreparties.site/login";

    // register button
    @FindBy(how = How.XPATH, using = "//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa']")
    private SelenideElement registerButton;

    // error password text
    @FindBy(how = How.XPATH, using = "//p[contains(text(),'Некорректный пароль')]")
    private SelenideElement errorPassword;

    // email field
    @FindBy(how = How.XPATH, using = "//input[@type='text']")
    private SelenideElement emailField;

    // password field
    @FindBy(how = How.XPATH, using = "//input[@type='password']")
    private SelenideElement passwordField;

    // enter button
    @FindBy(how = How.XPATH, using = "//button[text()='Войти']")
    private SelenideElement enterButton;

    @Step("tap on register button")
    public RegistrationPage clickRegister() {
        registerButton.click();
        sleep(500);
        return page(RegistrationPage.class);
    }

    @Step("enter email")
    public LoginPage setEmail(String email){
        emailField.sendKeys(email);
        return page(LoginPage.class);
    }

    @Step("enter password")
    public LoginPage setPassword(String password){
        passwordField.sendKeys(password);
        return page(LoginPage.class);
    }

    @Step("authorized")
    public void authorized(){
        enterButton.click();
    }

    @Step("login user")
    public MainPage loginUser(String email, String password){
        setEmail(email);
        setPassword(password);
        authorized();
        return page(MainPage.class);
    }

    @Step("check error password text")
    public boolean checkErrorPasswordText() {
        errorPassword.shouldBe(visible);
        return true;
    }
    @Step("authorized")
    public boolean authorizedButton(){
        enterButton.shouldBe(visible);
        return true;
    }

}


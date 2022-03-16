package com.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.Selenide.sleep;

public class RegistrationPage {
    public static final String URL = "https://stellarburgers.nomoreparties.site/register";

    //name field
    @FindBy(how= How.XPATH, using = "//fieldset[1]//input")
    private SelenideElement nameField;

    //email field
    @FindBy(how=How.XPATH, using = "//fieldset[2]//input")
    private SelenideElement emailField;

    //password field
    @FindBy(how=How.XPATH, using = "//input[@type='password']")
    private  SelenideElement passwordField;

    //enter link
    @FindBy(how = How.XPATH, using = "//a[contains(text(),'Войти')]")
    private SelenideElement enterLink;

    // register button
    @FindBy(how = How.XPATH, using = "//a[contains(text(),'Зарегистрироваться')]")
    private SelenideElement registerLink;

    // confirm register button
    @FindBy(how = How.XPATH, using = "//button[text()='Зарегистрироваться']")
    private SelenideElement registerButton;

    @Step("authorized link")
    public void tapAuthorizedLink(){
        registerLink.click();
    }

    @Step("authorized button")
    public void tapAuthorizedButton(){
        registerButton.click();
    }

    @Step("set name")
    public RegistrationPage setName(String name) {
        nameField.sendKeys(name);
        return page(RegistrationPage.class);
    }

    @Step("set email")
    public RegistrationPage setEmail(String email) {
        emailField.sendKeys(email);
        return page(RegistrationPage.class);
    }

    @Step("set password")
    public RegistrationPage setPassword(String password) {
        passwordField.sendKeys(password);
        return page(RegistrationPage.class);
    }

    @Step("tap on enter link")
    public LoginPage clickLoginLink() {
        enterLink.click();
        sleep(1500);
        return page(LoginPage.class);
    }

}

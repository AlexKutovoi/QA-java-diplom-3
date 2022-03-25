package com.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.page;

public class PasswordRecoverPage {
    public static final String URL = "https://stellarburgers.nomoreparties.site/forgot-password";

    //recover link
    @FindBy(how = How.XPATH,using = "//a[text()='Восстановить пароль']")
    private SelenideElement recoverLink;

    // recover button
    @FindBy(how = How.XPATH, using = "//button[contains(text(),'Восстановить')]")
    private SelenideElement recoverButton;// recover button

    // password recover
    @FindBy(how = How.XPATH, using = "//h2[contains(text(),'Восстановление пароля')]")
    private SelenideElement passwordRecover;

    @Step("tap on recover link")
    public LoginPage tapRecoverLink() {
        recoverLink.click();
        return page(LoginPage.class);
    }

    @Step("tap on recover button")
    public LoginPage tapRecoverButton(){
        recoverButton.click();
        return page(LoginPage.class);
    }
    @Step("visible link recover password")
    public boolean linkRecoverPassword(){
        passwordRecover.shouldBe(visible);
        return true;
    }


}

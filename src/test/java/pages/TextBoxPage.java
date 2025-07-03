package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.TextBoxResultsComponent;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxPage {
    private SelenideElement userNameInput = $("#userName"),
                            userEmailInput = $("#userEmail"),
                            currentAddressInput = $("#currentAddress"),
                            permanentAddressInput = $("#permanentAddress"),
                            submitButton = $("#submit");

    public TextBoxPage openPage(){
        open("/text-box");

        return this;
    }

    public TextBoxPage setUserName(String name){
        userNameInput.setValue(name);

        return this;
    }

    public TextBoxPage setUserEmail(String email){
        userEmailInput.setValue(email);

        return this;
    }

    public TextBoxPage setCurrentAddress(String currentAddress){
        currentAddressInput.setValue(currentAddress);

        return this;
    }

    public TextBoxPage setPermanentAddress(String permanentAddress){
        permanentAddressInput.setValue(permanentAddress);

        return this;
    }

    public TextBoxPage clickSubmitButton(){
        submitButton.click();

        return this;
    }

    public TextBoxPage checkResults(String key, String value){
        new TextBoxResultsComponent().verifySuccessfulResults(key, value);

        return this;
    }
}

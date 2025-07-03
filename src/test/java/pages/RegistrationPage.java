package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.RegistrationFormResultsComponent;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationPage {

    private SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            userNumberInput = $("#userNumber"),
            subjectsInput = $("#subjectsInput"),
            uploadPicture = $("#uploadPicture"),
            currentAddressInput = $("#currentAddress"),
            stateInput = $("#state"),
            cityInput = $("#city"),
            submitClick = $("#submit"),
            calendarInput = $("#dateOfBirthInput");

    private ElementsCollection subjectsSelect = $$(".subjects-auto-complete__option");

    CalendarComponent calendarComponent = new CalendarComponent();

    public RegistrationPage openPage() {
        open("/automation-practice-form");

        return this;
    }

    public RegistrationPage removeBanner() {
        executeJavaScript("$('footer').remove();");
        executeJavaScript("$('#fixedban').remove();");

        return this;
    }

    public RegistrationPage setFirstName(String firstName) {
        firstNameInput.setValue(firstName);

        return this;
    }

    public RegistrationPage setLastName(String lastName) {
        lastNameInput.setValue(lastName);

        return this;
    }

    public RegistrationPage setUserEmail(String userEmail) {
        userEmailInput.setValue(userEmail);

        return this;
    }

    public RegistrationPage setGender(String gender) {
        $(byText(gender)).click();

        return this;
    }

    public RegistrationPage setUserNumber(String number) {
        userNumberInput.setValue(number);

        return this;
    }

    public RegistrationPage setBirthday(String month, String year, String day) {
        calendarInput.clear();
        calendarComponent.setDate(month, year, day);

        return this;
    }

    public RegistrationPage setSubject(String subject) {
        subjectsInput.setValue(subject);
        subjectsSelect.findBy(text(subject)).click();

        return this;
    }

    public RegistrationPage setHobbies(String hobbies) {
        $(byText(hobbies)).click();

        return this;
    }

    public RegistrationPage setUploadPicture(String picture) {
        uploadPicture.uploadFromClasspath(picture);

        return this;
    }

    public RegistrationPage setAddress(String currentAddress) {
        currentAddressInput.setValue(currentAddress);

        return this;
    }

    public RegistrationPage setStateAndCity(String state, String city) {
        stateInput.click();
        $(byText(state)).click();
        cityInput.click();
        $(byText(city)).click();

        return this;
    }

    public RegistrationPage clickSubmit() {
        submitClick.click();

        return this;
    }

    public RegistrationPage checkResults(String key, String value) {
        new RegistrationFormResultsComponent().verifySuccessfulResults(key, value);

        return this;
    }

    public RegistrationPage checkNegativeResults() {
        new RegistrationFormResultsComponent().verifyNegativeResults();

        return this;
    }
}

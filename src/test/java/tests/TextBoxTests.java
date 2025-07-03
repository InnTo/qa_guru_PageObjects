package tests;


import org.junit.jupiter.api.Test;
import pages.TextBoxPage;


public class TextBoxTests extends TestBase {

    String name = "Test";
    String email = "Test@test.ru";
    String currentAddress = "Test address";
    String permanentAddress = "Another test address";

    TextBoxPage textBoxPage = new TextBoxPage();

    @Test
    void fillFormTest() {

        textBoxPage.openPage()
                .setUserName(name)
                .setUserEmail(email)
                .setCurrentAddress(currentAddress)
                .setPermanentAddress(permanentAddress)
                .clickSubmitButton()

                .checkResults("Name:", name)
                .checkResults("Email:", email)
                .checkResults("Current Address :", currentAddress)
                .checkResults("Permananet Address :", permanentAddress);
    }
}


package tests;


import org.junit.jupiter.api.Test;
import pages.RegistrationPage;


public class RegistrationFormTests extends TestBase {

    String firstName = "Test";
    String lastName = "TestLastName";
    String userEmail = "Test@test.ru";
    String gender = "Male";
    String number = "8961530834";
    String month = "April";
    String year = "2002";
    String day = "30";
    String subject = "Maths";
    String hobbies = "Sports";
    String picture = "test.jpg";
    String currentAddress = "Current test address";
    String state = "Uttar Pradesh";
    String city = "Agra";


    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void fillRegistrationFormTest() {

        registrationPage.openPage()
                .removeBanner()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserEmail(userEmail)
                .setGender(gender)
                .setUserNumber(number)
                .setBirthday(month, year, day)
                .setSubject(subject)
                .setHobbies(hobbies)
                .setUploadPicture(picture)
                .setAddress(currentAddress)
                .setStateAndCity(state, city)
                .clickSubmit()


                .checkResults("Student Name", firstName + " " + lastName)
                .checkResults("Student Email", userEmail)
                .checkResults("Gender", gender)
                .checkResults("Mobile", number)
                .checkResults("Date of Birth", day + " " + month + "," + year)
                .checkResults("Subjects", subject)
                .checkResults("Hobbies", hobbies)
                .checkResults("Picture", picture)
                .checkResults("Address", currentAddress)
                .checkResults("State and City", state + " " + city);
    }

    @Test
    void fillRegistrationFormWithMinDataTest() {

        registrationPage.openPage()
                .removeBanner()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setGender(gender)
                .setUserNumber(number)
                .clickSubmit()


                .checkResults("Student Name", firstName + " " + lastName)
                .checkResults("Gender", gender)
                .checkResults("Mobile", number);
    }

    @Test
    void negativeFillRegistrationFormTest() {

        registrationPage.openPage()
                .removeBanner()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setGender(gender)
                .setUserNumber("0")
                .clickSubmit()

                .checkNegativeResults();
    }

}


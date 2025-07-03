package pages.components;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationFormResultsComponent {

    public void verifySuccessfulResults(String key, String value){
        $(".table-responsive").$(byText(key)).parent()
                .shouldHave(text(value));
    }

    public void verifyNegativeResults(){
        $(".modal-content").shouldNot();
    }
}

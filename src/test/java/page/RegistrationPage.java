package page;

import page.component.CalendarComponent;
import page.component.RegistrationResultModal;

import java.io.File;

import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {
    CalendarComponent calendarComponent = new CalendarComponent();
    RegistrationResultModal registrationResultModal = new RegistrationResultModal();

    public RegistrationPage openPage() {
        open("https://demoqa.com/automation-practice-form");
        // удаление рекламы
//        executeJavaScript("$('#fixedban').remote()");
//        executeJavaScript("$$('footer.remote()");
        return this;
    }

    public RegistrationPage setFirstName(String value) {
        $("#firstName").setValue(value);
        return this;
    }

    public RegistrationPage setLastName(String value) {
        $("#lastName").setValue(value);
        return this;
    }

    public RegistrationPage setUserEmail(String value) {
        $("#userEmail").setValue(value);
        return this;
    }

    public RegistrationPage setGender() {
        $("#gender-radio-2").parent().$("label").click();
        return this;
    }

    public RegistrationPage setUserNumber(String value) {
        $("#userNumber").setValue(value);
        return this;
    }

    public RegistrationPage setDateOfBirth(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        calendarComponent.setDate(day, month, year);
        return this;
    }

    public RegistrationPage setSubjects(String value) {
        $("#subjectsInput").val(value).pressEnter();
        return this;
    }

    public RegistrationPage setHobbies(String value) {
        $x("//label[text()='" + value + "']").click();
        return this;
    }

    public RegistrationPage uploadFile(File file) {
        $("#uploadPicture").uploadFile(file);
        return this;
    }

    public RegistrationPage setCurrentAddress(String value) {
        $("#currentAddress").setValue(value);
        return this;
    }

    public RegistrationPage setStateAndCity(String numberInput, String value) {
        $("#react-select-" + numberInput + "-input").setValue(value).pressEnter();
        return this;
    }

    public RegistrationPage submitBtn() {
        $("#submit").submit();
        return this;
    }

    public RegistrationPage verifyModalAppears() {
        registrationResultModal.verifyModalAppears();
        return this;
    }

    public RegistrationPage verifyResult(String key, String value) {
        registrationResultModal.verifyResult(key, value);
        return this;
    }
}

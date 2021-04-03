package pageobjects.chain;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;

import com.codeborne.selenide.ElementsCollection;
import java.util.Map;

public class StudentRegistrationFormPage {

  public StudentRegistrationFormPage openPage() {
    open("https://demoqa.com/automation-practice-form");
    return this;
  }

  public StudentRegistrationFormPage fillForm(UserDefaultData testDate) {
    $("#firstName").setValue(testDate.getFirstName());
    $("#lastName").setValue(testDate.getLastName());
    $("#userEmail").setValue(testDate.getUserEmail());
    $("#genterWrapper .col-md-9.col-sm-12 [for=gender-radio-3]").shouldHave(
        text(testDate.getGender())).click();
    $("#userNumber").setValue(testDate.getUserNumber());

    $("#dateOfBirthInput").click();
    $(".react-datepicker__month-select").$(byText(testDate.getMonthOfBirth())).click();
    $(".react-datepicker__year-select").$(byText(testDate.getYearOfBirth())).click();
    $(".react-datepicker__month").$(byText(testDate.getDateOfBirth())).click();

    //$("#subjectsInput").setValue(subject); //todo: поле не сохраняется
    $("#hobbiesWrapper .col-md-9.col-sm-12 [for=hobbies-checkbox-3]").shouldHave(
        text(testDate.getHobby()))
                                                                     .click();
    $("#uploadPicture").uploadFile(testDate.getFile());
    $("#currentAddress").setValue(testDate.getCurrentAddress());
    $("#stateCity-wrapper #state").click();
    $("#stateCity-wrapper #state .css-26l3qy-menu").$(byText(testDate.getState())).click();
    $("#stateCity-wrapper #city").click();
    $("#stateCity-wrapper #city .css-26l3qy-menu").$(byText(testDate.getCity())).click();

    $("#submit").click();
    return this;
  }

  public StudentRegistrationFormPage checkData(Map<String, String> enteredData) {
    ElementsCollection rows = $$(".modal-content tbody tr");
    rows.forEach(row -> {
      ElementsCollection tds = row.$$("td");
      tds.get(1).shouldHave(exactText(enteredData.get(tds.get(0).text())));
    });
    return this;
  }

}

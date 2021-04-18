package pageobjects.chain;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;

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
    $("#genterWrapper [for=gender-radio-3]").click();
    $("#userNumber").setValue(testDate.getUserNumber());

    $("#dateOfBirthInput").click();
    $(".react-datepicker__month-select").$(byText(testDate.getMonthOfBirth())).click();
    $(".react-datepicker__year-select").$(byText(testDate.getYearOfBirth())).click();
    $(".react-datepicker__month").$(byText(testDate.getDateOfBirth())).click();

    $("#subjectsInput").val(testDate.getSubject()).pressEnter();
    $("#hobbiesWrapper [for=hobbies-checkbox-3]").click();
    $("#uploadPicture").uploadFile(testDate.getFile());
    $("#currentAddress").setValue(testDate.getCurrentAddress());
    $("#stateCity-wrapper #state").click();
    $("#stateCity-wrapper #state").$(byText(testDate.getState())).click();
    $("#stateCity-wrapper #city").click();
    $("#stateCity-wrapper #city").$(byText(testDate.getCity())).click();

    $("#submit").click();
    return this;
  }

  public StudentRegistrationFormPage checkData(Map<String, String> enteredData) {
    $$(".modal-content tbody tr").snapshot().forEach(row -> {
      String rowLabel = row.$("td").text();
      String expectedText = enteredData.get(rowLabel);
      row.$("td", 1).shouldHave(exactText(expectedText));
    });
    return this;
  }
}

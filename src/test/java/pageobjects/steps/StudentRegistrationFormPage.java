package pageobjects.steps;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import java.io.File;
import java.util.Map;

public class StudentRegistrationFormPage {

  private final SelenideElement
      firstNameInput = $("#firstName"),
      lastNameInput = $("#lastName"),
      userEmailInput = $("#userEmail"),
      genderGroup = $("#genterWrapper [for=gender-radio-3]"),
      userNumberInput = $("#userNumber"),
      subjectsInput = $("#subjectsInput"),
      dateOfBirthInput = $("#dateOfBirthInput"),
      monthOfBirthList = $(".react-datepicker__month-select"),
      yearOfBirthList = $(".react-datepicker__year-select"),
      dateOfBirth = $(".react-datepicker__month"),
      hobbyInput = $("#hobbiesWrapper [for=hobbies-checkbox-3]"),
      pictureInput = $("#uploadPicture"),
      currentAddressTextArea = $("#currentAddress"),
      stateInput = $("#stateCity-wrapper #state"),
      stateList = $("#stateCity-wrapper #state"),
      cityInput = $("#stateCity-wrapper #city"),
      cityList = $("#stateCity-wrapper #city"),
      submitButton = $("#submit");
  private final ElementsCollection
      resultGrid = $$(".modal-content tbody tr");


  public void openPage() {
    open("https://demoqa.com/automation-practice-form");
  }

  public void setFirstName(String firstName) {
    firstNameInput.setValue(firstName);
  }

  public void setLastName(String lastName) {
    lastNameInput.setValue(lastName);
  }

  public void setUserEmail(String userEmail) {
    userEmailInput.setValue(userEmail);
  }

  public void setGender() {
    genderGroup.click();
  }

  public void setUserNumber(String userNumber) {
    userNumberInput.setValue(userNumber);
  }

  public void setSubject(String subject) {
    subjectsInput.val(subject).pressEnter();
  }

  public void setBirthDate(String year, String month, String day) {
    dateOfBirthInput.click();
    monthOfBirthList.$(byText(month)).click();
    yearOfBirthList.$(byText(year)).click();
    dateOfBirth.$(byText(day)).click();
  }

  public void setHobby() {
    hobbyInput.click();
  }

  public void setFile(File file) {
    pictureInput.uploadFile(file);
  }

  public void setCurrentAddress(String currentAddress) {
    currentAddressTextArea.setValue(currentAddress);
  }

  public void setState(String state) {
    stateInput.click();
    stateList.$(byText(state)).click();
  }

  public void setCity(String city) {
    cityInput.click();
    cityList.$(byText(city)).click();
  }

  public void submitForm() {
    submitButton.click();
  }

  public void checkData(Map<String, String> enteredData) {
    resultGrid.snapshot().forEach(row -> {
      String rowLabel = row.$("td").text();
      String expectedText = enteredData.get(rowLabel);
      row.$("td", 1).shouldHave(exactText(expectedText));
    });
  }
}

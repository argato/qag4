package tests;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;

import com.codeborne.selenide.Configuration;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class StudentRegistrationFormTest {

  @BeforeAll
  static void setup() {
    Configuration.startMaximized = true;
  }

  @Test
  void successfulFillTest() {
    open("https://demoqa.com/automation-practice-form");
    String firstName = "AlexName";
    String lastName = "AlexFamily";
    String userEmail = "aa@aa.aa";
    String userNumber = "1234567890";
    String dateOfBirth = "17";
    String monthOfBirth = "May";
    String yearOfBirth = "2000";
    String gender = "Other";
    String hobby = "Music";
    String state = "Haryana";
    String city = "Panipat";
    String subject = "Chemistry";
    String currentAddress = "my current address";
    String fileName = "art.jpg";
    File file = new File("src/test/resources/" + fileName);

    Map<String, String> expectedData = new HashMap<>();
    expectedData.put("Student Name", firstName + " " + lastName);
    expectedData.put("Student Email", userEmail);
    expectedData.put("Gender", gender);
    expectedData.put("Mobile", userNumber);
    expectedData.put("Date of Birth", dateOfBirth + " " + monthOfBirth + "," + yearOfBirth);
    expectedData.put("Subjects", subject);
    expectedData.put("Hobbies", hobby);
    expectedData.put("Picture", fileName);
    expectedData.put("Address", currentAddress);
    expectedData.put("State and City", state + " " + city);

    $("#firstName").setValue(firstName);
    $("#lastName").setValue(lastName);
    $("#userEmail").setValue(userEmail);
    $("#genterWrapper [for=gender-radio-3]").click();
    $("#userNumber").setValue(userNumber);

    $("#dateOfBirthInput").click();
    $(".react-datepicker__month-select").$(byText(monthOfBirth)).click();
    $(".react-datepicker__year-select").$(byText(yearOfBirth)).click();
    $(".react-datepicker__month").$(byText(dateOfBirth)).click();

    $("#subjectsInput").val(subject).pressEnter();
    $("#hobbiesWrapper [for=hobbies-checkbox-3]").click();
    $("#uploadPicture").uploadFile(file);
    $("#currentAddress").setValue(currentAddress);
    $("#stateCity-wrapper #state").click();
    $("#stateCity-wrapper #state").$(byText(state)).click();
    $("#stateCity-wrapper #city").click();
    $("#stateCity-wrapper #city").$(byText(city)).click();

    $("#submit").click();
    $$(".modal-content tbody tr").snapshot().forEach(row -> {
      String rowLabel = row.$("td").text();
      String expectedText = expectedData.get(rowLabel);
      row.$("td", 1).shouldHave(exactText(expectedText));
    });
  }
}

package tests;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class StudentRegistrationFormWithFakerTest {

  @BeforeAll
  static void setup() {
    Configuration.startMaximized = true;
  }

  @Test
  void successfulFillTest() {
    Faker faker = new Faker();
    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String userEmail = faker.internet().emailAddress();
    String userNumber = faker.number().digits(10);
    String dateOfBirth = "17";
    String monthOfBirth = "May";
    String yearOfBirth = "2000";
    String gender = "Other";
    String hobby = "Music";
    String state = "Haryana";
    String city = "Panipat";
    String subject = "Chemistry";
    String currentAddress = faker.address().fullAddress();
    String fileName = "art.jpg";

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

    open("https://demoqa.com/automation-practice-form");
    $("#firstName").setValue(firstName);
    $("#lastName").setValue(lastName);
    $("#userEmail").setValue(userEmail);
    $("#genterWrapper [for=gender-radio-3]").click();
    $("#userNumber").setValue(userNumber);

    $("#dateOfBirthInput").click();
    $(".react-datepicker__month-select").$(byText(monthOfBirth)).click();
    $(".react-datepicker__year-select").$(byText(yearOfBirth)).click();
    $(".react-datepicker__month").$(byText(dateOfBirth)).click();

    $("#subjectsInput").val(subject);
    $(".subjects-auto-complete__menu-list").$(byText(subject)).click();
    $("#hobbiesWrapper [for=hobbies-checkbox-3]").click();
    $("#uploadPicture").uploadFromClasspath(fileName);
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

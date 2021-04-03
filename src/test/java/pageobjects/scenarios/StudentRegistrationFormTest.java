package pageobjects.scenarios;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class StudentRegistrationFormTest {

  StudentRegistrationFormPage studentRegistrationFormPage = new StudentRegistrationFormPage();

  @BeforeAll
  static void setup() {
    Configuration.startMaximized = true;
  }

  @Test
  void successfulFillTest() {
    UserDefaultData testDate = new UserDefaultData();
    studentRegistrationFormPage.openPage();
    studentRegistrationFormPage.fillForm(testDate);
    studentRegistrationFormPage.checkData(testDate.getEnteredDate());


  }
}

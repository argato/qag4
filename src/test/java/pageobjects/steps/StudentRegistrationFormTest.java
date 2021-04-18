package pageobjects.steps;

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
    studentRegistrationFormPage.setFirstName(testDate.getFirstName());
    studentRegistrationFormPage.setLastName(testDate.getLastName());
    studentRegistrationFormPage.setUserEmail(testDate.getUserEmail());
    studentRegistrationFormPage.setUserNumber(testDate.getUserNumber());
    studentRegistrationFormPage.setGender();
    studentRegistrationFormPage.setSubject(testDate.getSubject());
    studentRegistrationFormPage.setBirthDate(testDate.getYearOfBirth(), testDate.getMonthOfBirth(),
                                             testDate.getDateOfBirth());
    studentRegistrationFormPage.setHobby();
    studentRegistrationFormPage.setCurrentAddress(testDate.getCurrentAddress());
    studentRegistrationFormPage.setState(testDate.getState());
    studentRegistrationFormPage.setCity(testDate.getCity());
    studentRegistrationFormPage.setFile(testDate.getFile());

    studentRegistrationFormPage.submitForm();
    studentRegistrationFormPage.checkData(testDate.getEnteredDate());
  }
}

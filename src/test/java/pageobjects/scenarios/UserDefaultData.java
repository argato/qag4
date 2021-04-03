package pageobjects.scenarios;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class UserDefaultData {

  private final String firstName = "AlexName";
  private final String lastName = "AlexFamily";
  private final String userEmail = "aa@aa.aa";
  private final String userNumber = "1234567890";
  private final String dateOfBirth = "17";
  private final String monthOfBirth = "May";
  private final String yearOfBirth = "2000";
  private final String gender = "Other";
  private final String hobby = "Music";
  private final String state = "Haryana";
  private final String city = "Panipat";
  private final String subject = ""; //todo: поле не сохраняется
  private final String currentAddress = "my current address";
  private final String fileName = "art.jpg";
  private final File file = new File("src/test/resources/" + fileName);

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getUserEmail() {
    return userEmail;
  }

  public String getUserNumber() {
    return userNumber;
  }

  public String getDateOfBirth() {
    return dateOfBirth;
  }

  public String getMonthOfBirth() {
    return monthOfBirth;
  }

  public String getYearOfBirth() {
    return yearOfBirth;
  }

  public String getGender() {
    return gender;
  }

  public String getHobby() {
    return hobby;
  }

  public String getState() {
    return state;
  }

  public String getCity() {
    return city;
  }

  public String getSubject() {
    return subject;
  }

  public String getCurrentAddress() {
    return currentAddress;
  }

  public File getFile() {
    return file;
  }

  public Map<String, String> getEnteredDate() {
    Map<String, String> enteredData = new HashMap<>();
    enteredData.put("Student Name", firstName + " " + lastName);
    enteredData.put("Student Email", userEmail);
    enteredData.put("Gender", gender);
    enteredData.put("Mobile", userNumber);
    enteredData.put("Date of Birth", dateOfBirth + " " + monthOfBirth + "," + yearOfBirth);
    enteredData.put("Subjects", subject);
    enteredData.put("Hobbies", hobby);
    enteredData.put("Picture", fileName);
    enteredData.put("Address", currentAddress);
    enteredData.put("State and City", state + " " + city);
    return enteredData;
  }


}

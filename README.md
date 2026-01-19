# Selenium Junit Assignment   
**Name:** Mehbuba Alam Oishee  

## 1. Automation of this webform  
**URL:** https://www.digitalunite.com/practice-webform-learners  

### Project Description
This project automates the practice webform using Selenium WebDriver and JUnit 5.  
It fills all the required fields (Name, Number, Today's date, Email, Tell us a bit about yourself, Upload document, Consent checkbox), handles cookie banner, uploads a sample file, waits for manual CAPTCHA solving, submits the form, and asserts successful registration by checking the confirmation page URL and content.

### Technology & Tools Used
- Java (JDK 21)
- Selenium WebDriver (4.39.0)
- JUnit
- Gradle
- Faker library (for random name/email generation)
- ChromeDriver
- IntelliJ IDEA Community Edition

### How to Run the Project
1. Clone the repository:  
   `https://github.com/mehbubaoishee/Selenium_JUnit_Automation`
2. Open the project in IntelliJ IDEA
3. Place a sample file (e.g. `images.jpg`) in `src/test/resources/`
4. Run Gradle test command in Terminal:  
   `.\gradlew.bat test`  
   or  
   Right-click `WebformTest.java` → Run 'WebformTest'
5. During execution, manually solve the reCAPTCHA when prompted (10-second wait)
6. After run, check the console for success message and confirmation URL

### Important Links
--
### Test Result
<img width="1141" height="633" alt="2" src="https://github.com/user-attachments/assets/e7cc75bd-3f6d-4f20-92fb-324450c55bca" />

### Test Video
https://drive.google.com/file/d/13wT877lXGMtr2klpm6_kAvXyPW5VqrSM/view?usp=sharing

---

## 2. Scrap the table data from this page  
**URL:** https://dsebd.org/latest_share_price_scroll_by_value.php  

### Project Description
This project scrapes the latest share price table from DSE (Dhaka Stock Exchange) website.  
It waits for page load, locates the main table, extracts all cell values from rows, prints them in console with numbering, and saves the data to a text file (`table_data.txt`).

### Technology & Tools Used
- Java (JDK 21)
- Selenium WebDriver (4.39.0)
- JUnit
- Gradle
- ChromeDriver
- IntelliJ IDEA Community Edition

### How to Run the Project
1. Clone the repository:  
   `https://github.com/mehbubaoishee/Selenium_JUnit_Automation`
2. Open the project in IntelliJ IDEA
3. Run Gradle test command in Terminal:  
   `.\gradlew.bat test`  
   or  
   Right-click `ScrapTableData.java` (or your table class) → Run
4. Check console for printed cell values
5. Open `src/test/resources/table_data.txt` to see saved data

### Important Links
--
### Test Result
<img width="1178" height="650" alt="1" src="https://github.com/user-attachments/assets/1fbdb588-ebc4-47db-94f7-4f6d0fab73c0" />

### Test Video
https://drive.google.com/file/d/1q9XFGcYW9XewZrOLGBdXm6-MqmPM2RkD/view?usp=sharing

---


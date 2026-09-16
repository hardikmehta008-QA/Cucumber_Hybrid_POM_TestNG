package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

// Page Object for the Contact Us form: fill, submit and verify results.
public class ContactUsPage {
    private WebDriver driver;
    // 1. By Locators: OR (keep locators centralized for easy maintenance)
    private By contactHeading = By.xpath("//div[@class='col-sm-12']/*");
    private By contactName = By.xpath("//input[@name='name']");
    private By contactEmail = By.xpath("//input[@name='email']");
    private By subject = By.xpath("//input[@name='subject']");
    private By messageTextArea = By.xpath("//textarea[@name='message']");
    //form[@id='contact-us-form']/*[last()-2]
    private By submitButton = By.xpath("//input[@name='submit']");
    private By successMessage = By.xpath("//div[@class='status alert alert-success']");
    //2. Constructor of the page class:
    public ContactUsPage(WebDriver driver) {
        this.driver = driver;
    }
    //3. Page Actions: feature methods used by step definitions/tests.
    public String getContactUsPageTitle() {
        return driver.getTitle();
    }
    // Typo in name: keep for compatibility but consider renaming to getContactUsHeadingText().    public String getContactUstHeadingText() {        return driver.findElement(contactHeading).getText();    }
    public void fillContactForm(String name, String email, String subjectText, String message) {        // Interact with fields; consider adding waits/visibility checks in production code.        driver.findElement(contactName).click();        driver.findElement(contactName).sendKeys(name);
        driver.findElement(contactEmail).click();        driver.findElement(contactEmail).sendKeys(email);
        driver.findElement(subject).click();        driver.findElement(subject).sendKeys(subjectText);
        driver.findElement(messageTextArea).click();        driver.findElement(messageTextArea).sendKeys(message);    }
    public void clickSubmitButton() {        driver.findElement(submitButton).click();    }
    // Waits for JS alert, captures text and accepts it. Rename to acceptAlert() to follow Java naming conventions.    public String AcceptAlert() {        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));        Alert alert = wait.until(ExpectedConditions.alertIsPresent());        String alertText = alert.getText();        System.out.println("Alert message: " + alertText);        alert.accept();        return alertText;    }
    public String getSuccessMessage() {        return driver.findElement(successMessage).getText();    }
}

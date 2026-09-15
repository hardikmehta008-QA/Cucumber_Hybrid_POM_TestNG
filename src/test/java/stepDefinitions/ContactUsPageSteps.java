package stepDefinitions;

import factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Assert;
import pages.ContactUsPage;
import util.ExcelReader;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class ContactUsPageSteps {
    private ContactUsPage contactUsPage = new ContactUsPage(DriverFactory.getDriver());

    @Given("user navigates to contact us page")
    public void user_navigates_to_contact_us_page() {
        DriverFactory.getDriver().get("https://automationexercise.com/contact_us");

        String contactUsPageTitle = contactUsPage.getContactUsPageTitle();
        System.out.println("Contact Us Page Title: " + contactUsPageTitle);
        String contactUsHeadingText = contactUsPage.getContactUstHeadingText();
        System.out.println("Contact Us Heading Text: " + contactUsHeadingText);
        Assert.assertEquals("CONTACT US", contactUsHeadingText);

    }
    @When("user fills the form from given sheetname {string} and rownumber {int}")
    public void user_fills_the_form_from_given_sheetname_and_rownumber(String sheetName, Integer rowNumber) throws IOException, InvalidFormatException {
        ExcelReader excelReader = new ExcelReader();
        List<Map<String,String>> testData =  excelReader.getData("src/test/resources/Contact_us.xlsx", sheetName);
        String name = testData.get(rowNumber).get("Name");
        String email = testData.get(rowNumber).get("Email");
        String subjectText = testData.get(rowNumber).get("Subject");
        String message = testData.get(rowNumber).get("Message");
        contactUsPage.fillContactForm(name, email, subjectText, message);
    }
    @When("user clicks on submit button")
    public void user_clicks_on_submit_button() {
        contactUsPage.clickSubmitButton();

    }
    @When("user accept the alert {string}")
    public void user_accept_the_alert(String expectedAlertText) {
        String alertText = contactUsPage.AcceptAlert();
        System.out.println("Alert Text: " + alertText);
        Assert.assertEquals(expectedAlertText, alertText);
    }
    @Then("it shows a successful message {string}")
    public void it_shows_a_successful_message(String expectedSuccessMessage) {
        String actualSuccessMessage = contactUsPage.getSuccessMessage();
        System.out.println("Actual Success Message: " + actualSuccessMessage);
        Assert.assertEquals(expectedSuccessMessage, actualSuccessMessage);
    }

}

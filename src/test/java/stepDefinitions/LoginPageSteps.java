package stepDefinitions;

import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.LoginPage;

public class LoginPageSteps {

    private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
    private static String homePageTitle;

    @Given("user is on home page")
    public void user_is_on_home_page() {
        //DriverFactory.getDriver().get("https://automationexercise.com/"); // Replace with actual home page URL
        String homePageURL = loginPage.getHomePageUrl();
        System.out.println("Home Page URL: " + homePageURL);
    }

    @When("user gets the title of the home page")
    public void user_gets_the_title_of_the_home_page() {
        homePageTitle = loginPage.getHomePageTitle();
        System.out.println("Home Page Title: " + homePageTitle);
    }

    @Then("home page title should be {string}")
    public void home_page_title_should_be(String expectedTitleName) {
        /*if (homePageTitle.equals(expectedTitleName)) {
            System.out.println("Home page title is correct: " + homePageTitle);
        } else {
            System.out.println("Home page title is incorrect. Expected: " + expectedTitleName + ", Actual: " + homePageTitle);
        }*/
        Assert.assertTrue(homePageTitle.contains(expectedTitleName));
    }

    @Given("user clicks on login link")
    public void user_clicks_on_login_link() {
        loginPage.clickLoginLink();
    }
    @When("user is navigated to login page")
    public void user_is_navigated_to_login_page() {
        String loginPageUrl = loginPage.getLoginPageUrl();
        System.out.println("Login Page URL: " + loginPageUrl);

        String loginPageTitle = loginPage.getLoginPageTitle();
        System.out.println("Login Page Title: " + loginPageTitle);
        Assert.assertEquals("Automation Exercise - Signup / Login", loginPageTitle);
    }

    @Then("verify Login to your account text is visible")
    public void verify_login_to_your_account_text_is_visible() {
        String loginHeaderText = loginPage.getLoginHeaderText();
        System.out.println("Login Header Text: " + loginHeaderText);
        if(loginHeaderText.equals("Login to your account")) {
            System.out.println("Login to your account text is visible");
        } else {
            System.out.println("Login to your account text is not visible");
        }
    }

    @Then("user enters valid {string} and {string}")
    public void user_enters_valid_and(String username, String password) {
       loginPage.enterUsername(username);
       loginPage.enterPassword(password);
    }

    @And("user clicks on the login button")
    public void user_clicks_on_the_login_button() {
        loginPage.clickLoginButton();
    }

   /* @And("verify that Logged in as username is visible")
    public void verify_that_logged_in_as_username_is_visible() {
        String username = loginPage.verifyUserName();
        System.out.println("Logged in as: " + username);
        //Assert.assertEquals("testdata", username);
        if(username.equals("Logged in user:= " + username)) {
            System.out.println("Logged in as username is visible");
        } else {
            System.out.println("Logged in as username is not visible");
        }

    }*/

}

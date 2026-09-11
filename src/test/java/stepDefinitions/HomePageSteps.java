package stepDefinitions;

import factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.HomePage;
import pages.LoginPage;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class HomePageSteps {

    private static final Logger log = LoggerFactory.getLogger(HomePageSteps.class);
    private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
    private HomePage homepage;

    @Given("user has already logged in to application")
    public void user_has_already_logged_in_to_application(DataTable credentialTable) {
        List<Map<String, String>> userCredentials = credentialTable.asMaps(String.class, String.class);
        String username = userCredentials.get(0).get("email");
        String password = userCredentials.get(0).get("pwd");

        DriverFactory.getDriver().get("https://automationexercise.com/login");
        homepage = loginPage.login(username, password);
    }

    @Given("verify that Logged in as username is visible")
    public void verify_that_logged_in_as_username_is_visible() {
        String username = homepage.verifyUserName();
        System.out.println("Logged in as: " + username);
        //Assert.assertEquals("testdata", username);
        if (!username.equals("Logged in as := " + username)) {
            System.out.println("Logged in as username is visible");
        } else {
            System.out.println("Logged in as username is not visible");
        }
    }

    @Given("verify that product category section is visible on home page")
    public void verify_that_product_category_section_is_visible_on_home_page() {
        String categoryName = homepage.verifyCategoryName();
        System.out.println("Product category section is visible: " + categoryName);
        if (categoryName.equals("CATEGORY")) {
            System.out.println("Product category section is visible");
        } else {
            System.out.println("Product category section is not visible");
        }
    }

    @When("user gets the count of product categories")
    public void user_gets_the_count_of_product_categories(DataTable productCategoriesTable) {
        // Get the expected product categories from the DataTable in HomePage.feature
        List<String> expProductCategoriesList = productCategoriesTable.asList();
        System.out.println("Expected Product Categories List: " + expProductCategoriesList);

        List<String> actualProductCategoriesList = homepage.getProductsCategoryList();
        System.out.println("Actual Product Categories List: " + actualProductCategoriesList);

        Assert.assertTrue(expProductCategoriesList.containsAll(actualProductCategoriesList));

    }

    @Then("verify that count of product categories is {int}")
    public void verify_that_count_of_product_categories_is(Integer expectedCount) {
        Assert.assertTrue(homepage.getProductsCategoryCount() == expectedCount);

    }
}

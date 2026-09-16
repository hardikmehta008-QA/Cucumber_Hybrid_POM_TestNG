package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

// Page Object representing Login-related actions and elements.
public class LoginPage {

    private WebDriver driver;
    // 1. By Locators: Object Repository for this page. Prefer stable attributes (id/data-qa) over complex XPaths.
    private By loginLink = By.xpath("//a[@href='/login']");
    private By loginHeaderText = By.xpath("//div[@class='login-form']//h2");
    private By emailInput = By.xpath("//input[@data-qa='login-email' and @name='email']");
    private By passwordInput = By.xpath("//input[@data-qa='login-password' and @name='password']");
    private By loginButton = By.xpath("//button[@data-qa='login-button']");


    // 2. Constructor of the page class: keeps a reference to WebDriver used by tests.
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    //3. Page Actions: behaviors exposed by this page object.
    // Home page helpers (note: these return values from the current browser context)
    public String getHomePageUrl() {
        return driver.getCurrentUrl();
    }
    public String getHomePageTitle() {
        return driver.getTitle();
    }
    public void clickLoginLink() {
        // Wait until login link is visible and click when enabled. Prefer ExpectedConditions.elementToBeClickable.
        WebDriverWait wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(10));
        wait.until(driver -> driver.findElement(loginLink).isDisplayed());
        boolean loginLinkEnabled = driver.findElement(loginLink).isEnabled();
        if (loginLinkEnabled) {
            System.out.println("Login link is enabled. Clicking on it...");
            driver.findElement(loginLink).click();
        } else {
            System.out.println("Login link is not enabled. Cannot click.");
        }

    }
    //Login Page Actions:
    public String getLoginPageUrl() {
        return driver.getCurrentUrl();
    }
    public String getLoginPageTitle() {
        return driver.getTitle();
    }
    public String getLoginHeaderText() {
        return driver.findElement(loginHeaderText).getText();
    }
    public void enterUsername(String username) {
        // Consider clearing the field before typing to avoid residual text.
        driver.findElement(emailInput).click();
        driver.findElement(emailInput).sendKeys(username);
    }
    public void enterPassword(String password) {
        driver.findElement(passwordInput).click();
        driver.findElement(passwordInput).sendKeys(password);
    }
    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }
    // Composite action: perform login and return the next page object.
    // Avoid logging raw passwords in real projects; this is left as-is for debugging but should be removed for security.
    public HomePage login(String un, String pwd) {
        System.out.println("Logging in with username: " + un + " and password: " + pwd);
        driver.findElement(emailInput).click();
        driver.findElement(emailInput).sendKeys(un);
        driver.findElement(passwordInput).click();
        driver.findElement(passwordInput).sendKeys(pwd);
        driver.findElement(loginButton).click();
        return new HomePage(driver);
    }
}

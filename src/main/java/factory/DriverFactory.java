package factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

// Factory that creates and manages WebDriver instances using ThreadLocal to support parallel execution.
public class DriverFactory {
    public WebDriver driver;    public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();    /**     * Initialize the ThreadLocal driver based on requested browser name.     * Use WebDriverManager to manage driver binaries.     *     * @param browser browser id ("chrome", "firefox", "safari")     * @return WebDriver instance for the current thread     */    public WebDriver init_driver(String browser) {        System.out.println("browser value is: " + browser);        if (browser.equals("chrome")) {            WebDriverManager.chromedriver().setup();            tlDriver.set(new ChromeDriver());        } else if (browser.equals("firefox")) {            WebDriverManager.firefoxdriver().setup();            tlDriver.set(new FirefoxDriver());        } else if (browser.equals("safari")) {            tlDriver.set(new SafariDriver());        } else {            System.out.println("Please pass the correct browser value: " + browser);        }        // common driver setup        getDriver().manage().deleteAllCookies();        getDriver().manage().window().maximize();        // Base URL is hard-coded here; recommend moving to configuration.        getDriver().get("https://automationexercise.com/");        getDriver().manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(6));        return getDriver();    }    /**     * Returns the WebDriver instance for the current thread.     */    public static synchronized WebDriver getDriver() {        return tlDriver.get();    }}

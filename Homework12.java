import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by tinkerbellissimo on 1/20/17.
 */
public class Homework12 {
    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void start() {
        System.setProperty("webdriver.chrome.driver", "/Users/tinkerbellissimo/Downloads/chromedriver");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
    }

    @Test
    public void test() {
        driver.get("http://localhost/litecart/admin/");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();

        driver.findElement(By.cssSelector("ul li#app-:nth-child(2) .name")).click();
        driver.findElement(By.cssSelector(".button:last-child")).click();
        driver.findElement(By.cssSelector("[name=status]")).click();
        driver.findElement(By.xpath(".//*[@id='tab-general']/table/tbody/tr[2]/td/span/input")).sendKeys("whaleForSale");
        driver.findElement(By.cssSelector("[name=code")).sendKeys("123456");
        driver.findElement(By.cssSelector("[name=quantity")).clear();
        driver.findElement(By.cssSelector("[name=quantity")).sendKeys("1");
        driver.findElement(By.cssSelector("[type=file")).sendKeys("/Users/tinkerbellissimo/Desktop/whaleForSale.jpg");
        driver.findElement(By.cssSelector("div.tabs li:nth-child(4)")).click();
        driver.findElement(By.cssSelector("[name=purchase_price")).clear();
        driver.findElement(By.cssSelector("[name=purchase_price")).sendKeys("10");
        driver.findElement(By.cssSelector("[name=save]")).click();

        System.out.println(isElementPresent(driver, By.xpath(".//*[@id='content']/form/table/tbody/tr[5]/td[3]/a")));
    }

    @After
    public void stop() {
        driver.quit();
        driver = null;
    }

    boolean isElementPresent(WebDriver driver, By locator) {
        try {
            driver.findElement(locator);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}

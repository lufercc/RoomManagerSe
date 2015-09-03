package RoomManager;

import java.util.regex.Pattern;
import java.sql.Driver;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class AllopAdm{
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://172.20.208.142:4040/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    driver.manage().window().maximize();
  }

  @Test
  public void testAllOptionAdmin() throws Exception {
    driver.get(baseUrl + "/admin/#/login");
    driver.findElement(By.id("loginUsername")).clear();
    driver.findElement(By.id("loginUsername")).sendKeys("roompro\\room");
    driver.findElement(By.id("loginPassword")).clear();
    driver.findElement(By.id("loginPassword")).sendKeys("Control123!");
    driver.findElement(By.xpath("//button[@type='submit']")).click();
    assertTrue(isElementPresent(By.linkText("Room Manager")));
    driver.findElement(By.linkText("Email Servers")).click();
    driver.findElement(By.linkText("Impersonation")).click();
    assertEquals("Exchange Server Account", driver.findElement(By.cssSelector("label")).getText());
    driver.findElement(By.linkText("Conference Rooms")).click();
    assertEquals("Filter By Room", driver.findElement(By.cssSelector("div.col-xs-12 > div.ng-scope > div.row.ng-scope > div.col-xs-12")).getText());
    driver.findElement(By.linkText("Resources")).click();
    assertEquals("AddRemove\nFilter By Name", driver.findElement(By.cssSelector("div.col-xs-12.grid-header-bar")).getText());
    driver.findElement(By.linkText("Issues")).click();
    driver.findElement(By.linkText("Locations")).click();
    assertEquals("Locations", driver.findElement(By.cssSelector("h1")).getText());
    driver.findElement(By.linkText("Tablets")).click();
    //assertEquals("Tablet", driver.findElement(By.cssSelector("h1")).getText());
    driver.findElement(By.linkText("sign out")).click();
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}

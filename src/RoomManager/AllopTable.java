package RoomManager;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class AllopTable {
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
  public void testAllOptionTable() throws Exception {
    driver.get(baseUrl + "/tablet/#/register");
    driver.findElement(By.id("service-url-input")).clear();
    driver.findElement(By.id("service-url-input")).sendKeys("http://172.20.208.142:4040");
    driver.findElement(By.id("username")).clear();
    driver.findElement(By.id("username")).sendKeys("roompro\\room");
    driver.findElement(By.id("password")).clear();
    driver.findElement(By.id("password")).sendKeys("Control123!");
    driver.findElement(By.xpath("//div[@type='submit']")).click();
    driver.findElement(By.cssSelector("button.btn.btn-primary")).click();
    driver.findElement(By.cssSelector("div.meeting-title.ng-binding")).click();
    assertEquals("Schedule", driver.findElement(By.cssSelector("div.item.item-title > span")).getText());
    driver.findElement(By.cssSelector("i.fa.fa-home")).click();
    driver.findElement(By.cssSelector("div.tile-next.eod > div.info > div.meeting-title.ng-binding")).click();
    assertEquals("Schedule", driver.findElement(By.cssSelector("div.item.item-title > span")).getText());
    driver.findElement(By.cssSelector("i.fa.fa-home")).click();
    driver.findElement(By.xpath("//rm-panel-option/div/div/span")).click();
    driver.findElement(By.cssSelector("i.fa.fa-home")).click();
    driver.findElement(By.cssSelector("div.tile-button-search")).click();
    driver.findElement(By.cssSelector("i.fa.fa-home")).click();
    driver.findElement(By.xpath("//div[@id='timeline-container']/rm-vis/div/div[2]/div[2]/div[5]")).click();
    driver.findElement(By.cssSelector("i.fa.fa-home")).click();
    driver.findElement(By.xpath("//div[@id='timeline-container']/rm-vis/div/div[2]/div[2]/div[5]")).click();
    assertEquals("Schedule", driver.findElement(By.cssSelector("div.item.item-title > span")).getText());
    driver.findElement(By.cssSelector("i.fa.fa-home")).click();
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

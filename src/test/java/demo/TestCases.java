package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.logging.Level;
// import io.github.bonigarcia.wdm.WebDriverManager;
import demo.wrappers.Wrappers;

public class TestCases {
    ChromeDriver driver;

    /*
     * TODO: Write your tests here with testng @Test annotation. 
     * Follow `testCase01` `testCase02`... format or what is provided in instructions
     */

     
    /*
     * Do not change the provided methods unless necessary, they will help in automation and assessment
     */
    @BeforeTest
    public void startBrowser()
    {
        System.setProperty("java.util.logging.config.file", "logging.properties");

        // NOT NEEDED FOR SELENIUM MANAGER
        // WebDriverManager.chromedriver().timeout(30).setup();

        ChromeOptions options = new ChromeOptions();
        LoggingPreferences logs = new LoggingPreferences();

        logs.enable(LogType.BROWSER, Level.ALL);
        logs.enable(LogType.DRIVER, Level.ALL);
        options.setCapability("goog:loggingPrefs", logs);
        options.addArguments("--remote-allow-origins=*");

        System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "build/chromedriver.log"); 
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    
    
    }

@Test
public  void testCase01() throws InterruptedException{
   

driver.get("https://docs.google.com/forms/d/e/1FAIpQLSep9LTMntH5YqIXa5nkiPKSs283kdwitBBhXWyZdAS-e4CxBQ/viewform");
WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe("https://docs.google.com/forms/d/e/1FAIpQLSep9LTMntH5YqIXa5nkiPKSs283kdwitBBhXWyZdAS-e4CxBQ/viewform"));

Thread.sleep(2000);
WebElement name=driver.findElement(By.xpath("//span[normalize-space()='Name']/parent::div/parent::div/parent::div/following-sibling::div[@class='AgroKb']/div/div/div/div/input[@type='text']"));
name.click();
name.sendKeys("Crio Learner");
driver.findElement(By.xpath("//span [@class='M7eMe' and text()='Why are you practicing Automation?']/parent::div/parent::div/parent::div/parent::div/div[2]/div/div/div/textarea")).sendKeys("I want to be the best QA Engineer! 1710572021");
}

@Test
public  void testCase02() throws InterruptedException{

    
driver.findElement(By.xpath("//span[text()='0 - 2']")).click();
   driver.findElement(By.xpath("//span[text()='Java']")).click();
   driver.findElement(By.xpath("//span[text()='Selenium']")).click();
   driver.findElement(By.xpath("//span[text()='TestNG']")).click();
   driver.findElement(By.xpath("//span[text()='Choose']")).click();
   Thread.sleep(3000);
  WebElement drop= driver.findElement(By.xpath("//div[@role='option']//span[@class='vRMGwf oJeWuf'][normalize-space()='Mr']"));
  drop.click();}


  @Test
  public  void testCase03() throws InterruptedException{
  Thread.sleep(1000);
  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        String timestamp = String.valueOf(java.time.LocalDateTime.now());
        String date=timestamp.substring(8,10);
        int act=Integer.parseInt(date);
         act=act-7;
        driver.findElement(By.xpath("//input[@type='date']")).sendKeys(String.format("%d-09-2024", act));
        System.out.println("date Sent");
        driver.findElement(By.xpath("(//div[@class='Xb9hP']/input[@type='text' and @jsname='YPqjbf'])[2]")).sendKeys("07");
        driver.findElement(By.xpath("(//div[@class='Xb9hP']/input[@type='text' and @jsname='YPqjbf'])[3]")).sendKeys("30");
        System.out.println("Time Sent");
        driver.findElement(By.xpath("//span[text()='Submit']")).click();
        System.out.println("submission doen");
        WebElement sucessmessage=driver.findElement(By.xpath("//div[@class='vHW8K']"));
      String text=sucessmessage.getText();
      System.out.println(text);
      wait.until(ExpectedConditions.urlToBe("https://docs.google.com/forms/d/e/1FAIpQLSep9LTMntH5YqIXa5nkiPKSs283kdwitBBhXWyZdAS-e4CxBQ/formResponse"));

    }     




    @AfterTest
    public void endTest()
    {
       // driver.close();
        //driver.quit();

    }
}
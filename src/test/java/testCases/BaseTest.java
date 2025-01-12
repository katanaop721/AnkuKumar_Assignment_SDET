package testCases;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;



public class BaseTest {
	
	public static WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }
    
    @AfterClass
    public void tearDown() {
            driver.quit(); 
    }
    
 // Method to generate a random 6-character alphanumeric string
	public String randString() {
		  String generatestr=RandomStringUtils.randomAlphabetic(6);
		  return generatestr;
	  }
	
	
	public String captureScreen(String tname) throws IOException {
		
		// Get current timestamp for unique naming of screenshots
	    String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
	    
	    
	    TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
	    File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
	    
	 // Define the target file path where screenshot will be saved
	    String targetFilePath = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timeStamp + ".png";
	    File targetFile = new File(targetFilePath);
	    
	    // Rename the screenshot file to target file path
	    sourceFile.renameTo(targetFile);

	    return targetFilePath;
	}
	
}

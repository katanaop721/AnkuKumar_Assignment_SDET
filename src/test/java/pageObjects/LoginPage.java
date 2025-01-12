package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	// Locators for the elements on the login page
	@FindBy(xpath="//input[@name='user-name']") WebElement usernameField;
    @FindBy(xpath="//input[@name='password']") WebElement passwordField;
    @FindBy(xpath="//input[@id='login-button']") WebElement loginButton;


    public void enterUsername(String username){
        usernameField.sendKeys(username);
    }
    public void enterPassword(String password){
        passwordField.sendKeys(password);
    }
    public void clickOnLogin(){
        loginButton.click();
    }
 // Method to check if the login form is present on the page (last step)
    public boolean isLoginFormPresent() {
    	return loginButton.isDisplayed();
    }

		
}

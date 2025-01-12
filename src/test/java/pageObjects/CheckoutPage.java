package pageObjects;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends BasePage {

	public CheckoutPage(WebDriver driver) {
		super(driver);
	}

	// Locators for the various elements on the checkout page
	@FindBy(id="first-name") WebElement firstName;
	@FindBy(id="last-name") WebElement lastName;
	@FindBy(id="postal-code") WebElement postalCode;
	@FindBy(id="continue") WebElement continuebtn;
    @FindBy(className = "summary_subtotal_label") WebElement total;
    @FindBy(id = "finish") WebElement finishBtn;
    @FindBy(xpath="//h2[@class='complete-header']") WebElement msgConfirmation;
    @FindBy(id="finish") WebElement btnfinish;
    @FindBy(id="react-burger-menu-btn") WebElement hamburgerIcon;
    @FindBy(id="logout_sidebar_link") WebElement logOut;
	
    
    
	public void enterFirstName(String fname) {
		firstName.sendKeys(fname);
	}
	public void enterLastName(String lname) {
		lastName.sendKeys(lname);
	}
	public void enterPostalCode(String zipCode) {
		postalCode.sendKeys(zipCode);
	}
	
	public void clickOnContinueBtn() {
		continuebtn.click();
	}
	 public void clickOnFinishBtn() {
	        finishBtn.click();
	    }

	  public Double getTotalText() {
		  String totalText = total.getText();

	        // Extract the numeric value from the string using regular expression
	        String priceString = totalText.replaceAll("[^0-9.]", ""); // Removes everything except digits and dots

	        // Convert the string to a double
	        return Double.parseDouble(priceString);
	    }
	  
	  public void clickOnFinish() {
		  btnfinish.click();
	  }
	  public String getConfirmMessage(){
		  return msgConfirmation.getText();
	  }
	  public void clickOnHamburgerIcon() {
		  hamburgerIcon.click();
	  }
	  public void clickOnLogout() {
		  logOut.click();
	  }

}

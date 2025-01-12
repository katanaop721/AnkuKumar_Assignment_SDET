package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InventoryPage extends BasePage{

	public InventoryPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//a[@class='shopping_cart_link']") WebElement addToCartIcon;
	
	
	// Method to get the dynamic locator for Add to Cart buttons
     By getAddToCartButtonLocator(String productName) {
    	 // Convert the product name to lowerCase and replace spaces with hyphens
    	 String formattedProductName = productName.toLowerCase().replace(" ", "-");
    	    
    	 // Build the ID by appending the formatted product name to the prefix
    	 String dynamicId = "add-to-cart-" + formattedProductName;
    	 
    	 return By.id(dynamicId); // Locator built dynamically using product name
    }
     public void addToCart() {
 		addToCartIcon.click();
 	}
    // Method to add multiple items to the cart
    public void addItemsToCart(String[] productNames) {
        for (String productName : productNames) {
            By addToCartButton = getAddToCartButtonLocator(productName); // Get the dynamic locator for the Add to Cart button for each product
            driver.findElement(addToCartButton).click(); // // Clicking the button for each product
            System.out.println(productName + " added to the cart.");
        }
	
    }
}

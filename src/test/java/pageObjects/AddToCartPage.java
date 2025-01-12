package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddToCartPage extends BasePage {

	public AddToCartPage(WebDriver driver) {
		super(driver);
	}

	// Locator for the "Checkout" button
    @FindBy(xpath="//button[@id='checkout']") WebElement checkout;
 // Locator for the price of items in the cart
    @FindBy(className="inventory_item_price") List<WebElement> priceElements;
    // Locator for cart items
    @FindBy(className = "cart_item") List<WebElement> cartItems;
    

	
	
 // Method to check if a product is in the cart
    public boolean isProductInCart(String productName) {
        for (WebElement item : cartItems) {
            if (item.getText().contains(productName)) {
                return true; // Product is found in the cart
            }
        }
        return false; // Product is not found in the cart
	
    	}
    
 // Method to calculate the total price of all items in the cart
    public double getTotalPrice() {
    	double total=0.0;
    	// Iterating over all price elements and summing up the prices
        for(WebElement priceElement:priceElements) {
        	String priceText=priceElement.getText().replace("$", "");
        	double price=Double.parseDouble(priceText); // Converting the price text to double
        	total+=price;
        }
        return total;
    }
 // Method to click on the Checkout button to proceed with the checkout process
    public void clickOnCheckout(){
     	checkout.click();
     }
    
}

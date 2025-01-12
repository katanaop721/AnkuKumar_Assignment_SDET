package testCases;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.AddToCartPage;
import pageObjects.CheckoutPage;
import pageObjects.InventoryPage;
import pageObjects.LoginPage;
import utilities.ConfigReader;

public class TC01_EndToEnd extends BaseTest{
	
    @Test
    public void endToEnd() {
    	String url = ConfigReader.getProperty("url");
        String username = ConfigReader.getProperty("username");
        String password = ConfigReader.getProperty("password");
        
        driver.get(url);
        
        //Login Pages Actions
        LoginPage loginpage=new LoginPage(driver);
        loginpage.enterUsername(username);
        loginpage.enterPassword(password);
        loginpage.clickOnLogin();
        
        //Inventory Page Actions
        InventoryPage inventoryPage = new InventoryPage(driver);

        // List of product names to add to the cart
        String[] productNames = {"Sauce Labs Backpack", "Sauce Labs Bike Light", "Sauce Labs Fleece Jacket"};
        inventoryPage.addItemsToCart(productNames);
        inventoryPage.addToCart();
        
        //checking the product that is it added to cart or not
        AddToCartPage cart=new AddToCartPage(driver);
        for (String product : productNames) {
        	Assert.assertTrue(cart.isProductInCart(product), product + " not found in the cart!");
        }
      
     // Print the total price of the products in the cart
        System.out.println("Here I am printing my total: " + cart.getTotalPrice());
        
        cart.clickOnCheckout();
        
        //checkout operations
        CheckoutPage chPage=new CheckoutPage(driver);
        chPage.enterFirstName(randString());
        chPage.enterLastName(randString());
        chPage.enterPostalCode(randString());
        chPage.clickOnContinueBtn();
        

        double actualTotal = chPage.getTotalText(); // Get the total price from the checkout page
        double expectedTotal = cart.getTotalPrice(); // Get the expected total price from the cart

        // Validate that the total price is correct within a margin of 0.01 (tolerance for floating-point comparison)
        Assert.assertTrue(Math.abs(actualTotal - expectedTotal) < 0.01, "The total price is incorrect. Expected: " + expectedTotal + ", but got: " + actualTotal);
        
        chPage.clickOnFinish();
        
     // Validate the confirmation message after finishing the checkout process
        String Expected ="Thank you for your order!";
        Assert.assertEquals(chPage.getConfirmMessage(), Expected);
        
        chPage.clickOnHamburgerIcon();
        chPage.clickOnLogout();
        
     // Verify that the login form is displayed after logout
        Assert.assertTrue(loginpage.isLoginFormPresent(), "Logout failed! Login form is not displayed.");
        
    }
}

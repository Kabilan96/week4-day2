package week4.day2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazon {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		Actions action = new Actions(driver);
		//Load the uRL 
		driver.get("https://www.amazon.in/");
		
		//search as one-plus 9 pro 
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("oneplus 9 pro", Keys.ENTER);
		
		//Get the price of the first product
		String price = driver.findElement(By.xpath("//span[@class='a-price-whole']")).getText();
		price = price.replaceAll("[\\D]", " ");
		price = price.trim();
		System.out.println("Price of first product :" + price);
		
		//Print the number of customer ratings for the first displayed product
		String rating = driver.findElement(By.xpath("//span[@class='a-size-base']")).getText();
		System.out.println("Number of Customer Rating :" + rating);
		
		//Mouse Hover on the stars
		WebElement fiveRating = driver.findElement(By.xpath("//span[@class='a-icon-alt']"));
		action.moveToElement(fiveRating).click().perform();
		
		//Get the percentage of ratings for the 5 star
		String numRating = driver.findElement(By.xpath("//span[@class='a-size-base']/a[@class='a-link-normal']")).getText();
		System.out.println("Number of 5 star Rating :" + numRating);
		
		//Click the first text link of the first image
		WebElement firstPic = driver.findElement(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
		firstPic.click();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> winNew = new ArrayList<String>(windowHandles);
		driver.switchTo().window(winNew.get(1));
		
		//Take a screen shot of the product displayed
		WebElement screenPic = driver.findElement(By.id("imgTagWrapperId"));
		File screenshotAs = screenPic.getScreenshotAs(OutputType.FILE);
		File dest = new File("./snaps/img3.png");
		FileUtils.copyFile(screenshotAs, dest);
		
		//Click 'Add to Cart' button
		driver.findElement(By.id("add-to-cart-button")).click();
		
		// Get the cart sub-total and verify if it is correct.
		String subTotal = driver.findElement(By.id("attach-accessory-cart-subtotal")).getText();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		subTotal = subTotal.replaceAll("[\\D]", " ");
		System.out.println(subTotal);
		
		if (subTotal.contains(price))
			System.out.println("Same Price " +subTotal);
		else
			System.out.println("Not Same Price " +subTotal);
		
		driver.quit();
	}

}

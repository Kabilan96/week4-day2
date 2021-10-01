package week4.day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Sortable {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://jqueryui.com/sortable/");
		driver.switchTo().frame(0);
		
		WebElement sort1 = driver.findElement(By.xpath("//ul[@id='sortable']/li[1]"));
		WebElement sort2 = driver.findElement(By.xpath("//ul[@id='sortable']/li[6]"));
		WebElement sort3 = driver.findElement(By.xpath("//ul[@id='sortable']/li[5]"));
		WebElement sort4 = driver.findElement(By.xpath("//ul[@id='sortable']/li[3]"));
		 Actions builder=new Actions(driver);	
		   
		 builder.dragAndDrop(sort2, sort1).perform();
	
		 Thread.sleep(2000);
		 
		// builder.dragAndDrop(sort4, sort3).perform();
		builder.clickAndHold(sort4).moveToElement(sort3).release(sort3).perform();
		 
		driver.switchTo().defaultContent();
		
		
	}

}

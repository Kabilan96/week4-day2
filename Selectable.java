package week4.day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Selectable {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://jqueryui.com/selectable/");
		driver.switchTo().frame(0);
	
		WebElement element1 = driver.findElement(By.xpath("//li[text()='Item 2']"));
		WebElement element2 = driver.findElement(By.xpath("//li[text()='Item 3']"));
		WebElement element3 = driver.findElement(By.xpath("//li[text()='Item 4']"));

		Actions action = new Actions(driver);
		action.moveToElement(element1).click().perform();
		Thread.sleep(2000);
		action.moveToElement(element2).click().perform();
		Thread.sleep(2000);
		action.moveToElement(element3).click().perform();
		driver.switchTo().defaultContent();
	
	}
}

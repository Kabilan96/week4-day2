package week4.day2;

import java.util.concurrent.TimeUnit;

import org.apache.hc.core5.util.Timeout;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Draggable {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://jqueryui.com/draggable/");
		driver.switchTo().frame(0);
		WebElement element = driver.findElement(By.id("draggable"));
		Actions builder = new Actions(driver);
		int x = element.getLocation().getX();
		int y = element.getLocation().getY();
		builder.dragAndDropBy(element, x+80, y+40).perform();
		

	}

}

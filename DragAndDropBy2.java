package week4.day1;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DragAndDropBy2 {

	public static void main(String[] args) {
		
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver(co);
		driver.get("https://jqueryui.com/droppable/");
		driver.manage().window().maximize();
		//switch to frame
		driver.switchTo().frame(0);
		//Find the element for drag
		WebElement drag = driver.findElement(By.id("draggable"));
		//Find the element for drop
		WebElement drop = driver.findElement(By.id("droppable"));
		//Actions
		Actions builder = new Actions(driver);
		builder.dragAndDrop(drag, drop).perform();
		//Verify
		System.out.println(drop.getText());

		

		
	}

}

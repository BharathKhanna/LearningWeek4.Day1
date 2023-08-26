package week4.day1;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Frame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver(co);
		driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_confirm");
		driver.manage().window().maximize();
		//Switch to frame
		driver.switchTo().frame(1);
		//Click on element
		driver.findElement(By.xpath("//button[text()='Try it']")).click();
		//Click cancel
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
		//Print the resulting text
		String text = driver.findElement(By.id("demo")).getText();
		System.out.println(text);

	}

}

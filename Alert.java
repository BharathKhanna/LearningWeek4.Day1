package week4.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Alert {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver(co);
		driver.get("https://www.leafground.com/alert.xhtml;jsessionid=node0fknpzhbqej06hi9vfvb4rust239367.node0");
		driver.manage().window().maximize();
		//Click on the alert box
		driver.findElement(By.xpath("(//span[text()='Show'])[5]")).click();

	}

}

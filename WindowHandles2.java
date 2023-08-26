package week4.day1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandles2 {

	public static void main(String[] args) throws InterruptedException {
		
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver(co);
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		//Window Handle
		String windowHandle = driver.getWindowHandle();
		
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
		//Click Merge lead
		driver.findElement(By.linkText("Merge Leads")).click();
		//From lead to icon
		driver.findElement(By.xpath("//span[text()='From Lead']/following::img")).click();
		//Window handles
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> lstWindowHandles = new ArrayList<String>(windowHandles);
		String secondWindowHandle = lstWindowHandles.get(1);
		driver.switchTo().window(secondWindowHandle);
		//Type Babu
		driver.findElement(By.name("firstName")).sendKeys("Babu");
		//Click Find Leads
		driver.findElement(By.xpath("//button[text()=\"Find Leads\"]")).click();
		Thread.sleep(5000);
		//Click on first resulting lead
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']//a")).click();
		//Move the control back to first window
		driver.switchTo().window(windowHandle);
		
	}

}

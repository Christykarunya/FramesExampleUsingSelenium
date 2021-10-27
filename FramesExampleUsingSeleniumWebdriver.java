package week4.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FramesExampleUsingSeleniumWebdriver {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://chercher.tech/practice/frames-example-selenium-webdriver");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.switchTo().frame("frame1");
		driver.findElement(By.xpath("//b[@id='topic']/following-sibling::input")).sendKeys("FramesExampleInSelenium");
		Thread.sleep(2000);
		//driver.switchTo().defaultContent();
		
		driver.switchTo().frame("frame3");
		driver.findElement(By.xpath("//b[text()='Inner Frame Check box :']/following-sibling::input")).click();
		driver.switchTo().defaultContent();
		Thread.sleep(2000);
		
		driver.switchTo().frame("frame2");
		WebElement animalDD = driver.findElement(By.id("animals"));
		Select dd1=new Select(animalDD);
		dd1.selectByValue("babycat");
		Thread.sleep(2000)
		
		driver.close();
	}
	
}
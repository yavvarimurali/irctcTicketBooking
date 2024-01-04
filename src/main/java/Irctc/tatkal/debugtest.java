package Irctc.tatkal;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class debugtest {
	@Test
	public void main() throws InterruptedException {
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	driver.get("https://rahulshettyacademy.com/locatorspractice/");
	driver.findElement(By.cssSelector("input#inputUsername")).sendKeys("rahul");
	driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys("rahulshettyacademy");
	driver.findElement(By.id("chkboxOne")).click();
	driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click();
	//Thread.sleep(1000);
	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(3));
	
	WebElement tag=wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("p")));
	
	//WebElement tag=driver.findElement(By.tagName("p"));
	System.out.println(tag.getText());
	
	Assert.assertEquals(tag.getText(),"You are successfully logged in.");
}
}

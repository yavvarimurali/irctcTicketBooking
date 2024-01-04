package Irctc.tatkal;

import java.time.Duration;
import java.util.List;
import java.util.Scanner;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BokingTicket {
	/**
	 * @throws InterruptedException
	 */
	@Test
	public void ticketbooking() throws InterruptedException {
		Scanner input = new Scanner(System.in);

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.manage().timeouts().pageLoadTimeout(Duration.ofMinutes(3));

		driver.get("https://www.irctc.co.in/nget/train-search");
		/*
		 * WebElement ele= driver.findElement(By.linkText("LOGIN"));
		 * 
		 * WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		 * 
		 * wait.until(ExpectedConditions.elementToBeClickable(ele)).click();
		 * 
		 * //driver.findElement(By.cssSelector("input[class='ng-tns-c57-9']")).sendKeys(
		 * "Secundrabad"+Keys.DOWN+Keys.ENTER); WebElement
		 * checkbox=driver.findElement(By.xpath("//label[@for='otpLogin']"));
		 * 
		 * wait.until(ExpectedConditions.elementToBeClickable(checkbox)).click();
		 * 
		 * WebElement
		 * proceed=driver.findElement(By.cssSelector("button[class='btn btn-primary']"))
		 * ;
		 * 
		 * wait.until(ExpectedConditions.elementToBeClickable(proceed)).click();
		 * 
		 * driver.findElement(By.cssSelector("input[formcontrolname='userid']")).
		 * sendKeys("yavvarimurali");
		 * 
		 * driver.findElement(By.cssSelector("input[formcontrolname='password']")).
		 * sendKeys("Murali@225");
		 * 
		 * driver.findElement(By.xpath("//span/button[@class='search_btn train_Search']"
		 * )).click();
		 * 
		 * String otp=input.next();
		 * 
		 * driver.findElement(By.cssSelector("input[id='loginOTP']")).sendKeys(otp);
		 * 
		 * driver.findElement(By.cssSelector("button[class='btn btn-primary']")).click()
		 * ;
		 * 
		 * WebElement
		 * msg=driver.findElement(By.xpath("//span[@class='ng-star-inserted']"));
		 * 
		 * String welcomemsg=wait.until(ExpectedConditions.visibilityOf(msg)).getText();
		 * 
		 * System.out.println(welcomemsg);
		 * 
		 WebElement from = driver.findElement(By.cssSelector("input.ng-tns-c57-8"));

		from.sendKeys("SECUNDERABAD JN - SC (SECUNDERABAD)");

		Thread.sleep(200);

		from.sendKeys(Keys.ENTER);

		WebElement to = driver.findElement(By.cssSelector("input.ng-tns-c57-9"));

		to.sendKeys("PALASA - PSA ");

		Thread.sleep(200);

		to.sendKeys(Keys.ENTER);

		WebElement date = driver.findElement(By.cssSelector("input.ng-tns-c58-10"));

		// date.clear();

		// Thread.sleep(1000);

		String key = Keys.chord(Keys.DOWN, Keys.CONTROL, "A", Keys.BACK_SPACE);

		date.sendKeys(key + "24/11/2023");

		Thread.sleep(1000);

		date.sendKeys(Keys.ENTER);

		List<WebElement> list = driver.findElements(By.xpath("//div[contains(@class,train-heading)]/strong"));

		for (int i = 0; i < list.size(); i++) {

		}
		System.out.println(list);

		Thread.sleep(3000);

		input.close();
		public void scrollToWebElement(WebElement element) {
    JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center', inline: 'nearest'});", element);
}

		
*/
		//span[contains(text(),'IRCTC Trains')]
		WebElement element=driver.findElement(By.xpath("//span[contains(text(),'IRCTC Trains')]")) ;
		JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center', inline: 'nearest'});", element);
		
		// driver.close();
	}
}
//ng-tns-c57-9 ui-inputtext ui-widget ui-state-default ui-corner-all ui-autocomplete-input ng-star-inserted"
//ng-tns-c57-8 ui-inputtext ui-widget ui-state-default ui-corner-all ui-autocomplete-input ng-star-inserted

package Irctc.tatkal;

import java.time.Duration;
import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class chatgpt2 {

	@Test
	public void ticketbooking() throws InterruptedException {
		Scanner input = new Scanner(System.in);

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		driver.get("https://www.irctc.co.in/nget/train-search");
		/*
		 * WebElement ele = driver.findElement(By.linkText("LOGIN"));
		 * 
		 * wait.until(ExpectedConditions.visibilityOf(ele)).click();
		 * 
		 * WebElement checkbox =
		 * driver.findElement(By.xpath("//label[@for='otpLogin']"));
		 * 
		 * wait.until(ExpectedConditions.elementToBeClickable(checkbox)).click();
		 * 
		 * WebElement proceed =
		 * driver.findElement(By.cssSelector("button[class='btn btn-primary']"));
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
		 * String otp = input.next();
		 * 
		 * driver.findElement(By.cssSelector("input[id='loginOTP']")).sendKeys(otp);
		 * 
		 * driver.findElement(By.cssSelector("button[class='btn btn-primary']")).click()
		 * ;
		 * 
		 * WebElement msg =
		 * driver.findElement(By.xpath("//span[@class='ng-star-inserted']"));
		 * 
		 * String welcomemsg =
		 * wait.until(ExpectedConditions.visibilityOf(msg)).getText();
		 * 
		 * System.out.println(welcomemsg);
		 */
		WebElement ele = driver.findElement(By.linkText("LOGIN"));

		wait.until(ExpectedConditions.visibilityOf(ele)).click();

		//WebElement checkbox = driver.findElement(By.xpath("//label[@for='otpLogin']"));

		//wait.until(ExpectedConditions.elementToBeClickable(checkbox)).click();

		//WebElement proceed = driver.findElement(By.cssSelector("button[class='btn btn-primary']"));

		//wait.until(ExpectedConditions.elementToBeClickable(proceed)).click();

		driver.findElement(By.cssSelector("input[formcontrolname='userid']")).sendKeys("yavvarimurali");

		driver.findElement(By.cssSelector("input[formcontrolname='password']")).sendKeys("Murali@225");

		driver.findElement(By.xpath("//span/button[@class='search_btn train_Search']")).click();

		String otp = input.next();

		driver.findElement(By.cssSelector("input[id='loginOTP']")).sendKeys(otp);

		driver.findElement(By.cssSelector("button[class='btn btn-primary']")).click();

		WebElement msg = driver.findElement(By.xpath("//span[@class='ng-star-inserted']"));

		String welcomemsg = wait.until(ExpectedConditions.visibilityOf(msg)).getText();

		System.out.println(welcomemsg);

		WebElement from = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.ng-tns-c57-8")));
		from.sendKeys("SECUNDERABAD JN - SC (SECUNDERABAD)");
		from.sendKeys(Keys.ENTER);

		WebElement to = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.ng-tns-c57-9")));
		to.sendKeys("PALASA - PSA ");
		to.sendKeys(Keys.ENTER);

		WebElement date = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.ng-tns-c58-10")));
		date.sendKeys(Keys.chord(Keys.DOWN, Keys.CONTROL, "A", Keys.BACK_SPACE) + "24/11/2023");
		date.sendKeys(Keys.ENTER);

		List<WebElement> list = wait.until(ExpectedConditions
				.visibilityOfAllElementsLocatedBy(By.xpath("//div[contains(@class,'train-heading')]/strong")));

		for (WebElement element : list) {
			// Perform actions with each element if needed
			int i = 0;
			System.out.println(element.getText());

			if (element.getText().equalsIgnoreCase("KONARK EXPRESS (11019)")) {
				// Find and click the AC class for Konark Express
				List<WebElement> acClasslist = element
						.findElements(By.xpath("//div/strong[contains(text(), 'AC 3 Tier (3A)')]"));
				System.out.println("acclasslistsize" + acClasslist.size());
				for (WebElement acclass : acClasslist) {
					int count = 0;
					if (i == count) {
						acclass.click();
					}
					count++;
				}

				System.out.println(element.getAccessibleName() + element.getAriaRole());
				WebElement datepicker = wait.until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath("//div/strong[contains(text(),'Fri, 24 Nov')]")));

				datepicker.click();
				// Find and click the "Book Now" button for Konark Express Fri, 24 Nov
				WebElement bookNowButton = element.findElement(By.xpath("//button[contains(text(), 'Book Now')]"));
				bookNowButton.click();

				break; // Assuming you want to interact with only the first matching train element
			}
			i++;
		}

		input.close();
		// WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(5));

		// This waits for 5 seconds before closing the browser
		// wait.sleep(Duration.ofSeconds(5));

		// driver.quit();
	}
}

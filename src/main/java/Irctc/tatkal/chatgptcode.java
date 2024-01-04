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

public class chatgptcode {

	@Test
	public void ticketbooking() throws InterruptedException {
		Scanner input = new Scanner(System.in);

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		driver.get("https://www.irctc.co.in/nget/train-search");

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
			System.out.println(element.getText());

			if (element.getText().equalsIgnoreCase("VISAKHA EXP (17016)")) {
				WebElement correspondingChild = element.findElement(By.xpath(
						"//parent::*//parent::*//following-sibling::div[2]//div//table//tr//td//div//div/strong"));
				String correspondingChildText = correspondingChild.getText();
				System.out.println(correspondingChildText);
				correspondingChild.click();
				break; // Assuming you want to interact with only the first matching train element
			}
		}

		input.close();
		// WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(5));

		// This waits for 5 seconds before closing the browser
		// wait.sleep(Duration.ofSeconds(5));

		// driver.quit();
	}
}
//div[contains(@class, "form-group")]//strong[contains(text(), "  
//VISAKHA EXP (17016)
//")]

//div[conatins(@class,'form-group')]//strong[contains(text(),'VISAKHA EXP (17016)')]
//div[conatins(@class,"form-group")]//strong[contains(text(),"VISAKHA EXP (17016)")]
//div[contains(@class, "form-group")]//strong[contains(text(), "VISAKHA EXP (17016)")]
/*

public void selectTrainAndClass(String trainName,String classTypeName,String date) throws InterruptedException {
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.tbis-div")));
	
	
	
	StringBuffer sb=new StringBuffer();
	sb.append("//div[contains(@class,\"form-group\")]//strong[contains(text(),\"").append(trainName).append("\")]");		
	
	String trainxpath=sb.toString();
	logger.info(trainxpath);
	
	driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));		
	WebElement train=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(trainxpath)) );
	
	//wait.until(ExpectedConditions.stalenessOf(train));
	
	JavascriptExecutor jse=(JavascriptExecutor)driver;
	//jse.executeScript("arguments[0].scrollIntoView({ behavior: 'smooth', block: 'center', inline: 'nearest' });",train);
	
	Point location = train.getLocation();
	int xPosition = location.getX();
	int yPosition = location.getY();

	System.out.println("X Position: " + xPosition);
	System.out.println("Y Position: " + yPosition);

	jse.executeScript("window.scrollBy(arguments[0], arguments[1])", xPosition, yPosition);
	
	
	sb.delete(0, sb.length());
	
	sb.append("//div/strong[contains(text(),\"").append(classTypeName).append("\")]");
	
	String classTypexpath=sb.toString();
	logger.info(classTypexpath);
	WebElement classType=wait.until(ExpectedConditions.visibilityOf(train.findElement(By.xpath(classTypexpath))));
	classType.click();
	sb.delete(0, sb.length());
	
	sb.append("//div/strong[contains(text(),\"").append(date).append("\")]");
	
	String datepickxpath=sb.toString();
	
	logger.info(datepickxpath);
	
	WebElement datePick=wait.until(ExpectedConditions.visibilityOf(train.findElement(By.xpath(datepickxpath))));
	
	datePick.click();
	
	sb.delete(0, sb.length());
	
	sb.append("//button[contains(text(),\"Book Now\"");
	
	String booknowbtnxpath=sb.toString();
	WebElement bookNowBtn=wait.until(ExpectedConditions.visibilityOf(train.findElement(By.xpath(booknowbtnxpath))));
	
	bookNowBtn.click();
	
}
*/
//trainTitle.click(); // Clicking on the identified train

//Now, within this specific train element, locate the class and date elements
//Adjust the locators according to your IRCTC page structure
/*           
//WebElement classElement = driver.findElement(By.xpath(elementxpath));
scrollToWebElement(classElement);
classElement.click(); // Clicking on the desired class

WebElement dateElement = trainElement.findElement(By.xpath(".//strong[contains(text(),'" + date + "')]"));
scrollToWebElement(dateElement);
dateElement.click(); // Clicking on the desired date
*/
// Perform further actions or booking steps if needed
// ...

//break; // Exit loop after finding the desired train

//By.xpath("//button[contains(text(), 'Book Now')]")
//datepicker.click();

//wait.until(ExpectedConditions
//	.attributeContains(bookNowButton,"class", "btnDefault train_Search ng-star-inserted"));

//	wait.until(ExpectedConditions.refreshed(null));


package Irctc.tatkal;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class IRCTCBookingAutomation {

	private WebDriver driver;
	private WebDriverWait wait;
	final static Logger logger = LoggerFactory.getLogger(IRCTCBookingAutomation.class);

	public IRCTCBookingAutomation(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(60));

	}

	public void login(String username, String password) throws InterruptedException {
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(120));
		driver.get("https://www.irctc.co.in/nget/train-search");
		WebElement loginLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("LOGIN")));
		loginLink.click();

		logger.info("page opened");

		WebElement userIdField = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[formcontrolname='userid']")));
		userIdField.sendKeys(username);
		logger.info("username entered");
		WebElement passwordField = driver.findElement(By.cssSelector("input[formcontrolname='password']"));
		passwordField.sendKeys(password);
		logger.info("password entered");
		// WebElement captcha=driver.findElement(By.cssSelector("input#captcha"));

		// Thread.sleep(7000);

		// WebElement popupBody =
		// driver.findElement(By.cssSelector(".ui-dialog-draggable"));

		// Scroll to the bottom of the popup body
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.querySelector('div.ui-dialog-content').scrollBy(0,500)");

		Thread.sleep(15000);

		WebElement loginButton = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'SIGN IN')]")));
		loginButton.click();
	}

	public void enterSourceAndDestination(String source, String destination) {
		WebElement from = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.ng-tns-c57-8")));
		from.sendKeys(source);
		from.sendKeys(Keys.ENTER);
		logger.info("source name is entered correctly " + source);
		WebElement to = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.ng-tns-c57-9")));
		to.sendKeys(destination + Keys.DOWN);
		// to.sendKeys(Keys.ENTER);
		logger.info("destination name is entered correctly " + destination);
	}

	public void selectDate(String date) {
		WebElement dateField = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.ng-tns-c58-10")));
		dateField.sendKeys(Keys.chord(Keys.DOWN, Keys.CONTROL, "A", Keys.BACK_SPACE) + date);
		dateField.sendKeys(Keys.ENTER);
		logger.info("journey date selected " + date);

		// wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("input.ng-tns-c57-8")));
	}

	public void scrollToWebElement(WebElement element) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;

			js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center', inline: 'nearest'});",
					element);
		} catch (Exception e) {
			logger.info("not able to scroll to the element");
		}
	}

	public void selectTrainAndClass(String trainName, String classTypeName) throws InterruptedException {
		logger.info("select train method started");
		List<WebElement> trainElements =wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[contains(@class,'train-heading')]")));
		int traincount = 0;
		for (WebElement trainElement : trainElements) {
			traincount++;
			WebElement trainTitle = trainElement.findElement(By.xpath(".//strong"));
			logger.info(trainTitle.getText() + "  " + trainName);
			if (trainTitle.getText().contains(trainName)) {
				scrollToWebElement(trainTitle);
				String elementxpath = String.format("//div/strong[contains(text(),'%s')]",classTypeName);
				logger.info(elementxpath);
				
				List<WebElement> acClasslist = driver.findElements(By.xpath(elementxpath));

				if (!acClasslist.isEmpty() && traincount <= acClasslist.size()) {
					WebElement acClass = acClasslist.get(traincount - 1);
					scrollToWebElement(acClass);
					acClass.click();

					WebElement datepicker = wait.until(ExpectedConditions
							.visibilityOfElementLocated(By.xpath("//div/strong[contains(text(),'4 Dec')]")));
					datepicker.click();

					//scrollToWebElement(datepicker);
					List<WebElement> bookNowButtonlist = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//button[contains(text(), 'Book Now')]")));

					//wait.until(ExpectedConditions.elementToBeClickable(bookNowButton));
					WebElement bookNowBtn=bookNowButtonlist.get(traincount-1);
					scrollToWebElement(bookNowBtn);
					
					bookNowBtn.click();

					break;
				}
			} else {
				logger.info("The train which you are looking for is not founded");
			}
		}
	}

	public void searchAndBookTicket(String trainName) {
		List<WebElement> trainElements = wait.until(ExpectedConditions
				.visibilityOfAllElementsLocatedBy(By.xpath("//div[contains(@class,'train-heading')]/strong")));

		int trainCount = 0;

		for (WebElement element : trainElements) {
			String currentTrainName = element.getText();
			logger.info(currentTrainName + "  " + trainName);
			trainCount++;

			if (currentTrainName.equalsIgnoreCase(trainName)) {
				// scrollToWebElement(element);
				List<WebElement> acClasslist = element
						.findElements(By.xpath("//div/strong[contains(text(), 'AC 3 Tier (3A)')]"));

				if (!acClasslist.isEmpty() && trainCount <= acClasslist.size()) {
					WebElement acClass = acClasslist.get(trainCount - 1);

					acClass.click();

					WebElement datepicker = wait.until(ExpectedConditions
							.visibilityOfElementLocated(By.xpath("//div/strong[contains(text(),'Sun, 10 Dec')]")));
					datepicker.click();
					// By.xpath("//button[contains(text(), 'Book Now')]")
					datepicker.click();
					scrollToWebElement(datepicker);
					WebElement bookNowButton = driver.findElement(By.xpath("//button[contains(text(), 'Book Now')]"));
					logger.info(bookNowButton.getDomAttribute("class"));
					// wait.until(ExpectedConditions
					// .attributeContains(bookNowButton,"class", "btnDefault train_Search
					// ng-star-inserted"));

					// wait.until(ExpectedConditions.refreshed(null));

					wait.until(ExpectedConditions.elementToBeClickable(bookNowButton));
					bookNowButton.click();

					break;
				}
			}
		}
	}
	
	public void fillingPassengerDtls(List<String> passdtlsList) {
		String Name=passdtlsList.get(0);
		String age=passdtlsList.get(1);
		String gender=passdtlsList.get(2);
		String preference=passdtlsList.get(3);
		WebElement passangerName=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Passenger Name']")));
		passangerName.sendKeys(Name);
		WebElement passangerAge=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Age']")));
		passangerAge.sendKeys(age);
		WebElement passangerGender=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@formcontrolname='passengerGender']")));
		Select genderdropdown=new Select(passangerGender);
		genderdropdown.selectByVisibleText(gender);
		WebElement passangerPreference=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@formcontrolname='passengerBerthChoice']")));
		Select passangerPreferencedropdown=new Select(passangerPreference);
		passangerPreferencedropdown.selectByVisibleText(preference);
		
		WebElement autoUpdateCheckbox=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='autoUpgradation']")));
		scrollToWebElement(autoUpdateCheckbox);
//		autoUpdateCheckbox.click();
		
		WebElement paymentBhimUpi=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[contains(text(),'Pay through BHIM/UPI')]/p-radiobutton")));
		scrollToWebElement(paymentBhimUpi);
		paymentBhimUpi.click();
		
		WebElement continueBtn=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[contains(text(),'Continue ')]")));
		scrollToWebElement(continueBtn);
		continueBtn.click();
	}

}

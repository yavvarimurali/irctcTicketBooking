package Irctc.tatkal;

import java.util.LinkedList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class test {
	@Test
	public void testautomation() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver(options);

		IRCTCBookingAutomation irctcAutomation = new IRCTCBookingAutomation(driver);

		// Input credentials, source, destination, date, etc. from the user or
		// configuration
		String username = "yavvarimurali";
		String password = "Murali@225";
		String sourceStation = "SECUNDERABAD JN - SC (SECUNDERABAD)";
		String destinationStation = "PALASA - PSA";
		String travelDate = "12/4/2024";
		String trainToBook = "VISAKHA EXP (17016)";
		String classType="AC 3 Tier (3A)";
		
		List<String> passList=new LinkedList<String>();
		passList.add("Murali");
		passList.add("28");
		passList.add("Male");
		passList.add("Lower");

		irctcAutomation.login(username, password);
		irctcAutomation.enterSourceAndDestination(sourceStation, destinationStation);
		irctcAutomation.selectDate(travelDate);
		irctcAutomation.selectTrainAndClass(trainToBook,classType);
		irctcAutomation.fillingPassengerDtls(passList);

		// driver.quit();
	}

}

package org.iit.mmp.patientmodule.pages;

import java.util.List;

import org.iit.util.AppLibrary;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class PayFeesPage {
	WebDriver driver;
	By username = By.id("username");
	By password = By.id("password");
	By submit = By.name("submit");
	By payNowBtn = By.linkText("Pay Now");
	By payAmount = By.id("amount");
	By continueBtn = By.xpath("//input[@value='Continue']");
	By cardHolder = By.id("name");
	By cardType = By.id("card_name");
	By cardNumber = By.id("cid");
	By cardExpiryMonth = By.id("cardMonth");
	By cardExpiryYear = By.id("cardYear");
	By cvv = By.id("cvv");
	By submitBtn = By.xpath("//input[@value='submit']");
	
	public PayFeesPage(WebDriver driver)
	{
		this.driver=driver;
	}

	/*
	 * public boolean validateFeesDetailsinFeesPage(HashMap<String,String> hMap)
	 * { boolean result = false; driver.findElement(payNowBtn).click(); //Xray
	 * 06/20/2020:......$50 String chooseFees[] = driver.findElement(By.
	 * xpath("//li[contains(text(),'Xray 06/20/2020:......$50')]")).getText().
	 * split(":");
	 * 
	 * }
	 */
	public void selectPayment(String amount) {
		Select payment = new Select(driver.findElement(payAmount));
		payment.selectByVisibleText(amount);
		driver.findElement(continueBtn).click();
	}

	public void cardDetails(String cardHolderName, String cid, String expiryMonth, String expiryYear, String cvvValue) {
		driver.findElement(cardHolder).sendKeys(cardHolderName);

		Select card = new Select(driver.findElement(cardType));
		List<WebElement> cardList = card.getOptions();

		for (int i = 0; i < cardList.size(); i++) {
			String cardName = card.getOptions().get(i).getText();
			if (cardName.equals("Visa")) {
				card.selectByVisibleText("Visa");
				//String visaCardNumber=(long) (AppLibrary.getRandomDigits(14) + 4400000000000000L)+"";
				driver.findElement(cardNumber).sendKeys(visaCardNumber);
				break;
			} else if (cardName.equals("Master Card")) {
				card.selectByVisibleText("Master Card");
				//String masterCardNumber=;
				driver.findElement(cardNumber).sendKeys(masterCardNumber);
				break;
			} else if (cardName.equals("American Express")) {
				card.selectByVisibleText("American Express");
				//String aeCardNumber =
				driver.findElement(cardNumber).sendKeys(aeCardNumber);
				break;
			} else if (cardName.equals("Discover")) {
				card.selectByVisibleText("Discover");
				//String discoverCardNumber=;
				driver.findElement(cardNumber).sendKeys(discoverCardNumber);
				break;
			}
		}

		Select month = new Select(driver.findElement(cardExpiryMonth));
		month.selectByValue(expiryMonth);

		Select year = new Select(driver.findElement(cardExpiryYear));
		year.selectByValue(expiryYear);

		driver.findElement(cvv).sendKeys(cvvValue);
	}

	public void submitPayment() {
		driver.findElement(submitBtn).click();
	}

	public void runner() {
		selectPayment("$50");
		cardDetails("Riaben", "4407685646574498", "12", "23", "666");
		submitPayment();

	}

}

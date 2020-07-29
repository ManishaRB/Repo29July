package org.iit.mmp.patientmodule.pages;

import java.util.HashMap;
import java.util.Random;

import org.iit.mmp.helper.HelperClass;
import org.iit.util.AppLibrary;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class RegistrationPage {
	By fNameTB = By.id("firstname");
	By lNameTB = By.id("lastname");
	By dobTB = By.id("datepicker");	
	By licenseTB = By.id("license");
	By ssnTB = By.id("ssn");
	By stateTB = By.id("state");
	By cityTB = By.id("city");	
	By addressTB = By.id("address");
	By zipCodeTB = By.id("zipcode");	
	By ageTB = By.id("age");	
	By heightTB = By.id("height");
	By weightTB = By.id("weight");
	By pharmacyTB = By.id("pharmacy");	
	By pharma_adressTB = By.id("pharma_adress");	
	By emailTB = By.id("email");	
	By passwordTB = By.id("password");	
	By usernameTB = By.id("username");
	By confirmPasswordTB = By.id("confirmpassword");
	By securityLB = By.id("security");	
	By answerTB = By.id("answer");	
	By submitBT = By.xpath("//p[@class='login button']//input");
	WebDriver driver;
	HelperClass helperObj ;
	HashMap<String,String> hMap = new HashMap<String,String>();
	int nChars = 5;
	public RegistrationPage(WebDriver driver)
	{
		this.driver = driver;
		helperObj = new HelperClass(driver);
	}
	public void enterFirstName()
	{
		String fnameValue="ATFName" + AppLibrary.getRandomChars(nChars);
		driver.findElement(fNameTB).sendKeys(fnameValue);
		hMap.put("fname", fnameValue);

	}
	public void enterLastName()
	{
		String lnameValue="ATLName" + AppLibrary.getRandomChars(nChars);
		driver.findElement(lNameTB).sendKeys(lnameValue);
		hMap.put("lname", lnameValue);

	}
	public void enterdob(int n)
	{
		String date = AppLibrary.getFutureYear(n, "dd/MM/YYYY");
		driver.findElement(dobTB).sendKeys(date);
		hMap.put("dob", date);

	}
	public void enterLicense()
	{
		Long licenseValue=AppLibrary.getRandomDigits(8);
		driver.findElement(licenseTB).sendKeys("12345678");
		hMap.put("license", licenseValue.toString());

	}
	public void enterssn()
	{
		Long ssnValue=AppLibrary.getRandomDigits(9);
		driver.findElement(ssnTB).sendKeys(ssnValue.toString());
		hMap.put("ssn", ssnValue.toString());

	}
	public void enterState()
	{
		int n = new Random().nextInt(3);
		String stateValue=AppLibrary.stateArr()[n] ;
		driver.findElement(stateTB).sendKeys(stateValue);
		hMap.put("state", stateValue);

	}
	public void entercity()
	{
		int n = new Random().nextInt(3);
		String cityValue=AppLibrary.stateArr()[n] ;
		driver.findElement(cityTB).sendKeys(cityValue);
		hMap.put("city", cityValue);

	}
	public void enterAddress()
	{
		String addressValue="ATFName" + AppLibrary.getRandomChars(nChars);
		driver.findElement(addressTB).sendKeys(addressValue);
		hMap.put("address", addressValue);

	}
	public void enterzipCode()
	{
		Long zipValue=AppLibrary.getRandomDigits(4);
		driver.findElement(zipCodeTB).sendKeys(zipValue.toString());
		hMap.put("zipCode", zipValue.toString());

	}
	public void enterAge()
	{
		Long ageValue = AppLibrary.getRandomDigits(1);
		driver.findElement(ageTB).sendKeys(ageValue.toString());
		hMap.put("age", ageValue.toString());

	}
	public void enterWeight()
	{
		Long weightValue = AppLibrary.getRandomDigits(1);
		driver.findElement(weightTB).sendKeys(weightValue.toString());
		hMap.put("weight", weightValue.toString());

	}
	public void enterheight()
	{
		Long heightValue=AppLibrary.getRandomDigits(1);
		driver.findElement(heightTB).sendKeys(heightValue.toString());
		hMap.put("fname", heightValue.toString());

	}
	public void enterPharmacy()
	{
		String pharmacyValue="ATFName" + AppLibrary.getRandomChars(nChars);
		driver.findElement(pharmacyTB).sendKeys(pharmacyValue);
		hMap.put("pharmacy", pharmacyValue);

	}
	public void enterPharmacyAddress()
	{
		String pharma_adress_value="ATFName" + AppLibrary.getRandomChars(nChars);
		driver.findElement(pharma_adressTB).sendKeys(pharma_adress_value);
		hMap.put("pharmacyaddress", pharma_adress_value);

	}
	public void enterEmail()
	{
		String emailValue="ATFName" + AppLibrary.getRandomChars(nChars)+"@gmail.com";
		driver.findElement(emailTB).sendKeys(emailValue);
		hMap.put("email", emailValue);

	}
	public void enterPassword()
	{
		String pwordValue="ATFName" + AppLibrary.getRandomChars(nChars)+ AppLibrary.getRandomDigits(nChars);
		driver.findElement(passwordTB).sendKeys(pwordValue);
		hMap.put("password", pwordValue);



		driver.findElement(confirmPasswordTB).sendKeys(pwordValue);
		hMap.put("confirmPwd", pwordValue);


	}
	public void enterusernameTB()
	{
		String unameValue="ATFName" + AppLibrary.getRandomChars(nChars);
		driver.findElement(usernameTB).sendKeys(unameValue);
		hMap.put("uname", unameValue);

	}
	public void enterSecurity()
	{
		Select select = new Select(driver.findElement(securityLB));
		select.selectByVisibleText("what is your best friend name");
		String answerValue="ATFName" + AppLibrary.getRandomChars(nChars);
		driver.findElement(answerTB).sendKeys(answerValue);

	}
	public void clickOnSaveButton() throws InterruptedException
	{


		Thread.sleep(5000);
		driver.findElement(submitBT).click();


	}
	public String readSuccessMsg()
	{
		Alert alrt = driver.switchTo().alert();
		String actual = alrt.getText();
		alrt.accept();
		return actual;
	}
	public HashMap<String, String> fillData() throws InterruptedException
	{
		enterFirstName();
		enterLastName( );
		enterAddress();
		enterAge();
		entercity();
		enterdob(-20);
		enterEmail();
		enterheight();
		enterLicense();
		enterPassword();
		enterPharmacy();
		enterPharmacyAddress();
		enterSecurity();
		enterssn();
		enterState();
		enterusernameTB();
		enterWeight();
		enterzipCode();
		clickOnSaveButton();
		return hMap;
	}
}

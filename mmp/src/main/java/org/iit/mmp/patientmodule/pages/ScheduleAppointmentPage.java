package org.iit.mmp.patientmodule.pages;

import java.util.HashMap;

import org.iit.mmp.helper.HelperClass;
import org.iit.util.AppLibrary;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class ScheduleAppointmentPage {
	By createAppointmentButton = By.xpath("//input[@value='Create new appointment']");
	By datePicker = By.xpath("//input[@class='hasDatepicker']");
	By continueButton = By.id("ChangeHeatName");
	By symptxtbox = By.id("sym");
	By submitButton =By.xpath("//input[@value='Submit']");
	By providerNameDetails = By.xpath("//a[contains(text(),'Provider')]");
	By timeDetails =  By.xpath("//a[contains(text(),'Time')]");
	By headerDetails =  By.xpath("(//h3[@class='panel-title'])[2]");
	By symDetails =  By.xpath("//a[contains(text(),'Symptoms')]");

	WebDriver driver;
	HelperClass helperObj ;
	public ScheduleAppointmentPage(WebDriver driver)
	{
		this.driver = driver;
		helperObj = new HelperClass(driver);
	}
	
	public HashMap<String, String> bookAnAppointment(String doctorName)
	{	
		HashMap<String,String> hMap= new HashMap<String,String>();
		  
		String time = "10Am";
		String dateofApp = AppLibrary.getFutureDate(20);
		String sym = "Booking an appointment for" + doctorName+ "on date "+dateofApp+"For Symptom Fever";	 
		driver.findElement(createAppointmentButton).click();
		driver.findElement(By.xpath("//h4[text()='"+doctorName+"']/ancestor::ul/following-sibling::button")).click();
		driver = helperObj.switchToAFrameAvailable("myframe", 20);
		driver.findElement(datePicker ).sendKeys(dateofApp);
		driver.findElement(datePicker).sendKeys(Keys.TAB);
		Select timeSelector = new Select(driver.findElement(By.id("time")));
		timeSelector.selectByVisibleText(time);
		driver.findElement(continueButton ).click();
		driver.findElement(symptxtbox).sendKeys(sym);
		driver.findElement(submitButton).click();
		hMap.put("time", "10Am");
		hMap.put("doctorName",doctorName);
		hMap.put("sym", sym);
		hMap.put("dateofApp", dateofApp);
		return hMap;
	}
	public boolean validateAppointmentDetailsinSchedulePage(HashMap<String,String> hMap)
	{
		boolean result = false;
		helperObj.navigateToAModule("Schedule Appointment");
		
		String providerName[] = driver.findElement(providerNameDetails).getText().split(":");
		String timeArr[] = driver.findElement(timeDetails).getText().split(":");
		String appTime = driver.findElement(headerDetails).getText();
		String symArr[] = driver.findElement(symDetails).getText().split(":");
		
		if(hMap.get("doctorName").contains(providerName[1]) &&  hMap.get("time").contains(timeArr[1])
				&& hMap.get("dateofApp").contains(appTime) &&  hMap.get("sym").contains(symArr[1]))
		{
			result = true;
			System.out.println("Data for schedule appointment is displayed successfully");
		}
		return result;
	}

}


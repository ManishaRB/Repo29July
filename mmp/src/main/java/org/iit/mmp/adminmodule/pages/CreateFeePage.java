package org.iit.mmp.adminmodule.pages;

import java.io.IOException;
import java.util.HashMap;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateFeePage {
	WebDriver driver;	
	By appointment=By.id("app_date");
	By typeOfService=By.id("service");
	By submitButton=By.xpath("//input[@value='submit']");
	
	public CreateFeePage(WebDriver driver) 
	{
		this.driver=driver;
	}
	public HashMap<String,String> createFees (String selectAppointment, String selectService) throws IOException
	{ 
	
		HashMap<String,String> hMap= new HashMap<String,String>();
		
		Select appt=new Select(driver.findElement(appointment));
	    appt.selectByVisibleText(selectAppointment);
	    
	    Select service=new Select(driver.findElement(typeOfService));
	    service.selectByVisibleText(selectService);
	    
	    driver.findElement(submitButton).click();
	    hMap.put("selectAppointment", selectAppointment.toString());
	    hMap.put("serviceName", selectService);
	    System.out.println(selectService);
		return hMap;
	}
	
	public String readSuccessMsg()
	{
		Alert alrt = driver.switchTo().alert();
		String actual = alrt.getText();
		alrt.accept();
		return actual;
	}
}

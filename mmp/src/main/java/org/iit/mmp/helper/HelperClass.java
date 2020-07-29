package org.iit.mmp.helper;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HelperClass {
	public WebDriver driver;
	public HelperClass(WebDriver driver)
	{
		this.driver = driver;
	}
	public WebDriver switchToAFrameAvailable(String frame,int timeInSecs)
	{
		WebDriverWait wait = new WebDriverWait(driver,timeInSecs);
		driver =wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frame));
		return driver;
	}
	public void launchPatientModule(String url)
	{
		driver.get("http://96.84.175.78/MMP-Release2-Integrated-Build.6.8.000/portal/login.php");
	}
	public void launchAdminModule(String url)
	{
		driver.get("http://96.84.175.78/MMP-Release2-Admin-Build.2.1.000/login.php");
	}
	public void navigateToAModule(String moduleName)
	{
		driver.findElement(By.xpath("//span[contains(text(),'"+moduleName+"')]")).click();			
	}
	public void captureScreenshot(String tc_Name) throws IOException
	{
		System.out.println("Capturing the Screenshot for testcase" + tc_Name);
		TakesScreenshot tsh = (TakesScreenshot)driver;
		File srcFile = tsh.getScreenshotAs(OutputType.FILE);
		String destPath = System.getProperty("user.dir")+"\\screenshnots\\"+tc_Name+Calendar.getInstance().getTimeInMillis()+".jpg";
		File destFile = new File(destPath);
		FileUtils.copyFile(srcFile, destFile);
		System.out.println("Exiting the Screenshot method");
		
	}
	public void login(String uName,String pWord)
	{
		driver.findElement(By.id("username")).sendKeys(uName);
		driver.findElement(By.id("password")).sendKeys(pWord);
		driver.findElement(By.name("submit")).click();
	}
	public void adminLogin(String uName,String pWord)
	{
		  driver.findElement(By.id("username")).sendKeys(uName);
		  driver.findElement(By.id("password")).sendKeys(uName);
		  driver.findElement(By.name("admin")).click();
	}
	public void patientLogin(String username, String password)
	{
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.name("submit")).click();
	}
	public void navigateToPatientServices(String serviceName)
	{
		driver.findElement(By.xpath("//input[@value='"+serviceName+"']")).click();
	}
	public void searchPatientByName(String patientName) throws InterruptedException
	{

		driver.findElement(By.id("search")).sendKeys(patientName);
		driver.findElement(By.className("tfbutton")).click();
		List<WebElement> patientList = driver.findElements(By.xpath("//div[@id='show']/descendant::table/tbody/tr/td/a"));
		for(int i=0;i<patientList.size();i++)
		{ 
			if(patientList.get(i).getText().contains(patientName));

				{
					patientList.get(i).click();
					break;
				}
		}

	}
	public void searchPatientBySSN(String ssn) throws InterruptedException
	{

		driver.findElement(By.id("search")).sendKeys(ssn);
		driver.findElement(By.className("tfbutton")).click();
		List<WebElement> Rows = driver.findElements(By.xpath("//div[@id='show']/descendant::table/tbody/tr"));
		int totalRows = Rows.size();
		
		//count columns
		List<WebElement> Columns = driver.findElements(By.xpath("//div[@id='show']/descendant::table/tbody/tr[1]/td"));
		int totalColumns = Columns.size();
		
		//Extract data
		for(int i=1;i<=totalRows;i++)
		{
			for(int j=1;j<=totalColumns;j++)
			{
				WebElement dataCell = driver.findElement(By.xpath("//div[@id='show']/descendant::table/tbody/tr["+i+"]/td["+j+"]"));
				System.out.println(dataCell.getText());

	        }
		}
	}
}

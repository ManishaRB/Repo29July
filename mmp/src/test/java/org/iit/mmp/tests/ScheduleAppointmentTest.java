package org.iit.mmp.tests;

import java.util.HashMap;

import org.iit.mmp.helper.HelperClass;
import org.iit.mmp.patientmodule.pages.ScheduleAppointmentPage;
import org.iit.util.TestBase;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
//Explained in the class
public class ScheduleAppointmentTest extends TestBase 
{
HelperClass helper;
	
	@Parameters({"url","uname","pword","drName"})
	@Test(description="US_004, Validate Schedule appointment",groups={"sanity","regression","UI","patientmodule","US_004"})
	public  void validateScheduleAppointment(String url,String uname,String pword,String drName) {
		helper = new HelperClass(driver);
		helper.launchPatientModule(url);
		helper.login(uname,pword);
		helper.navigateToAModule("Schedule Appointment");
		ScheduleAppointmentPage sPage = new ScheduleAppointmentPage(driver);
		HashMap<String,String> hMap = sPage.bookAnAppointment(drName);
		helper.navigateToAModule("Schedule Appointment");
	    boolean result = sPage.validateAppointmentDetailsinSchedulePage(hMap);
	    Assert.assertTrue(result);
	}

}

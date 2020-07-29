package org.iit.mmp.tests;

import java.io.IOException;
import java.util.HashMap;

import org.iit.mmp.adminmodule.pages.CreateFeePage;
import org.iit.mmp.helper.HelperClass;
import org.iit.mmp.patientmodule.pages.PayFeesPage;
import org.iit.mmp.patientmodule.pages.ScheduleAppointmentPage;
import org.iit.util.TestBase;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class PayFeesTest extends TestBase {
	HelperClass helper;
	PayFeesPage PFP;
	CreateFeePage CFP;
	
	
	
	@Parameters({"url","uname","pword","selectAppointment", "selectService"})
	@Test(description="US_004 Pay Fees Page", groups= {"sanity","regression","UI","patientmodule","US_004"})
	public void validatePayFeesTests(String url,String uname,String pword,String drName) throws InterruptedException, IOException
	{
		//login to admin portal
		helper=new HelperClass(driver);
        helper.launchAdminModule(url);
        helper.adminLogin(uname,pword);
        helper.navigateToAModule("Patient");
        helper.searchPatientByName("RADHIKA");
        
		//create fee
		helper.navigateToPatientServices("Create Fee");
	    CFP = new CreateFeePage(driver);
	    HashMap<String,String> hMap = CFP.createFees(selectAppointment, selectService);
        CFP.readSuccessMsg();
		
		//Login to patient portal and pay fee
        helper.launchPatientModule(url);
        helper.patientLogin(uname,pword);
        helper.navigateToAModule("Fees");
        PFP=new PayFeesPage(driver);
        PFP.runner();
        helper.navigateToAModule("Logout");
	}

}

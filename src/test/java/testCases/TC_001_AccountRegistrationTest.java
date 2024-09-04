package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_001_AccountRegistrationTest extends BaseClass{
	
	@Test(groups= {"Sanity","Master"})
	public void verify_account_registration()
	{
		try {
		logger.info("**** Started TC_001_AccountRegistrationTest *****");
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		logger.info("**** Clicked on MyAcoount button ****");
		hp.clickRegister();
		logger.info("**** Clicked on Regsiter button ****");
		
		AccountRegistrationPage regpage=new AccountRegistrationPage(driver);
		logger.info("**** Providing the customer details ****");
		regpage.setFirstName(randomeString().toUpperCase());
		regpage.setLastName(randomeString().toUpperCase());
		regpage.setEmail(randomeString()+"@gmail.com");// randomly generated the email
		regpage.setTelephone(randomeNumber());
		
		String password=randomAlphaNumeric();
		
		regpage.setPassword(password);
		regpage.setConfirmPassword(password);
		
		regpage.setPrivacyPolicy();
		regpage.clickContinue();
		logger.info("**** Validating expected message ****");
		String confmsg=regpage.getConfirmationMsg();
		if(confmsg.equals("Your Account Has Been Created!")) {
			Assert.assertTrue(true);
		}
		else {
			
			logger.error("***Test Failed**");
			logger.debug("*** Debug logs..*");
			Assert.assertTrue(false);
			
		}
		//Assert.assertEquals(confmsg, "Ynt Has Been Created!");
		}
		catch(Exception e){
			
			Assert.fail();
			
		}
		
		logger.info("**** Finished TC_001_AccountRegistrationTest *****");
	}
	
	
	
	
}











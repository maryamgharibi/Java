import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;

public class PasswordValidatorTest {
	private  PasswordValidator pv ;
  @Test(dataProvider = "validPass")
  public void validPassword(  String[] pass) {
	  for (String p:pass) {
		  boolean result  = pv.ValidatePassword(p);
		  System.out.println("Password is valid : " + p + " , " + result);
		  AssertJUnit.assertEquals( true,result);
	  }
	  
  }

  
  
  @Test(dataProvider = "invalidPass", 
  dependsOnMethods="validPassword")
  public void invalidPassword(  String[] pass) {
	  for (String p:pass)
	  {
		 boolean result =   pv.ValidatePassword(p); 
		 System.out.println("Password is valid : " + p + " , " + result);
		 AssertJUnit.assertEquals(false,result);
	  }
	 
  }
  
  @DataProvider
  public Object[][] validPass() {
	  return new Object[][]{
		   {new String[] {
			   "mkyong1A@", "mkYOn12$", 
		   }}
	        };
  }
  
  @DataProvider
  public Object[][] invalidPass() {
    return new Object[][] {
    	{new String[] {
    			 "mY1A@","mkyong12@","mkyoNg12*",
                 "mkyonG$$","MKYONG12$"	  
 		   }}
    };
  }
  @BeforeClass
  public void beforeClass() {
	    pv = new PasswordValidator();
	    
  }

  @AfterClass
  public void afterClass() {
  }

  @BeforeTest
  public void beforeTest() {
  }

}

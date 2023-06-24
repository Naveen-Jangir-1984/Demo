package Login;

import initEnvironement.BaseTest;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import screenObjects.HomePage;
import screenObjects.LoginPage;

import static SignUp.TestSignUp.Password;
import static SignUp.TestSignUp.UserName;
import static utility.PropertiesUtils.urlWebsiteLoginPro;

public class TestLogin extends BaseTest {

	private LoginPage loginPage;
	private HomePage homePage;
 
    /*
     SCENARIO: TC002_login_user_guru99_successfully
     Precondition: Account guru99 created from TestSignUp
     1: Goes to Login page
     2: Verify UI of Login page
     3: Input valid Account & submit
     4: Verify user logged successfully with Home Page display
     */

	@BeforeClass
	public void beforeClass() {
		super.setUp(urlWebsiteLoginPro);
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
	}

	@Test(priority = 2)
	public void TC002_LoginUserSuccessfully() {
		loginPage.VerifyLoginPageAllElements();
		loginPage.Login(UserName, Password);
		homePage.VerifyHomePageAllElements();
	}

	@AfterClass
	public void afterClass() {
		super.afterClass();
	}
}
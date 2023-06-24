package SignUp;

import initEnvironement.BaseTest;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import screenObjects.SignupPage;
import screenObjects.SignupSuccessfulPage;
import utility.LogUtils;

import static utility.PropertiesUtils.urlWebsiteSignupPro;

public class TestSignUp extends BaseTest {

	private SignupPage signupPage;
	private SignupSuccessfulPage signupSuccessfulPage;
	public static String UserName = "";
	public static String Password = "";

 /*
  SCENARIO: TC001_create_new_user_guru99_successfully
  Precondition: An email valid
  1: Goes to guru99 Signup page
  2: Verify UI of Signup page
  3: Input valid email & submit
  4: Verify user create with username & password
  5: Get user info for next suite in need
  */

	@BeforeClass
	public void beforeClass() {
		super.setUp(urlWebsiteSignupPro);
		signupPage = new SignupPage(driver);
		signupSuccessfulPage = new SignupSuccessfulPage(driver);
		LogUtils.info("----Test SignUp-----------------------");
	}

	@Test(priority = 1)
	public void TC001_CreateNewUserSuccessfully() {
		signupPage.VerifySignUpPageAllElements();
		signupPage.TheBarTextShouldBe("Guru99 Bank");
		signupPage.TheTableTextShouldBe("Enter your email address");
		signupPage.TheEmailIdTextShouldBe("Email ID");
		signupPage.InputEmail("test" + System.currentTimeMillis() + "@gmail.com");
		signupPage.ClickButtonSubmit();
		signupSuccessfulPage.VerifyCreatedAccountSuccessfulPageAllElements();

		// Verify all element text on this page
		signupSuccessfulPage.TheBarTextShouldBe("Guru99 Bank");
		signupSuccessfulPage.TheTableTextShouldBe("Access details to demo site.");
		signupSuccessfulPage.TheUserIdTextShouldBe("User ID :");
		signupSuccessfulPage.ThePassWordTextShouldBe("Password :");
		signupSuccessfulPage.TheNoteTextShouldBe("This access is valid only for 20 days.");

		// Verify Account created successfully
		UserName = signupSuccessfulPage.GetAccountName();
		Password = signupSuccessfulPage.GetAccountPassword();
		signupSuccessfulPage.VerifyAccount(UserName, Password);
	}

	@AfterClass
	public void afterClass() {
		super.afterClass();
	}
}
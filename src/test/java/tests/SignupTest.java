package tests;

import base.TestBase;
import org.testng.annotations.Test;
import pages.signupPage;

public class SignupTest extends TestBase {


    @Test
    public void testSignup() throws InterruptedException {
        // Implement signup test steps here
        signupPage log = new signupPage(driver);
        log.loginclick();
        log.SignUpButton();
        log.fullName("Gaurav Bhatia");

        Thread.sleep(4000);
        log.setMobileNumberField("505551663");
        Thread.sleep(1000);
        log.setEmailField("gaurav.k.b@Yopmail.com");
        Thread.sleep(1000);
        log.setLanguageDropdown();
        Thread.sleep(1000);
        log.setTermsCheckbox();
        Thread.sleep(1000);
        log.clickContinueButton();

    }
}

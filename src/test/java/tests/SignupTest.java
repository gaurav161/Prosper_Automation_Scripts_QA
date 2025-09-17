package tests;

import base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.signupPage;

import java.util.List;

public class SignupTest extends TestBase {


    @Test(priority = 1)
    public void testSignup() throws InterruptedException {
        // Implement signup test steps here
        signupPage log = new signupPage(driver);
        log.loginclick();
        log.SignUpButton();
        log.fullName("Kuljeet Singh");

        Thread.sleep(4000);
        log.setMobileNumberField("505551669");
        Thread.sleep(1000);
        log.setEmailField("Kuljeet.R@Yopmail.com");
        Thread.sleep(1000);
//        log.setLanguageDropdown();
//        Thread.sleep(1000);
        log.setTermsCheckbox();
        Thread.sleep(1000);
        log.clickContinueButton();
        Thread.sleep(4000);
        log.phoneOTP("1234");
        Thread.sleep(3000);
        log.emailOTP("1234");

    }

}

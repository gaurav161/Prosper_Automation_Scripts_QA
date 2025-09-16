package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class signupPage {

    private final WebDriver driver;
    private WebDriverWait wait;

    public signupPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(20));
        PageFactory.initElements(driver, this);

    }


    @FindBy(xpath = "//strong[text()='Sign Up']")
    private WebElement signUpButton;

    @FindBy(name = "name")
    private WebElement fullNameField;

    @FindBy(name = "phone")
    private WebElement mobileNumberField;

    @FindBy(name = "email")
    private WebElement emailField;

    @FindBy(xpath = "//button[@role='combobox']")
    private  WebElement languageDropdown;

    @FindBy(id = "terms_and_condition")
    private WebElement termsCheckbox;


    @FindBy(xpath = "//button[normalize-space()='Continue']")
    private WebElement continueButton;

    public void loginclick(){
        List<WebElement>buttons = driver.findElements(By.xpath("//button[@id='login-btn-desktop']"));
        for (WebElement btn : buttons) {
            if (btn.isDisplayed()) {
                btn.click();
                break;
            }

        }
    }
    public void SignUpButton() throws  InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(signUpButton)).click();
    }

    public void fullName(String setFullName){
        wait.until(ExpectedConditions.elementToBeClickable(fullNameField)).sendKeys(setFullName);
    }

    public void setMobileNumberField(String setMobileNumber){
        wait.until(ExpectedConditions.elementToBeClickable(mobileNumberField)).sendKeys(setMobileNumber);
    }

    public void setEmailField(String setEmail){
        wait.until(ExpectedConditions.elementToBeClickable(emailField)).sendKeys(setEmail);
    }

    public void setLanguageDropdown(){
        WebElement hiddenSelect = driver.findElement(By.xpath("//select[@aria-hidden='true']"));

        // Use Selenium Select class
        Select select = new Select(hiddenSelect);
        select.selectByVisibleText("English");

    }
    public void setTermsCheckbox(){
//       wait.until(ExpectedConditions.elementToBeClickable(termsCheckbox)).click();

            WebElement geekmark = driver.findElement(By.cssSelector("label[for='terms_and_condition'] span.geekmark"));
            wait.until(ExpectedConditions.elementToBeClickable(geekmark)).click();


    }

    public void clickContinueButton(){
        wait.until(ExpectedConditions.elementToBeClickable(continueButton)).click();
    }








}

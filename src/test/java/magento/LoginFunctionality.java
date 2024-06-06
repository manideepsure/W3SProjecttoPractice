package magento;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginFunctionality {
	
	WebDriver driver;
	public LoginFunctionality(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@title = 'Email']")
	WebElement txtUsername;
	
	@FindBy(xpath = "//input[@title = 'Password']")
	WebElement txtPassword;
	
	@FindBy(xpath = "//button[@class = 'action login primary']")
	WebElement btnLogin;
	
	
	
	
	public void setIUsername(String uname) {
		txtUsername.sendKeys(uname);
	}
	
	public void setPassword(String pwd) {
		txtPassword.sendKeys(pwd);
	}
	
	public void ClickLoginBtn() {
		btnLogin.click();
	}

}

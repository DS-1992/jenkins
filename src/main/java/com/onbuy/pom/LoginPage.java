package com.onbuy.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	//Declaration
	@FindBy(id="inputEmail")
	private WebElement untbx;
	
	@FindAll({@FindBy(id="inputPassword"),@FindBy(name="pasword")})
	private WebElement pwdtbx;
	
	@FindBys({@FindBy(name="submit"),@FindBy(xpath = "//button[.='Login']")})
	private WebElement lgBtn;
	
	//Initialization
	public LoginPage(WebDriver driver) 
	{
	PageFactory.initElements(driver, this);
	}
	
	//utilization
	
	public WebElement getUntbx() {
		return untbx;
	}

	public WebElement getPwdtbx() {
		return pwdtbx;
	}

	public WebElement getLgBtn() {
		return lgBtn;
	}
	
	//Bussiness logic
	public void Logintoapp(String USERNAME,String PASSWORD)
	{
		untbx.sendKeys(USERNAME);
		pwdtbx.sendKeys(PASSWORD);
		lgBtn.click();
	}

}

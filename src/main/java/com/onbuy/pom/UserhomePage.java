package com.onbuy.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserhomePage {
	@FindBy(xpath="//a[text()='Logout']")
	private WebElement lgoutbtn1;
	
	public UserhomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getLgoutbtn() {
		return lgoutbtn1;
	}
	
	public void logoutUser()
	{
		lgoutbtn1.click();
	}
}

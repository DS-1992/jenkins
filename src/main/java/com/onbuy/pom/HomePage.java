package com.onbuy.pom;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.onbuy.genericutilities.WebDriverUtilities;

public class HomePage {
	//Declaration
	@FindBy(xpath="//a[contains(text(),'Insert Product')]" )
	private WebElement insertProdtab;
	
	@FindBy(partialLinkText = "Sub Category")
	private WebElement subcattab;
	
	@FindBy(xpath="//img[@class='nav-avatar']")
	private WebElement imglogo;
	
	@FindBy(xpath="//a[text()='Logout']")
	private WebElement logoutBtn;
	
	//Initialization
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//Utilization
	
	public WebElement getInsertProdtab() {
		return insertProdtab;
	}



	/*public WebElement getManageProducttab() {
		return manageProducttab;
	}

	public WebElement getSearchtbx() {
		return searchtbx;
	}

	public WebElement getEditIcon() {
		return editIcon;
	}

	public WebElement getPalb() {
		return palb;
	}

	public WebElement getUpdateBtn() {
		return updateBtn;
	}

	public WebElement getDeleteIcon() {
		return deleteIcon;
	}*/

	public WebElement getSubcattab() {
		return subcattab;
	}


	public WebElement getImglogo() {
		return imglogo;
	}

	public WebElement getLogoutBtn() {
		return logoutBtn;
	}
	
	//Business Libraries
	public void clickInsertProducttab()
	{
		insertProdtab.click();
	}
	
	public void clickSubCattab()
	{
		subcattab.click();
	}
		 public void logoutfromapp()
	 {
		 imglogo.click();
		 logoutBtn.click();
	 }
}

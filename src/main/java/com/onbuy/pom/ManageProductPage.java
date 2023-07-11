package com.onbuy.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.onbuy.genericutilities.WebDriverUtilities;

public class ManageProductPage {
	//Declaration
	@FindBy(xpath="//a[contains(text(),'Manage Products')]")
	private WebElement manageProdtab;

	@FindBy(xpath="//input[@aria-controls='DataTables_Table_0']")
	private WebElement searchBar;
	
	@FindBy(xpath="//i[@class='icon-edit']")
	private WebElement editBtn;
	
	@FindBy(id="productAvailability")
	private WebElement Prodavail;
	
	@FindBy(xpath="//button[text()='Update']")
	private WebElement updateBtn;
	
	@FindBy(xpath="//tbody[@role='alert']/tr[last()]/descendant::i[@class='icon-remove-sign']")
	private WebElement deleteBtn;
	
//	@FindBy(xpath="//img[@class='nav-avatar']")
//	private WebElement imglogo;
//	
//	@FindBy(xpath="//a[text()='Logout']")
//	private WebElement logoutBtn;
	
	//initialization
	public ManageProductPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//utilization
	public WebElement getManageProdtab() {
		return manageProdtab;
	}

	public WebElement getSearchBar() {
		return searchBar;
	}

	public WebElement getEditBtn() {
		return editBtn;
	}

	public WebElement getProdavail() {
		return Prodavail;
	}

	public WebElement getUpdateBtn() {
		return updateBtn;
	}

	public WebElement getDeleteBtn() {
		return deleteBtn;
	}

	/*
	 * public WebElement getImglogo() { return imglogo; }
	 * 
	 * public WebElement getLogoutBtn() { return logoutBtn; }
	 */
	//Business libraries
		public void manageProduct(WebDriver driver, WebDriverUtilities wlib, String SearchProductName,String UpdateProductAva )
		{
		manageProdtab.click();
		searchBar.sendKeys(SearchProductName);
		editBtn.click();
		wlib.select(Prodavail, UpdateProductAva);
		updateBtn.click();
		manageProdtab.click();
		deleteBtn.click();
		wlib.swithToAlertWindowAndAccpect(driver, "Are you sure you want to delete?");
		
		}
		public void clickDeleteButton()
		{
			deleteBtn.click();
		}
	
	}

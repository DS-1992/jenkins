package com.onbuy.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SubCategoryPage 
{
	@FindBy(xpath="//input[@aria-controls='DataTables_Table_0']")
	private WebElement searchBar;
	
	@FindBy(xpath="//tbody[@role='alert']/tr[last()]/descendant::i[@class='icon-remove-sign']")
	private WebElement deleteIcon;
	
	public SubCategoryPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getDeleteIcon() {
		return deleteIcon;
		
	}
	
	public WebElement getSearchBar() {
		return searchBar;
	}

	//Business libraries
	public void clickDelete()
	{
		deleteIcon.click();
	}
	
	public void searchSubcat(String subcat)
	{
		searchBar.sendKeys(subcat);
	}

}

package com.onbuy.pom;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.onbuy.genericutilities.WebDriverUtilities;

public class InsertProductPage {
	
	@FindBy(name="category")
	private WebElement CTRlistbox;
	
	@FindAll({@FindBy(id="subcategory"),@FindBy(name="subcategory")})
	private WebElement SUBCTRlistbox;
	
	@FindBy(name="productName")
	private WebElement productName;
	
	@FindBy(name="productCompany")
	private WebElement ProCompany;
	
	@FindBy(name="productpricebd")
	private WebElement ProductPriceBD;
	
	@FindBy(name="productprice")
	private WebElement ActualPrice;
	
	@FindBy(name="productDescription")
	private WebElement ProDesc;
	
	@FindBy(name="productShippingcharge")
	private WebElement ProShipCharge;
	
	@FindBy(id="productAvailability")
	private WebElement paListbox;
	
	@FindBy(id="productimage1")
	private WebElement productimage1;
	
	@FindBy(name="productimage2")
	private WebElement productimage2;
	
	@FindBy(name="productimage3")
	private WebElement productimage3;
	
	@FindBy(xpath="//button[text()='Insert']")
	private WebElement insertBtn;
	
	public InsertProductPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);

	}
	
	public WebElement getCTRlistbox() {
		return CTRlistbox;
	}

	public WebElement getSUBCTRlistbox() {
		return SUBCTRlistbox;
	}

	public WebElement getProductName() {
		return productName;
	}

	public WebElement getProCompany() {
		return ProCompany;
	}

	public WebElement getProductPriceBD() {
		return ProductPriceBD;
	}

	public WebElement getActualPrice() {
		return ActualPrice;
	}

	public WebElement getProDesc() {
		return ProDesc;
	}

	public WebElement getProShipCharge() {
		return ProShipCharge;
	}

	public WebElement getPaListbox() {
		return paListbox;
	}

	public WebElement getProductimage1() {
		return productimage1;
	}

	public WebElement getProductimage2() {
		return productimage2;
	}

	public WebElement getProductimage3() {
		return productimage3;
	}

	public WebElement getInsertBtn() {
		return insertBtn;
	}

	//Business Libraries
	public void createproduct(WebDriverUtilities wLib, String Category, String SubCategory, String productNam, String ProdCompany,String ProdPriceBD,String ActualProdPrice,String ProdDesc,String ProdShipCharge,String Prodavail)
	{
		
		wLib.select(CTRlistbox, Category);
		wLib.select(SUBCTRlistbox, SubCategory);
		productName.sendKeys(productNam);
		ProCompany.sendKeys(ProdCompany);
		ProductPriceBD.sendKeys(ProdPriceBD);
		ActualPrice.sendKeys(ActualProdPrice);
		ProDesc.sendKeys(ProdDesc);
		ProShipCharge.sendKeys(ProdShipCharge);
		wLib.select(paListbox, Prodavail);
		
	}

	 public void fileupload(WebDriver driver, String imgfilepath)
	   {
	
			
		   File f=new File(imgfilepath);
			String ap = f.getAbsolutePath();
			productimage1.sendKeys(ap);
			productimage2.sendKeys(ap);
			productimage3.sendKeys(ap);
			insertBtn.click();
	   }

}

package onBuy.com.TC;


import org.testng.annotations.Test;

import com.onbuy.genericutilities.BaseClass;

import com.onbuy.pom.HomePage;
import com.onbuy.pom.InsertProductPage;
import com.onbuy.pom.ManageProductPage;



public class ProductTest extends BaseClass {

	//Dharmendra Saraswat

	@Test
	public void Producttest() throws Throwable {
	
		
		//Get the path of excel path
	
		String excelpath = flib.getFilePathFromPropertiesFile("testScriptdatafilePath");
		String imgpath = flib.getFilePathFromPropertiesFile("imgfilepath");
	
		//get the test script data
		int random = jlib.getRandomNumber();
		String productName = elib.getDataFromExcelBasedTestId(excelpath, "Product", "TC_35", "Product Name")+random;
		String Category = elib.getDataFromExcelBasedTestId(excelpath, "Product", "TC_35", "Category");
		String SubCategory = elib.getDataFromExcelBasedTestId(excelpath, "Product", "TC_35", "Sub-Category");
		String ProCompany = elib.getDataFromExcelBasedTestId(excelpath, "Product", "TC_35", "Product Company");
		String ProductPriceBD = elib.getDataFromExcelBasedTestId(excelpath, "Product", "TC_35", "ProductPriceBD");
		String ActualPrice = elib.getDataFromExcelBasedTestId(excelpath, "Product", "TC_35", "ActualPrice");
		String ProDesc = elib.getDataFromExcelBasedTestId(excelpath, "Product", "TC_35", "Product Description");
		String ProShipCharge = elib.getDataFromExcelBasedTestId(excelpath, "Product", "TC_35", "ProductShippingCharge");
		String ProAvail = elib.getDataFromExcelBasedTestId(excelpath, "Product", "TC_35", "Product Availability");
		String SearchProductName = elib.getDataFromExcelBasedTestId(excelpath, "Product", "TC_35", "SearchProductName");
		String UpdateProductAvail = elib.getDataFromExcelBasedTestId(excelpath, "Product", "TC_35", "UpdateProductAva");
		
		//Enter all the details and click on insert button
		
		HomePage hp= new HomePage(driver);
		hp.clickInsertProducttab();
		
		InsertProductPage ip=new InsertProductPage(driver);
		ip.createproduct(wlib, Category, SubCategory, productName, ProCompany, ProductPriceBD, ActualPrice, ProDesc, ProShipCharge, ProAvail);
		ip.fileupload(driver, imgpath);
		
		ManageProductPage mp=new ManageProductPage(driver);
		mp.manageProduct(driver, wlib, SearchProductName, UpdateProductAvail);
		
		hp.logoutfromapp();
		
	}
}

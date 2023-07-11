package com.onbuy.genericutilities;

import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.onbuy.pom.HomePage;
import com.onbuy.pom.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public WebDriver driver=null;
	public String envfilepath;

	public FileUtilities flib=new FileUtilities();
	public ExcelUtlities elib=new ExcelUtlities();
	public WebDriverUtilities wlib=new WebDriverUtilities();
	public JavaUtilities jlib=new JavaUtilities();
	public JdbcUtilities dlib=new JdbcUtilities();
	
	public String excelpath;
	
	
	
	@BeforeSuite
	public void connectDB() throws SQLException
	{
		dlib.connectDB();
		System.out.println("Database Connected");
	}
	
	@BeforeClass
	public void launchBrowser() throws Throwable
	{
		WebDriverManager.chromedriver().setup();
		envfilepath = flib.getFilePathFromPropertiesFile("projectConfigDataFilePath");

		//String Browser = flib.getDataFromProperties(envfilepath, "browser");
		//String AURL = flib.getDataFromProperties(envfilepath, "Adminurl");
		String Browser=System.getProperty("browser");
		String AURL=System.getProperty("Adminurl");
		if(Browser.equalsIgnoreCase("Chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(Browser.equalsIgnoreCase("Firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else if(Browser.equalsIgnoreCase("Edge"))
		{
			driver=new EdgeDriver();
		}
		else
		{
			driver=new ChromeDriver();
		}
		
		wlib.maximizeBrowser(driver);
		driver.get(AURL);
		
		wlib.waitForElementInDOM(driver);
		System.out.println("Browser launched");
		
	}
	@BeforeMethod
	public void logintoapp() throws Throwable
	{
		excelpath = flib.getFilePathFromPropertiesFile("testScriptdatafilePath");

		
		String AUSERNAME = flib.getDataFromProperties(envfilepath, "Adminusername");
		String APASSWORD = flib.getDataFromProperties(envfilepath, "Adminpassword");
		
		LoginPage l=new LoginPage(driver);
		l.Logintoapp(AUSERNAME, APASSWORD);
		
		System.out.println("Successfully Login");
		
	}
	@AfterMethod
	public void logoutfromapp()
	{
		System.out.println("Successfully logout");
	}
	@AfterClass
	public void closeBrowser()
	{
		driver.quit();
		System.out.println("Closed browser");
	}
	
	
	@AfterSuite
	public void closeDB() throws SQLException
	{
		dlib.closeDB();
		System.out.println("Database Closed");

	}
	

}

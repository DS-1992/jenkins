package onBuy.com.TC;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.onbuy.genericutilities.BaseClass;
import com.onbuy.pom.HomePage;
import com.onbuy.pom.LoginPage;
import com.onbuy.pom.ManageProductPage;
import com.onbuy.pom.SubCategoryPage;
import com.onbuy.pom.UserhomePage;


public class DeleteSubCategoryTest extends BaseClass {
	
	@Test
	public void DeleteSubcategorytest() throws Throwable {
		
		String subcat = elib.getDataFromExcel(excelpath, "subcategory", 1, 0);

		
		//Get the data from Property File
	String Aurl = flib.getDataFromProperties(envfilepath, "Adminurl");
	String Aun = flib.getDataFromProperties(envfilepath, "Adminusername");
	String Apwd = flib.getDataFromProperties(envfilepath, "Adminpassword");

	/*
	 * WebDriverManager.chromedriver().setup();
	 * //WebDriverManager.firefoxdriver().setup(); // Open the Browser WebDriver
	 * driver=null; if(Browser.equalsIgnoreCase("Chrome")) { driver=new
	 * ChromeDriver(); } else if(Browser.equalsIgnoreCase("Firefox")) {
	 * //System.setProperty("webdriver.gecko.driver", ".\\target\\geckodriver.exe");
	 * driver=new FirefoxDriver(); } else if(Browser.equalsIgnoreCase("Edge")) {
	 * driver=new EdgeDriver(); } else { driver=new ChromeDriver(); }
	 * 
	 * driver.manage().window().maximize();
	 * driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	 */
		//Enter the URL
		driver.get(Aurl);
		//Enter the username and password and click on login button
		LoginPage lp=new LoginPage(driver);
		lp.Logintoapp(Aun, Apwd);
		//driver.findElement(By.id("inputEmail")).sendKeys(Aun);
		//driver.findElement(By.id("inputPassword")).sendKeys(Apwd);
		//driver.findElement(By.xpath("//button[text()='Login']")).click();
		// click on create sub category major tab
		HomePage hp=new HomePage(driver);
		hp.clickSubCattab();
		//driver.findElement(By.partialLinkText("Sub Category")).click();
		SubCategoryPage scp=new SubCategoryPage(driver);
		scp.searchSubcat(subcat);
		
		ManageProductPage mp=new ManageProductPage(driver);
		mp.clickDeleteButton();
		
		//click on delete icon under actions section in manage sub-category
		//driver.findElement(By.xpath("//tbody[@role='alert']/tr[last()]/descendant::i[@class='icon-remove-sign']")).click();
		wlib.swithToAlertWindowAndAccpect(driver, "Are you sure you want to delete?");
		/*Alert a = driver.switchTo().alert();
		System.out.println(a.getText());
		a.accept();
		*/
		//click on logout button
		hp.logoutfromapp();
		//driver.findElement(By.xpath("//img[@class='nav-avatar']")).click();
		//driver.findElement(By.xpath("//a[text()='Logout']")).click();
	}
	
	@Test
	
		public void checkinUserModule() throws Throwable
		{

		String Userurl = flib.getDataFromProperties(envfilepath, "Userurl");
		String Userusername = flib.getDataFromProperties(envfilepath, "Userusername");
		String Userpassword = flib.getDataFromProperties(envfilepath, "Userpassword");
		//Enter the User URL
		driver.get(Userurl);

		//click on login button and enter valid credentials
		driver.findElement(By.linkText("Login")).click();
		driver.findElement(By.name("email")).sendKeys(Userusername);
		driver.findElement(By.name("password")).sendKeys(Userpassword);
		driver.findElement(By.xpath("//button[text()='Login']")).click();

		//click on the specified category section 
		driver.findElement(By.xpath("//a[text()=' Books']")).click();

		//check the sub category section that specified sub-category is deleted or not
		List<WebElement> wes = driver.findElements(By.xpath("//li[@class='dropdown menu-item']"));
		for (WebElement element : wes) {
			String data = element.getText();

			if (data.contains("Novel")) {
				System.out.println("Novel is present and Fail");
				break;
			} else {
				System.out.println("Novel is not present and Pass");
			}
		}

		UserhomePage uhp=new UserhomePage(driver);
		uhp.logoutUser();
		//click on logout button
		//driver.findElement(By.xpath("//a[text()='Logout']")).click();

	

	}

}

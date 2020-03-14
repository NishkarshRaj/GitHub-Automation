package github;

//Import the required packages
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Main
{
	public static String str;
	public static WebDriver driver;
	public static WebElement element;
	
	@BeforeSuite
	public void Setup_Drivers()
	{
		System.setProperty("webdriver.chrome.driver", "D:\\UPES DevOps\\DevOps Sem 6\\Test Automation\\Softwares\\chromedriver.exe");		
	}
	
	//Before Method because it repeats as many times as the Test Cases
	@BeforeMethod
	public void Visit_GitHub()
	{
		driver = new ChromeDriver();
		driver.navigate().to("https://github.com/login");
		driver.manage().window().maximize();
	}
	@Test(dataProvider = "getData",priority=1)
	public void Login(String username, String password) 
	{
		//Assertions
		str = driver.findElement(By.xpath("//*[@id=\"login\"]/form/div[1]/h1")).getText();
		Assert.assertTrue(str.contains("Sign"));
		str = driver.findElement(By.xpath("//*[@id=\"login\"]/form/div[4]/label[1]")).getText();
		Assert.assertTrue(str.contains("Username"));
		str = driver.findElement(By.xpath("//*[@id=\"login\"]/form/div[4]/label[2]")).getText();
		Assert.assertTrue(str.contains("Password"));
		Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"login\"]/form/div[4]/input[9]")).isEnabled());
				//Image check	/html/body/div[1]/div[2]/div/a/svg
		
		element = driver.findElement(By.name("login"));
		element.sendKeys(username);
		element = driver.findElement(By.name("password"));
		element.sendKeys(password);
		driver.findElement(By.name("commit")).click();
	}
	@DataProvider(name="getData")
	public Object[][] getData(){
	Object[][] obj = new Object[3][2];
	obj[0][0] = "nishkarshraj000@gmail.com";
	obj[0][1] = "Nish123!@#";
	obj[1][0] = "MeghaRawat3";
	obj[1][1] = "Megh4@123";
	obj[2][0] = "raj123khare@gmail.com";
	obj[2][1] = "Ni$hkar$H3";
	return obj;
	}
	
	@Test(priority=2)
	public void CreateRepository()
	{
		element = driver.findElement(By.name("login"));
		element.sendKeys("nishkarshraj000@gmail.com");
		element = driver.findElement(By.name("password"));
		element.sendKeys("Nish123!@#");
		driver.findElement(By.name("commit")).click();
		
		//Homepage assertions
		str = driver.findElement(By.xpath("/html/body/div[4]/div/aside[1]/div[2]/div[1]/div/h2")).getText();
		Assert.assertTrue(str.contains("Repositories"));
		Assert.assertTrue(driver.findElement(By.xpath("/html/body/div[4]/div/aside[1]/div[2]/div[1]/div/h2/a")).isEnabled());
		
		
		//Create Repository
		driver.findElement(By.xpath("/html/body/div[4]/div/aside[1]/div[2]/div[1]/div/h2/a")).click();		
		element = driver.findElement(By.xpath("//*[@id=\"repository_name\"]"));		
		element.sendKeys("Test Automation");
		
		//Create Repository Page Assertions
		str = driver.findElement(By.xpath("//*[@id=\"new_repository\"]/div[2]/auto-check/dl/dt/label")).getText();
		Assert.assertTrue(str.contains("Repository"));
		str = driver.findElement(By.xpath("//*[@id=\"repository-owner-label\"]")).getText();
		Assert.assertTrue(str.contains("Owner"));
		
		driver.findElement(By.xpath("//*[@id=\"new_repository\"]/div[3]/button")).submit();	
	
		
		//Repository Homepage Assertions
		str = driver.findElement(By.xpath("//*[@id=\"js-repo-pjax-container\"]/div[1]/nav/span[1]/a/span")).getText();
		Assert.assertTrue(str.contains("Code"));
		str = driver.findElement(By.xpath("//*[@id=\"js-repo-pjax-container\"]/div[1]/nav/span[2]/a/span[1]")).getText();
		Assert.assertTrue(str.contains("Issues"));
		
		//Add Default file to make the repository forkable because empty repository cannot be forked
		driver.findElement(By.xpath("//*[@id=\"js-repo-pjax-container\"]/div[2]/div/div[1]/div[1]/p/a[1]")).click();
		//File name
		element = driver.findElement(By.name("filename"));		
		element.sendKeys("README.md");
		//Content
		element = driver.findElement(By.xpath("//*[@id=\"js-repo-pjax-container\"]/div[2]/div/div/form[2]/div[5]/div[2]/div/div[5]/div[1]/div/div/div/div[5]/div/pre"));		
		element.sendKeys("Default Content");
		
		//Create File Assertions
		str = driver.findElement(By.xpath("//*[@id=\"js-repo-pjax-container\"]/div[2]/div/div/form[2]/div[5]/div[1]/div[1]/button[1]")).getText();
		Assert.assertTrue(str.contains("Edit"));
		str = driver.findElement(By.xpath("//*[@id=\"js-repo-pjax-container\"]/div[2]/div/div/form[2]/div[5]/div[1]/div[1]/button[2]")).getText();
		Assert.assertTrue(str.contains("Preview"));
		driver.findElement(By.id("submit-file")).click();				
	}
	
	//Fork 1
	@Test(priority=3)
	public void Fork1()
	{
		element = driver.findElement(By.name("login"));
		element.sendKeys("raj123khare@gmail.com");
		element = driver.findElement(By.name("password"));
		element.sendKeys("Ni$hkar$H3");
		driver.findElement(By.name("commit")).click();
		
		//Navigate to repository to be forked
		driver.navigate().to("https://github.com/Nishkarsh007/Test-Automation");
		//Fork the repository
		//Time Delay to interact
		int i;
		for(i=0;i<10000;i++)
		{
			//
		}
		//driver.findElement(By.partialLinkText("Fork")).click();
		driver.findElement(By.xpath("/html/body/div[4]/div/main/div[2]/div/ul/li[3]/form/button")).click();
	}
	
	@Test(priority=5)
	public void Fork2()
	{
		element = driver.findElement(By.name("login"));
		element.sendKeys("MeghaRawat3");
		element = driver.findElement(By.name("password"));
		element.sendKeys("Megh4@123");
		driver.findElement(By.name("commit")).click();
		
		//Navigate to repository to be forked
		driver.navigate().to("https://github.com/Nishkarsh007/Test-Automation");
		//Fork the repository
		int i;
		for(i=0;i<10000;i++)
		{
			//
		}
		driver.findElement(By.xpath("/html/body/div[4]/div/main/div[2]/div/ul/li[3]/form/button")).click();
	}
	
	@Test(priority=4)
	public void PR1()
	{
		element = driver.findElement(By.name("login"));
		element.sendKeys("raj123khare@gmail.com");
		element = driver.findElement(By.name("password"));
		element.sendKeys("Ni$hkar$H3");
		driver.findElement(By.name("commit")).click();
		
		//Navigate to repository to be forked but commit to master branch rather than creating new branch
				driver.navigate().to("https://github.com/RajBoss007/Test-Automation");
				// Create new file in the new branch
				driver.findElement(By.xpath("//*[@id=\"js-repo-pjax-container\"]/div[3]/div/div[3]/div[2]/form/button")).click();
				element = driver.findElement(By.xpath("//*[@id=\"js-repo-pjax-container\"]/div[3]/div/div/form[2]/div[1]/span/input"));
				element.sendKeys("Feature.md");
				element = driver.findElement(By.xpath("//*[@id=\"js-repo-pjax-container\"]/div[3]/div/div/form[2]/div[5]/div[2]/div/div[5]/div[1]/div/div/div/div[5]/div/pre"));
				element.sendKeys("Default Content");
				driver.findElement(By.xpath("//*[@id=\"submit-file\"]")).click();
		
		// the new branch with feature.md file is created
		// Revisit the homepage of the repository to get access to PR button
		//driver.navigate().to("https://github.com/RajBoss007/Test-Automation");
		//Note, we assume patch 1 as the default branching mechanism! patch 2 even wont work
		//driver.findElement(By.xpath("//*[@id=\"js-repo-pjax-container\"]/div[3]/div/div[1]/ul/li[2]/a")).click(); //Open branches
		
		driver.findElement(By.xpath("//*[@id=\"js-repo-pjax-container\"]/div[3]/div/div[3]/a")).click();
		
		/*
		//Pull Request Page Assertions
		str = driver.findElement(By.xpath("//*[@id=\"js-repo-pjax-container\"]/div[3]/div/div[1]/div[1]/h1")).getText();
		Assert.assertTrue(str.contains("Comparing"));
		Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"js-repo-pjax-container\"]/div[3]/div/div[2]/div/button")).isEnabled());
		*/
	}
	@Test(priority=6)
	public void PR2()
	{
		element = driver.findElement(By.name("login"));
		element.sendKeys("MeghaRawat3");
		element = driver.findElement(By.name("password"));
		element.sendKeys("Megh4@123");
		driver.findElement(By.name("commit")).click();
		
		//Navigate to repository to be forked but commit to master branch rather than creating new branch
				driver.navigate().to("https://github.com/MeghaRawat3/Test-Automation");
				// Create new file in the new branch
				driver.findElement(By.xpath("//*[@id=\"js-repo-pjax-container\"]/div[3]/div/div[3]/div[2]/form/button")).click();
				element = driver.findElement(By.name("filename"));
				element.sendKeys("Feature2.md");
				element = driver.findElement(By.xpath("//*[@id=\"js-repo-pjax-container\"]/div[3]/div/div/form[2]/div[5]/div[2]/div/div[5]/div[1]/div/div/div/div[5]/div/pre"));
				element.sendKeys("Default Content");
				driver.findElement(By.xpath("//*[@id=\"submit-file\"]")).click();
		
		// the new branch with feature.md file is created
		// Revisit the homepage of the repository to get access to PR button
		//driver.navigate().to("https://github.com/RajBoss007/Test-Automation");
		//Note, we assume patch 1 as the default branching mechanism! patch 2 even wont work
		//driver.findElement(By.xpath("//*[@id=\"js-repo-pjax-container\"]/div[3]/div/div[1]/ul/li[2]/a")).click(); //Open branches
		
		driver.findElement(By.xpath("//*[@id=\"js-repo-pjax-container\"]/div[3]/div/div[3]/a")).click();
	}
	@Test(priority=7)
	public void MergePR()
	{
		element = driver.findElement(By.name("login"));
		element.sendKeys("nishkarshraj000@gmail.com");
		element = driver.findElement(By.name("password"));
		element.sendKeys("Nish123!@#");
		driver.findElement(By.name("commit")).click();
		driver.navigate().to("https://github.com/Nishkarsh007/Test-Automation");
		driver.findElement(By.xpath("//*[@id=\"js-repo-pjax-container\"]/div[1]/nav/span[3]/a/span[1]")).click();
	}
	@AfterMethod
 	public void Destructor()
 	{
	  //Delete the current session
	  //driver.quit();
 	}
  @AfterSuite
	public void Completion()
	{
		System.out.println("All test cases completed");
	}
}

package midsem;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
public class DataProviders {
	@Test(dataProvider = "getData")
	public void Login(String username, String password) 
	{
		System.setProperty("webdriver.chrome.driver", "D:\\UPES DevOps\\DevOps Sem 6\\Test Automation\\Softwares\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.navigate().to("https://github.com/login");
		driver.manage().window().maximize();
		WebElement element; 
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
}

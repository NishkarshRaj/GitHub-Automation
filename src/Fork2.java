package midsem;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class Fork2
{
	public static void main(String [] args) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "D:\\UPES DevOps\\DevOps Sem 6\\Test Automation\\Softwares\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.navigate().to("https://github.com/login");
		driver.manage().window().maximize();
		WebElement element; 
		element = driver.findElement(By.name("login"));
		element.sendKeys("MeghaRawat3");
		element = driver.findElement(By.name("password"));
		element.sendKeys("Megh4@123");
		driver.findElement(By.name("commit")).click();
		
		//Navigate to repository to be forked
		driver.navigate().to("https://github.com/Nishkarsh007/Test-Automation");
		//Fork the repository
		driver.findElement(By.xpath("/html/body/div[4]/div/main/div[2]/div/ul/li[3]/form/button")).click();
	}
}

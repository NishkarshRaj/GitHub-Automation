package midsem;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class Fork 
{
	public static void main(String [] args) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "D:\\UPES DevOps\\DevOps Sem 6\\Test Automation\\Softwares\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.navigate().to("https://github.com/login");
		driver.manage().window().maximize();
		WebElement element; 
		element = driver.findElement(By.name("login"));
		element.sendKeys("raj123khare@gmail.com");
		element = driver.findElement(By.name("password"));
		element.sendKeys("Ni$hkar$H3");
		driver.findElement(By.name("commit")).click();
		
		//Navigate to repository to be forked
		driver.navigate().to("https://github.com/Nishkarsh007/Test-Automation");
		//Fork the repository
		//driver.findElement(By.linkText("Fork")).click();
		//Time Delay to interact
		int i;
		for(i=0;i<1000;i++)
		{
			//
		}
		driver.findElement(By.xpath("//*[@id=\"js-repo-pjax-container\"]/div[2]/div/ul/li[3]/form/button")).click();
	}
}

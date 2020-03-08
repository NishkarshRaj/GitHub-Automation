package midsem;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class PullRequest 
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
		
		/*
		//Navigate to repository to be forked
		driver.navigate().to("https://github.com/RajBoss007/Test-Automation");
		// Create new file in the new branch
		driver.findElement(By.xpath("//*[@id=\"js-repo-pjax-container\"]/div[3]/div/div[3]/div[2]/form/button")).click();
		element = driver.findElement(By.xpath("//*[@id=\"js-repo-pjax-container\"]/div[3]/div/div/form[2]/div[1]/span/input"));
		element.sendKeys("Feature.md");
		element = driver.findElement(By.xpath("//*[@id=\"js-repo-pjax-container\"]/div[3]/div/div/form[2]/div[5]/div[2]/div/div[5]/div[1]/div/div/div/div[5]/div/pre"));
		element.sendKeys("Default Content");
		driver.findElement(By.xpath("//*[@id=\"js-repo-pjax-container\"]/div[3]/div/div/form[2]/div[6]/div/div[3]/div[2]/label/input")).click();
		driver.findElement(By.xpath("//*[@id=\"submit-file\"]")).click(); 
		*/
		
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
		driver.findElement(By.xpath("//*[@id=\"js-repo-pjax-container\"]/div[3]/div/div[2]/div/button")).submit();
	}
}

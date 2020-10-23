/**
 * 
 */
package Flipkart;

import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.util.List;

import org.openqa.selenium.support.ui.Select;

/**
 * @author Nrupal
 *
 */
public class Iphone {

	

	// Launching Firefox browser

	public static void LaunchBrowser() throws Exception {
		
		WebDriver driver;
		System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe");
		driver = new FirefoxDriver();

		
		// a. Maximize the browser window

		driver.manage().window().maximize();

		// b. Add 30 seconds implicit wait.

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		// c. Resolve http://flipkart.com/

		
		driver.get("https://www.flipkart.com/");
		String s = driver.getTitle();
		Assert.assertEquals(driver.getTitle(), s);
		driver.findElement(By.xpath("//button[@class='_2AkmmA _29YdH8']")).sendKeys(Keys.ESCAPE);
	
	
	   // Go to flipkart and search for iphone

	
		// d. Search for the product "iPhone 6" on that page

		driver.findElement(By.className("LM6RPg")).sendKeys("iPhone 6");
		driver.findElement(By.className("vh79eN")).click();

		// e. On the search results click on mobiles in categories

		Thread.sleep(2000);
		driver.findElement(By.className("sUG0yY")).click();

	
		//f(i) Filters Price range: Rs. 30000 and above

		driver.findElement(By.className("_1qKb_B")).click();
		WebElement min_dd = driver.findElement(By.className("fPjUPw"));
		Select min = new Select(min_dd);
		min.selectByIndex(9);
	
		// f(ii) select Brand: Apple

		Thread.sleep(2000);
		driver.findElement(By.className("_1GEhLw")).click();
		
		// f(iii) Select Flipkart assured
		Thread.sleep(2000);
		driver.findElement(By.className("_2rIV_l")).click();

		
		//g. Create a list to display price, product name and link to the product details page on console
	
		Thread.sleep(2000);
		String url = driver.getCurrentUrl();
		System.out.println(url+"\n");  //Print product link
		
		WebElement product = driver.findElement(By.xpath("//div[@id='container']"));
		
		List<WebElement> list = product.findElements(By.className("_2cLu-l"));
		System.out.println("Total Products : "+list.size());  // To display total no of products
		
	
	//list to display price, product name
		
		// array to store the name and price 
		
		String details[][] = new String[list.size()][2];
		int i,j;
		i=j=0;
		
		Iterator<WebElement> itr = list.iterator();
		while(itr.hasNext() && i<list.size()) {
			details[i][0] = itr.next().getText(); //Storing the name of the phones
			i++;
		}
		
		List<WebElement> listPrice = product.findElements(By.className("_1vC4OE"));
		
		Iterator<WebElement> itr1 = listPrice.iterator();
		while(itr1.hasNext() && j<list.size()) {
			String price = itr1.next().getText(); //Storing the price of the phone
			details[j][1] = price.substring(1);
			j++;
		}
		
		for(i=0; i<list.size(); i++) {
			for(j=0; j<2; j++) {
				System.out.print(details[i][j]+", ");
			}
			System.out.println();
		}
		
		//driver.quit();

	}

	// close the browser
	public void closeBrowser() {

		
	//	driver.quit();

	}

	public static void main(String[] args) throws Exception {

		Iphone i = new Iphone();
		i.LaunchBrowser();
		//i.search();
		//i.filter_search();
		 i.closeBrowser();

	}

}

//2. Create PR (Push and Pull Request) with the changes to the script

//Master Branch created successfully and all the changes are pushed upstream.
//https://github.com/Nrupal-sys/BrowserStack_Assignment2.git

//Pull Request created successfuly.  From  Git Repo >>Origin >> Config Fetch 



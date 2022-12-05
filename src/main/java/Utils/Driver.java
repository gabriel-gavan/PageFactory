package Utils;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

//import javax.print.DocFlavor.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * Scope of class is to parameterize the browser instantiation
 * @author gabriel.gavan
 *
 */
public class Driver {
	/**
	 * ThreadLocal class that we are using only for parallel run
	 */
	public static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	/**
	 * Scope of this method is to create browser objects for Chrome. Firefox, Edge based on parameter "browser"
	 * Uses WebDriverManager (link to site) to handle the drivers executables
	 * @param browser
	 * @return
	 * @throws MalformedURLException 
	 */
	public WebDriver initDriver(String browser) throws MalformedURLException {
		RemoteWebDriver rwd;
		if(browser.equalsIgnoreCase("chrome")) {
		//	WebDriverManager.chromedriver().setup();
		//	driver.set(new ChromeDriver());
			
			ChromeOptions option = new ChromeOptions();
			option.addArguments("--headless");
			option.addArguments("--window-size=1920,1080");
			rwd = new RemoteWebDriver(new URL("http://192.168.0.166:4444"),option);
			driver.set(rwd);
			
			driver.get().manage().window().maximize();
			driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			long chromeId = Thread.currentThread().getId();
			System.out.println("Chrome --> Thread id = " + chromeId);
			return driver.get();
		} else if (browser.equalsIgnoreCase("firefox")) {
			//WebDriverManager.firefoxdriver().setup();
		//	driver.set(new FirefoxDriver());
			
			FirefoxBinary firefoxBinary = new FirefoxBinary();
			firefoxBinary.addCommandLineOptions("--headless");
			FirefoxOptions firefoxoptions = new FirefoxOptions();
			firefoxoptions.setBinary(firefoxBinary);
			rwd = new RemoteWebDriver(new URL("http://192.168.0.166:4444"),firefoxoptions);
			driver.set(rwd);
			
			driver.get().manage().window().maximize();
			driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			long fiefoxId = Thread.currentThread().getId();
			System.out.println("Firefox --> Thread id = " + fiefoxId);
			return driver.get();
		} else if (browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver.set(new EdgeDriver());
			driver.get().manage().window().maximize();
			driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			long edgeid = Thread.currentThread().getId();
			System.out.println("Edge --> Thread id = " + edgeid);
			return driver.get();
		}
		return driver.get();
}
}

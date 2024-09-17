package utilityfile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.sound.midi.SysexMessage;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.testng.annotations.Parameters;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;




//import utilityt.Datautils;

public class BaseClass {
	protected static WebDriver driver;
	public static Select sd;
	//public ExtentSparkReporter spark;
	//public ExtentReports report;
    //@Parameters({"browser"})
	public void browser() {

		// WebDriverManager.firefoxdriver().setup();
		/*
		 * switch (browser) { case "chrome": driver = new ChromeDriver(); break; case
		 * "firefox": driver =new FirefoxDriver(); break; default:
		 * System.err.println("broswer can't"); break; }
		 */
		//ChromeOptions option = new ChromeOptions();
		//option.addArguments("--headless");
		//driver = new ChromeDriver(option);
		driver = new ChromeDriver();
		// driver =new FirefoxDriver();
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	}

	public void MasterUrl() {
		driver.get("http://leaftaps.com/opentaps/control/main");
	}
public void quitb() {
	
	driver.quit();
}
	public WebElement idLocator(String idname) {
		WebElement idName = driver.findElement(By.id(idname));
		return idName;
	}

	public WebElement nameloc(String namel) {
		WebElement name = driver.findElement(By.name(namel));
		return name;
	}

	public void dropdown(WebElement element, String vistext ) {
		 Select sd = new Select(element);
		 sd.selectByVisibleText(vistext);
		 //return sd; 
	 }
	public Select dropd(WebElement element) {
		 sd = new Select(element);
		 //sd.selectByVisibleText(vistext);
		 return sd; 
	 }
	public WebElement xpathlocator(String xpathn) {
		WebElement xpathname = driver.findElement(By.xpath(xpathn));
		return xpathname;
	}

	public WebElement classnamelocator(String classname) {
		WebElement clsname = driver.findElement(By.className(classname));
		return clsname;
	}

	public void clickM(WebElement element) {
		element.click();
	}

	public void sendkeys(WebElement element, String name) {
		element.sendKeys(name);
	}

	public void sleep(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String title() {
		String title = driver.getTitle();
		System.out.println(title);
		return title;
	}
	public void windowhandle(int num) {
		String Parentwindow = driver.getWindowHandle();
		Set<String> allwindow = driver.getWindowHandles();
		ArrayList<String> alltab = new ArrayList<String>(allwindow);
		driver.switchTo().window(alltab.get(num));
		{
			String title = driver.getCurrentUrl();
			System.out.println("Current URl Child is: " + title);
			childclassoperation.childopera();
		}
		driver.switchTo().window(Parentwindow);
		String title = driver.getCurrentUrl();
		System.out.println("Current URl is: " + title);
		}

	public String excelRead(String sheet, int row, int cell) throws IOException {
		// String value=null;
		File f = new File("./test-data/CRMFA Data.xlsx");
		FileInputStream fin = new FileInputStream(f);
		Workbook w = new XSSFWorkbook(fin);
		Sheet s = w.getSheet(sheet);
		Row r = s.getRow(row);
		Cell c = r.getCell(cell);
		DataFormatter d = new DataFormatter();
		String CellValue = d.formatCellValue(c);
		System.out.println(CellValue);
		w.close();
		
		
		
		
		return CellValue;

	}
	
	@SuppressWarnings("deprecation")
	public Timeouts impwaitt() {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		
		
		Timeouts impwait = driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		return impwait;
		
	
	}
 public String screenshotA(String screenName) {
	 File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	 String destlo = "./ScreenS/"+screenName+".png";
	 File dest = new File(destlo);
	 try {
		FileUtils.copyFile(source, dest);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 //FileHandler.copy(source, dest);
	 return destlo;
 }

public void sendKeys(CharSequence[] charSequences) {
	WebElement element = null;
	CharSequence name = null;
	// TODO Auto-generated method stub
	element.sendKeys(name);
}

public List<WebElement> xpathelemnts(String xnames) {
	List<WebElement> xNames = driver.findElements(By.xpath(xnames));
	return xNames;
}
}

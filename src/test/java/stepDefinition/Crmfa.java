package stepDefinition;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.model.Report;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilityfile.BaseClass;

//import testNg.BaseClass;

public class Crmfa extends BaseClass{
	BaseClass b= new BaseClass();
	

	//WebDriver driver;
	/*
	 * @Given("user launch the browser and website") public void
	 * user_is_already_on_login_page() {
	 * 
	 * 
	 * }
	 */

	@When("user enter username and password") //\"(.*)\"
	public void title_of_login_page_is_crm(DataTable cred  ) {
		
		WebElement user = b.idLocator("username");
		WebElement passw = b.idLocator("password");
		List<List<String>> data = cred.asLists(); //cred.cells();
		/*
		 * List<Map<String, String>> data = cred.asMaps(String.class , String.class);
		 * for (Map<String, String> map : data) { b.sendkeys(user, map.get("username"));
		 * b.sendkeys(passw, map.get("password")); }
		 */
		/*List of String */
		b.sendkeys(user,data.get(1).get(0)); //DemoSalesManager
		//WebElement passw = b.idLocator("password");
		b.sendkeys(passw, data.get(1).get(1)); //crmsfa
	}
		
	@Then("verify the title page")
	public void verifyTitle() {
		b.impwaitt();
		String titlemainpage = driver.getTitle();
		System.out.println("Title of Main Page: "+titlemainpage);
		}
	@Then("enter to main Lead page")
	public void mainpage() {
		WebElement fin = b.classnamelocator("decorativeSubmit");
		b.clickM(fin);
		b.screenshotA("Main Page");
		b.title();
        if(b.title().equals("Leaftaps - TestLeaf Automation Platform")) {
        	System.out.println("Datai is Fine");
        }else {
        	System.out.println(" Not Logicaly proven");
        }
	}
	
	@Then("user mainpage and enter in create lead page")
	public void user_enter_username_and_password() {
		WebElement but = b.idLocator("button");
		b.clickM(but);
		WebElement Clead = b.xpathlocator("//a[text()='Create Lead']");
		b.clickM(Clead);
		b.screenshotA("Create Lead Page");
	}

	@Then("user fill company name")
	public void user_clicks_login_button() {
		WebElement Formfill = b.idLocator("createLeadForm_companyName");
		b.sendkeys(Formfill, "Azees&Co");
		WebElement wind = b.xpathlocator("//input[@id='createLeadForm_parentPartyId']/following::a[1]");
		b.clickM(wind);
		b.windowhandle(1);
		b.sleep(1000);
		// driver.findElement(By.xpath("//input[@name='id']")).sendKeys("10477");
		/*
		 * WebElement comp = b.nameloc("accountName"); b.sendkeys(comp,
		 * "Credit Limited Account");
		 * b.xpathlocator("//button[text()='Find Accounts']").click(); //
		 * b.xpathlocator("//a[text()='10477']").click(); b.sleep(5000); b.sleep(3000);
		 * b.xpathlocator("//a[text()='Credit Limited Account']").click();
		 */
		WebElement drop = b.nameloc("dataSourceId");
		//b.screenshotA("final");
		b.dropd(drop);
		List<WebElement> options = sd.getOptions();
		for (WebElement A : options) {
			String text = A.getText();
			System.out.println(text);
		}
		sd.selectByVisibleText("Cold Call");
	}

	@Then("user exit browser")
	public void user_is_on_homepage() {
		
		b.quitb();
	}

}

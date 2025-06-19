package deel_automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SalaryInsightPage extends BasePage {

	public SalaryInsightPage(WebDriver driver) {
		super(driver);
	}
	
	public By Insight_Tool_Section = By.xpath("//div//h2[contains(text(),'Salary Insights Tool')]");
	public By Role_Button = By.xpath("//input[contains(@name,'role')]");
	public By Country_Value = By.xpath("//input[contains(@name,'country')]");
	public By Role_TextBox = By.xpath(".//*[@placeholder='Select a role']");
	public By RoleNameList = By.xpath(".//*[@role='listbox']//li");
	public By RequestDemoBtn = By.xpath("//button[contains(@id,'request-a-demo')]");
	
	
	
	public By RoleCloseBtn = By.xpath(".//*[@data-testid='CloseIcon']");
	
	public By Country_TextBox = By.xpath(".//*[@placeholder='Select a country']");
	public By CountryNameList = By.xpath(".//*[@role='listbox']//p");
	
	public By SearchButton = By.xpath(".//button[@type='submit']");
	
	public By SalaryTable = By.xpath(".//div[@data-qa='salary-table']//h2");
	
	public By RoleNames = By.xpath(".//*[contains(@class,'listbox')]//li//div[contains(@class,'MuiBox-root css-kwpt08')]");

	public By FilterBar = By.xpath(".//*[@data-qa='filter-bar']");
	
	public By FirstFilter = By.xpath("//div[@data-qa='filter-bar']//div//div//button");
	
	public By FilterHeading = By.xpath("//*[contains(@class, 'MuiGrid-item css-9uq6kp')]//p[contains(text(),\"List\")]");
	
	public By FilterSearchBox = By.xpath("//input[@placeholder='Search']");
	
	public By FilterRadioGroup = By.xpath(".//*[@role='radiogroup']");
	
	public By FilterRadioList = By.xpath(".//*[@role='radiogroup']//label");
	
	public By FormHeading = By.xpath("//*[contains(@class, 'MuiGrid-root')]//p[contains(text(),\"Unlock\")]");
	
	
	
			



}

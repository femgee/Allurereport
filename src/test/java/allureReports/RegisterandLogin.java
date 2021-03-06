package allureReports;

import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class RegisterandLogin {

	WebDriver driver;

	@BeforeClass
	public void setupinstance() {
		BaseClass bs = new BaseClass();
		driver = bs.initialize_driver();
		driver.get("https://demo.nopcommerce.com/register?returnUrl=%2Fregister%3FreturnUrl%3D%252F");
	}

	@Test(priority = 1)
	@Description("Verify that user can register successfully")
	@Epic("Epic001")
	@Feature("Feature1: Registration Test")
	@Story("Story: Registration")
	@Step("Verify Registration")
	@Severity(SeverityLevel.CRITICAL)
	public void registrationTest() {

		driver.findElement(By.id("gender-male")).click();// selected gender as male

		driver.findElement(By.id("FirstName")).sendKeys("Testerg"); // entered firstname script

		driver.findElement(By.id("LastName")).sendKeys("Testino1234"); // entered lastname script

		Select day = new Select(driver.findElement(By.name("DateOfBirthDay")));
		day.selectByValue("6"); // selected day of birth

		Select month = new Select(driver.findElement(By.name("DateOfBirthMonth")));
		month.selectByVisibleText("June"); // selected month of biryh

		Select year = new Select(driver.findElement(By.name("DateOfBirthYear")));
		year.selectByValue("1978"); // selected year of birth

		driver.findElement(By.id("Email")).sendKeys("femgee2009@gmail.com"); // entered year of birth
		driver.findElement(By.id("Company")).sendKeys("Lakin Technology Limited"); // entered company details

		WebElement pass = driver.findElement(By.id("Password")); // entered password
		pass.sendKeys("Lakintec");

		WebElement conf = driver.findElement(By.id("ConfirmPassword"));
		conf.sendKeys("Lakintec"); // confirmed password
		driver.findElement(By.id("register-button")).click();

		driver.navigate().back();
	}

	@Test(priority = 2)
	@Description("Verify that user can login successfully")
	@Epic("Epic002")
	@Feature("Feature2: Login Test")
	@Story("Story: Login")
	@Step("Verify Login")
	@Severity(SeverityLevel.CRITICAL)

	public void login() {

		driver.get("https://demo.nopcommerce.com/login?returnUrl=%2F");// navigated to login page

		WebElement email = driver.findElement(By.id("Email"));
		email.sendKeys("femgee2009@gmail.com");// entered email detail

		WebElement pass = driver.findElement(By.id("Password"));
		pass.sendKeys("Lakintec");

		WebElement button = driver
				.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]/div[2]/form/div[3]/input"));
		button.click();

	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}

}

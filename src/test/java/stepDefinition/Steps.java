package stepDefinition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import java.util.*;

public class Steps {

	public static WebDriver driver; // = new ChromeDriver();
	public static String originalWindow = null;
	public static WebElement pricingCardSection = null;
	public static WebElement gridContainer = null;
	public static List<WebElement> gridItems = null;
	public static WebElement selectedGridItemView = null;
	public static WebElement selectedGridItemSelect = null;
	public static String selectedGridItemTitle = null;
	public static WebElement selectedServiceBanner = null;
	public static WebElement selectedServiceBannerDescription = null;
	public static String selectedServiceBody = null;




	@When("^I go to AntidoteHealth website$")
	public void I_go_to_AntidoteHealth_website() throws Throwable {
		driver.manage().window().maximize();

		String siteUrl = "https://www.antidotehealth.com/";

		driver.get(siteUrl);

		Thread.sleep(2000);

	}

	@And("^I navigate to pricing$")
	public void I_navigate_to_pricing() throws Throwable {


		driver.findElement(By.xpath("//div[@class='nav-menu-inner']//a[contains(text(),'Pricing')]")).click();

	}

	@Then("^I select a service randomly and toggle view details button")
	public void I_select_a_service_randomly_and_toggle_view_details_button() throws Throwable {

		pricingCardSection = driver.findElement(By.xpath("//section[@class='p--section is--pricing-cards wf-section']"));
		gridContainer = pricingCardSection.findElement(By.xpath("//div[@class='p--container is--pricing-cards-new']"));
		gridItems = gridContainer.findElements(By.xpath("//div[@class='price--card-wrapper is--1']"));

		Random random = new Random();
		int num = random.nextInt(gridItems.size());

		selectedGridItemView = gridItems.get(num).findElement(By.xpath("//div[@class='read-more-less']"));
		selectedGridItemSelect = gridItems.get(num).findElement(By.xpath("//a[@class='p--button is--price w-button']"));
		selectedGridItemTitle = gridItems.get(num).findElement(By.xpath("//h3[@class='title is--30']")).getText();

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)", "");
		selectedGridItemView.click();
		Thread.sleep(2000);
		selectedGridItemView.click();
		Thread.sleep(3000);

	}

	@Then("^I click the select button")
	public void I_click_the_select_button() throws Throwable {

		originalWindow = driver.getWindowHandle();
		assert driver.getWindowHandles().size() == 1;

		selectedGridItemSelect.click();
	}

	@And("^I Assert the plans features")
	public void I_Assert_the_plans_features() throws Throwable {

		for (String windowHandle : driver.getWindowHandles()) {
			if(!originalWindow.contentEquals(windowHandle)) {
				driver.switchTo().window(windowHandle);
				break;
			}
		}

		selectedServiceBanner = driver.findElement(By.xpath("//div[@class='payment-plan-banner']"));
		selectedServiceBannerDescription = selectedServiceBanner.findElement(By.xpath("//div[@class='payment-plan-banner-description']"));
		selectedServiceBody = selectedServiceBannerDescription.findElement(By.xpath("//p[@class='selected-plan-body']")).getText();

		switch(selectedGridItemTitle) {
			case "Primary Care":
				assert (selectedServiceBody.contains("Primary Care"));
				assert (selectedServiceBody.contains("Urgent Care"));
				assert (selectedServiceBody.contains("Medical Notes"));
			break;

			case "Complete Care":
				assert (selectedServiceBody.contains("Primary Care"));
				assert (selectedServiceBody.contains("Hypertension Care"));
				assert (selectedServiceBody.contains("Diabetes Care"));
				assert (selectedServiceBody.contains("Assistance with Out-of-Pocket Drug Expenses"));
			break;

			case "Mental Health":
				assert (selectedServiceBody.contains("Primary Care"));
				assert (selectedServiceBody.contains("Diabetes Care"));
				assert (selectedServiceBody.contains("Hypertension Care"));
				assert (selectedServiceBody.contains("Assistance With Out-Of-Pocket Drug Expenses"));
			break;

		}

		Thread.sleep(2000);
	}

}

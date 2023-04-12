package stepDefinition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.Response;

import java.util.*;

public class Steps {

	public static WebDriver driver; // = new ChromeDriver();
	public static WebElement pricingCardSection = null;
	public static WebElement gridContainer = null;
	public static List<WebElement> gridItems = null;
	public static WebElement selectedGridItem = null;



	@When("^I go to AntidoteHealth website$")
	public void I_go_to_AntidoteHealth_website() throws Throwable {

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
		selectedGridItem = gridItems.get(num);
		WebElement viewButton = selectedGridItem.findElement(By.xpath("//div[@class='read-more-less']"));
		viewButton.click();
		viewButton.click();

	}

	@Then("^I click the select button")
	public void I_click_the_select_button() throws Throwable {

		selectedGridItem.findElement(By.xpath("//a[@class='p--button is--price w-button']")).click();

	}

}

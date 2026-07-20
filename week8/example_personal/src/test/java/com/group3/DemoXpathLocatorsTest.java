package com.group3;

import net.bytebuddy.utility.dispatcher.JavaDispatcher;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Demo: XPath locators in Selenium
 *
 * 1. XPath is the most flexible locator strategy
 * 2. Prefer relative XPATH over absolute
 * 3. XPath functions enable element finding
 * 4. XPath has axis navigate the DOM tree
 *
 * TEST siteL: https://the-internet.herokuapp.com
 */

@DisplayName("XPath Locators Demo")
public class DemoXpathLocatorsTest {

    private WebDriver driver;
    private static final String BASE_URL = "https://the-internet.herokuapp.com";

    @BeforeEach
    void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterEach
    void tearDown(){
        if(driver != null){
            driver.quit();
        }
    }

    @Test
    @DisplayName("Abolsute XPath - starts from root of DOM")
    void absoluteXpath_startsFromRoot(){
        /*
        Absolute xpath starts with single slash
        starts from document root

        Problems:
        - Very brittle - breaks id DOM structure changes
        - Hard to read and maintain
        - Avoid in production
         */

        driver.get(BASE_URL);

        // Absolute Xpath - BAD PRACTICE (demos concept)
        // Example: /html/body/div[2]/div/h1
        // Abs Xpath breaks if any elements change in absolute path

        try{
            WebElement heading = driver.findElement(By.xpath("/html/body/div[2]/div/h1"));
            System.out.println("Heading: " + heading.getText());
        } catch (NoSuchElementException e){
            System.out.println("Absolute XPath is brittle" + e);
        }


    }

    @Test
    @DisplayName("Relative XPath - pref in production")
    void demoXPath_relativePath(){

        driver.get(BASE_URL);

        WebElement heading = driver.findElement(By.xpath("//h1[@class='heading']"));
        System.out.println("Heading text: " + heading);
        assertNotNull(heading.getText());
    }


    // 2. XPath with Attributes
    @Test
    @DisplayName("Xpath by ID Atrributes")
    void xpathById_findElements(){
        driver.get(BASE_URL + "/login");

        WebElement usernameInput = driver.findElement(By.xpath("//input[@id='username']"));
        assertTrue(usernameInput.isDisplayed());
        System.out.println("Found username input by Id");
    }

    @Test
    @DisplayName("XPath by attribute")
    void xpathByAttribute_findElement(){

        driver.get(BASE_URL + "/login");

        WebElement passwordInput = driver.findElement(By.xpath("//input[@name='password']"));
        assertTrue(passwordInput.isDisplayed());
        System.out.println("Found password input by attribute name");
    }

    @Test
    @DisplayName("Xpath with mutli-attributes")
    void xpathByMultipleAttributes_moreSpecific(){

        // combines multiple atttributes for more specific element matching
        driver.get(BASE_URL + "/login");

        WebElement loginButton = driver.findElement(By.xpath("//button[@class='radius']"));
        assertTrue(loginButton.isDisplayed());
        System.out.println("Found login button: " + loginButton.getText());


    }

    @Test
    @DisplayName("contains() - Partial text match")
    void xpathContains_partialMatch(){
        driver.get(BASE_URL + "/login");

        /*
        * contains matches with attributes/text CONTAINS the value
        * Great for dynamic IDs or partial class names
         */

        WebElement formLinks = driver.findElement(By.xpath("//a[contains(text(), 'Form')]"));
        System.out.println("Found Link: " + formLinks.getText());

        assertTrue(formLinks.getText().contains("Form"));

        WebElement heading = driver.findElement(By.xpath("//*[contains(text(), 'heading')]"));

        System.out.println("Heading: " + heading.getText());

    }

    // 4. XPath Axes
    @Test
    @DisplayName("parent axis - navigate up")
    void xPathParent_navigateUp(){

        driver.get(BASE_URL + "/tables");
        WebElement cell = driver.findElement(By.xpath("//td[text()='jsmith@gmail.com']"));
        WebElement parentRow = cell.findElement(By.xpath("./parent::tr"));

        System.out.println("Parent row text: " + parentRow.getText());
        assertTrue(parentRow.getText().contains("smith"));
    }

    @Test
    @DisplayName("child axes - nagivate down")
    void xPathChild_navigateDown(){
        driver.get(BASE_URL);

        // find all direct child links available
        /*
        * child:: selects direct children
        * Default axis, so child::div is same as just div
         */

        List<WebElement> links = driver.findElements(By.xpath("//div[@id='content']//a"));
        System.out.println("Found: " + links.size());
        assertFalse(links.isEmpty());
    }
}

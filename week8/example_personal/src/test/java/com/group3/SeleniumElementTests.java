package com.group3;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.*;

/**
 *  Demo Selenium interactions
 *  1. WebElement represents any HTML element
 *  2. Basic interactions: click, sendKeys, clear
 *  3. Information getters: getText, getAttribute, getCssValue
 *  4. State Checks: isDisplayed, isEnabled, isSelected
 *
 *  TEST site: https://the-internet.herokuapp.com
 */

@DisplayName("Element Interaction Demo")
public class SeleniumElementTests {

    private WebDriver driver;
    private static final String BASE_URL = "https://the-internet.herokuapp.com";

    // setup
    @BeforeEach
    void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    // teardown
    @AfterEach
    void tearDown(){
        if(driver != null){
            driver.quit();
        }
    }

    //1. basic click test

    @Test
    @DisplayName("click() - Basic button click")
    void click_basicButton(){
        /*
        click simulates a mouse cliuck on the element like a button, link, checkbox, etc
        */
        driver.get(BASE_URL + "/add_remove_elements/");

        // find the button with XPath expression
        WebElement addButton = driver.findElement(
                By.xpath("//button[text()='Add Element']")
        );

        // before clicking
        int elementsBefore = driver.findElements(By.className("added-manually")).size();
        System.out.println("Elements before click: " + elementsBefore);

        addButton.click();

        int elementsAfter = driver.findElements(By.className("added-manually")).size();
        System.out.println("Elements after click: " + elementsAfter);
        assertEquals(elementsBefore + 1, elementsAfter);
    }

    //    @Disabled("fix form auth")
    @Test
    @DisplayName("click() - Link nav")
    void click_linkNavigation(){
        driver.get(BASE_URL);

        WebElement link = driver.findElement(By.linkText("Form Authentication"));
        link.click();
        assertTrue(driver.getCurrentUrl().contains("login"));
    }

    // 2: text input opertaions

    @Test
    @DisplayName("sendKeys() - Type text into input field")
    void sendKeys_typeText(){
        /*
        * sendKeys() types text into input fields
        * works with text fields, textareas, etc.
         */
        driver.get(BASE_URL + "/login");
        WebElement usernameInput = driver.findElement(By.id("username"));
        WebElement passwordInput = driver.findElement(By.id("password"));


        // type into the fields
        usernameInput.sendKeys("John Smith");
        passwordInput.sendKeys("SuperSecretPassword");

        // verify text was entered
        assertEquals("John Smith", usernameInput.getAttribute("value"));
        assertEquals("SuperSecretPassword", passwordInput.getAttribute("value"));
        System.out.println("Text Entered Successfully");
    }

    @Test
    @DisplayName("sendKeys() - Special Keys")
    void sendKeys_specialKeys(){

        driver.get(BASE_URL + "/login");

        WebElement usernameInput  = driver.findElement(By.id("username"));
        WebElement passwordInput = driver.findElement(By.id("password"));

        // tab moves to next input field
        usernameInput.sendKeys("tomsmith");
        usernameInput.sendKeys(Keys.TAB);

        passwordInput.sendKeys("SuperSecretPassword");
        passwordInput.sendKeys(Keys.TAB);

        System.out.println("URL after login: " + driver.getCurrentUrl());

    }
    @Test
    @DisplayName("getText() - get visible text field")
    void getText_demo(){
        driver.get(BASE_URL + "/login");

        WebElement heading = driver.findElement(By.tagName("h2"));
        String headingText = heading.getText();

        assertEquals("Login Page", headingText);
        System.out.println("Header: " + headingText);

        WebElement subheading = driver.findElement(By.tagName("h4"));
        System.out.println("Subheading: " + subheading);


    }

    @Test
    @DisplayName("getAttribute() - Get Attribute values")
    void getAttribute_getAttributeValues(){
        /*
        *  getAttribute retrieves HTML attribute values
        *  Common attributes: id, class, name, href, value, placeholder
         */


        driver.get(BASE_URL + "/login");
        // xpath can index multiple instances of HTML tag
        WebElement usernameInput = driver.findElement(By.id("username"));

        // get attributes
        String id = usernameInput.getAttribute("id");
        String type = usernameInput.getAttribute("type");
        String name = usernameInput.getAttribute("name");
        System.out.println("Id: " + id);
        System.out.println("Type: " + type);
        System.out.println("Name: " + name);

        assertAll(()->assertEquals("username", id),
                ()->assertEquals("text", type),
                ()->assertEquals("username", name));
    }
}

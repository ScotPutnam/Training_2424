import pytest
from selenium import webdriver
from selenium.webdriver.chrome.options import Options
from selenium.webdriver.chrome.service import Service
from selenium.webdriver.common.by import By
from webdriver_manager.chrome import ChromeDriverManager


@pytest.fixture(scope="module")
def driver():
    """Create a Chrome WebDriver for Selenium tests."""
    options = Options()
    options.add_argument("--headless=new")
    options.add_argument("--window-size=1920,1080")
    options.add_argument("--no-sandbox")
    options.add_argument("--disable-dev-shm-usage")

    service = Service(ChromeDriverManager().install())
    browser = webdriver.Chrome(service=service, options=options)
    browser.implicitly_wait(5)

    yield browser

    browser.quit()


def test_css_selector_by_id(driver):
    driver.get("https://the-internet.herokuapp.com/login")

    username_input = driver.find_element(By.CSS_SELECTOR, "#username")

    assert username_input.is_displayed()
    assert username_input.get_attribute("id") == "username"
    assert username_input.get_attribute("name") == "username"


def test_css_selector_by_class_and_tag(driver):
    driver.get("https://the-internet.herokuapp.com/login")

    radius_button = driver.find_element(By.CSS_SELECTOR, ".radius")
    login_button = driver.find_element(By.CSS_SELECTOR, "button")

    assert radius_button.is_displayed()
    assert login_button.is_displayed()
    assert radius_button.tag_name.lower() == "button"


def test_css_selector_by_attribute_and_descendant_selector(driver):
    driver.get("https://the-internet.herokuapp.com/login")

    password_input = driver.find_element(By.CSS_SELECTOR, "input[type='password']")
    form_input = driver.find_element(By.CSS_SELECTOR, "form input[name='password']")

    assert password_input.is_displayed()
    assert password_input.get_attribute("type") == "password"

    assert form_input.is_displayed()
    assert form_input.get_attribute("name") == "password"

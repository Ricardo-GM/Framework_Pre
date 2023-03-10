package StepDefinitions;

import Functions.CreateDriver;
import Functions.SeleniumFunctions;
import Pages.Page_login;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;

import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

public class StepsDefinitions_login {
    private static Properties prop = new Properties();
    private static InputStream in = CreateDriver.class.getResourceAsStream("../test.properties");

    WebDriver driver;
    SeleniumFunctions functions = new SeleniumFunctions();

    Page_login page_login = new Page_login();

    //public static boolean actualState = Boolean.parseBoolean(null);

    Logger log = Logger.getLogger(StepsDefinitions_login.class);

    public StepsDefinitions_login() {
        driver = Hooks.driver;

    }


    // Scenario scenario = null;

    // public void scenario (Scenario scenario) { this.scenario = scenario; }
    /*
    @Given("^I am in App main site")
    public void iAmInAppSite() throws IOException {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String url = functions.readProperties("MainAppUrlBase");
        prop.load(in);
        log.info("Navigate to: " + url);
        driver.get(url);
        functions.pageHasLoaded();
    }

    @Given("^I go to site (.*)")
    public void goToSite(String URL) {
        log.info("Navigate to: " + URL);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(URL);
        functions.pageHasLoaded();
    }

    @Then("^I load the DOM Information (.*)$")
    public void loadDOMInformationFromJSON(String json) throws Exception {
        SeleniumFunctions.FileName = json;
        SeleniumFunctions.readJson();
        log.info("initialize file: " + json);
    }

    @Then("^I do a click in element (.*)")
    public void doAClickInElement(String element) throws Exception {
        By SeleniumElement = SeleniumFunctions.getCompleteElement(element);
        functions.waitForClickableElement(element);
        driver.findElement(SeleniumElement).click();
        log.info("Click on element by " + element);
    }

    @Then("^I set (.*) with text (.*)")
    public void setElementWithText(String element, String text) throws Exception {
        By SeleniumElement = SeleniumFunctions.getCompleteElement(element);
        driver.findElement(SeleniumElement).sendKeys(text);
    }

    @And("^I put (.*) in element (.*)")
    public void putElementWithText(String text, String element) throws Exception {
        By SeleniumElement = SeleniumFunctions.getCompleteElement(element);
        driver.findElement(SeleniumElement).sendKeys(text);
        driver.findElement(SeleniumElement).submit();
    }

    @Given("^I set (.*) value in Data Scenario")
    public void iSetUserEmailValueInDataScenario(String parameter) throws IOException {
        functions.RetriveTestData(parameter);
    }

    @And("I save text of (.*) as Scenario Context")
    public void iSaveTextOfTituloAsScenarioContext(String element) throws Exception {
        By SeleniumElement = SeleniumFunctions.getCompleteElement(element);
        String ScenarioElementText = driver.findElement(SeleniumElement).getText();
        functions.SaveInScenario(element + ".text", ScenarioElementText);
    }

    @And("I set (.*) with key value (.*)")
    public void iSetEmailWithKeyValueTitleText(String element, String key) throws Exception {
        functions.iSetElementWithKeyValue(element, key);
    }

    @And("^I set text (.*) in dropdown (.*)")
    public void iSetTextInDropdown(String option, String element) throws Exception {
        Select opt = (Select) functions.selectOption(element);
        opt.selectByVisibleText(option);
    }

    @And("^I set index (.*) in dropdown (.*)")
    public void iSetIndexInDropdown(int option, String element) throws Exception {
        Select opt = (Select) functions.selectOption(element);
        opt.selectByIndex(option);
    }

    @Then("I close the window")
    public void iCloseTheWindow() {
        log.info("Closing windows");
        driver.close();
    }


    @Then("I check if (.*?) error message is (.*)")
    public void iCheckIfErrorMessageIs(String element, String state) throws Exception {
        actualState = functions.isElementDisplayed(element);
        Assert.assertEquals("El estado es diferente al esperado", actualState, Boolean.valueOf(state));
    }

    @And("^I switch to Frame: (.*)")
    public void switchToFrame(String frame) throws Exception {
        functions.switchToFrame(frame);
    }

    @And("^I switch to parent frame")
    public void switchToParentFrame() {
        functions.switchToParentFrame();
    }

    @And("^I check the checkbox having (.*)$")
    public void iCheckTheCheckboxHavingFrameInput(String element) throws Exception {
        functions.checkCheckbox(element);
    }

    @And("^I click in JS element (.*)$")
    public void clickInJSElement(String element) throws Exception {
        functions.clickJSElement(element);
    }


    @And("^I wait for element (.*) to be present")
    public void waitForElementToBePresent(String element) throws Exception {
        actualState = functions.isElementDisplayed(element);
        Assert.assertEquals("El estado es diferente al esperado", true, actualState);
    }

    @And("^I wait for element (.*) to be visible")
    public void waitForElementToBeVisible(String element) throws Exception {
        functions.waitForElementVisible(element);
    }

    @And("^I scroll to element (.*)")
    public void scrollToElement(String element) throws Exception {
        functions.scrollToElement(element);
    }

    @Then("Assert if (.*) is equal to (.*)")
    public void assertTextEquals(String element, String expectedText) throws Exception {
        String actualText = functions.GetTextElement(element);
        Assert.assertEquals(expectedText, actualText);
    }

    @Then("^Assert if (.*) contains text (.*)")
    public void checkPartialTextElementPresent(String element, String text) throws Exception {
        functions.checkPartialTextElementPresent(element, text);
    }

    @And("^I wait (.*) seconds")
    public void waitForGivenSeconds(int seconds) throws InterruptedException {
        int secs = seconds * 1000;
        Thread.sleep(secs);
    }

    @Then("^I (accept|dismiss) alert")
    public void iAcceptAlert(String want) {
        functions.acceptAlert(want);
    }


    @And("I take screenshot: (.*)")
    public void takeScreenshot(String name) throws IOException {
        functions.ScreenShot(name);
    }

    @And("I wait site is loaded")
    public void iWaitSiteIsLoaded() {
        functions.pageHasLoaded();
    }

    @And("I attach a Screenshot to Report: (.*)")
    public void iAttachAScreenshotToReportParaAllure(String description) {
        functions.attachScreenShot(description);
    }

    @Then("I resize browser to mobile")
    public void iResizeBrowserToMobile() {
        Map<String, String> mobileEmulation = new HashMap<>();

        mobileEmulation.put("deviceName", "Nexus 5");


        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);

        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("http://automationpractice.com/index.php");
        driver.manage().window().maximize();
    }
    */

    //Prueba Login

    @Given("I am on the login page")
    public void i_am_on_the_login_page() throws Exception {
        String url = functions.readProperties("MainAppUrlBase");
        log.info("Entrar en : " + url);
        driver.get(url);

        //Leer archivo login.json con los selectores
        SeleniumFunctions.FileName = "login.json";
        SeleniumFunctions.readJson();
        log.info("initialize file: login" );


    }

    @When("I login with (.+) and (.+)")
    public void i_login_with_username_and_password(String username, String password) throws Exception {
        page_login.login(username, password);
        log.info("Se ingres?? el usuario: " + username + " y el password: " + password );
    }

    @Then("I should see a flash message saying (.+)")
    public void i_should_see_a_flash_message(String message) throws Exception {
        page_login.viewFlashMessage(message);



    }



}

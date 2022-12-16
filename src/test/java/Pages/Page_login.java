package Pages;

import StepDefinitions.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Page_login {

    WebDriver driver;


    public Page_login() {
        driver = Hooks.driver;
    }



    //Elementos
    By usernameInput = By.id("username");
    By passwordInput = By.id("password");
    By submitButton = By.xpath("//*[@id='login']/button");
    By flashMessage =  By.id("flash");

    //Métodos

    public void setUsername(String username) {
        driver.findElement(usernameInput).sendKeys(username);


    }

    public void setPassword(String password) {
        driver.findElement(passwordInput).sendKeys(password);
    }

    public void clickSubmitButton(){
        driver.findElement(submitButton).click();
    }

    public void login(String username, String password) {
        setUsername(username);
        setPassword(password);
        clickSubmitButton();
    }

    public void viewFlashMessage(String message) {
        WebElement flashMessageElement = driver.findElement(flashMessage);
        if(flashMessageElement.isDisplayed()) {
            String flashMessageText = flashMessageElement.getText();
            flashMessageText = flashMessageText.replaceAll("\n×","");
            if (!flashMessageText.equals(message)) {
                org.junit.Assert.fail("No se encontró el mensaje esperado. Mensaje mostrado: " + flashMessageText + "Mensaje esperado: " + message);
            }
        }else{
            org.junit.Assert.fail("No se encontró el elemento");
        }

    }
}

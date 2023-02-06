package selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class YuGoHomePage {
    private static final String PAGE_URL = "http://localhost:4200/home";
    private final WebDriver webDriver;
    private final WebDriverWait waiter;
    private Actions actions;


    // ===================== Map =====================
    @FindBy(how = How.CSS, css = "body")
    private WebElement map;


    // ===================== Route picker form =====================
    @FindBy(how = How.CSS, css = "form div:nth-child(1) button")
    private WebElement selectDepartureIcon;
    @FindBy(how = How.CSS, css = "form div:nth-child(2) button")
    private WebElement selectDestinationIcon;
    @FindBy(how = How.CSS, css = "form button.mdc-button")
    private WebElement pickRouteContinueButton;



    // ===================== Pick vehicle type form =====================
    @FindBy(how = How.XPATH, xpath = "//h2[text()='LUX']/../../..")
    private WebElement luxVehicleCard;
    @FindBy(how = How.XPATH, xpath = "//h2[text()='STANDARD']/../../..")
    private WebElement standardVehicleCard;
    @FindBy(how = How.XPATH, xpath = "//h2[text()='VAN']/../../..")
    private WebElement vanVehicleCard;
    @FindBy(how = How.CSS, css = "app-ride-pick-properties button:nth-child(2)")
    private WebElement pickVehicleTypeContinueButton;


    public YuGoHomePage(WebDriver webDriver){
        this.webDriver = webDriver;
        actions = new Actions(webDriver);
        waiter = new WebDriverWait(this.webDriver, Duration.ofSeconds(10));
        webDriver.get(PAGE_URL);
        PageFactory.initElements(webDriver, this);
    }

    public void clickSelectDepartureIcon(){
        waiter.until(ExpectedConditions.elementToBeClickable(selectDepartureIcon)).click();
    }
    public void clickSelectDestinationIcon(){
        waiter.until(ExpectedConditions.elementToBeClickable(selectDestinationIcon)).click();
    }
    public void clickOnMap(int xOffset, int yOffset){
        actions.moveToElement(map).moveByOffset(xOffset, yOffset).click().perform();
    }
    public void clickRouteContinueButton(){
        waiter.until(ExpectedConditions.elementToBeClickable(pickRouteContinueButton)).click();
    }
    public void selectLuxVehicle(){
        waiter.until(ExpectedConditions.elementToBeClickable(luxVehicleCard)).click();
    }
    public void clickVehicleTypeContinueButton(){
        waiter.until(ExpectedConditions.elementToBeClickable(pickVehicleTypeContinueButton)).click();
    }
}
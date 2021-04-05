import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SeleniumTestProp {
    WebDriver driver;

    public SeleniumTestProp(WebDriver driver) {
        this.driver = driver;
    }

    By nameLord = By.cssSelector("input#lordName");
    By ageAgeLord = By.cssSelector("input#lordAge");
    By createLord = By.cssSelector("button#createLord");

    By namePlanet = By.cssSelector("input#planetName");
    By createPlanet = By.cssSelector("button#createPlanet");

    By planetId = By.cssSelector("input#planetId");
    By destroyPlanet = By.cssSelector("button#destroyPlanet");

    By managerLordId = By.cssSelector("input#managerLordId");
    By managerPlanetId = By.cssSelector("input#managerPlanetId");
    By managerLordByPlanet = By.cssSelector("button#managerLordByPlanet");

    By allLords = By.cssSelector("button#allLords");
    By allLoafers = By.cssSelector("button#allLoafers");
    By topLords = By.cssSelector("button#topLords");


    public SeleniumTestProp typeLordName(String name) {
        driver.findElement(nameLord).sendKeys(name);
        return this;
    }

    public SeleniumTestProp typeLordAge(Integer age) {
        driver.findElement(ageAgeLord).sendKeys(age.toString());
        return this;
    }

    public SeleniumTestProp clickCreateLord() {
        driver.findElement(createLord).click();
        return this;
    }

    public SeleniumTestProp typePlanetName(String name) {
        driver.findElement(namePlanet).sendKeys(name);
        return this;
    }

    public SeleniumTestProp clickCreatePlanet() {
        driver.findElement(createPlanet).click();
        return this;
    }

    public SeleniumTestProp typePlanetId(Integer id) {
        driver.findElement(planetId).sendKeys(id.toString());
        return this;
    }

    public SeleniumTestProp clickDestroyPlanet() {
        driver.findElement(destroyPlanet).click();
        return this;
    }

    public SeleniumTestProp typeManagerLordId(Integer id) {
        driver.findElement(managerLordId).sendKeys(id.toString());
        return this;
    }

    public SeleniumTestProp typeManagerPlanetId(Integer id) {
        driver.findElement(managerPlanetId).sendKeys(id.toString());
        return this;
    }

    public SeleniumTestProp clickManagerLordByPlanet() {
        driver.findElement(managerLordByPlanet).click();
        return this;
    }

    public SeleniumTestProp clickGetAllLords() {
        driver.findElement(allLords).click();
        return this;
    }

    public SeleniumTestProp clickGetAllLoafers() {
        driver.findElement(allLoafers).click();
        return this;
    }

    public SeleniumTestProp clickGetTopLords() {
        driver.findElement(topLords).click();
        return this;
    }
}

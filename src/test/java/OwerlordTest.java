
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;

public class OwerlordTest {
    ChromeDriver driver = new ChromeDriver();
    SeleniumTestProp seleniumTestProp;

    @Test
    public void typeInvalidNameLord(){
        driver.get("C:\\Users\\user\\Desktop\\OwerLord\\src\\main\\resources\\site\\Index.html");
        seleniumTestProp = new SeleniumTestProp(driver);
        seleniumTestProp.typeLordName("Maks").typeLordAge(43).clickCreateLord()
                .typePlanetName("Mars").clickCreatePlanet()
                .typeManagerLordId(1).typeManagerPlanetId(1).clickManagerLordByPlanet();
    }


}

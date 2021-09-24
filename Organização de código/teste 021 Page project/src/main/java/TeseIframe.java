import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

// teste com iframe

public class TeseIframe {

    // criação de metodos para agilisar e reduzir os códigos de teste.
    private WebDriver driver;

    @Before
    public void inicializa(){
        driver = new FirefoxDriver();
        driver.manage().window().setSize(new Dimension(1200, 765));
        driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
    }
    @After
    public  void ficnalizar(){
        driver.quit();
    }

    // inicialização da suite de testes.
        @Test
        public void deveInteragirComFrame() {

            driver.switchTo().frame("frame1");
            driver.findElement(By.id("frameButton")).click();
            Alert alert = driver.switchTo().alert();
            String msg = alert.getText();
            Assert.assertEquals("Frame OK!", msg);
            alert.accept();

            driver.switchTo().defaultContent();
            driver.findElement(By.id("elementosForm:nome")).sendKeys(msg);

        }
}

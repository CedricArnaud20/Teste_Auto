import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.sql.Driver;
import java.util.Locale;

// teste com iframe
public class TesteJanela {

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

        WebDriver driver = new FirefoxDriver();
        driver.manage().window().setSize(new Dimension(1200, 765));
        driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");

        driver.switchTo().frame("frame1");
        driver.findElement(By.id("frameButton")).click();
        Alert alert = driver.switchTo().alert();
        String msg = alert.getText();
        Assert.assertEquals("Frame OK!", msg);
        alert.accept();

        driver.switchTo().defaultContent();
        driver.findElement(By.id("elementosForm:nome")).sendKeys(msg);
    }

// teste janela
    @Test
    public void deveInteragircomJanela(){

        driver.findElement(By.id("buttonPopUpEasy")).click();
        driver.switchTo().window("Popup");
        driver.findElement(By.tagName("textarea")).sendKeys(("Deu certo?"));
        driver.close();
       // driver.switchTo().window("Popup");
       // driver.findElement(By.tagName("textarea")).sendKeys("e agora?");

    }

    @Test
    public void deveInteragirSemTitulo() {

        driver.findElement(By.id("buttonPopUpHard")).click();
        System.out.println(driver.getWindowHandle());
        System.out.println(driver.getWindowHandle());
        driver.switchTo().window(driver.getWindowHandle().toLowerCase(Locale.ROOT));
        driver.findElement(By.tagName("textarea")).sendKeys(("Deu certo?"));
        driver.switchTo().window(driver.getWindowHandle().toLowerCase(Locale.ROOT));
        driver.findElement(By.tagName("textarea")).sendKeys("e agora?");


    }
}

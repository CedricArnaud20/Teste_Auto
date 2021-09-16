import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

//Alert simple
public class TesteAlert {
    @Test
    public void deveInteragirComAlertSimple() {
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().setSize(new Dimension(1200, 765));
        driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");

        driver.findElement(By.id("alert")).click();
        Alert alert = driver.switchTo().alert();
        String texto = alert.getText();
        Assert.assertEquals("Alert Simples", texto);
        alert.accept();

        driver.findElement(By.id("elementosForm:nome")).sendKeys(texto);
    }
    //Alert com confirm
    @Test
    public void deveInteragirComAlertConfirm() {
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().setSize(new Dimension(1200, 765));
        driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");

        driver.findElement(By.id("confirm")).click();
        Alert alert = driver.switchTo().alert();
        String texto = alert.getText();
        Assert.assertEquals("Confirm Simples",alert.getText());
        alert.accept();

    }
    // interagir com prompt
    @Test
    public void deveInteragirComPrompt() {
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().setSize(new Dimension(1200, 765));
        driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");

        driver.findElement(By.id("prompt")).click();
        Alert alerta = driver.switchTo().alert();
        Assert.assertEquals("Digite um numero", alerta.getText());
        alerta.sendKeys("12");
        alerta.accept();
        Assert.assertEquals("Era 12?", alerta.getText());
        alerta.accept();
        Assert.assertEquals(":D", alerta.getText());
        alerta.accept();

        driver.quit();

    }
}
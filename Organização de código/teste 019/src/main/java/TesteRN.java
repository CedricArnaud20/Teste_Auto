import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class TesteRN {

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
    public void deveInteragirComAlertSimple() {

        driver.findElement(By.id("elementosForm:nome")).sendKeys("Cedric Arnaud");
        driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Sagang Pfembi");
        driver.findElement(By.name("elementosForm:sexo")).click();
        driver.findElement(By.id("elementosForm:comidaFavorita:0")).click();
        new Select(driver.findElement(By.id("elementosForm:escolaridade"))).selectByVisibleText("Superior");
        new Select(driver.findElement(By.id("elementosForm:esportes"))).selectByVisibleText("Futebol");
        driver.findElement(By.id("elementosForm:sugestoes")).sendKeys("Pimeiro preenchimento de formulário");
        driver.findElement(By.id("elementosForm:cadastrar")).click();

        Assert.assertTrue( driver.findElement(By.id("resultado")).getText().startsWith("Cadastrado"));
        Assert.assertTrue( driver.findElement(By.id("descNome")).getText().endsWith("Cedric Arnaud"));
        Assert.assertTrue( driver.findElement(By.id("descSobreNome")).getText().endsWith("Sagang Pfembi"));
        Assert.assertEquals("Sexo: Masculino", driver.findElement(By.id("descSexo")).getText());
        Assert.assertEquals("Comida: Carne", driver.findElement(By.id("descComida")).getText());
        Assert.assertEquals("Escolaridade: superior", driver.findElement(By.id("descEscolaridade")).getText());
        Assert.assertEquals("Esportes: Futebol", driver.findElement(By.id("descEsportes")).getText());
        Assert.assertEquals("Sugestoes: Pimeiro preenchimento de formulário",
                driver.findElement(By.id("descSugestoes")).getText());

    }

    @Test
    public void deveValidarNomeObrigatorio() {
        driver.findElement(By.id("elementosForm:cadastrar")).click();
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals("Nome eh obrigatorio", alert.getText());

    }
    @Test
    public void deveValidarSobreeObrigatorio() {

        driver.findElement(By.id("elementosForm:nome")).sendKeys("Cedric Arnaud");
        driver.findElement(By.id("elementosForm:cadastrar")).click();
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals("Sobrenome eh obrigatorio", alert.getText());

    }


    @Test
    public void deveValidarSexoObrigatorio() {

        driver.findElement(By.id("elementosForm:nome")).sendKeys("Cedric Arnaud");
        driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Sagang Pfembi");
        driver.findElement(By.id("elementosForm:cadastrar")).click();
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals("Sexo eh obrigatorio", alert.getText());

        driver.quit();
    }

    @Test
    public void deveValidarComidaVegetariana() {

        driver.findElement(By.id("elementosForm:nome")).sendKeys("Cedric Arnaud");
        driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Sagang Pfembi");
        driver.findElement(By.name("elementosForm:sexo")).click();
        driver.findElement(By.id("elementosForm:comidaFavorita:0")).click();
        driver.findElement(By.id("elementosForm:comidaFavorita:3")).click();
        driver.findElement(By.id("elementosForm:cadastrar")).click();
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals("Tem certeza que voce eh vegetariano?", alert.getText());

    }

    @Test
    public void deveValidarEsporteListaIndeciso() {

        driver.findElement(By.id("elementosForm:nome")).sendKeys("Cedric Arnaud");
        driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Sagang Pfembi");
        driver.findElement(By.name("elementosForm:sexo")).click();
        driver.findElement(By.id("elementosForm:comidaFavorita:0")).click();
        Select combo = new Select(driver.findElement(By.id("elementosForm:esportes")));
        combo.selectByVisibleText("Karate");
        combo.selectByVisibleText("O que eh esporte?");
        driver.findElement(By.id("elementosForm:cadastrar")).click();
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals("Voce faz esporte ou nao?", alert.getText());

    }

}

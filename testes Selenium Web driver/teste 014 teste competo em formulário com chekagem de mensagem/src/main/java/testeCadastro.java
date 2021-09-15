
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;


public class testeCadastro {
        @Test
        public void deveInteragirComAlertSimple() {
            WebDriver driver = new FirefoxDriver();
            driver.manage().window().setSize(new Dimension(1200, 765));
            driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");

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
            driver.quit();

        }
}

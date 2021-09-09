
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class TesteCampoTreinamento {

    @Test
    public void testeTestField(){
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().setSize(new Dimension(1200, 765));
        driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
        driver.findElement(By.id("elementosForm:nome")).sendKeys("Cedric");
        Assert.assertEquals("Cedric", driver.findElement(By.id("elementosForm:nome")).getAttribute("value"));




    	driver.quit();
    }

    @Test

    public void deveInteragirComTextArea(){
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().setSize(new Dimension(1200, 765));
        driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
        driver.findElement(By.id("elementosForm:sugestoes")).sendKeys("Teste");
        Assert.assertEquals("Teste", driver.findElement(By.id("elementosForm:sugestoes")).getAttribute("value"));


//        driver.quit();

    }

    @Test

    public void deveInteragirComCombo() {
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().setSize(new Dimension(1200, 765));
        driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
        WebElement element = driver.findElement(By.id("elementosForm:escolaridade"));
        Select combo = new Select(element);
 //       combo.selectByIndex(2);
 //         combo.selectByValue("especializacao");
        combo.selectByVisibleText("Mestrado");

        Assert.assertEquals("Mestrado", combo.getFirstSelectedOption().getText());

        driver.quit();
    }

    @Test

    public void deveInteragirValoresComCombo() {
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().setSize(new Dimension(1200, 765));
        driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
        WebElement element = driver.findElement(By.id("elementosForm:escolaridade"));
        Select combo = new Select(element);
        List<WebElement> options = combo.getOptions();
        Assert.assertEquals(8, options.size());

        boolean  encontrou = false;
        for (WebElement option: options){
            if(option.getText().equals("Mestrado")){
                encontrou = true;
                break;
            }
        }
        Assert.assertTrue(encontrou);

    }

    @Test

    public void deveInteragirValoresComComboMultiplo() {
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().setSize(new Dimension(1200, 765));
        driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
        WebElement element = driver.findElement(By.id("elementosForm:esportes"));
        Select combo = new Select(element);
        combo.selectByVisibleText("Natacao");
        combo.selectByVisibleText("Corrida");
        combo.selectByVisibleText("O que eh esporte?");

        List<WebElement> allSelectedOptions = combo.getAllSelectedOptions();
        Assert.assertEquals(3,allSelectedOptions.size());

        combo.deselectByVisibleText("corrida");
        allSelectedOptions = combo.getAllSelectedOptions();
        Assert.assertEquals(2,allSelectedOptions.size());

        driver.quit();
    }

    @Test

    public void deveInteragirValoresComBotao() {
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().setSize(new Dimension(1200, 765));
        driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
        WebElement botao =  driver.findElement(By.id("buttonSimple"));
        botao.click();
        Assert.assertEquals("Obrigado!", botao.getAttribute("value"));
        driver.quit();

    }
}

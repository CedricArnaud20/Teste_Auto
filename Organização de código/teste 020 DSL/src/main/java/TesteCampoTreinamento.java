
import com.sun.jna.platform.win32.WinNT;
import org.apache.http.impl.conn.SystemDefaultRoutePlanner;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;


public class TesteCampoTreinamento {

    // criação de metodos para agilisar e reduzir os códigos de teste.
    private WebDriver driver;
    private  DSL dsl;

    @Before
    public void inicializa() {
        driver = new FirefoxDriver();
        driver.manage().window().setSize(new Dimension(1200, 765));
        driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
        dsl = new DSL(driver);
    }


    @After
    public  void ficnalizar(){
        driver.quit();
    }

    // inicialização da suite de testes.

    @Test
    public void testeTestField(){
        dsl.escreve("elementosForm:nome","Cedric" );
        Assert.assertEquals("Cedric", dsl.obterValorCampo("elementosForm:nome"));
    }

    @Test

    public void deveInteragirComTextArea(){
        dsl.escreve("elementosForm:sugestoes", "Teste");
        Assert.assertEquals("Teste", dsl.obterValorCampo("elementosForm:sugestoes"));
    }



    @Test
    public void deveInteragirComCombo() {
        WebElement element = driver.findElement(By.id("elementosForm:escolaridade"));
        Select combo = new Select(element);
 //       combo.selectByIndex(2);
 //         combo.selectByValue("especializacao");
        combo.selectByVisibleText("Mestrado");

        Assert.assertEquals("Mestrado", combo.getFirstSelectedOption().getText());

    }

    @Test

    public void deveInteragirValoresComCombo() {

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

        WebElement element = driver.findElement(By.id("elementosForm:esportes"));
        Select combo = new Select(element);
        combo.selectByVisibleText("Natacao");
        combo.selectByVisibleText("Corrida");
        combo.selectByVisibleText("O que eh esporte?");

        List<WebElement> allSelectedOptions = combo.getAllSelectedOptions();
        Assert.assertEquals(3,allSelectedOptions.size());

        combo.deselectByVisibleText("C orrida");
        allSelectedOptions = combo.getAllSelectedOptions();
        Assert.assertEquals(2,allSelectedOptions.size());

    }

    @Test

    public void deveInteragirValoresComBotao() {

        WebElement botao =  driver.findElement(By.id("buttonSimple"));
        botao.click();
        Assert.assertEquals("Obrigado!", botao.getAttribute("value"));

    }

// Interargir com link  verificar se o link é clicável e o texto que é apresentado depois o click está correto
    @Test
    public void deveInteragirValoresComLink() {

        driver.findElement(By.linkText("Voltar")).click();
        Assert.assertEquals("Voltou!",driver.findElement(By.id("resultado")).getText());

    }


// Div e SPAN identificar textos
    @Test
    public void deveBuscarTextosNaPagina() {


  //     Assert.assertTrue(driver.findElement(By.tagName("body"))
  //              .getText().contains("Campo de Treinamento"));

        Assert.assertEquals("Campo de Treinamento",
                driver.findElement(By.tagName("h3")).getText());

        Assert.assertEquals("Cuidado onde clica, muitas armadilhas...",
                driver.findElement(By.className("facilAchar")).getText());

    }
}
// fim escopo de Elementos básicos
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class CampodeTreinamentoPage {

    private DSL dsl;

    public CampodeTreinamentoPage(WebDriver driver){
        dsl = new DSL(driver);
    }


//
    public void setNome(String nome){
         dsl.escrever("elementosForm:nome", nome);
    }

    public void  setSobrenome(String Sobrenome){
         dsl.escrever("elementosForm:sobrenome", Sobrenome);
    }

    public  void setSexoFeminino(){
        dsl.clicarRadio("elementosForm:sexo:1");
    }
    public  void setSexoMasculino(){
        dsl.clicarRadio("elementosForm:sexo:0");
    }

    public void setComidaPizza(){
        dsl.clicarRadio("elementosForm:comidaFavorita:2");
    }
    public void setComidaCarne(){
        dsl.clicarRadio("elementosForm:comidaFavorita:0");
    }
    public void setComidaVegetariano(){
        dsl.clicarRadio("elementosForm:comidaFavorita:3");
    }

    public  void setEscolaridade(String valor){
        dsl.selecionarCombo("elementosForm:escolaridade", valor);
    }

    public  void setEsportes (String... valores){
        for (String valor : valores)
        dsl.selecionarCombo("elementosForm:esportes", valor);
    }

    public  void setClicarBotaoCadastrar(){
        dsl.clicarBotao("elementosForm:cadastrar");
    }

//
    public String obterResultadoCdastro(){
        return  dsl.obterTexto("resultado");
    }

    public String obterNomeCadastro(){
        return dsl.obterTexto("descNome");
    }

    public  String obterSobreNomeCadastro(){
        return dsl.obterTexto("descSobrenome");
    }

    public  String obterSexoCadastro(){
        return dsl.obterTexto("descSexo");
    }

    public  String  obterComidaCadastro(){
       return dsl.obterTexto("descComida") ;
    }

    public  String obterEscolaridadeCadastro(){
       return dsl.obterTexto("descEscolaridade");
    }

    public  String obterEsporteCadastro(){
        return dsl.obterTexto("descEsportes");
    }



}

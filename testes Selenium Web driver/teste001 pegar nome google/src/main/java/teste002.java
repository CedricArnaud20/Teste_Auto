import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class teste002 {
   public static void main(String[] args) {
   //   System.setProperty("WebDriver.gecko.driver","caminho onde está o driver");
      WebDriver driver = new FirefoxDriver();
      driver.get("https://www.google.com");
      System.out.println(driver.getTitle());
   }
}

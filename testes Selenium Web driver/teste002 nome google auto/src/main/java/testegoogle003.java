import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class testegoogle003 {

   @Test
   public void teste() {
       WebDriver driver =new FirefoxDriver();
       driver.get("https://www.google.com");
       System.out.println(driver.getTitle());
       Assert.assertEquals("Google", driver.getTitle());

    }
}
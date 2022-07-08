package runers;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = "pretty",
        monochrome = true,
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        features = "src/test/java/resources/inserir_conta.feature",
        glue = "steps",
        tags = "@ignore",
        dryRun = false)
public class Runner {

    @BeforeClass
    public static void reset(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://seubarriga.wcaquino.me/login");
        driver.findElement(By.id("email")).sendKeys("leticia@south.com.br");
        driver.findElement(By.id("senha")).sendKeys("leticia");
        driver.findElement(By.tagName("button")).click();
        driver.findElement(By.linkText("reset")).click();
        driver.quit();
    }
}
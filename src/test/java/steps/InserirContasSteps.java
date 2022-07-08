package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.File;
import java.io.IOException;


public class InserirContasSteps {

    private WebDriver driver;



        @Dado("que estou acessando a aplicação")
        public void que_estou_acessando_a_aplicação() {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.get("https://seubarriga.wcaquino.me/login");
        }

        @Quando("informo o usuário {string}")
        public void informo_o_usuário(String string) {
            driver.findElement(By.id("email")).sendKeys(string);
        }

        @Quando("a senha {string}")
        public void a_senha(String string) {
            driver.findElement(By.id("senha")).sendKeys(string);
        }

        @Quando("seleciono entrar")
        public void seleciono_entrar() {
            driver.findElement(By.tagName("button")).click();
        }

        @Então("visualizo a página inicial")
        public void visualizo_a_página_inicial() {
            String texto = driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText();
            Assert.assertEquals("Bem vindo, Leticia!", texto);

        }

        @Quando("seleciono Contas")
        public void seleciono_contas() {

            driver.findElement(By.linkText("Contas")).click();
        }

        @Quando("seleciono Adicionar")
        public void seleciono_adicionar() {
            driver.findElement(By.linkText("Adicionar")).click();

        }
        @Quando("informo a conta {string}")
        public void informo_a_conta(String arg1) {
            driver.findElement(By.id("nome")).sendKeys(arg1);

        }

        @Quando("seleciono Salvar")
        public void seleciono_salvar() {

            driver.findElement(By.tagName("button")).click();
        }

        @Então("a conta é inserida com sucesso")
        public void a_conta_é_inserida_com_sucesso() {
            String texto = driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText();
            Assert.assertEquals("Conta adicionada com sucesso!", texto);

        }

        @Então("sou notificado que o nome da conta é obrigatório")
        public void sou_notificado_que_o_nome_da_conta_é_obrigatório() {
            String texto = driver.findElement(By.xpath("//div[@class='alert alert-danger']")).getText();
            Assert.assertEquals("Informe o nome da conta", texto);

        }

    @Então("sou notificado que já existe uma conta com esse nome")
    public void sou_notificado_que_já_existe_uma_conta_com_esse_nome() {
        String texto = driver.findElement(By.xpath("//div[@class='alert alert-danger']")).getText();
        Assert.assertEquals("Já existe uma conta com esse nome!", texto);
    }

    @Então("recebo a mensagem {string}")
   public void recebo_a_mensagem(String arg1) {
     String texto = driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText();
     Assert.assertEquals(arg1, texto);
       }

    @Então("recebo mensagem {string}")
   public void recebo_mensagem(String arg1) {
     String texto = driver.findElement(By.xpath("//div[@class='alert alert-danger']")).getText();
     Assert.assertEquals(arg1, texto);
       }


       @Before
    public void inicia(){
            System.out.println("Começando aqui");
       }

       @After(order = 1)
       public void screenshot(Scenario cenario){
          File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
           try {
               FileUtils.copyFile(file, new File("target/screenshot/"+cenario.getId()+".jpg"));
           } catch (IOException e) {
               e.printStackTrace();
           }
       }
       @After(order = 0)
    public void fecharBrowser(){
            driver.quit();
            System.out.println();
       }


    }


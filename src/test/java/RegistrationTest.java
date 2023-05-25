 import static org.testng.Assert.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class RegistrationTest {

    private static final String URL = "http://localhost:8083/registration";
    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        // Configura la ubicación del driver de Chrome
        System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
        // Inicializa el driver de Chrome
        driver = new ChromeDriver();
        // Navega a la página de registro
        driver.get(URL);
    }

    @AfterClass
    public void tearDown() throws InterruptedException {
        // Espera 5 segundos antes de cerrar la sesión del driver
        Thread.sleep(5000);
        // Cierra la sesión del driver
        driver.quit();
    }

    @Test
    public void testRegistration() {
        // Introduce los datos en el formulario de registro
        driver.findElement(By.id("firstName")).sendKeys("cristobal");
        driver.findElement(By.id("lastName")).sendKeys("canas");
        driver.findElement(By.id("email")).sendKeys("cristobal.canas@gmail.com");
        driver.findElement(By.id("password")).sendKeys("password");
        driver.findElement(By.id("my-form")).submit();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.urlContains("?success"));
        // Comprueba que se muestra un mensaje de éxito después de enviar el formulario
        String successMessage = driver.findElement(By.className("alert-info")).getText();
        assertEquals("You've successfully registered to our awesome app!", successMessage);
    }

} 

//import static org.testng.Assert.*;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Test;
//import java.util.concurrent.TimeUnit;
//
//public class RegistrationTest {
//
//    private static final String URL = "http://localhost:8083/registration";
//    private WebDriver driver;
//
//    @BeforeClass
//    public void setUp() {
//        // Configura la ubicación del driver de Chrome
//        System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
//        // Inicializa el driver de Chrome
//        driver = new ChromeDriver();
//        // Navega a la página de registro
//        driver.get(URL);
//    }
//
//
//    @Test
//    public void testRegistration() {
//        // Introduce los datos en el formulario de registro
//        driver.findElement(By.id("firstName")).sendKeys("diego");
//        driver.findElement(By.id("lastName")).sendKeys("pino");
//        driver.findElement(By.id("email")).sendKeys("dipinoar@gmail.com");
//        driver.findElement(By.id("password")).sendKeys("pass");
//        driver.findElement(By.id("my-form")).submit();
//
//        WebDriverWait wait = new WebDriverWait(driver, 10);
//        wait.until(ExpectedConditions.urlContains("?success"));
//        // Comprueba que se muestra un mensaje de éxito después de enviar el formulario
//        String successMessage = driver.findElement(By.className("alert-info")).getText();
//        assertEquals("You've successfully registered to our awesome app!", successMessage);
//
//        // Dirigirse a la página de inicio de sesión
//        driver.get("http://localhost:8083/login");
//
//        // Introduce el usuario y la contraseña
//        driver.findElement(By.id("username")).sendKeys("dipinoar@gmail.com");
//        driver.findElement(By.id("password")).sendKeys("pass");
//
//        // Hacer clic en el botón de inicio de sesión
//        driver.findElement(By.id("login-submit")).click();
//
//          // Esperar a que aparezca la alerta o se redirija a la página de inicio
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//
//        String currentUrl = driver.getCurrentUrl();
//        
//
//             if (currentUrl.contains("/")) {
//            // El usuario está registrado y se ha redirigido a la página de inicio
//            assertEquals("http://localhost:8083/", currentUrl);
//        } else {
//            fail("Unexpected URL: " + currentUrl);
//        }
//    }
//
//    @AfterClass
//    public void tearDown() {
//        // Cerrar el navegador
//        driver.quit();
//    }
//
//}
//  
//      
//
//       
//
//   

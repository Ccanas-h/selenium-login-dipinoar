import static org.testng.Assert.*;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTest {

    private WebDriver driver;

    @BeforeClass
    public void setup() {
        // Configurar el driver de Chrome
        System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void testLogin() {
        // Abrir la página de inicio de sesión
        driver.get("http://localhost:8083/login");

        // Introducir el usuario y la contraseña
        driver.findElement(By.id("username")).sendKeys("cristobal.canas@gmail.com");
        driver.findElement(By.id("password")).sendKeys("password");

        // Hacer clic en el botón de inicio de sesión
        driver.findElement(By.id("login-submit")).click();

        // Esperar a que aparezca la alerta o se redirija a la página de inicio
        WebDriverWait wait = new WebDriverWait(driver, 10);

        // Obtener la URL actual
        String currentUrl = driver.getCurrentUrl();

        // Verificar si contiene "/login?error"
        if (currentUrl.contains("/login?error")) {
            // El usuario no está registrado y se espera obtener la alerta de error
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            String failMessage = driver.findElement(By.cssSelector(".alert-danger")).getText();
            assertEquals("Invalid username or password.", failMessage);
        } else if (currentUrl.contains("/")) {
            // El usuario está registrado y se ha redirigido a la página de inicio
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            assertEquals("http://localhost:8083/", currentUrl);
        } else {
            fail("Unexpected URL: " + currentUrl);
        }
    }

    @AfterClass
    public void tearDown() {
        // Cerrar el navegador
        driver.quit();
    }
}

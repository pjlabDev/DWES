/**
 * 
 */
package selenium_example;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


/**
 * @author usuario
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//Si se añaden los drivers a las variables de entorno no hace falta escribir esta linea, si no, es importantisima
		System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
		
		//Creamos la instancia WebDriver utilizando el navegador FireFox
		WebDriver driver = new FirefoxDriver();
		
		//ImplicitWait
		//Para que espere 10 segundos, por si hubiese algún boton o algo en la página que no aparece nada mas cargarla
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		try {
			
			driver.get("http://www.blazedemo.com");
//			driver.navigate().to("https://www.wikipedia.es");
			
			//Para firefox, para chrome se le quita lo del file://, aunque tampoco daría error si se deja
//			driver.get("file://C:/PROYECTOS/web_test/index_completo.html");
			
//			driver.findElement(By.id("n-randompage")).click();
//			driver.findElement(By.linkText("Página aleatoria")).click();

//			WebElement titleElement = driver.findElement(By.tagName("title"));
//			String titulo = titleElement.getAttribute("innerText");

//			WebElement leerButton = driver.findElement(By.xpath("//*[@id=\"main-tfa\"]//*[text() = ' Leer ']"));
//			leerButton.click();
			
//			WebElement contenidoP = driver.findElement(By.cssSelector("div#main-tfa>p:nth-of-type(2)"));
//			System.out.println(contenidoP.getText());
			
			
			//FluentWait
			//Lo mismo que el implicitwait pero mejorado
//			Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
//					.withTimeout(Duration.ofSeconds(10))
//					.pollingEvery(Duration.ofSeconds(2))
//					.ignoring(NoSuchElementException.class);
//			
//			WebElement buttonImplicitWait = wait.until(new Function<WebDriver, WebElement>(){
//				public WebElement apply(WebDriver driver) {
//					return driver.findElement(By.id("boton"));
//				}
//			});
//			
//			buttonImplicitWait.click();
			
			
			//ExplicitWait
			//Lo mismo que los dos anteriores pero con este es posible poner una condicion (Por ejemplo un boton que sea clicable
			//tras haber pasado 10 segundos de la carga de la pagina)
			
			//Creamos la instancia WebDriverWait a la que llamamos para esperar a que el elemento cumpla la condicion que establecemos
//			WebDriverWait wait = new WebDriverWait(driver,10);
			
			//El 5000 hace que hasta que no pasen los 5 segundos no hace la accion que le digamos mas abajo, en este caso, pulsar el boton
//			WebDriverWait wait = new WebDriverWait(driver,10,5000);
			
			
			//Llamamos a la instancia wait y especificamos que esperamos (que al menos en 10 segundos) el elemento este disponible
			//para hacer clic
//			WebElement boton = wait.until(ExpectedConditions.elementToBeClickable(By.id("boton")));
//			boton.click();
			
			//Esto es para escribir dentro de un input
//			WebElement searchbox = driver.findElement(By.id("searchInput"));
//			WebElement searchButton = driver.findElement(By.id("searchButton"));
			
//			Thread.sleep(2000);
//			searchbox.sendKeys("Selenium");
//			Thread.sleep(2000);
//			searchButton.click();
			
			//Esto es para seleccionar una opcion dentro de un dropdown o combobox
//			Select combobox = new Select(driver.findElement(By.name("fromPort")));
//			Thread.sleep(2000);
//			combobox.selectByVisibleText("San Diego");
			
			
			//Para los checkbox hay que crear una lista de elementos para poder trabjar con los checkbox (IMPORTANTE la s de finElementS)
//			List<WebElement> listaCheckBox = driver.findElements(By.name("checkbox"));
//			for (WebElement elemento : listaCheckBox) {
//				//Esto hara clic en todos los checkbox
//				elemento.click();
//				Thread.sleep(1000);
//			}
			//Para deseleccionar volvemos a hacer clic
//			listaCheckBox.get(0).click();
			
			//Esto es para los alerts que puedan saltar en nuestra aplicación
//			WebElement alertbutton = driver.findElement(By.id("alertButton"));
//			alertbutton.click();
//			
//			Thread.sleep(2000);
//			
//			WebDriverWait wait = new WebDriverWait(driver,10);
//			
//			Alert alert = wait.until(ExpectedConditions.alertIsPresent());
			//Tambien se puede utilizar esta otra opcion
//			Alert alert2 = driver.switchTo().alert();
			//si el alert tiene un input que tuviera que escribir en el alert, se usa alert.sendKeys();
			//si el alert no tiene un input y se manda el sendKeys, da error.
			//para darle a cancelar, en vez de usar alert.accept(), se utiliza alert.dismiss()
//			alert.accept();
			
			
			
			Thread.sleep(5000);
			
			String title = driver.getTitle();
			System.out.println(title);
		
		} catch (Exception e) {
		
			e.printStackTrace();
		
		} finally {

			driver.quit();
		}
	}

}

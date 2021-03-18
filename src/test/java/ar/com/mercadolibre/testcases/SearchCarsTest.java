package ar.com.mercadolibre.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;

public class SearchCarsTest extends TestBase {
	/*
	 * 1. Navegar a la pagina de mercado libre
	 * 2. Buscar "autos"
	 * 3. Obtener nombres de articulos y sus links
	 * 4. Guardar los datos obtenidos en un archivo de texto
	 * 
	 */
	
	@BeforeMethod
	public void setUp() {

	}
	
	@Test(priority=1)
	public void loginPageTitleTest() {

	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}

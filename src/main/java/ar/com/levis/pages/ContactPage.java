package ar.com.levis.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class ContactPage extends TestBase {

	// Initializing the Page Objects:
	public ContactPage() {
		PageFactory.initElements(driver, this);
	}
	
	// Este metodo sirve para cuando la parte de un xpath cambia
	// Por ejemplo puedo usarlo para validar el numero de una orden
	// luego de realizar la compra
	// -->   //a[text()='shomething words')]
	public void SelectSomethingByName(String name) {
		driver.findElement(By.xpath("//a[text()='" + name + "')]"));
	}
}

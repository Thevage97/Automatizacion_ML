package steps;

import org.openqa.selenium.WebDriver;
import engine.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.MLPage;

public class ML {

    WebDriver driver = DriverFactory.getDriver();  // <- el método que inicializa correctamente tu driver
    MLPage mlp = new MLPage(driver);

    @Given("Abrir la pagina web www.mercadolibre.com.mx")
    public void abrir_la_pagina_web_www_mercadolibre_com_mx() {
        mlp.abrir_la_pagina_web_www_mercadolibre_com_mx();
    }

    @When("Cerrar todas las ventanas y popoops")
    public void cerrar_todas_las_ventanas_y_popoops() {
        mlp.cerrar_todas_las_ventanas_y_popoops();
    }

    @Then("Buscar en la barra de busqueda playstation")
    public void buscar_en_la_barra_de_busqueda_playstation() {
        mlp.buscar_en_la_barra_de_busqueda_playstation();
    }

    @Then("Filtrar producto por condicion nuevo")
    public void filtrar_producto_por_condicion_nuevo() {
        mlp.filtrar_producto_por_condicion_nuevo();
    }

    @Then("Filtrar producto por localizacion CDMX")
    public void filtrar_producto_por_localizacion_cdmx() {
        mlp.filtrar_producto_por_localizacion_cdmx();
    }

    @Then("Filtrar producto por menor precio")
    public void filtrar_producto_por_menor_precio() {
        mlp.filtrar_producto_por_menor_precio();
    }

    @Then("Obtener los nombres y precios de los cinco primeros productos")
    public void obtener_nombres_y_precios_de_los_cinco_primeros_productos() {
        mlp.obtener_nombres_y_precios_de_los_cinco_primeros_productos();
    }
}
package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import pages.elements.EML;
import org.openqa.selenium.support.PageFactory;

public class MLPage extends GlobalPage{

    EML eml = new EML();

    public MLPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void abrir_la_pagina_web_www_mercadolibre_com_mx(){
        takeScreenshot("Paso_1.jpg");
        openURL("https://www.mercadolibre.com");
        globalSleep(2000);
        imprimirConsolaInfo("La pagina abrio correctamente");
        click(eml.optMexico);
    }

    public void cerrar_todas_las_ventanas_y_popoops(){
        takeScreenshot("Paso_2.jpg");

        try {
            globalSleep(3000);
            click(eml.popoopMasTarde);
        } catch (Exception e) {
            imprimirConsolaInfo("Popoop NO visible");
        }
    }

    public void buscar_en_la_barra_de_busqueda_playstation(){
        takeScreenshot("Paso_3.jpg");
        click(eml.buscadorHome);
        write(eml.buscadorHome, "playstation 5");
        globalSleep(2000);
        click(eml.btnBuscarHome);
        globalSleep(2000);
    }

    public void filtrar_producto_por_condicion_nuevo(){
        takeScreenshot("Paso_4.jpg");
        scrollToElement(eml.filtroNuevo);
        globalSleep(2000);
        click(eml.filtroNuevo);
        globalSleep(2000);
    }

    public void filtrar_producto_por_localizacion_cdmx(){
        takeScreenshot("Paso_5.jpg");
        scrollToElement(eml.filtroCDMX);
        globalSleep(2000);
        click(eml.filtroCDMX);
        globalSleep(5000);
    }

    public void filtrar_producto_por_menor_precio(){
        takeScreenshot("Paso_6.jpg");
        click(eml.btnOrdernarPor);
        globalSleep(2000);
        click(eml.optOrdernarPorMenorPrecio);
        globalSleep(2000);
    }
    
    public void obtener_nombres_y_precios_de_los_cinco_primeros_productos() {
        takeScreenshot("Paso_7.jpg");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        List<WebElement> nombres = new ArrayList<>();
        List<WebElement> precios = new ArrayList<>();

        int intentos = 0;

        while ((nombres.size() < 5 || precios.size() < 5) && intentos < 20) {
            nombres = driver.findElements(By.className("poly-component__title"));
            precios = driver.findElements(By.className("andes-money-amount__fraction"));

            if (nombres.size() >= 5 && precios.size() >= 5) break;

            js.executeScript("window.scrollBy(0, 300);");
            globalSleep(1000);
            intentos++;
        }

        int total = Math.min(5, Math.min(nombres.size(), precios.size()));
        for (int i = 0; i < total; i++) {
            imprimirConsolaInfo("Producto #" + (i + 1) + ": " +
                    nombres.get(i).getText() + " - Precio: $" + precios.get(i).getText());
        }

        if (total < 5) {
            imprimirConsolaError("Solo se pudieron obtener " + total + " productos tras hacer scroll.");
        }
    }
}

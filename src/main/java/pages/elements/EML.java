package pages.elements;

import org.openqa.selenium.By;

public class EML {
    public String optMexico = "//*[@id=\"MX\"]";
    public String popoopMasTarde = "/html/body/div[5]/div/div/div[2]/div/div/div[2]/button[2]";
    public String buscadorHome = "//*[@id=\"cb1-edit\"]";
    public String btnBuscarHome = "/html/body/header/div/div[2]/form/button";
    public String filtroNuevo = "//*[@id=\"root-app\"]/div/div[2]/aside/section[2]/div[5]/ul/li[1]/a";
    public String filtroCDMX = "//*[@id=\"root-app\"]/div/div[2]/aside/section[2]/div[10]/ul/li[1]/a";
    public String btnOrdernarPor = "//*[@id=\"root-app\"]/div/div[2]/section/div[2]/div[2]/div/div/div[2]";
    public String optOrdernarPorMenorPrecio = "//*[@id=\":R1b56ie:-menu-list-option-price_asc\"]";
    public By listaNombresProductos = By.xpath("/html/body/main/div/div[2]/section/div[5]/ol/li[1]/div/div/div/div[2]/h3");
    public By listaPreciosProductos = By.xpath("/html/body/main/div/div[2]/section/div[5]/ol/li[1]/div/div/div/div[2]/div/div[1]/div[1]/div/span[1]");
}

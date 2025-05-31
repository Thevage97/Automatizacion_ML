package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.commons.io.FileUtils;
import java.io.File;

public class GlobalPage {

    public WebDriver driver;
    public WebDriverWait wait;
    private static final Logger logger = LogManager.getLogger(GlobalPage.class);

    public GlobalPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15)); 
    }

    public void globalSleep(int Time) {
        try {
            Thread.sleep(Time);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public void imprimirConsolaDebug(String mensaje) {
        logger.debug(mensaje);
    }

    public void imprimirConsolaInfo(String mensaje) {
        logger.info(mensaje);
    }

    public void imprimirConsolaError(String mensaje) {
        logger.error(mensaje);
    }

    public void openURL(String url) {
        try {
            driver.get(url);
            System.out.println("Navegando a: " + url);
        } catch (WebDriverException e) {
            logger.error("Error al navegar a la URL: " + url, e);
        }
    }

    public void click(String xpath) {
    if (driver == null) {
        throw new IllegalStateException("El WebDriver no está inicializado.");
    }
    if (xpath == null || xpath.isEmpty()) {
        throw new IllegalArgumentException("El xpath no puede ser nulo ni vacío.");
    }

    try {
        By locator = By.xpath(xpath);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        element.click();
        imprimirConsolaInfo("Click exitoso en el elemento: " + xpath);
    } catch (TimeoutException e) {
        imprimirConsolaError("No se pudo hacer clic: el elemento no fue clickable a tiempo. XPath: " + xpath);
        throw e;
    } catch (Exception e) {
        imprimirConsolaError("Error inesperado al hacer clic en el elemento: " + xpath);
        throw e;
    }
}

    public void write(String xpath, String text) {
        if (driver == null) {
            throw new IllegalStateException("El WebDriver no está inicializado.");
        }
        if (xpath == null || xpath.isEmpty()) {
            throw new IllegalArgumentException("El xpath no puede ser nulo ni vacío.");
        }

        try {
            By locator = By.xpath(xpath);
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            element.clear();
            element.sendKeys(text);
            imprimirConsolaInfo("Escribiendo '" + text + "' en el elemento: " + xpath);
        } catch (TimeoutException e) {
            imprimirConsolaError("No se pudo escribir: el elemento no fue visible a tiempo. XPath: " + xpath);
            throw e;
        } catch (Exception e) {
            imprimirConsolaError("Error inesperado al escribir en el elemento: " + xpath);
            throw e;
        }
    }

    public void scrollToElement(String xpath) {
        By locator = By.xpath(xpath);
        int maxScrolls = 10;
        int scrollAmount = 200; // píxeles por scroll

        for (int i = 0; i < maxScrolls; i++) {
            try {
                WebElement element = driver.findElement(locator);
                if (element.isDisplayed()) {
                    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", element);
                    System.out.println("Elemento visible y scroll realizado hasta: " + xpath);
                    return;
                }
            } catch (Exception e) {

            }

            ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, arguments[0]);", scrollAmount);
            globalSleep(1000); // Espera para que el scroll se vea suave
        }

        System.out.println("No se encontró el elemento tras hacer scroll: " + xpath);
    }

    public void takeScreenshot(String fileName) {
        try {
            // Crear carpeta si no existe
            File directory = new File("ScreenShot");
            if (!directory.exists()) {
                directory.mkdirs();
            }

            String fullPath = "ScreenShot/" + fileName;
            TakesScreenshot screenshot = (TakesScreenshot) driver;
            byte[] screenshotBytes = screenshot.getScreenshotAs(OutputType.BYTES);
            FileUtils.writeByteArrayToFile(new File(fullPath), screenshotBytes);
            System.out.println("Captura de pantalla guardada como: " + fullPath);
        } catch (Exception e) {
            System.err.println("Error al tomar la captura de pantalla: " + e.getMessage());
        }
    }


    public void closeBrowser() {
        driver.quit();
        System.out.println("Navegador cerrado.");
    }
}
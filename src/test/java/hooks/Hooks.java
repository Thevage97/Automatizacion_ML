package hooks;

import engine.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import utils.ExtentReportManager;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

import java.io.File;
import java.io.IOException;

public class Hooks {

    private WebDriver driver;
    private ExtentTest scenarioNode;

    @Before
    public void setUp(Scenario scenario) {
        driver = DriverFactory.getDriver();

        ExtentTest feature = ExtentReportManager.getFeature();
        if (feature == null) {
            ExtentReportManager.createFeature("Escenarios de prueba");
        }
        scenarioNode = ExtentReportManager.getFeature().createNode(scenario.getName());
    }

    @After
    public void tearDown(Scenario scenario) {
        try {
            TakesScreenshot ts = (TakesScreenshot) driver;
            File src = ts.getScreenshotAs(OutputType.FILE);
            String screenshotPath = ExtentReportManager.getReportPath() + "/" + scenario.getName().replaceAll(" ", "_") + ".png";
            File dest = new File(screenshotPath);
            FileUtils.copyFile(src, dest);

            scenarioNode.info("Captura de pantalla:", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());

        } catch (IOException e) {
            scenarioNode.warning("No se pudo adjuntar la captura: " + e.getMessage());
        }

        if (scenario.isFailed()) {
            scenarioNode.fail("Escenario fallido: " + scenario.getName());
        } else {
            scenarioNode.pass("Escenario exitoso: " + scenario.getName());
        }

        DriverFactory.quitDriver();
        ExtentReportManager.flushReport();
    }
}

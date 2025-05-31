package utils;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ExtentReportManager {
    private static ExtentReports extent;
    private static ExtentTest feature;

    private static String reportPath;

    public static ExtentReports getInstance() {
        if (extent == null) {
            // Obtener fecha y hora para carpeta única
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss");
            String timestamp = LocalDateTime.now().format(formatter);
            reportPath = "TestReport/ExtentReports_" + timestamp;

            // Crear la carpeta si no existe
            new File(reportPath).mkdirs();

            ExtentSparkReporter spark = new ExtentSparkReporter(reportPath + "/ExtentReport.html");
            spark.config().setDocumentTitle("Automation Report");
            spark.config().setReportName("Resultado de pruebas");
            spark.config().setTheme(Theme.STANDARD);

            extent = new ExtentReports();
            extent.attachReporter(spark);
            extent.setSystemInfo("Tester", "QA TEST");
            extent.setSystemInfo("Framework", "Selenium + Cucumber + JUnit");
        }
        return extent;
    }

    public static ExtentTest createFeature(String featureName) {
        feature = getInstance().createTest(featureName);
        return feature;
    }

    public static ExtentTest getFeature() {
        return feature;
    }

    public static void flushReport() {
        if (extent != null) {
            extent.flush();
        }
    }

    public static String getReportPath() {
        return reportPath;
    }
}

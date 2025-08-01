package utilities.extent_report;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.cucumber.java.Scenario;
import io.cucumber.plugin.event.PickleStepTestStep;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class ExtentReport {
    public static final String extentReportPath = System.getProperty("user.dir") + "/resources/reports";
    public static final String extentReportConfigPath = System.getProperty("user.dir") + "/src/test/java/utilities/extent_report";
    public static final String delegateFileName = "delegate";
    public static final String testCaseFileName = "testCase";
    public static int testCaseNumber = 1;
    private static ExtentReports extent = new ExtentReports();
    private static ExtentTest test;
    private static int currentStepDefIndex;
    private static Scenario scenario;
    private static List<PickleStepTestStep> stepDef;
    private static boolean currentlyUsingReport = false;

    @BeforeTest
    @Parameters("ReportName")
    public void startReport(String reportName) throws IOException {
        currentlyUsingReport = true;
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(extentReportPath + reportName + ".html");
        sparkReporter.loadXMLConfig(new File(extentReportConfigPath + "extent-config.xml"));
        extent.attachReporter(sparkReporter);

        String cssContent = "";
        String jsContent = "";

        try {
            cssContent = new String(Files.readAllBytes(Paths.get(extentReportConfigPath + "extent.css")));
            jsContent = new String(Files.readAllBytes(Paths.get(extentReportConfigPath + "extent.js")));
        } catch (Exception e) {
            e.printStackTrace();
        }

        sparkReporter.config().setCss(cssContent);
        sparkReporter.config().setJs(jsContent);

        extent.setSystemInfo("User Name", System.getProperty("user.name"));
        extent.setSystemInfo("Browser", System.getProperty("BROWSERNAME"));
        extent.setSystemInfo("Environment", System.getProperty("ENVIRONMENT"));
        extent.setSystemInfo("Pipeline Executor", System.getenv("BUILD_USER"));
        extent.setSystemInfo("OS", System.getProperty("os.name"));
        extent.setSystemInfo("Java Version", System.getProperty("java.version"));

    }
    public static void setScenario(Scenario currentScenario){
        scenario = currentScenario;
    }

    public static void startTestCase(){
            String testCaseName = testCaseNumber++ + "- " + scenario.getName();
            test = extent.createTest(testCaseName);
            currentStepDefIndex = 0;
            test.assignCategory(getFeatureFileName());
    }




    public static String getFeatureFileName() {
        Path featureFilePath = Paths.get(scenario.getUri());
        String fileName = featureFilePath.getFileName().toString();
        String[] parts = fileName.split("\\.feature");
        return parts[0];
    }

}

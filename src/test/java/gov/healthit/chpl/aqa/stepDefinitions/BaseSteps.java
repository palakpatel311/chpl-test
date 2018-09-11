package gov.healthit.chpl.aqa.stepDefinitions;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/** Base class for step definition files. */
public class BaseSteps {

    private WebDriver driver;
    private WebDriverWait shortWait;
    private WebDriverWait longWait;
    private String url = System.getProperty("url");
    private String filePath = System.getProperty("filePath");
    private String screenshotPath;
    protected static final int TIMEOUT = 30;
    protected static final int LONG_TIMEOUT = 90;
    protected static final String CHARS = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    /** Default constructor. */
    public BaseSteps() {
        super();
        this.driver = Hooks.getDriver();
        this.setShortWait(new WebDriverWait(this.driver, TIMEOUT));
        this.setLongWait(new WebDriverWait(this.driver, LONG_TIMEOUT));
        if (StringUtils.isEmpty(this.url)) {
            this.setUrl("http://localhost:3000/");
        }
        if (StringUtils.isEmpty(this.filePath)) {
            String tempDirectory = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test" + File.separator + "resources";
            this.setFilePath(tempDirectory);
        }
        screenshotPath = System.getProperty("user.dir") + File.separator + "test-output";
    }

    /**
     * Take a screenshot.
     * @param hash a string that will be inserted into the filename to avoid overwriting images.
     * All "non-word characters" will be replaced with "_"
     * @throws Exception if there is an exception
     */
    public void takeScreenshot(final String hash) throws Exception {
        File scrFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
        File outFile = new File(screenshotPath + File.separator + "failed-test-" + hash.replaceAll("\\W+", "_") + ".png");
        FileUtils.copyFile(scrFile, outFile);
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(final WebDriver driver) {
        this.driver = driver;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(final String filePath) {
        this.filePath = filePath;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(final String url) {
        this.url = url;
    }

    public WebDriverWait getLongWait() {
        return longWait;
    }

    public void setLongWait(final WebDriverWait longWait) {
        this.longWait = longWait;
    }

    public WebDriverWait getShortWait() {
        return shortWait;
    }

    public void setShortWait(final WebDriverWait shortWait) {
        this.shortWait = shortWait;
    }

}

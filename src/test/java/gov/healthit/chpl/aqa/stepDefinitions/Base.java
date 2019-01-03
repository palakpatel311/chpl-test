package gov.healthit.chpl.aqa.stepDefinitions;

import java.io.File;
import java.io.FileNotFoundException;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/** Base class for step definition files. */
public class Base {
    private EventFiringWebDriver driver;
    private WebDriverWait wait;
    private String url = System.getProperty("url");
    private String filePath = System.getProperty("filePath");
    protected static final long TIMEOUT = 30;
    protected static final long LONG_TIMEOUT = 120;
    private static final int MAX_RETRYCOUNT = 8;
    private static final int SLEEP_TIME = 5000;
    protected static final String CHARS = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    /** Default constructor. */
    public Base() {
        super();
        this.driver = Hooks.getDriver();
        this.setWait(new WebDriverWait(this.driver, TIMEOUT));
        if (StringUtils.isEmpty(this.url)) {
            this.setUrl("http://localhost:3000/");
        }
        if (StringUtils.isEmpty(this.filePath)) {
            String tempDirectory = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test" + File.separator + "resources";
            this.setFilePath(tempDirectory);
        }
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(final EventFiringWebDriver driver) {
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

    public WebDriverWait getWait() {
        return wait;
    }

    public void setWait(final WebDriverWait wait) {
        this.wait = wait;
    }

    /**
     * Checks whether the specified file is downloaded or not by iterating 8 times where each iteration has a wait of 5 seconds.
     * @param fileName expected downloaded file name
     * @throws FileNotFoundException if the expected file not found
     */
    public void checkIfFileIsDownloaded(final String fileName)throws FileNotFoundException {
        String downloadFileName = null;
        boolean fileFound = false;
        final long sleepTime = SLEEP_TIME;
        int retryCount = 0;
        while (!fileFound && retryCount <= MAX_RETRYCOUNT) {
            try {
                File[] files = Hooks.getDownloadDirectory().listFiles();
                for (File file : files) {
                    downloadFileName = file.getName();
                    if (downloadFileName.startsWith(fileName)) {
                        fileFound = true;
                        break;
                    }
                    Thread.sleep(sleepTime);
                    retryCount++;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (!fileFound) {
            throw new FileNotFoundException("File: " + fileName + " not downloaded");
        }
    }
}

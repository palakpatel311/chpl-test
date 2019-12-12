package gov.healthit.chpl.aqa.stepDefinitions;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.Before;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

/** Base class for step definition files. */
public class Base {
    private EventFiringWebDriver driver;
    private WebDriverWait wait;
    private static String url = System.getProperty("url");
    private String filePath = System.getProperty("filePath");
    private static String apikey = System.getProperty("apikey");
    protected static final long TIMEOUT = 30;
    protected static final long LONG_TIMEOUT = 120;
    private static final int MAX_RETRYCOUNT = 8;
    private static final int LAST_MODIFIED_WINDOW_MILLIS = 15000;
    protected static final int SLEEP_TIME = 5000;
    protected static final int DEBOUNCE_TIME = 500;
    protected static final String CHARS = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static String username;
    private static String password;
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

    public static  String getUrl() {
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

    public static  String getApikey() {
        return apikey;
    }

    public void setApikey(final String apikey) {
        this.apikey = apikey;
    }

    /**
     * Checks whether the specified file is downloaded or not by iterating 8 times where each iteration has a wait of 5 seconds.
     * @param fileName expected downloaded file name
     * @throws FileNotFoundException if the expected file not found
     */
    public void checkIfFileIsDownloaded(final String fileName)throws FileNotFoundException {
        String downloadFileName = null;
        boolean fileFound = false;
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
                    Thread.sleep(SLEEP_TIME);
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

    /**
     * Checks if the recent downloaded file is downloaded completely.
     * file name starts with name of the file and ends with extension.
     * @param fileName is the name of file
     * @param ext expected extension of the file
     * @throws FileNotFoundException if the expected file not found
     */
    public void checkCompleteFileDownload(final String fileName, final String ext) throws FileNotFoundException {
        boolean foundFile = false;
        int retryCount = 0;
        try {
            while (!foundFile && retryCount <= MAX_RETRYCOUNT) {
                File[] files = Hooks.getDownloadDirectory().listFiles();
                for (int i = 0; i < files.length; i++) {
                    Long currentTime = System.currentTimeMillis();
                    if ((files[i].getName().startsWith(fileName) && files[i].getName().endsWith(ext)) && ((currentTime - files[i].lastModified()) < LAST_MODIFIED_WINDOW_MILLIS)) {
                        foundFile = true;
                        break;
                    }
                }
                if (!foundFile) {
                    retryCount++;
                    Thread.sleep(SLEEP_TIME);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (!foundFile) {
            throw new FileNotFoundException("File not downloaded completely");
        }
    }

    /**
     * Navigate to a specific environment.
     * @param env test environment in which tests will be run
     * @return envURL
     */
    public String getEnvUrl(final String env) {
        String envUrl;
        switch (env) {
        case "DEV": envUrl = "https://chpl.ahrqdev.org";
        break;
        case "STG": envUrl = "https://chpl.ahrqstg.org";
        break;
        case "PROD": envUrl = "https://chpl.healthit.gov";
        break;
        default: envUrl = getUrl();
        break;
        }
        return envUrl;
    }

    /**
     * Get Current Date.
     * @return date in MM/dd/yyyy format
     */
    public String getCurrentDate() {
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        Date date = new Date();
        String dateFormatted = dateFormat.format(date);
        return dateFormatted;
    }

    /**
     * Get Date with Time Zone.
     * @param date in MMMM dd,yyyy with time stamp and GMT time zone
     * @throws ParseException if unable to parse the date
     * @return date
     */
    public Date getFormatedDateTimeZone(final String date) throws ParseException {
        Date dateInstance = null;
        if (date != null) {
        DateFormat dateFormat = new SimpleDateFormat("MMMM dd,yyyy hh:mm:ss a z");
        dateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
           dateInstance = dateFormat.parse(date);
        }
        return dateInstance;
    }

    public static String getAuth(String role) {
    	switch (role) { 
        case "ROLE_ADMIN": 
            username = System.getProperty("roleAdminUsername"); 
            password= System.getProperty("roleAdminPassword");
            break; 
        case "ROLE_ACB": 
        	username = System.getProperty("roleAcbUsername"); 
            password= System.getProperty("roleAcbPassword");
            break; 
        case "ROLE_ONC": 
        	username = System.getProperty("roleOncUsername"); 
            password= System.getProperty("roleOncPassword");
            break; 
        default: 
        	username = System.getProperty("roleAdminUsername"); 
            password= System.getProperty("roleAdminPassword");
            break; 
        } 
    	RestAssured.baseURI= Base.getUrl();
		Response res= given()
				.header("API-KEY", Base.getApikey())
				.header("content-type", "application/json")
				.body("{\r\n" + 
						"  \"password\": \""+password+ "\",\r\n" + 
						"  \"userName\": \""+username+"\"\r\n" + 
						"}")
				.when()
				.post("rest/auth/authenticate")
				.then().assertThat().statusCode(200).and().contentType(ContentType.JSON)
				.extract().response();
    	JsonPath js= res.jsonPath();
		String token= js.get("token");
		String auth= "Bearer "+token;
		return auth;   					
    }
}


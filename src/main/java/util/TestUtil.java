package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.*;

import base.TestBase;

public class TestUtil extends TestBase {

    public static long PAGE_LOAD_TIMEOUT = 20;
    public static long IMPLICIT_WAIT = 10;

    static Workbook book;
    static Sheet sheet;

    // Common methods
    public String GetTitle() {
        return driver.getTitle();
    }

    public void SwitchToFrame(String index) {
        driver.switchTo().frame(index);
    }

    // Read Test Data Sheet
    public static Object[][] getTestData(String sheetName, String testDataPath) {
        FileInputStream file = null;
        try {
            file = new FileInputStream(testDataPath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            book = WorkbookFactory.create(file);
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        sheet = book.getSheet(sheetName);
        Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
        // System.out.println(sheet.getLastRowNum() + "--------" +
        // sheet.getRow(0).getLastCellNum());
        for (int i = 0; i < sheet.getLastRowNum(); i++) {
            for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
                data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
                // System.out.println(data[i][k]);
            }
        }
        return data;
    }

    // Take Screenshot
    public static void takeScreenshotAtEndOfTest() throws IOException {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String currentDir = System.getProperty("user.dir");
        FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
    }

    // Check Page Links
    public boolean checkingPageLinks() {
        // Get the list of all links and images:
        List<WebElement> linksList = new ArrayList<WebElement>();
        linksList.addAll(driver.findElements(By.tagName("a")));
        linksList.addAll(driver.findElements(By.tagName("img")));

        System.out.println("Total of links and images → " + linksList.size());

        List<WebElement> activeLinks = new ArrayList<WebElement>();
        List<String> brokenLinks = new ArrayList<String>();

        // Iterate linksList - exclude all the links/images - doesnt have any href atribute
        for (int i = 0; i < linksList.size(); i++) {
            if (linksList.get(i).getAttribute("href") != null && (!linksList.get(i).getAttribute("href").contains("javascript")) && (!linksList.get(i).getAttribute("href").contains("tel")) && (!linksList.get(i).getAttribute("href").contains("mailto"))) {
                activeLinks.add(linksList.get(i));
            }
        }

        // Get the size of active links list
        System.out.println("Total of active links and images → " + activeLinks.size());

        // Check the href url, with httpconnection api:
        for (int j = 0; j < activeLinks.size(); j++) {
            try {
                HttpURLConnection connection = (HttpURLConnection) new URL(activeLinks.get(j).getAttribute("href")).openConnection();
                connection.connect();
                String response = connection.getResponseMessage();
                // El condicional de 999 lo puse para que no falle con ese estatus pero deberia ver como arreglarlo
                // Por lo que lei deberia tratar de ver como simular que la request la hace el navegador y no una app java
                if (connection.getResponseCode() >= 400 && connection.getResponseCode() != 999) {
                    brokenLinks.add(activeLinks.get(j).getAttribute("href"));
                }
                connection.disconnect();
                System.out.println(activeLinks.get(j).getAttribute("href") + " → " + response);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if (brokenLinks.size() > 0) {
            System.out.println("\n#######ERROR BROKEN LINKS#######");
            System.out.println("Total of links and images → " + brokenLinks.size());
            for (int k = 0; k < brokenLinks.size(); k++) {
                System.out.println("This link is broken → " + brokenLinks.get(k));
            }
            return false;
        } else {
            return true;
        }
    }
}

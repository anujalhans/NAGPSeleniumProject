package com.nagp.amazon.util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.nagp.amazon.base.TestBase;

public class TestUtil extends TestBase {

	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 20;
   
	
	//Common function to select the value from any drop-down menu
	public static void selectValueFromDropDown(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByVisibleText(value);
	}
   
	//common function to capture the screenshot in case of Test Failure
	public static String captureScreeshot(String testMethodName) {
		// log.debug("Launching the capture screen shot");
		File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		/*
		 * SimpleDateFormat formatter = new
		 * SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); Date date = new Date();
		 * String fileName = formatter.format(date);
		 */
		Date date = new Date();
		String fileName = date.toString().replace(":", "-").replace(" ", "-");
		String path = System.getProperty("user.dir") + "\\FailedTestCasesScreenshots\\" + testMethodName + "_"
				+ fileName + ".png";
		File destination = new File(path);

		try {

			FileUtils.copyFile(source, destination);
		} catch (IOException e) {
			System.out.println("Error in capturing screen shot" + e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("An unknown exception occured while capturing screen shot:" + e.getMessage());
			e.printStackTrace();
		}
		return path;
	}
	
	
   //common function to move all the results from Current Test Results folder to Archive folder at the start of each execution
	public static void moveToArchiveFolder() {
		Date date = new Date();
		//String folderNamewithDate = date.toString().replace(":", "-").replace(" ", "-");
		//String currentFolderpath = System.getProperty("user.dir") + "\\Current Test Results"+folderNamewithDate+"\\";
		String currentFolderpath = System.getProperty("user.dir") + "\\Current Test Results\\";
		String archiveFolderPath = System.getProperty("user.dir") + "\\Archive Test Results\\";
		final File sourceDir = new File(currentFolderpath);
		final File destinationDir = new File(archiveFolderPath);
		for (File f : sourceDir.listFiles()) {
			Path sourcePath = Paths.get(sourceDir.getAbsolutePath() + "\\" + f.getName());
			Path destinationPath = Paths.get(destinationDir.getAbsolutePath() + "\\" + f.getName());
			try {
				Files.move(sourcePath, destinationPath, StandardCopyOption.REPLACE_EXISTING);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}

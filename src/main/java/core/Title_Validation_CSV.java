package core;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class Title_Validation_CSV {

	public static void main(String[] args) throws IOException {
		String line = null;
		String SplitBy = ",";
		String test_case_id = null;
		String url = null;
		String title_expected = null;
		String csvFile = "./src/main/resources/Test.csv";
		BufferedReader br = null;
		
		
		br = new BufferedReader(new FileReader(csvFile));
		WebDriver driver = new HtmlUnitDriver();  
		while ((line = br.readLine()) != null) {
			
			String[] csv = line.split(SplitBy);
			test_case_id = csv[0];
			url = csv[1];
			title_expected = csv[2];
			
//			System.out.println(test_case_id);
//			System.out.println(url);
//			System.out.println(title_expected);
			
			
			driver.get(url);
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			String title_actual = driver.getTitle();
			System.out.println("");
			System.out.println("Test Case ID: \t\t" + test_case_id);
			System.out.println("URL: \t\t\t" + url);
			System.out.println("Title Expected: \t" + title_expected);
			System.out.println("Title Actual: \t\t" + title_actual);
			if (title_expected.equals(title_actual)) {
				System.out.println("Test Case Result: \t" + "Passed");
			} else  {
				System.out.println("Test Case Result: \t" + "Failed");
			}
				
			
		}
		
		driver.quit();
		br.close();

	}

}

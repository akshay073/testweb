package practice.JunitTest;


import static org.junit.Assert.*;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import junit.framework.Assert;

public class App {
	WebDriver D1 =new ChromeDriver();

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("BeforeClass");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("AfterClass");
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("Before");
		D1.get("http://localhost:8090/WebWithDB/");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("After");
		D1.quit();
	}

	@Test
	public void test() throws IOException  {
		System.out.println("Test");
	    D1.getTitle();
	    //Assert.assertEquals("Login",D1.getTitle());
	    //if this validation fails then it does not proceed further, in each test only one validation is checked
	    
	    if(!D1.getTitle().equals("Login"))
	    {
	    	Date d = new Date();
	        System.out.println(d);
	        FileWriter f = new FileWriter("C:\\Users\\aksha\\Desktop\\JunitLog.txt",true);
	        BufferedWriter b = new BufferedWriter(f);
	        b.write(d+" Title is not a match");
	        b.newLine();
	        b.close();
	        f.close();
	    }	
	}
	
	@Test
	public void test2() throws Exception  {
		System.out.println("Test2");
		D1.findElement(By.id("txtUserN"));	
	}
	@Test
	public void test3() throws Exception  {
		System.out.println("Test3");
		D1.findElement(By.id("txtPassword"));
	}
		

}

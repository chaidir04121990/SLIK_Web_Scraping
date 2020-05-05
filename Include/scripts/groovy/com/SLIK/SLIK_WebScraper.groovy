package com.SLIK
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords

import internal.GlobalVariable

import MobileBuiltInKeywords as Mobile
import WSBuiltInKeywords as WS
import WebUiBuiltInKeywords as WebUI

import org.openqa.selenium.WebElement
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By
import org.openqa.selenium.Point

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException

import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When


import java.io.File
import java.io.IOException
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths

import net.sourceforge.tess4j.Tesseract
import net.sourceforge.tess4j.TesseractException

import java.util.logging.FileHandler
import  java.util.logging.Logger
import java.util.Locale;

import javax.imageio.ImageWriteParam;

import java.awt.Graphics2D;
import net.sourceforge.tess4j.*;
import java.awt.Image;
//import java.awt.Point
import java.awt.image.*;
import javax.imageio.ImageIO;

import java.awt.Rectangle
import java.awt.Robot
import java.awt.Toolkit
import java.awt.image.BufferedImage

import cucumber.api.Scenario
import org.openqa.selenium.OutputType
import org.openqa.selenium.TakesScreenshot
import org.apache.commons.io.FileUtils
import org.eclipse.persistence.internal.jpa.parsing.jpql.antlr.JPQLParser.deleteClause_scope

import java.awt.*
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.configuration.RunConfiguration

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import groovy.json.JsonSlurper;
import com.kms.katalon.core.testobject.RestRequestObjectBuilder
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty as TestObjectProperty
import com.kms.katalon.core.testobject.UrlEncodedBodyParameter
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Alert;



import java.awt.datatransfer.StringSelection
import java.awt.event.KeyEvent
import javax.swing.JComponent

import groovy.time.TimeCategory as TimeCategory
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys

import java.time.LocalDate
import org.openqa.selenium.interactions.Actions;

class SLIK_WebScraper {
	//	WebDriver driver=new FirefoxDriver();
	WebDriver driver =  new ChromeDriver();
	//	WebDriver driver = DriverFactory.getWebDriver()
	WebDriverWait wait=new WebDriverWait(driver, 20);


	String popup_dialog = "//div[@role='dialog']"
	String General_Button = "//button[text()='{PARAM}']"
	String General_Tab_Menu = "//div[@class='gnb']/ul[@class='g_menu' and @id='top1menu']/li/a[text()='{PARAM}']"
	String Left_Menu_of_Mainmenu_Pemantauan = "//div[@id='left_menu']/div[@class='clearfix']/aside[@class='sidebar']/nav[@class='sidebar_nav']/ul[@class='metismenu' and @id='menu']/li/ul[@id='left-menu' and @class='LeftMnRow']/li/a/span[text()='Pemantauan Aktivitas']"
	String Pemantauan_Aktivitas_expanded = "//div[@id='left_menu']/div[@class='clearfix']/aside[@class='sidebar']/nav[@class='sidebar_nav']/ul[@class='metismenu' and @id='menu']/li/ul[@id='left-menu' and @class='LeftMnRow']/li/a/span[text()='Pemantauan Aktivitas']/../../ul[@aria-expanded='true' and @class='collapse in']/li/a[text()='{PARAM}']"

	def replace(String x,oldc,newc){
		String str =  new String(x)
		return str.replace(oldc, newc)
		return str
	}

	@Given("Login SLIK")
	def capture_captcha() throws IOException, InterruptedException{
		//		System.setProperty("webdriver.chrome.driver", "/Users/chaidir.pratama01/Documents/Apps/Chromedriver/80_0_3987_106/chromedriver")
		//		System.setProperty("webdriver.gecko.driver", "/Users/chaidir.pratama01/Documents/Apps/Geckodriver/geckodriver2")
		//		WebDriver driver =  new ChromeDriver();
		//		WebDriver driver=new FirefoxDriver();

		driver.get("https://slik.ojk.go.id/slik");
		driver.manage().window().maximize();
		WebUI.delay(3)
		
		// Input ID
		DriverFactory.changeWebDriver(driver)
		TestObject new_obj_ID = new TestObject().addProperty('xpath', ConditionType.EQUALS, "//input[@name='loginId']")
		WebUI.setText(new_obj_ID, GlobalVariable.ID, FailureHandling.STOP_ON_FAILURE)

		//Input Password
		TestObject new_obj_pass = new TestObject().addProperty('xpath', ConditionType.EQUALS, "//input[@name='password']")
		WebUI.setText(new_obj_pass, GlobalVariable.PASSWORD, FailureHandling.STOP_ON_FAILURE)

		// get entire page screenshot
		File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		BufferedImage  fullImg = ImageIO.read(screenshot);
		BufferedImage eleScreenshot= fullImg.getSubimage(2473, 626, 168, 45);
		ImageIO.write(eleScreenshot, "png", screenshot);

		// Copy the element screenshot to disk
		File screenshotLocation = new File("/Users/chaidir.pratama01/Katalon Studio/OCR/Screenshot/new_captcha1.png");
		FileUtils.copyFile(screenshot,screenshotLocation);

		//Input captcha text to textarea of captcha
		def response = WS.sendRequest(findTestObject('Captcha_reader'))
		println response.getResponseBodyContent()
		String ro = response.getResponseBodyContent()
		TestObject captcha_xpath_input = new TestObject().addProperty('xpath', ConditionType.EQUALS, "//input[@name='captcha-answer']")
		WebUI.setText(captcha_xpath_input, ro, FailureHandling.STOP_ON_FAILURE)

		//Click Button Masuk
		TestObject BTN_Masuk_submit = new TestObject().addProperty('xpath', ConditionType.EQUALS, "//div/input[@type='submit' and @name='btnLogin']")
		WebUI.click(BTN_Masuk_submit, FailureHandling.STOP_ON_FAILURE)
		WebUI.waitForPageLoad(10)
	}
	@And("Login SLIK as Supervisor Succeed")
	def Login_Succeed(){
		String peringatan = "//div/span[text()='Peringatan']"
		TestObject login_failed = new TestObject().addProperty('xpath', ConditionType.EQUALS, peringatan)
		def Verify_element = WebUI.verifyElementPresent(login_failed, 10)
		if(Verify_element==false){
			WebUI.switchToWindowUrl("https://slik.ojk.go.id/slik")
			WebUI.delay(10)
			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_ENTER);
			r.keyRelease(KeyEvent.VK_ENTER);
		}
		else{
			WebUI.refresh()
			return capture_captcha()
		}
	}
	@And("Select Tab Menu \"([^\"]*)\"")
	def Select_Tab_Menu(String value){
		TestObject main_frame = new TestObject().addProperty('xpath', ConditionType.EQUALS, "//frame[@id='main']")
		WebUI.switchToFrame(main_frame,10)
		def xpath_new = replace(General_Tab_Menu, '{PARAM}', value)
		TestObject new_obj = new TestObject().addProperty('xpath', ConditionType.EQUALS, xpath_new)
		WebUI.verifyElementPresent(new_obj, 10, FailureHandling.STOP_ON_FAILURE)
		WebUI.click(new_obj)
	}
	@And("Select and Expand Left Menu \"([^\"]*)\"")
	def Select_and_Expand_Left_Menu(String value){
		TestObject new_obj = new TestObject().addProperty('xpath', ConditionType.EQUALS, Left_Menu_of_Mainmenu_Pemantauan)
		WebUI.verifyElementPresent(new_obj, 10, FailureHandling.STOP_ON_FAILURE)
		WebUI.click(new_obj, FailureHandling.STOP_ON_FAILURE)
	}
	@And("Select Submenu \"([^\"]*)\"")
	def Select_Submenu(String value){
		def xpath_new = replace(Pemantauan_Aktivitas_expanded, '{PARAM}', value)
		TestObject new_obj = new TestObject().addProperty('xpath', ConditionType.EQUALS, xpath_new)
		WebUI.verifyElementPresent(new_obj, 10, FailureHandling.STOP_ON_FAILURE)
		WebUI.click(new_obj, FailureHandling.STOP_ON_FAILURE)
	}

	@And("Select day-1 of \"([^\"]*)\"")
	def Select_DayMinusOne(String value){
		WebUI.executeJavaScript("document.getElementsByClassName('input_s1')[1].removeAttribute('readonly');",null)
		use(groovy.time.TimeCategory,{
			def dateFormat = 'ddMMyyyy'
			def Today = new Date()
			String TodayString=Today.format(dateFormat)
			def TodayMin1 = Today - 1.days
			String TodayMin1Str = TodayMin1.format(dateFormat)
			println('Yesterday was '+TodayMin1Str)
			if(value=="Log Aktivitas"){
				TestObject new_obj_text = new TestObject().addProperty('xpath', ConditionType.EQUALS, "//input[@class='input_s1' and @name='START_ACTIVITY_DATE_SRC']")
				WebUI.setText(new_obj_text, TodayMin1Str)
			}
			else if(value=="Log Aksi"){
				String xpath_obj = "//span[text()='Tanggal Aktivitas']/../span[2]/input[@type='text']"
				TestObject new_obj = new TestObject().addProperty('xpath', ConditionType.EQUALS, xpath_obj)
				WebUI.waitForElementVisible(new_obj, 30)
				WebUI.focus(new_obj)
				WebUI.sendKeys(new_obj, Keys.chord(Keys.BACK_SPACE))
				WebUI.sendKeys(new_obj, Keys.chord(Keys.BACK_SPACE))
				WebUI.sendKeys(new_obj, Keys.chord(Keys.BACK_SPACE))
				WebUI.sendKeys(new_obj, Keys.chord(Keys.BACK_SPACE))
				WebUI.sendKeys(new_obj, Keys.chord(Keys.BACK_SPACE))
				WebUI.sendKeys(new_obj, Keys.chord(Keys.BACK_SPACE))
				WebUI.sendKeys(new_obj, Keys.chord(Keys.BACK_SPACE))
				WebUI.sendKeys(new_obj, Keys.chord(Keys.BACK_SPACE))
				WebUI.setText(new_obj, TodayMin1Str)

			}
			else{
				println("UNKNOWN PROCESS")
			}
			
		})
	}
	@And("Select Today of \"([^\"]*)\"")
	def Select_Today(String value){
		WebUI.executeJavaScript("document.getElementsByClassName('input_s1')[2].removeAttribute('readonly');",null)
		use(groovy.time.TimeCategory,{
			def dateFormat = 'ddMMyyyy'
			def Today = new Date()
			String TodayString=Today.format(dateFormat)
			println('Today is '+TodayString)
			if(value=="Log Aktivitas"){
				TestObject new_obj_text = new TestObject().addProperty('xpath', ConditionType.EQUALS, "//input[@class='input_s1' and @name='END_ACTIVITY_DATE_SRC']")
				WebUI.setText(new_obj_text, TodayString)
			}
			else if(value=="Log Aksi"){
				TestObject new_obj_text = new TestObject().addProperty('xpath', ConditionType.EQUALS, "//input[@class='input_s1' and @name='END_ACTIVITY_DATE']")
				WebUI.setText(new_obj_text, TodayString)
			}
			else{
				println("UNKNOWN PROCESS")
			}
		})
	}
	@And("Click Button \"([^\"]*)\"")
	def GeneralButton(String value){
		def xpath_new_btn = replace(General_Button, '{PARAM}', value)
		TestObject new_obj_btn = new TestObject().addProperty('xpath', ConditionType.EQUALS, xpath_new_btn)
		WebUI.click(new_obj_btn)
		WebUI.waitForPageLoad(10)
		WebUI.delay(20)
	}
	@And("Click Toolbar Export")
	def Export(){
		TestObject new_iframe = new TestObject().addProperty('xpath', ConditionType.EQUALS, "//iframe[@id='reportIframe']")
		WebUI.switchToFrame(new_iframe, 10)

		TestObject new_toolbar_export = new TestObject().addProperty('xpath', ConditionType.EQUALS, "//div[@id='reportViewFrame']/div[@class='content ']/div[@class='header ']/div[@id='viewerToolbar']/ul[@class='list buttonSet']/li[@class='node']/ul[@class='list buttonSet']/li[2]/button[@id='export']")
		def elementexist = WebUI.verifyElementPresent(new_toolbar_export, 10)

		TestObject Export_As_Excel = new TestObject().addProperty('xpath', ConditionType.EQUALS, "//body[@id='reportViewer']/div[@id='menu']/div[@class='content']/ul/li[3]/p[text()='As Excel']")


		if(elementexist==true){
			println('element toolbar export exist')
			WebUI.delay(5)
			WebUI.focus(new_toolbar_export)
			//			WebUI.mouseOver(Export_As_Excel)
			//			WebUI.delay(5)
			//			WebUI.click(Export_As_Excel)
		}
		else{
			println('element does not exist')
		}
	}
	@And("Export As Excel")
	def ExportAsExcel(){
		TestObject Export_As_Excel = new TestObject().addProperty('xpath', ConditionType.EQUALS, "//body[@id='reportViewer']/div[@id='menu']/div[@class='content']/ul/li[3]/p[text()='As Excel']")
		WebUI.mouseOver(Export_As_Excel)
		WebUI.delay(5)
		WebUI.click(Export_As_Excel)
	}
	@And("Logout")
	def logout(){
		String xpath_logout = "//span/a[text()='Logout']"
		TestObject new_obj_logout = new TestObject().addProperty('xpath', ConditionType.EQUALS, xpath_logout)
		WebUI.verifyElementPresent(new_obj_logout, 10, FailureHandling.STOP_ON_FAILURE)
		WebUI.click(new_obj_logout)
	}
	@And("Close browser")
	def close_browser(){
		WebUI.closeBrowser()
	}
}
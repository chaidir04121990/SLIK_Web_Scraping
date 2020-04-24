package com.chody.takescreenshot

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import java.awt.image.BufferedImage
import java.nio.file.Files
import java.nio.file.Path

import javax.imageio.ImageIO

import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

import com.kms.katalon.core.annotation.Keyword

import ru.yandex.qatools.ashot.AShot
import ru.yandex.qatools.ashot.Screenshot
import ru.yandex.qatools.ashot.coordinates.WebDriverCoordsProvider

import internal.GlobalVariable

public class Take_Screenshot {
	@Keyword
	static BufferedImage takeElementImage(WebDriver webDriver, WebElement webElement) {
		Screenshot screenshot = new AShot().
				coordsProvider(new WebDriverCoordsProvider()).
				takeScreenshot(webDriver, webElement)
		return screenshot.getImage()
	}

	@Keyword
	static void saveElementImage(WebDriver webDriver, WebElement webElement, Path output) {
		if (!Files.exists(output.getParent())) {
			Files.createDirectories(output.getParent())
		}
		BufferedImage image = takeElementImage(webDriver, webElement)
		ImageIO.write(image, "PNG", output.toFile())
	}
}

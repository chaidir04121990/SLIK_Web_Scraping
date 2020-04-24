package grayscale

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

import internal.GlobalVariable

import java.awt.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class Grayscale_Keyword {
	/**
	 * This "toGray" method uses built in methods to convert an image to proper 8-bit gray scale.
	 * @param original - input image
	 * @return gray - grayscale image
	 *
	 * Found on: http://stackoverflow.com/questions/9131678/convert-a-rgb-image-to-grayscale-image-reducing-the-memory-in-java
	 */
	@Keyword
	public BufferedImage toGray(BufferedImage original) {
		//new BufferedImage for grayscale of original
		BufferedImage gray = new BufferedImage(original.getWidth(), original.getHeight(), BufferedImage.TYPE_BYTE_GRAY);
		Graphics g = gray.getGraphics();
		g.drawImage(original, 0, 0, null);
		//If we want to save the image
		ImageIO.write(gray,"JPG",new File("/Users/chaidir.pratama01/Desktop/Output_Grayscale.png"));
		return gray;
	}
}

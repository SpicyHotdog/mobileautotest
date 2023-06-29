package org.example;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import org.testng.annotations.Test;
import java.net.URL;

/**
 * Hello world!
 *
 */
public class App 
{
    @Test
    public static void main( String[] args )
    {
        XCUITestOptions options = new XCUITestOptions()
                //.setUdid("C69083B9-ABC3-4953-BED5-7350FB1A681D")
                .setUdid("00008020-000535E21178002E")
                .setAutomationName("xcuitest")
                //.setApp("/Users/yuki/Library/Developer/Xcode/DerivedData/HelloWorld-agevixnelxovaofclwigogwibiba/Build/Products/Debug-iphonesimulator/HelloWorld.app");
                .setApp("com.hsbc.dbbhk.bizexpress.enterprise");
        IOSDriver driver;
        try{
                driver = new IOSDriver(
                    // The default URL in Appium 1 is http://127.0.0.1:4723/wd/hub
                    new URL("http://127.0.0.1:4723"), options
            );
            //WebElement el = driver.findElement(AppiumBy.accessibilityId("myId"));
            //el.click();
            //driver.wait(3000);

            driver.findElement(AppiumBy.name(("alertCTAPositiveButton"))).click();
            driver.findElement(AppiumBy.name(("Log on"))).click();
            synchronized (driver){
                driver.wait(1000);

                driver.findElement(AppiumBy.xpath("//XCUIElementTypeTextField[@name='Enter your username']")).sendKeys("test12345");
                driver.wait(1000);
                driver.findElement(AppiumBy.xpath("//XCUIElementTypeButton[@name='Continue']")).click();
                driver.wait(1000);


                //input password and security code
                driver.findElement(AppiumBy.xpath("//XCUIElementTypeSecureTextField[@name='Enter your password']")).sendKeys("b2g3ifd");
                driver.findElement(AppiumBy.xpath("//XCUIElementTypeSecureTextField[@name='Enter your security code']")).sendKeys("049576");
                driver.wait(1000);
                driver.findElement(AppiumBy.xpath("//XCUIElementTypeButton[@name='Continue']")).click();
                driver.wait(1000);

                //click on the close button
                driver.findElement(AppiumBy.xpath("//XCUIElementTypeButton[@name='headerRightButton']")).click();

                driver.wait(1000);

                //get the 3rd profile from the profile list
                driver.findElement(AppiumBy.xpath("//XCUIElementTypeStaticText[@name='O87-HKHBAP002000214001PUSER1']")).click();
                driver.wait(1000);
                //click on close button
                driver.findElement(AppiumBy.xpath("//XCUIElementTypeButton[@name='headerRightButton']")).click();

                //select payment from bottom menu
                driver.findElement(AppiumBy.xpath("//XCUIElementTypeCell[@name='Payment & Transfer']")).click();

                //click on third party payment
                driver.findElement(AppiumBy.xpath("//XCUIElementTypeStaticText[@name='Third party account']")).click();

                driver.wait(2000);
                //select the 1st payee from contact card
                driver.findElement(AppiumBy.xpath("//XCUIElementTypeStaticText[@value='2018lin' and @name='payeeInfoNameLabel']")).click();

                driver.wait(2000);
                //select bank of TW
                driver.findElement(AppiumBy.xpath("//XCUIElementTypeStaticText[@value='TW BANK ACCOUNT TEST' and @name='TW BANK ACCOUNT TEST']")).click();

                driver.wait(2000);
                driver.findElement(AppiumBy.xpath("//XCUIElementTypeStaticText[@value='Enter an amount' and @name='transferDetailsDebitAmountAmountLabel']")).click();

                //input debit amount
                driver.wait(2000);
                driver.findElement(AppiumBy.xpath("//XCUIElementTypeTextField[@name='transferAmountInputDebitEdittext']")).sendKeys("100");

                //click on continue button
                driver.wait(1000);
                driver.findElement(AppiumBy.xpath("//XCUIElementTypeButton[@name='Continue']")).click();

                //click done button
                driver.wait(1000);
                driver.findElement(AppiumBy.xpath("//XCUIElementTypeButton[@name='transferAmountCTAButton']")).click();

                //click on preview payment
                driver.wait(1000);
                driver.findElement(AppiumBy.xpath("//XCUIElementTypeCell[@value='Radio button' and @name='We pay local bank charges, the beneficiary pays overseas bank charges.']")).click();
                driver.findElement(AppiumBy.xpath("//XCUIElementTypeButton[@name='transferDetailsCTAButton']")).click();

                //confirm the payment
                driver.wait(1000);
                driver.findElement(AppiumBy.xpath("//XCUIElementTypeButton[@name='transferVerifyCTAButton']")).click();

                driver.wait(1000);
                driver.findElement(AppiumBy.xpath("//XCUIElementTypeSecureTextField[@name='verificationSecurityCodeEdittext']")).sendKeys("564321");

                driver.wait(100);
                driver.findElement(AppiumBy.xpath("//XCUIElementTypeButton[@name='Done']")).click();

                //driver.wait(100);
                //driver.findElement(AppiumBy.xpath("//XCUIElementTypeButton[@name='verificationDoneButton']")).click();

                driver.wait(1000);
                //System.out.println(driver.getPageSource());
                if(driver.findElement(AppiumBy.xpath("//XCUIElementTypeStaticText[@name='acknowledgementStatusTitleLabel']"))!=null){
                    if(driver.findElement(AppiumBy.xpath("//XCUIElementTypeStaticText[@name='acknowledgementStatusTitleLabel']")).getText().equals("Your instruction has been received. ")){
                        System.out.println("Testing has been completed!");
                    }
                }
                driver.quit();
            }

        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }

        System.out.println( "Hello World!" );
    }
}

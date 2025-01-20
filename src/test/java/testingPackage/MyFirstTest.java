package testingPackage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.swing.*;
import java.time.Duration;
import java.util.concurrent.ExecutionException;



public class MyFirstTest
{
    //1-open browser ex google
    WebDriver driver = new ChromeDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    By TextField = new By.ById("my-text-id");
    By Password = new By.ByName("my-password");
    By TextArea = new By.ByName("my-textarea");

    By Dropselect = new By.ByName("my-select");
    By DropDetails = new By.ByName("my-datalist");
    By Checkbox = new By.ById("my-check-2");
    By color = new By.ByName("my-colors");
    By chooseFile = new By.ByName("my-file");

    By date = new By.ByName("my-date");
    By range = new By.ByName("my-range");

    By submit = new By.ByXPath("/html/body/main/div/form/div/div[2]/button");
    By AssertNextPAge = new By.ByXPath("/html/body/main/div/div[1]/div/h1");




    @Test
    public void FirstTest() throws InterruptedException
    {
        driver.get("https://www.selenium.dev/selenium/web/web-form.html");

        driver.findElement(TextField).click();
        driver.findElement(Password).click();
        driver.findElement(TextArea).click();
        driver.findElement(DropDetails).click();

        driver.findElement(TextField).sendKeys("Mostafa");
        driver.findElement(Password).sendKeys("123456");
        driver.findElement(TextArea).sendKeys(" iti intake 45");


        Select select = new Select(driver.findElement(Dropselect));
        select.selectByIndex(1);

        WebElement inputField = driver.findElement(DropDetails);
        inputField.sendKeys("San Francisco");

        driver.findElement(Checkbox).click();
        driver.findElement(color).click();

        try{
            Actions action = new Actions(driver);
            action.click(driver.findElement(chooseFile)).perform();

        }catch (Exception e){
            System.out.println("Error while Handling chooseFile" + e.getMessage());
        }

        WebElement colorPicker = driver.findElement(color);
        colorPicker.sendKeys("#0000FF");
        colorPicker.sendKeys(Keys.ENTER);



        driver.findElement(date).click();
        WebElement specificDay = driver.findElement(By.xpath("//td[text()='15']"));
        specificDay.click();


        driver.findElement(submit).click();
        String EnsureSubmitting =  driver.findElement(AssertNextPAge).getText();
        Assert.assertEquals(EnsureSubmitting , "Form submitted");
       driver.close();
    }



    By adder =new By.ById("adder");
    By RedBox =new By.ById("box0");

    By newInput = new By.ById("reveal");
    By newInputBox = new By.ById("revealed");

    @Test
    public void Test2()
    {
        driver.get("https://www.selenium.dev/selenium/web/dynamic.html");

        driver.findElement(adder).click();
        driver.findElement(newInput).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(RedBox));
        wait.until(ExpectedConditions.presenceOfElementLocated(newInput));

        Assert.assertTrue(driver.findElement(RedBox).isDisplayed());
        Assert.assertTrue(driver.findElement(newInputBox).isDisplayed());

        driver.findElement(newInputBox).sendKeys("Welcome iti");

        driver.close();

    }
}

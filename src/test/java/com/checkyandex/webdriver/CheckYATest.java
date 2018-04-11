package com.checkyandex.webdriver;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;


public class CheckYATest
{


    @Test
    public void Test001() {
        try {
            //Инициализация драйвера для создания экземпляра браузера Google Chrome
            System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();


            //Открытие адреса в созданном экземпляре браузера
            driver.get("https://yandex.ru");

            //задержка в 2 секунды
            Thread.sleep(2000);


            //поиск и открытие элемента Маркет
            WebElement element = ((ChromeDriver) driver).findElement(By.cssSelector("[data-id='market']"));
            element.click();

            //задержка в 2 секунды
            Thread.sleep(2000);


            //поиск и открытие элемента Электроника
            element = ((ChromeDriver) driver).findElement(By.linkText("Электроника"));

            element.click();

            //задержка в 2 секунды
            Thread.sleep(2000);

            //поиск и открытие элемента Телевизоры
            element = ((ChromeDriver) driver).findElement(By.linkText("Телевизоры"));
            element.click();

            //задержка в 2 секунды
            Thread.sleep(2000);


            //поиск и ввод данных в элемент Цена от
            element = ((ChromeDriver) driver).findElement(By.cssSelector("[name='Цена от']"));
            element.sendKeys("20000");

            //задержка в 3 секунды
            Thread.sleep(3000);


            //поиск и выбор данных в списке элементов производителей телевизоров
            element = ((ChromeDriver) driver).findElement(By.cssSelector("[data-reactid='91']"));
            element.click();

            //задержка в 3 секунды
            Thread.sleep(3000);

            element = ((ChromeDriver) driver).findElement(By.cssSelector("[data-reactid='112']"));
            element.click();

            //задержка в 3 секунды
            Thread.sleep(3000);

            //поиск элемента отображения количества элементов на странице и управление

            element = ((ChromeDriver) driver).findElement(By.xpath("/html/body/div[1]/div[4]/div[2]/div[1]/div[2]/div/div[3]/span/button"));
            String s = element.getText();

            if (s.equals("Показывать по 48")) {
                element.click();
                Thread.sleep(2000);

                element = ((ChromeDriver) driver).findElement(By.xpath("/html/body/div[3]/div/div/div[1]/span"));
                element.click();
            }

            //задержка в 3 секунды
            Thread.sleep(3000);

            //поиск поиск первого элемента в списке и запись его данных и дальнейший поиск по сохраненным данным

            element = ((ChromeDriver) driver).findElement(By.xpath("/html/body/div[1]/div[4]/div[2]/div[1]/div[2]/div/div[1]/div[1]/div[4]/div[1]/div/a"));
            s = element.getText();

            element = ((ChromeDriver) driver).findElement(By.id("header-search"));
            element.sendKeys(s);

            //задержка
            Thread.sleep(3000);


            element = element = ((ChromeDriver) driver).findElement(By.cssSelector("[type='submit']"));
            ;
            element.click();

            //задержка
            Thread.sleep(3000);

            //сравнение наименования найденного товара с сохраненными данными

            element = ((ChromeDriver) driver).findElement(By.xpath("/html/body/div[1]/div[4]/div[2]/div[2]/div/div[1]/div[1]/div/h1"));

            if (element.getText().equals(s)) {
                assertTrue(true);
            }

            driver.close();
        }
        catch (InterruptedException e) {
            //
        }
    }

}

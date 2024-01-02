package org.example;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "D:\\Tester\\telerik\\Services\\ChromeDriver\\chromedriver.exe");

        for (int i = 0; i < 4; i++) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            WebDriver driver = new ChromeDriver(options);
            driver.get("https://www.telerik.com/services");

            try {
                Thread.sleep(5000); // Consider using WebDriverWait instead
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            WebElement cookie = driver.findElement(By.id("onetrust-accept-btn-handler"));
            cookie.click();

            List<WebElement> frontElements = driver.findElements(By.className("Front"));
            if (i < frontElements.size()) {
                frontElements.get(i).click();
            }
        }
    }
}

/*
Go to https://www.telerik.com/services
(loop this 4 times and each time open new session) Click on Kendo UI Consulting,
Telerik Consulting, Test Studio Consulting and UI/UX Design to reach each element subpage
 */
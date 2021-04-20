import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class Practico9 {

    // Ejercicio 1
    @Test
    public void abrirGoogleChrome(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com/");
        driver.close();
    }


    // Ejercicio 3
    @Test
    public void bbcMundoTest(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.bbc.com/mundo");

        List<WebElement> listaH1s = driver.findElements(By.tagName("h1"));
        System.out.println("La cantidad de h1s es: " + listaH1s.size());

        for (WebElement h1 : listaH1s) {
            System.out.println("--> H1: " + h1.getText());
        }

        System.out.println("\t");

        List<WebElement> listaH2s = driver.findElements(By.tagName("h2"));
        System.out.println("La cantidad de h2s es: " + listaH2s.size());

        for (WebElement h2 : listaH2s) {
            System.out.println("--> H2: " + h2.getText());
        }

        driver.close();
    }


    // Ejercicio 4
    @Test
    public void bbcMundoLinks(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.bbc.com/mundo");

        List<WebElement> listaLinks = driver.findElements(By.tagName("a"));
        System.out.println("La cantidad de Links es: " + listaLinks.size());

        for (WebElement links : listaLinks) {
            System.out.println("--> Link: " + links.getText());
        }

        driver.close();
    }


    // Ejercicio 5
    @Test
    public void bbcMundoListas(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.bbc.com/mundo");

        List<WebElement> listaListas = driver.findElements(By.tagName("li"));
        System.out.println("La cantidad de Listas es: " + listaListas.size());

        for (WebElement listas : listaListas) {
            System.out.println("--> Lista: " + listas.getText());
        }

        driver.close();
    }


    // Ejercicio 6
    @Test
    public void spotifyTitleTest(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.spotify.com");

        String titleToValidate = "Escuchar es todo - Spotify";
        String spotifyWebGetTitle = driver.getTitle();

        if (spotifyWebGetTitle.equals(titleToValidate)){
            System.out.println("Test passed!!");
        }
        else{
            System.out.println("Test failed!!");
        }

        driver.close();
    }

    // Ejercicio 7
    @Test
    public void getWindowsSizeTest(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");

        Dimension currentDimension = driver.manage().window().getSize();

        System.out.println("La resolución actual de la ventana es");
        System.out.println("Alto: " + currentDimension.height + " - " + "Ancho: " + currentDimension.width);

        Dimension newDimension = new Dimension(1024,768);
        driver.manage().window().setSize(newDimension);

        System.out.println("\t");
        System.out.println("Se ha cambiado la resolución de la ventana a ");
        System.out.println("Alto: " + newDimension.height + " - " + "Ancho: " + newDimension.width);

        driver.close();
    }

    // Ejercicio 8
    public static WebDriver getGoogleDriver(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");
        return driver;
    }

    // Ejercicio 9
    public static WebDriver getDriver(String webSiteDomain){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://" + webSiteDomain);
        return driver;
    }

    // Ejercicio 10
    @Test
    public void searchInGoogle(){
        WebDriver driver = getGoogleDriver();

        WebElement searchField = driver.findElement(By.name("q"));
        searchField.sendKeys("WebElement");

        WebElement searchButton = driver.findElement(By.name("btnK"));
        searchButton.submit();

        driver.close();
    }

    // Ejercicio 11
    @Test
    public void searchInGoogleAndGoBack(){
        WebDriver driver = getGoogleDriver();

        System.out.println("\t");
        System.out.println("Web site: " + driver.getTitle());

        WebElement searchField = driver.findElement(By.name("q"));
        searchField.sendKeys("WebElement");

        WebElement searchButton = driver.findElement(By.name("btnK"));
        searchButton.submit();

        driver.navigate().back();
        driver.navigate().refresh();
        driver.navigate().forward();

        driver.close();
    }

    // Ejercicio 12
    @Test
    public void facebookPageTest(){
        WebDriver driver = getDriver("www.facebook.com");

        List <WebElement> divQuantity = driver.findElements(By.tagName("div"));
        System.out.println("La cantidad de tags tipo 'div' es: " + divQuantity.size());

        System.out.println("\t");
        List <WebElement> a_hrefQuantity = driver.findElements(By.tagName("a"));
        System.out.println("La cantidad de hipervinculos es: " + a_hrefQuantity.size());

        for (WebElement a_href_list : a_hrefQuantity) {
            System.out.println("hipervínculo: " + a_href_list.getText());
        }

        System.out.println("\t");
        List <WebElement> buttonsQuantity = driver.findElements(By.tagName("button"));
        System.out.println("La cantidad de botones es: " + buttonsQuantity.size());

        for (WebElement buttonsList : buttonsQuantity) {
            System.out.println("botón: " + buttonsList.getText());
        }

        driver.close();
    }

    // Ejercicio 13
    @Test
    public void sendKeysToFacebook(){
        WebDriver driver = getDriver("www.facebook.com");

        WebElement emailField = driver.findElement(By.name("email"));
        emailField.sendKeys("test@test.com");

        WebElement passwordField = driver.findElement(By.name("pass"));
        passwordField.sendKeys("holamundo");

        WebElement loginButton = driver.findElement(By.name("login"));
        loginButton.click();

        driver.close();
    }

    // Ejercicio 14
    @Test
    public void getNetflixInfo(){
        WebDriver driver = getDriver("www.netflix.com/uy/");

        List <WebElement> h1Elements = driver.findElements(By.tagName("a"));
        for (WebElement h1List : h1Elements) {
            System.out.println("h1: " + h1List.getText());
        }

        driver.navigate().refresh();

        System.out.println("\t");

        List <WebElement> buttonElements = driver.findElements(By.tagName("button"));
        for (WebElement buttonsList : buttonElements) {
            System.out.println("h1: " + buttonsList.getText());
        }

        System.out.println("\t");

        List <WebElement> divElements = driver.findElements(By.tagName("div"));
        System.out.println("La cantidad de tags tipo 'div' es: " + divElements.size());

        System.out.println("\t");
        System.out.println("Titulo de la página: " + driver.getTitle());
        System.out.println("\t");

        List <WebElement> linkElements = driver.findElements(By.tagName("link"));
        System.out.println("La cantidad de tags tipo 'link' es: " + linkElements.size());

        driver.close();
    }
}

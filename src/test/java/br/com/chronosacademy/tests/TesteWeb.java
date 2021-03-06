package br.com.chronosacademy.tests;

import br.com.chronosacademy.core.Driver;
import br.com.chronosacademy.enums.Browser;
import br.com.chronosacademy.pages.CursosPage;
import br.com.chronosacademy.pages.PrincipalPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;



public class TesteWeb {

    WebDriver driver;
    Driver driverWeb;
    PrincipalPage principalPage;
    CursosPage cursosPage;

    @Before
    public void inicializaTeste(){
        driverWeb = new Driver(Browser.CHROME);

        driver =  driverWeb.getDriver();

        driver.get("https://www.chronosacademy.com.br/");
        principalPage = new PrincipalPage(driver);
    }
    @Test
    public void primeiroTeste(){

        String titulo = principalPage.getTitulo();
        Assert.assertEquals("Porque Tempo É Conhecimento", titulo);
    }

    @Test
    public void segundoTeste() {
        cursosPage = new CursosPage(driver);
        principalPage.clickBotao();

        String h2Titulo = cursosPage.getTitulo2();
        Assert.assertEquals("AUTOMAÇÃO SEM COMPLICAÇÃO WEB 2.0", h2Titulo);
    }

    @After
    public void finaizaTeste(){

        driver.quit();
    }

}

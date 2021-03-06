package br.com.chronosacademy.steps;

import br.com.chronosacademy.core.Driver;
import br.com.chronosacademy.enums.Browser;
import br.com.chronosacademy.pages.LoginPage;
import br.com.chronosacademy.pages.NewAccountPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import org.junit.Assert;

import java.util.Map;

public class LoginSteps {

    LoginPage loginPage;
    String username;

    @Before
    public void iniciaNavegador(){
       new Driver(Browser.CHROME);
    }
    @After
    public void fechaNavegador(){
        Driver.getDriver().quit();
    }
    @Dado("que a modal esteja aberta")
    public void queAModalEstejaAberta() {
        Driver.getDriver().get("http://advantageonlineshopping.com/#/");
        loginPage = new LoginPage();
        loginPage.clickBtnLogin();
        loginPage.visibilityOfBtnFechar();
        loginPage.aguardaLoader();
    }
    @Quando("for realizado um clique fora da modal")
    public void forRealizadoUmCliqueForaDaModal() {
        loginPage.clickDivFechaModal();
    }
    @Entao("a janela modal deve ser fechada")
    public void aJanelaModalDeveSerFechada() throws Exception {
        try {
            loginPage.invisibilityOfBtnFechar();
        }catch (Exception e){
            throw new Exception("A Janela modal não foi fechada");
        }

    }

    @Quando("realizado um clique no icone de fechar a modal")
    public void realizadoUmCliqueNoIconeDeFecharAModal() {
        loginPage.clickBtnFechar();

    }

    @Quando("for realizado um clique no Link Create New Account")
    public void forRealizadoUmCliqueNoLinkCreateNewAccount() {
        loginPage.clickLinkCreateAccount();
    }

    @Entao("a pagina Create Account deve ser exibida")
    public void aPaginaCreateAccountDeveSerExibida() {
        NewAccountPage newAccountPage = new NewAccountPage();
        Assert.assertEquals("CREATE ACCOUNT", newAccountPage.getTextNewAccount());

    }

    @Quando("os campos de login sejam preenchidos da seguinte forma")
    public void osCamposDeLoginSejamPreenchidosDaSeguinteForma(Map<String, String> map) {
        username = map.get("login");
        String password = map.get("password");
        boolean remember = Boolean.parseBoolean(map.get("remember"));


        loginPage.setImpUserName(username);
        loginPage.setInpPassword(password);
        if (remember) loginPage.clickImpRemember();
        
    }

    @Quando("for realizado o clique no botao sign in")
    public void forRealizadoOCliqueNoBotaoSignIn() {
        loginPage.clickBtnSignIn();
    }

    @Entao("deve ser possivel logar no sistema")
    public void deveSerPossivelLogarNoSistema() {
        Assert.assertEquals(username, loginPage.getUsuarioLogado());
    }

    @Entao("o sitema deve exibir uma mensagem de erro")
    public void oSitemaDeveExibirUmaMensagemDeErro() {
    Assert.assertEquals("Incorrect user name or password.", loginPage.getErroLogin());
    }

    @Entao("o botao sign in deve permanecer desabilitado")
    public void oBotaoSignInDevePermanecerDesabilitado() {
        boolean enabled = loginPage.isBtnSignIn();
        Assert.assertFalse(enabled);
    }
}

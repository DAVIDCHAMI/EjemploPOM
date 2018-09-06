package com.sura.reclamaciones.pages.generics;

import com.sura.reclamaciones.constantes.ConstanteGlobal;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class MenuClaimPage extends GeneralPage {

  @FindBy(xpath = ".//*[@id=':tabs-innerCt']")
  WebElementFacade mnuPrimerNivel;

  @FindBy(
    xpath =
        ".//div[contains(@id,'menu-') and @class='x-panel x-layer x-panel-default x-menu x-border-box']"
  )
  WebElementFacade mnuSegundoNivel;

  @FindBy(xpath = "//input[@id='QuickJump-inputEl']")
  WebElementFacade txtComandoPolicy;

  @FindBy(xpath = " //div[@id='westPanel-innerCt']")
  WebElementFacade mnuLateralPrimerNivel;

  private String selectOpcion =
      "//span[contains(@class,'x-tree-node-text')][contains(text(),'COMODIN')]";
  private String auxSelectOpcion = "";

  @FindBy(xpath = "//span[@id='Claim:ClaimMenuActions-btnIconEl']")
  WebElementFacade btnAcciones;

  @FindBy(xpath = "//div[@class='x-css-shadow'][1]")
  WebElementFacade mnuPanelOpciones;

  @FindBy(
    xpath =
        ".//div[@class='x-panel x-layer x-panel-default x-menu x-border-box x-vertical-scroller x-panel-vertical-scroller x-panel-default-vertical-scroller']"
  )
  WebElementFacade mnuReclamacion;

  public MenuClaimPage(WebDriver wDriver) {
    super(wDriver);
  }

  public void seleccionarOpcionMenuPrimerNivel(String nombreOpcion) {
    mnuPrimerNivel.findElement(By.xpath("//span[contains(text(), '" + nombreOpcion + "')]"));
    mnuPrimerNivel.click();
  }

  public void buscarReclamacion(String nombreOpcion, String numeroReclamacion) {
    mnuPrimerNivel
        .findElement(By.xpath(".//a[contains(.,'" + nombreOpcion + "')]"))
        .sendKeys(Keys.ARROW_DOWN);
    mnuSegundoNivel
        .findElement(By.xpath("//input[@id='TabBar:ClaimTab:ClaimTab_FindClaim-inputEl']"))
        .sendKeys(numeroReclamacion, Keys.ENTER);
  }

  public void seleccionarOpcionMenuSegundoNivel(String nombreOpcion, String subItem) {
    mnuPrimerNivel
        .findElement(By.xpath(".//a[contains(.,'" + nombreOpcion + "')]"))
        .sendKeys(Keys.ARROW_DOWN);
    mnuSegundoNivel.findElement(By.xpath(".//a[contains(.,'" + subItem + "')]")).click();
  }

  public void seleecionarOpcionMenuLateralPrimerNivel(String nombreOpcion) {
    mnuLateralPrimerNivel
        .findElement(
            By.xpath(
                "//span[contains(@class,'x-tree-node-text')][contains(text(),'"
                    + nombreOpcion
                    + "')]"))
        .click();
    realizarEsperaCarga();
  }

  public void ingresarComandoClaim(String comando) {
    txtComandoPolicy.type(comando).sendKeys(Keys.ENTER);
  }

  public void seleccionarOpcionMenuLateralSegundoNivel(String nombreOpcion, String subItem) {
    mnuLateralPrimerNivel
        .findElement(
            By.xpath(
                "//span[contains(@class,'x-tree-node-text')][contains(text(),'"
                    + nombreOpcion
                    + "')]"))
        .click();
    realizarEsperaCarga();
    auxSelectOpcion = selectOpcion.replace(ConstanteGlobal.COMODIN, subItem);
    $(auxSelectOpcion).waitUntilVisible().click();
  }

  public void seleccionarOpcionMenuAccionesPrimerNivel(String nombreOpcion) {
    btnAcciones.waitUntilVisible().click();
    mnuPanelOpciones
        .findElement(
            By.xpath(
                "//span[contains(@class,'x-menu-item-text')][contains(text(),'"
                    + nombreOpcion
                    + "')]"))
        .click();
    realizarEsperaCarga();
  }
}

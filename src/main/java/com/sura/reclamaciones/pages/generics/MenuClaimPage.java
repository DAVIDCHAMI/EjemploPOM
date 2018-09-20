package com.sura.reclamaciones.pages.generics;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class MenuClaimPage extends GeneralPage {

  @FindBy(xpath = ".//*[@id=':tabs-innerCt']")
  private WebElementFacade mnuPrimerNivel;

  @FindBy(
    xpath =
        ".//div[contains(@id,'menu-') and @class='x-panel x-layer x-panel-default x-menu x-border-box']"
  )
  private WebElementFacade mnuSegundoNivel;

  @FindBy(xpath = "//input[@id='QuickJump-inputEl']")
  private WebElementFacade txtComandoPolicy;

  @FindBy(xpath = " //div[@id='westPanel-innerCt']")
  private WebElementFacade mnuLateralPrimerNivel;

  @FindBy(xpath = "//input[@id='TabBar:ClaimTab:ClaimTab_FindClaim-inputEl']")
  private WebElementFacade mnuBuscar;

  @FindBy(xpath = "//span[@id='Claim:ClaimMenuActions-btnIconEl']")
  private WebElementFacade btnAcciones;

  @FindBy(xpath = "//div[@class='x-css-shadow'][1]")
  private WebElementFacade mnuPanelOpciones;

  @FindBy(xpath = "//div[@id='TabBar:ClaimTab:ClaimTab_FindClaim_Button']")
  private WebElementFacade btnBuscar;

  public MenuClaimPage(WebDriver wDriver) {
    super(wDriver);
  }

  public void seleccionarOpcionMenuPrimerNivel(String nombreOpcion) {
    mnuPrimerNivel
        .findElement(By.xpath(String.format(".//a[contains(.,'%s')]", nombreOpcion)))
        .sendKeys(Keys.ARROW_DOWN);
  }

  public void seleccionarOpcionMenuSegundoNivel(String nombreOpcion, String subItem) {
    mnuPrimerNivel
        .findElement(By.xpath(".//a[contains(.,'" + nombreOpcion + "')]"))
        .sendKeys(Keys.ARROW_DOWN);
    mnuSegundoNivel.findElement(By.xpath(".//a[contains(.,'" + subItem + "')]")).click();
  }

  public void seleccionarOpcionMenuLateralPrimerNivel(String nombreOpcion) {
    mnuLateralPrimerNivel
        .findElement(
            By.xpath(
                String.format(
                    "//span[contains(@class,'x-tree-node-text')][contains(text(),'%s')]",
                    nombreOpcion)))
        .click();
    realizarEsperaCarga();
  }

  public void ingresarComandoClaim(String comando) {
    txtComandoPolicy.type(comando).sendKeys(Keys.ENTER);
  }

  public void seleccionarOpcionMenuLateralSegundoNivel(String nombreOpcion, String subItem) {
    seleccionarOpcionMenuLateralPrimerNivel(nombreOpcion);
    seleccionarOpcionMenuLateralPrimerNivel(subItem);
  }

  public void buscarReclamacion(String strOpcionMenu, String strReclamacion) {
    seleccionarOpcionMenuPrimerNivel(strOpcionMenu);
    mnuBuscar.click();
    mnuBuscar.typeAndEnter(strReclamacion);
    realizarEsperaCarga();
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

package com.sura.reclamaciones.pages.notificacionaviso;

import com.sura.reclamaciones.constantes.ConstanteGlobal;
import com.sura.reclamaciones.pages.generics.GeneralPage;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;

public class AsistenteVirtualAtrPage extends GeneralPage {

  private String mnuAsistenteVirtual = "//span[contains(text(),'COMODIN')]";
  private String auxMnuAsistenteVirtual = "";

  @FindBy(xpath = "//img[@title='Asistente Virtual']")
  private WebElementFacade bntAsistenteVirtual;

  @FindBy(xpath = "//div[@class='ig_ac11e92_r5 rootMenu rootMenu nodeSubMenu nodeSubMenuSelected']/span")
  private WebElementFacade lstAsistenteVirtual;

  @FindBy(id = "slbProducto")
  private WebElementFacade lstProducto;

  @FindBy(xpath = "//option[contains(text(),'AGRO')]")
  private WebElementFacade mnuOtroProducto;

  @FindBy(xpath = "//img[@src='images/Bot_Aceptar.jpg']")
  private WebElementFacade btnAceptar;

  @FindBy(xpath = "//div[@igtag='/modules/serviciosexternos/displayservice.aspx?id=RECLAMACIONESEMPRESARIALESASESOR&TIPO=RAMOS GENERALES']/span")
  private WebElementFacade mnuReclamacionEmpresa;


  public AsistenteVirtualAtrPage(WebDriver driver) {
    super(driver);
  }

  public void accederHerramientaAvisoEmpresa(){
    bntAsistenteVirtual.waitUntilVisible().click();
    enfocarVentana();
    auxMnuAsistenteVirtual = mnuAsistenteVirtual.replace(ConstanteGlobal.COMODIN, "Asistente virtual");
    $(auxMnuAsistenteVirtual).waitUntilVisible().click();
    auxMnuAsistenteVirtual = mnuAsistenteVirtual.replace(ConstanteGlobal.COMODIN, "Herramientas");
    $(auxMnuAsistenteVirtual).waitUntilVisible().click();
    auxMnuAsistenteVirtual = mnuAsistenteVirtual.replace(ConstanteGlobal.COMODIN, "Reclamaciones");
    $(auxMnuAsistenteVirtual).waitUntilVisible().click();
    //auxMnuAsistenteVirtual = mnuAsistenteVirtual.replace(ConstanteGlobal.COMODIN, "Empresas");
    //$(auxMnuAsistenteVirtual).waitUntilVisible().click();
    mnuReclamacionEmpresa.waitUntilVisible().click();
  }

  public void seleccionarPlanListaProducto(){
    enfocarVentana();
    lstProducto.waitUntilVisible().click();
    mnuOtroProducto.waitUntilVisible().click();
    btnAceptar.waitUntilVisible().click();
  }

}

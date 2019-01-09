package com.sura.reclamaciones.pages.notificacionaviso;

import com.sura.reclamaciones.constantes.ConstanteGlobal;
import com.sura.reclamaciones.pages.generics.GeneralPage;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;

public class BuscarPolizaPage extends GeneralPage {
  private String lstTipoDocumento = "//li[.='COMODIN']";
  private String auxTipoDocumento = "";

  @FindBy(
    xpath =
        "//input[@id='FNOLWizard:FNOLWizard_FindPolicyScreen:FNOLWizardFindPolicyPanelSet:basicSearchSura:FNOLWizardFindPolicyInputSet:licensePlate-inputEl']"
  )
  private WebElementFacade txtPlaca;

  @FindBy(xpath = "//input[@id='FNOLWizard:FNOLWizard_FindPolicyScreen:ScreenMode_true-inputEl']")
  private WebElementFacade rbtBuscarPoliza;

  @FindBy(
    xpath =
        "//input[@id='FNOLWizard:FNOLWizard_FindPolicyScreen:FNOLWizardFindPolicyPanelSet:basicSearchSura:FNOLWizardFindPolicyInputSet:policyNumber-inputEl']"
  )
  private WebElementFacade txtNumeroPoliza;

  @FindBy(
    xpath =
        "//td[.='Tipo documento del asegurado']//div[@class='x-trigger-index-0 x-form-trigger x-form-arrow-trigger x-form-trigger-first']"
  )
  private WebElementFacade mnuTipoDocumento;

  @FindBy(
    xpath =
        "//input[@id='FNOLWizard:FNOLWizard_FindPolicyScreen:FNOLWizardFindPolicyPanelSet:basicSearchSura:FNOLWizardFindPolicyInputSet:ssn-inputEl']"
  )
  private WebElementFacade txtNumeroDocumento;

  @FindBy(xpath = "//td[.='Fecha del siniestro']//div")
  private WebElementFacade mnuFechaSiniestro;

  @FindBy(xpath = "//span[.='Hoy']//span[@class='x-btn-button']")
  private WebElementFacade btnFechaHoy;

  @FindBy(
    xpath =
        "//input[@id='FNOLWizard:FNOLWizard_FindPolicyScreen:FNOLWizardFindPolicyPanelSet:basicSearchSura:FNOLWizardFindPolicyInputSet:date-inputEl']"
  )
  private WebElementFacade txtFecha;

  @FindBy(xpath = "//span[@class='g-underlined'][contains(text(),'s')]")
  private WebElementFacade btnBuscar;

  @FindBy(
    xpath =
        "//a[@id='FNOLWizard:FNOLWizard_FindPolicyScreen:FNOLWizardFindPolicyPanelSet:PolicyResultLV:0:selectButton']"
  )
  private WebElementFacade btnPoliza;

  @FindBy(id = "snfPolizaInformacionAsegurado")
  private WebElementFacade txtNumeroPolizaAtr;

  @FindBy(id = "lnkConsultarAseguradoInformacionAsegurado")
  private WebElementFacade btnConsultarDatosAseguradoATR;

  @FindBy(id = "idAseguradoInformacionAsegurado")
  private WebElementFacade txtNumeroDocumentoAtr;

  @FindBy(id = "tipoIdInformacionAsegurado")
  private WebElementFacade txtTipoDocumentoAsegurado;

  @FindBy(id = "lnkConsultarPolizasInformacionSiniestroEmp")
  private WebElementFacade btnConsultarPolizaAtr;

  @FindBy(xpath = "//input[@name='Pólizas EmpresarialesOption']")
  private WebElementFacade rbtPolizaAtr;

  @FindBy(xpath = "//input[@name='RiesgosOption']")
  private WebElementFacade rbtRiesgoPolizaAtr;

  public BuscarPolizaPage(WebDriver driver) {
    super(driver);
  }

  public void seleccionarOpcionBuscarPoliza() {
    rbtBuscarPoliza.waitUntilVisible();
    rbtBuscarPoliza.click();
  }

  public void escribirNumeroPoliza(String numPoliza) {
    txtNumeroPoliza.waitUntilVisible();
    txtNumeroPoliza.type(numPoliza);
  }

  public void seleccionarTipoDocumento(String tipoDocumento) {
    mnuTipoDocumento.waitUntilVisible();
    mnuTipoDocumento.click();
    auxTipoDocumento = lstTipoDocumento.replace(ConstanteGlobal.COMODIN, tipoDocumento);
    $(auxTipoDocumento).click();
  }

  public void escribirNumeroDocumento(String numDocumento) {
    txtNumeroDocumento.waitUntilVisible();
    txtNumeroDocumento.type(numDocumento);
  }

  public void seleccionarFechaHoySiniestro() {
    mnuFechaSiniestro.waitUntilVisible();
    mnuFechaSiniestro.click();
    btnFechaHoy.waitUntilVisible();
    btnFechaHoy.click();
  }

  public void escribirFechaSiniestro(String fecha) {
    txtFecha.waitUntilVisible();
    txtFecha.type(fecha);
  }

  public void buscarPoliza() {
    btnBuscar.waitUntilClickable();
    btnBuscar.click();
    realizarEsperaCarga();
    continuarSiguientePantalla();
  }

  public void escribirPlaca(String placa) {
    txtPlaca.waitUntilPresent();
    txtPlaca.type(placa);
  }

  public void seleccionarPoliza() {
    if (btnPoliza.isVisible()) {
      btnPoliza.waitUntilClickable();
      btnPoliza.click();
      realizarEsperaCarga();
    }
  }

  public void consultarDocumentoAtr(String tipoDocumentoAtr, String numDocumentoAtr) {
    String mnuTipoDocumentoAseguradoAtr = "//option[contains(text(),'COMODIN')]";
    enfocarVistaAutomatizacion();
    txtTipoDocumentoAsegurado.waitUntilVisible().click();
    navegarMenu(tipoDocumentoAtr, mnuTipoDocumentoAseguradoAtr);
    txtNumeroDocumentoAtr.waitUntilPresent().waitUntilVisible().type(numDocumentoAtr);
    btnConsultarDatosAseguradoATR.waitUntilVisible().click();
  }

  public void consultarPolizaAseguradoAtr() {
    btnConsultarPolizaAtr.waitUntilVisible().click();
    realizarEsperaCarga();
  }

  public void seleccionarPolizaAtr() {
    rbtPolizaAtr.waitUntilVisible().click();
    realizarEsperaCarga();
  }

  public void seleccionarRiegoPolizaAtr() {
    rbtRiesgoPolizaAtr.waitUntilVisible().click();
  }
}

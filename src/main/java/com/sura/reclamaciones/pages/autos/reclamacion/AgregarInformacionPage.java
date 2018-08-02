package com.sura.reclamaciones.pages.autos.reclamacion;

import static org.openqa.selenium.Keys.ENTER;

import com.sura.reclamaciones.pages.generics.GeneralPage;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class AgregarInformacionPage extends GeneralPage {

  public AgregarInformacionPage(WebDriver wdriver) {
    super(wdriver);
  }

  @FindBy(
    id =
        "NewClaimDuplicatesWorksheet:NewClaimDuplicatesScreen:NewClaimDuplicatesWorksheet_CloseButton-btnEl"
  )
  private WebElementFacade btnCerrarVentanaEmergente;

  @FindBy(xpath = ".//td[@class='x-input-cell']/input")
  WebElementFacade txtPretension;

  @FindBy(xpath = ".//label[contains(.,'Causa')]/../following-sibling::td//input")
  private WebElementFacade cmbCausaSiniestro;

  @FindBy(
    xpath =
        "//input[@id='FNOLWizard:AutoWorkersCompWizardStepSet:FNOLWizard_NewLossDetailsScreen:LossDetailsAddressDV:OriginCause-inputEl']"
  )
  private WebElementFacade cmbOrigenSiniestro;

  @FindBy(
    xpath =
        ".//td[@id='FNOLWizard:AutoWorkersCompWizardStepSet:FNOLWizard_NewLossDetailsScreen:LossDetailsAddressDV:AuthorityTransit-inputCell']/following-sibling::td"
  )
  private WebElementFacade cmbIntervinoAutoridad;

  @FindBy(
    xpath =
        "//td[@id='FNOLWizard:AutoWorkersCompWizardStepSet:FNOLWizard_NewLossDetailsScreen:CategorizationDV:Notification_Fault-inputCell']//input"
  )
  private WebElementFacade cmbCulpabilidad;

  @FindBy(
    xpath =
        "//td[@id='FNOLWizard:AutoWorkersCompWizardStepSet:FNOLWizard_NewLossDetailsScreen:LossDetailsAddressDV:AddressDetailInputSetRef:CCAddressInputSet:globalAddressContainer:Address_Picker-inputCell']/following-sibling::td"
  )
  private WebElementFacade cmbLugar;

  @FindBy(xpath = "//td[@class='g-after-input-cell']/a/img")
  private WebElementFacade btnAbajoVehiculo;

  @FindBy(xpath = "//div/a/span[contains(.,'Editar')]")
  private WebElementFacade btnEditarVehiculo;

  @FindBy(
    xpath =
        ".//td[@id='FNOLWizard:AutoWorkersCompWizardStepSet:FNOLWizard_NewLossDetailsScreen:LossDetailsAddressDV:AuthorityTransit-inputCell']/input"
  )
  private WebElementFacade txtIntervinoAutoridad;

  @FindBy(
    id =
        "FNOLWizard:AutoWorkersCompWizardStepSet:FNOLWizard_NewLossDetailsScreen:LossDetailsAddressDV:Description-inputEl"
  )
  private WebElementFacade txtSucedio;

  @FindBy(xpath = ".//span[@class='g-underlined' and contains(.,'F')]")
  private WebElementFacade btnFinalizar;

  public WebElementFacade getBtnCerrarVentanaEmergente() {
    return btnCerrarVentanaEmergente;
  }

  public void diligenciarFormulario(String label, String tipoCampo, String palabraAEscribir) {
    String formularioInformacionReclamacion =
        ".//div[contains(@id,'LossDetailsAddressDV')]/table//label[contains(.,'"
            + label
            + "')]/../following-sibling::td//"
            + tipoCampo;
    $(formularioInformacionReclamacion).sendKeys(palabraAEscribir);
  }

  public void escribirSucedido(String sucedido) {
    txtSucedio.type(sucedido);
    cmbCausaSiniestro.sendKeys(Keys.TAB);
    realizarEsperaCarga();
  }

  public void seleccionarCausa(String causa) {
    cmbCausaSiniestro.type(causa);
    cmbCausaSiniestro.sendKeys(Keys.TAB);
    realizarEsperaCarga();
  }

  public void seleccionarOrigen(String origen) {
    cmbOrigenSiniestro.type(origen);
    cmbOrigenSiniestro.sendKeys(Keys.TAB);
  }

  public void escribirValorPretension(String valorPretension) {
    txtPretension.type(valorPretension);
  }

  public void seleccionarIntervinoAutoridad(String autoridad) {
    txtIntervinoAutoridad.type(autoridad);
    txtIntervinoAutoridad.sendKeys(Keys.ENTER);
    realizarEsperaCarga();
  }

  public void cliquearBotonCerrar() {
    btnCerrarVentanaEmergente.waitUntilVisible().waitUntilClickable().click();
    realizarEsperaCarga();
  }

  public void seleccionarCulpabilidad(String culpabilidad) {
    cmbCulpabilidad.type(culpabilidad);
    cmbCulpabilidad.sendKeys(Keys.ENTER);
  }

  public void seleccionarLugar() {
    cmbLugar.waitUntilClickable().click();
    seleccionarOpcionCombobox("Medellin");
    realizarEsperaCarga();
  }

  public void ingresarEditarVehiculo() {
    btnAbajoVehiculo.click();
    btnEditarVehiculo.click();
    realizarEsperaCarga();
  }

  public void concluirReclamacion() {
    btnFinalizar.click();
    realizarEsperaCarga();
  }
}

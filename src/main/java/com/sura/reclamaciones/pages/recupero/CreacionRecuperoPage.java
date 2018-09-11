package com.sura.reclamaciones.pages.recupero;

import com.sura.reclamaciones.constantes.ConstanteGlobal;
import com.sura.reclamaciones.pages.generics.GeneralPage;
import java.util.List;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CreacionRecuperoPage extends GeneralPage {

  public CreacionRecuperoPage(WebDriver driver) {
    super(driver);
  }

  @FindBy(
    xpath =
        "//table[@id='NewRecoverySet:NewRecoveryScreen:RecoveryDetailDV:Payer-triggerWrap']//td/following-sibling::td/div"
  )
  private WebElementFacade txtPagador;

  @FindBy(
    xpath =
        "//input[@id='NewRecoverySet:NewRecoveryScreen:RecoveryDetailDV:ReserveLineInputSet:ReserveLine-inputEl']"
  )
  private WebElementFacade txtLineaReserva;

  @FindBy(
    xpath = "//input[@id='NewRecoverySet:NewRecoveryScreen:RecoveryDetailDV:Currency-inputEl']"
  )
  private WebElementFacade txtMoneda;

  @FindBy(id = "NewRecoverySet:NewRecoveryScreen:RecoveryDetailDV:RecoveryCategory-inputEl")
  private WebElementFacade txtCategoriaRecuperacion;

  @FindBy(id = "NewRecoverySet:NewRecoveryScreen:RecoveryDetailDV:idIngresoSAP-inputEl")
  private WebElementFacade txtComprobanteBancario;

  @FindBy(id = "NewRecoverySet:NewRecoveryScreen:RecoveryDetailDV:SuraEditableRecoveryLineItemsLV")
  private WebElementFacade tblElementoLinea;

  @FindBy(xpath = "//input[@name='Amount']")
  private WebElementFacade txtCantidad;

  @FindBy(
    xpath =
        "//input[@id='NewRecoverySet:NewRecoveryScreen:RecoveryDetailDV:dateTransaction-inputEl']"
  )
  private WebElementFacade txtFechaComprobante;

  @FindBy(
    xpath =
        "//a[@class='x-btn x-unselectable x-btn-toolbar x-box-item x-toolbar-item x-btn-default-toolbar-small x-noicon x-btn-noicon x-btn-default-toolbar-small-noicon']/span[@id='NewRecoverySet:NewRecoveryScreen:Update-btnWrap']"
  )
  private WebElementFacade btnActualizar;

  @FindBy(
    xpath = "//span[@id='ClaimFinancialsTransactions:ClaimFinancialsTransactionsScreen:ttlBar']"
  )
  private WebElementFacade lblTituloRecupero;

  private String seleccionarOpcion = "//li[.='COMODIN']";
  private String auxiliarSeleccionarOpcion = "";

  public void seleccionarPagador(String pagador) {
    txtPagador.waitUntilClickable();
    txtPagador.click();
    seleccionarOpcionCombobox(pagador);
    realizarEsperaCarga();
  }

  public void seleccionarLineaReserva(String lineaReserva) {
    txtLineaReserva.click();
    seleccionarOpcionCombobox(lineaReserva);
    realizarEsperaCarga();
  }

  public void seleccionarMoneda(String moneda) {
    txtMoneda.click();
    seleccionarOpcionCombobox(moneda);
  }

  public void seleccionarPais(String etiqueta, String pais) {
    buscarElementoLista(etiqueta, pais);
  }

  public void seleccionarDepartamento(String etiqueta, String departamento) {
    buscarElementoLista(etiqueta, departamento);
    realizarEsperaCarga();
  }

  public void seleccionarCiudad(String etiqueta, String ciudad) {
    buscarElementoLista(etiqueta, ciudad);
    realizarEsperaCarga();
  }

  public void seleccionarCategoriaRecuperacion(String recupero) {
    txtCategoriaRecuperacion.click();
    auxiliarSeleccionarOpcion = seleccionarOpcion.replace(ConstanteGlobal.COMODIN, recupero);
    $(auxiliarSeleccionarOpcion).click();
    realizarEsperaCarga();
  }

  public void diligenciarCodigoRetencion(String codigoRetencion, String encabezadoColumnaDevolver) {
    List<WebElement> elementoEncontrado =
        obtenerElementoTablaDatoDesconocido(tblElementoLinea, encabezadoColumnaDevolver, 1);
    elementoEncontrado.forEach(
        elemento -> {
          elemento.click();
          lstOpcionesCombobox.waitUntilVisible();
          seleccionarOpcionCombobox(codigoRetencion);
        });
    realizarEsperaCarga();
  }

  public void diligenciarCantidadRecupero(String montoRecupero, String encabezadoColumnaDevolver) {
    List<WebElement> elementoEncontrado =
        obtenerElementoTablaDatoDesconocido(tblElementoLinea, encabezadoColumnaDevolver, 1);
    elementoEncontrado.forEach(
        elemento -> {
          elemento.click();
          evaluateJavascript(
              String.format("$('input[name|=\"Amount\"]').val('%s')", montoRecupero));
        });
  }

  public void actualizarRecupero() {
    btnActualizar.waitUntilClickable();
    btnActualizar.click();
    lblTituloRecupero.waitUntilVisible();
    lblTituloRecupero.isVisible();
  }
}

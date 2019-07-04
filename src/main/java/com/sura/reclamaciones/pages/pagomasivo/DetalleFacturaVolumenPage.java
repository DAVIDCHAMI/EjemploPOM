package com.sura.reclamaciones.pages.pagomasivo;

import com.sura.reclamaciones.pages.generics.GeneralPage;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;

public class DetalleFacturaVolumenPage extends GeneralPage {
  @FindBy(
    id = "BulkPayWizard:BulkPayWizard_BulkInvoiceDetailScreen:BulkInvoiceDetailDV:Currency-inputEl"
  )
  private WebElementFacade cmbTipoMoneda;

  @FindBy(xpath = "//ul[@class='x-list-plain']")
  private WebElementFacade lstTipoMoneda;

  @FindBy(xpath = "//label[@class='x-form-cb-label x-form-cb-label-after']")
  private WebElementFacade rbtMetodoPago;

  @FindBy(
    id =
        "BulkPayWizard:BulkPayWizard_BulkInvoiceDetailScreen:BulkInvoiceDetailDV:Payee:PayeeMenuIcon"
  )
  private WebElementFacade btnBuscarBeneficiario;

  @FindBy(
    id =
        "BulkPayWizard:BulkPayWizard_BulkInvoiceDetailScreen:BulkInvoiceDetailDV:Payee:MenuItem_Search-textEl"
  )
  private WebElementFacade btnBuscarBeneficiarioPago;

  @FindBy(id = "BulkPayWizard:Finish-btnInnerEl")
  private WebElementFacade btnFinalizarPagoMasivo;

  @FindBy(id = "EditBulkInvoiceDetail:BulkInvoiceDetailScreen:SubmitButton-btnInnerEl")
  private WebElementFacade btnEnviarPagoMasivo;

  public DetalleFacturaVolumenPage(WebDriver wdriver) {
    super(wdriver);
  }

  public void seleccionarTipoMoneda(String tipoMoneda) {
    cmbTipoMoneda.click();
    lstTipoMoneda
        .findElement(org.openqa.selenium.By.xpath("./li[contains(.,'" + tipoMoneda + "')]"))
        .click();
  }

  public void buscarBeneficiario() {
    btnBuscarBeneficiario.waitUntilClickable();
    btnBuscarBeneficiario.click();
  }

  public void buscarBeneficiarioPago() {
    btnBuscarBeneficiarioPago.waitUntilPresent();
    btnBuscarBeneficiarioPago.click();
  }

  public void seleccionarMetodoPago(String metodoPago) {
    rbtMetodoPago.waitUntilClickable();
    rbtMetodoPago
        .findElement(
            By.xpath(
                "//following-sibling::label[contains( .,'"
                    + metodoPago
                    + "')]//preceding-sibling::input"))
        .click();
  }

  public void finalizarPagoMasivo() {
    btnFinalizarPagoMasivo.waitUntilClickable();
    btnFinalizarPagoMasivo.click();
  }

  public void enviarPagoMasivo() {
    btnEnviarPagoMasivo.waitUntilClickable();
    btnEnviarPagoMasivo.click();
  }
}

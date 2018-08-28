package com.sura.reclamaciones.pages.notificacionaviso;

import com.sura.reclamaciones.constantes.ConstanteGlobal;
import com.sura.reclamaciones.constantes.ReclamacionConstante;
import com.sura.reclamaciones.pages.generics.GeneralPage;
import com.sura.reclamaciones.pages.generics.MenuClaimPage;
import com.sura.reclamaciones.utils.Variables;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.fluentlenium.core.annotation.Page;
import org.openqa.selenium.WebDriver;

public class ResumenReclamacionPage extends GeneralPage {

  @Page MenuClaimPage menuClaimPage;

  @FindBy(
    xpath = "//div[@id='NewClaimSaved:NewClaimSavedScreen:NewClaimSavedDV:GoToClaim-inputEl']"
  )
  private WebElementFacade divNumeroReclamacion;

  @FindBy(xpath = "//a[@id='ClaimExposures:ClaimExposuresScreen:ExposuresLV:0:Type']")
  private WebElementFacade lnkTipoExposicion;

  @FindBy(
    xpath =
        "//div[@id='ClaimSummary:ClaimSummaryScreen:ClaimSummaryHeadlinePanelSet:TotalGrossIncurred-inputEl']"
  )
  private WebElementFacade divReserva;

  @FindBy(
    xpath =
        "//a[@id='ClaimFinancialsTransactions:ClaimFinancialsTransactionsScreen:TransactionsLV:0:Amount']"
  )
  private WebElementFacade lnkReservaTransaccion;

  @FindBy(
    xpath =
        "//a[@id='ClaimFinancialsSummary:ClaimFinancialsSummaryScreen:FinancialsSummaryPanelSet:FinancialsSummaryLV:0:RemainingReserves']"
  )
  private WebElementFacade lnkReservaResumen;

  public ResumenReclamacionPage(WebDriver driver) {
    super(driver);
  }

  public void obtenerNumeroReclamacion() {
    String numeroReclamacion;
    divNumeroReclamacion.waitUntilVisible();
    numeroReclamacion = divNumeroReclamacion.getText();
    numeroReclamacion = numeroReclamacion.replaceAll(Variables.FORMATEAR_MONTOS.getValor(), "");
    LOGGER.info(String.format("el número de reclamación generado es: %s", numeroReclamacion));
    divNumeroReclamacion.click();
  }

  public String validarExposicion() {
    String validadorExposicion;
    String validador;
    menuClaimPage.seleecionarOpcionMenuLateralPrimerNivel(ReclamacionConstante.EXPOSICIONES);
    if (lnkTipoExposicion.isVisible()) {
      validador = lnkTipoExposicion.waitUntilVisible().getText();
      switch (validador) {
        case ReclamacionConstante.EXPOSICION_CONTENIDO:
          validadorExposicion = ConstanteGlobal.SI;
          break;
        case ReclamacionConstante.EXPOSICION_PROPIEDAD:
          validadorExposicion = ConstanteGlobal.SI;
          break;
        default:
          validadorExposicion = ConstanteGlobal.NO;
          break;
      }
    } else {
      validadorExposicion = ConstanteGlobal.NO;
    }
    return validadorExposicion;
  }

  public String obtenerValorReserva() {
    String validadorReserva;
    menuClaimPage.seleecionarOpcionMenuLateralPrimerNivel(ReclamacionConstante.RESUMEN);
    validadorReserva = divReserva.waitUntilVisible().getText();
    validadorReserva = validadorReserva.replaceAll(Variables.FORMATEAR_MONTOS.getValor(), "");
    return validadorReserva;
  }

  public String validarReservaTransaccion(String montoReserva) {
    String validarReservaTransaccion;
    if (lnkReservaTransaccion.isVisible()) {
      validarReservaTransaccion = lnkReservaTransaccion.waitUntilVisible().getText();
      validarReservaTransaccion =
          validarReservaTransaccion.replaceAll(Variables.FORMATEAR_MONTOS.getValor(), "");
    } else {
      validarReservaTransaccion = montoReserva;
      LOGGER.info("No se ha generado reserva en la sección de transacciones");
    }
    return validarReservaTransaccion;
  }
}

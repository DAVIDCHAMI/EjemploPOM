package com.sura.reclamaciones.pages.pagos;

import com.sura.reclamaciones.pages.generics.GeneralPage;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;

import static com.sura.reclamaciones.utils.Utilidades.obtenerFechaActual;

public class EstablecerInstruccionPagoPage extends GeneralPage {

  public EstablecerInstruccionPagoPage(WebDriver driver) {
    super(driver);
  }

  @FindBy(
    xpath =
        "//input[@id='NormalCreateCheckWizard:CheckWizard_CheckInstructionsScreen:NewPaymentInstructionsDV:CheckWizardCheckSummaryInputSet:Check_DateOfService-inputEl']"
  )
  private WebElementFacade txtFechaPago;

  @FindBy(
    xpath =
        "//input[@id='NormalCreateCheckWizard:CheckWizard_CheckInstructionsScreen:NewPaymentInstructionsDV:CheckWizardCheckSummaryInputSet:Check_InvoiceNumber-inputEl']"
  )
  private WebElementFacade txtNumeroFactura;

  public void ingresarFechaFactura() {
    txtFechaPago.waitUntilClickable();
    txtFechaPago.sendKeys(obtenerFechaActual());
  }

  public void ingresarNumeroFactura(String strNumeroFactura) {
    txtNumeroFactura.click();
    txtNumeroFactura.sendKeys(strNumeroFactura);
  }
}

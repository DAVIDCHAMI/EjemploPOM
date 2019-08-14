package com.sura.reclamaciones.steps.pagos;

import static com.sura.reclamaciones.constantes.Constantes.CUENTA;
import static com.sura.reclamaciones.constantes.Constantes.SELECCIONAR;

import com.sura.reclamaciones.models.PagoSiniestro;
import com.sura.reclamaciones.pages.autos.reclamacion.DetalleExposicionAutomaticaPage;
import com.sura.reclamaciones.pages.generics.GeneralPage;
import com.sura.reclamaciones.pages.generics.MenuClaimPage;
import com.sura.reclamaciones.pages.generics.VerificacionDatosFinancierosPage;
import com.sura.reclamaciones.pages.notificacionaviso.ResumenReclamacionPage;
import com.sura.reclamaciones.pages.pagos.EstablecerInstruccionPagoPage;
import com.sura.reclamaciones.pages.pagos.IntroducirInformacionBeneficiarioPage;
import java.util.List;
import net.thucydides.core.annotations.Step;
import org.fluentlenium.core.annotation.Page;
import org.openqa.selenium.WebElement;

public class InformacionBeneficiarioPagoStep {

  List<WebElement> lstFilaPago;

  @Page MenuClaimPage menuClaimPage;

  @Page DetalleExposicionAutomaticaPage detalleExposicionAutomaticaPage;

  @Page IntroducirInformacionBeneficiarioPage introducirInformacionBeneficiarioPage;

  @Page VerificacionDatosFinancierosPage verificacionDatosFinancierosPage;

  @Page EstablecerInstruccionPagoPage establecerInstruccionPagoPage;

  @Page GeneralPage generalPage;

  @Page ResumenReclamacionPage resumenReclamacionPage;

  private static final String MENSAJE_PAGO_NO_REALIZADO = "No se generó orden de pago al asegurado";
  private static final String MENSAJE_RECHAZO_PAGO =
      "Elementos de línea : Para realizar el pago, primero debe verificar los detalles de investigación de auditoría";

  @Step
  public void consultarNumeroReclamacion() {
    resumenReclamacionPage.obtenerNumeroReclamacion();
  }

  public void ingresarInformacionBeneficiarioPago(
      String strBeneficiarioPago,
      String strMetodoPago,
      String strPagoSoloSura,
      List<PagoSiniestro> lstPago) {
    for (PagoSiniestro diligenciador : lstPago) {
      introducirInformacionBeneficiarioPage.seleccionarNombreBeneficiario(strBeneficiarioPago);
      introducirInformacionBeneficiarioPage.seleccionarTipoBeneficiario(
          diligenciador.getTipoBeneficiario());
      introducirInformacionBeneficiarioPage.seleccionarMetodoPago(
          strMetodoPago, CUENTA.getValor(), SELECCIONAR.getValor());
      introducirInformacionBeneficiarioPage.seleccionarPagoSura(strPagoSoloSura);
      introducirInformacionBeneficiarioPage.seleccionarPais(diligenciador.getPais());
      introducirInformacionBeneficiarioPage.seleccionarDepartamento(
          diligenciador.getDepartamento());
      introducirInformacionBeneficiarioPage.seleccionarCiudad(diligenciador.getCiudad());
      introducirInformacionBeneficiarioPage.seleccionarTipoDireccion(
          diligenciador.getTipoDireccion());
      generalPage.continuarSiguientePantalla();
    }
  }
}

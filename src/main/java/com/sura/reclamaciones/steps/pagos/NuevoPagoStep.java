package com.sura.reclamaciones.steps.pagos;

import static com.sura.reclamaciones.constantes.MenuConstante.RECLAMACION_MENU;

import com.sura.reclamaciones.constantes.PagoConstante;
import com.sura.reclamaciones.models.PagoEmpresarial;
import com.sura.reclamaciones.pages.generics.GeneralPage;
import com.sura.reclamaciones.pages.generics.MenuClaimPage;
import com.sura.reclamaciones.pages.pagos.EstablecerInstruccionPagoPage;
import com.sura.reclamaciones.pages.pagos.IntroducirInformacionBeneficiarioPage;
import com.sura.reclamaciones.pages.pagos.IntroducirInformacionPagoPage;
import java.util.List;
import net.thucydides.core.annotations.Step;
import org.fluentlenium.core.annotation.Page;

public class NuevoPagoStep {

  @Page IntroducirInformacionBeneficiarioPage introducirInformacionBeneficiarioPage;
  @Page IntroducirInformacionPagoPage introducirInformacionPagoPage;
  @Page EstablecerInstruccionPagoPage establecerInstruccionPagoPage;
  @Page GeneralPage generalPage;
  @Page MenuClaimPage menuClaimPage;

  @Step
  public void consultarNumeroReclamacion(String strNumeroReclamacion) {
    menuClaimPage.buscarReclamacion(RECLAMACION_MENU, strNumeroReclamacion);
    menuClaimPage.seleccionarOpcionMenuAccionesPrimerNivel(PagoConstante.PAGOS);
  }

  @Step
  public void ingresarInformacionBeneficiarioPago(
      String strTipoPago,
      String strBeneficiarioPago,
      String strMetodoPago,
      String strLineaReserva,
      String strPagoSoloSura,
      String strCodigoRetencion,
      List<PagoEmpresarial> lstPago) {
    lstPago.forEach(
        diligenciador -> {
          introducirInformacionBeneficiarioPage.seleccionarNombreBeneficiario(strBeneficiarioPago);
          introducirInformacionBeneficiarioPage.seleccionarTipoBeneficiario(
              diligenciador.getTipoBeneficiario());
          introducirInformacionBeneficiarioPage.seleccionarMetodoPago(
              strMetodoPago, PagoConstante.CUENTA);
          introducirInformacionBeneficiarioPage.seleccionarPagoSura(strPagoSoloSura);
          introducirInformacionPagoPage.seleccionarLineaReserva(strLineaReserva);
          introducirInformacionPagoPage.seleccionarTipoPago(strTipoPago);
          introducirInformacionPagoPage.ingresarComentario(diligenciador.getComentario());
          introducirInformacionPagoPage.ingresarCodigoRetencion(
              strCodigoRetencion, PagoConstante.CODIGO_RETENCION);
          introducirInformacionPagoPage.ingresarCantidadPago(strTipoPago, PagoConstante.CANTIDAD);
        });
  }

  @Step
  public void verificarPagoRealizado() {
    //to do:
  }
}

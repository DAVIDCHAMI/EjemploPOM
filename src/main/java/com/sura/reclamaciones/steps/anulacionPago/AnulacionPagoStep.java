package com.sura.reclamaciones.steps.anulacionPago;

import static com.sura.reclamaciones.constantes.MenuConstante.RECLAMACION_MENU;
import static org.junit.Assert.assertTrue;

import com.sura.reclamaciones.constantes.MenuConstante;
import com.sura.reclamaciones.constantes.PagoConstante;
import com.sura.reclamaciones.models.AnulacionPagoEmpresarial;
import com.sura.reclamaciones.pages.anulacionpago.DetallePagoPage;
import com.sura.reclamaciones.pages.anulacionpago.VerificacionAnulacionPagoPage;
import com.sura.reclamaciones.pages.generics.GeneralPage;
import com.sura.reclamaciones.pages.generics.MenuClaimPage;
import java.util.List;

import com.sura.reclamaciones.pages.pagos.VerificarPagoPage;
import net.thucydides.core.annotations.Step;
import org.fluentlenium.core.annotation.Page;

public class AnulacionPagoStep {
  @Page MenuClaimPage menuClaimPage;
  @Page GeneralPage generalPage;
  @Page DetallePagoPage detallePagoPage;
  @Page
    VerificacionAnulacionPagoPage verificacionAnulacionPagoPage;


  @Step
  public void consultarNumeroReclamacion(List<AnulacionPagoEmpresarial> lstNumeroReclamacion) {
    lstNumeroReclamacion.forEach(
        navegador -> {
          menuClaimPage.buscarReclamacion(RECLAMACION_MENU, navegador.getNumeroReclamacion());
          menuClaimPage.seleccionarOpcionMenuLateralSegundoNivel(
              MenuConstante.DATOS_FINANCIEROS, PagoConstante.PAGOS_RECUPEROS);
        });
  }

  @Step
  public void ingresarPagoAnular(List<AnulacionPagoEmpresarial> lstNumeroPago) {
    lstNumeroPago.forEach(
        diligenciador -> {
          detallePagoPage.ingresarAnulacionPago(diligenciador.getNumeroPago());
          detallePagoPage.realizarAnulacionPago();
        });
  }

  public void verificarAnulacionRealizada(String strAnulacionPago) {
      menuClaimPage.seleccionarOpcionMenuLateralSegundoNivel(MenuConstante.DATOS_FINANCIEROS, PagoConstante.PAGOS_RECUPEROS);

      assertTrue("El pago no quedo en estado anulado",verificacionAnulacionPagoPage.verificarEstadoAnulado(strAnulacionPago));
  }
}

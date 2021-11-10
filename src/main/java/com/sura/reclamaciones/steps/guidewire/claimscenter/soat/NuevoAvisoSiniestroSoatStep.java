package com.sura.reclamaciones.steps.guidewire.claimscenter.soat;

import com.sura.reclamaciones.pages.guidewire.claimscenter.comunes.BuscarPolizaPage;
import com.sura.reclamaciones.pages.guidewire.claimscenter.comunes.MenuClaimPage;
import com.sura.reclamaciones.utils.constantes.MenuConstante;
import net.thucydides.core.annotations.Step;
import org.fluentlenium.core.annotation.Page;

public class NuevoAvisoSiniestroSoatStep {

  @Page MenuClaimPage menuClaimPage;
  @Page BuscarPolizaPage buscarPolizaPage;

  @Step
  public void consultarPolizaSoat(String numeroPoliza) {
    seleccionarOpcionMenuPrincipal();
    completarFormularioBuscarPoliza(numeroPoliza);
    buscarPoliza();
    validarPolizaActiva();
  }

  @Step
  public void seleccionarOpcionMenuPrincipal() {
    menuClaimPage.seleccionarOpcionMenuSegundoNivel(
        MenuConstante.RECLAMACION_MENU, MenuConstante.NUEVA_RECLAMACION_MENU);
  }

  @Step
  public void completarFormularioBuscarPoliza(String numeroPoliza) {
    buscarPolizaPage.escribirNumeroPoliza(numeroPoliza);
    buscarPolizaPage.seleccionarFechaHoySiniestro();
  }

  @Step
  public void buscarPoliza() {
    buscarPolizaPage.buscarPoliza();
  }

  @Step
  public void validarPolizaActiva() {
    buscarPolizaPage.validarPoliza();
  }
}

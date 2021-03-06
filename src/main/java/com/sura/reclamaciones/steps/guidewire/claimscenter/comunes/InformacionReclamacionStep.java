package com.sura.reclamaciones.steps.guidewire.claimscenter.comunes;

import com.sura.reclamaciones.pages.guidewire.claimscenter.comunes.InformacionReclamacionPage;
import org.fluentlenium.core.annotation.Page;

public class InformacionReclamacionStep {

  @Page InformacionReclamacionPage informacionReclamacionPage;

  public void diligenciarInformacionIncidente(
      String causa, String valorPretension, String tipoIncidente) {
    informacionReclamacionPage.cerrarReclamosDuplicados();
    informacionReclamacionPage.escribirValorPretension(valorPretension);
    informacionReclamacionPage.seleccionarCausaSiniestro(causa);
    informacionReclamacionPage.seleccionarTipoIncidente(tipoIncidente);
    informacionReclamacionPage.finalizarSiniestro();
  }
}

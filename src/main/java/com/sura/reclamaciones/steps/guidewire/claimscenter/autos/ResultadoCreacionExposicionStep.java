package com.sura.reclamaciones.steps.guidewire.claimscenter.autos;

import com.sura.reclamaciones.pages.general.GeneralPage;
import net.thucydides.core.annotations.Step;
import org.fluentlenium.core.annotation.Page;

public class ResultadoCreacionExposicionStep {

  @Page GeneralPage generalPage;

  @Step
  public void buscarExposicionCreada() {
    generalPage.validarExposicionCreada();
  }
}

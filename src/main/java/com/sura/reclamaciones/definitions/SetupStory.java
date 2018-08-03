package com.sura.reclamaciones.definitions;

import com.sura.reclamaciones.steps.login.LoginClaimStep;
import com.sura.reclamaciones.utils.AmbientesUtil;
import cucumber.api.java.Before;
import net.thucydides.core.annotations.Steps;

public class SetupStory {

  @Steps LoginClaimStep loginClaimStep;

  AmbientesUtil ambientesUtil = new AmbientesUtil();

  @Before("@claims")
  public void seleccionarAmbiente() {
    if (ambientesUtil.getAmbiente().equals("lab")) {
      loginClaimStep.iniciarSesionLab();
    } else if (ambientesUtil.getAmbiente().equals("dllo")) {
      loginClaimStep.iniciarSesionAmbienteDllo();
    }
  }
}

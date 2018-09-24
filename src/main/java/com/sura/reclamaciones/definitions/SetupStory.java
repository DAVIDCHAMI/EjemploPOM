package com.sura.reclamaciones.definitions;

import com.sura.reclamaciones.constantes.ConstanteGlobal;
import com.sura.reclamaciones.steps.login.LoginClaimStep;
import com.sura.reclamaciones.utils.AmbientesUtil;
import cucumber.api.java.Before;
import java.io.IOException;
import net.thucydides.core.annotations.Steps;

public class SetupStory {

  @Steps LoginClaimStep loginClaimStep;

  AmbientesUtil ambientesUtil = new AmbientesUtil();

  @Before("@claimsEmpresarial")
  public void seleccionarAmbienteEmpresarial() throws IOException {
    if (ConstanteGlobal.LABORATORIO.equals(ambientesUtil.getAmbiente())) {
      loginClaimStep.iniciarSesionLab(ConstanteGlobal.ANALISTA_RECLAMACION_EMPRESARIAL);
    } else if (ConstanteGlobal.DESARROLLO.equals(ambientesUtil.getAmbiente())) {
      loginClaimStep.iniciarSesionAmbienteDllo();
    }
  }

  @Before("@claimsAuto")
  public void seleccionarAmbienteAuto() throws IOException {
    if (ConstanteGlobal.LABORATORIO.equals(ambientesUtil.getAmbiente())) {
      loginClaimStep.iniciarSesionLab(ConstanteGlobal.ANALISTA_RECLAMACION_AUTO);
    } else if (ConstanteGlobal.DESARROLLO.equals(ambientesUtil.getAmbiente())) {
      loginClaimStep.iniciarSesionAmbienteDllo();
    }
  }
}

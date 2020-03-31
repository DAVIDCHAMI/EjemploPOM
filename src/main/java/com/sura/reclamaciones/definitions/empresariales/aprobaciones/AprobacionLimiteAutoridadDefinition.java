package com.sura.reclamaciones.definitions.empresariales.aprobaciones;

import static com.sura.reclamaciones.utils.enums.Constantes.ANALISTA_RECLAMACION_EMPRESARIAL_SUPER_USUARIO;

import com.sura.reclamaciones.steps.guidewire.claimscenter.comunes.ConsultaDatoFinancieroTransaccionStep;
import com.sura.reclamaciones.steps.guidewire.claimscenter.comunes.LoginClaimStep;
import com.sura.reclamaciones.steps.guidewire.claimscenter.empresariales.AprobacionLimiteAutoridadStep;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Entonces;
import cucumber.api.java.es.Y;
import java.io.IOException;
import net.thucydides.core.annotations.Steps;

public class AprobacionLimiteAutoridadDefinition {

  @Steps AprobacionLimiteAutoridadStep aprobacionLimiteAutoridadStep;

  @Steps LoginClaimStep loginClaimStep;

  @Steps ConsultaDatoFinancieroTransaccionStep consultaDatoFinancieroTransaccionStep;

  @Entonces("^el estado de la transacción de reserva queda en (.*)$")
  public void verificarEstadoTransaccion(String strEstadoTransaccionReserva) {
    consultaDatoFinancieroTransaccionStep.verificarEstadoTransaccionReserva(
        strEstadoTransaccionReserva);
  }

  @Y(
      "^se genera la actividad, (.*) al Director o Gerente de atención de reclamaciones Empresariales$")
  public void verificarGeneracionActividadRevisarAprobarCambioReserva(
      String actividadAprobarReserva) throws IOException {
    aprobacionLimiteAutoridadStep.cerrarNavegador();
    loginClaimStep.iniciarSesionLab(ANALISTA_RECLAMACION_EMPRESARIAL_SUPER_USUARIO.getValor());
    aprobacionLimiteAutoridadStep.verificarGeneracionActividadRevisarAprobarCambioReserva(
        actividadAprobarReserva);
  }

  @Cuando("^es aprobada la actividad (.*)$")
  public void aprobarActividadRevisarAprobarCambioReserva(String actividadAprobarReserva) {
    aprobacionLimiteAutoridadStep.aprobarActividadRevisarAprobarCambioReserva(
        actividadAprobarReserva);
  }
}

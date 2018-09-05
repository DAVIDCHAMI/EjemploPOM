package com.sura.reclamaciones.definitions.notificacionaviso;

import com.sura.reclamaciones.models.ReclamacionEmpresarial;
import com.sura.reclamaciones.steps.generics.GenericStep;
import com.sura.reclamaciones.steps.notificacionaviso.*;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import net.thucydides.core.annotations.Steps;

public class NotificacionAvisoDefinition {

  ReclamacionEmpresarial reclamo;
  @Steps NuevaReclamacionEmpresarialStep nuevaReclamacionStep;
  @Steps GenericStep genericStep;

  @Dado("^que se tiene una poliza de (.*)$")
  public void buscarPoliza(String tipoCobertura) throws Throwable {
    reclamo =
        new ReclamacionEmpresarial(
            genericStep.getFilasModelo("reclamacion_empresarial", "escenarioAvisoEmpresariales"));
    nuevaReclamacionStep.seleccionarNuevaReclamacion("Re", "Nueva");
    nuevaReclamacionStep.buscarPolizaEmpresarial(reclamo.getLstReclamo());
  }

  @Cuando("^se genere un siniestro por causal (.*) con un valor de pretension de (.*)$")
  public void tomarDatosSiniestro(String causa, String valorPretension) {
    reclamo.getLstReclamo();
    nuevaReclamacionStep.seleccionarPropiedadImplicada();
    nuevaReclamacionStep.diligenciarInformacionPersonal(reclamo.getLstReclamo());
    nuevaReclamacionStep.seleccionarCausalIncidente(causa, valorPretension);
  }

  @Cuando("^un incidente de tipo (.*)$")
  public void tomarTipoIncidente(String tipoIncidente) {
    reclamo.getLstReclamo();
    nuevaReclamacionStep.diligenciarInformacionIncidente(reclamo.getLstReclamo(), tipoIncidente);
  }

  @Entonces("^se obtiene una reclamacion que (.*) genera exposicion$")
  public void verificarExposicion(String exposicion) {
    reclamo.getLstReclamo();
    nuevaReclamacionStep.validarReclamacion();
    nuevaReclamacionStep.visualizarResumenReclamacion();
    nuevaReclamacionStep.validarExposicionVisualizada(exposicion);
  }

  @Entonces("^que (.*) genera reserva con un monto (.*), envia correo y se asigna a un analista$")
  public void verificarReserva(String reserva, String monto) {
    reclamo.getLstReclamo();
    nuevaReclamacionStep.validarReservaVisualizada(monto);
    nuevaReclamacionStep.validarReservaDatosFinancieros(reclamo.getLstReclamo(), monto);
  }
}

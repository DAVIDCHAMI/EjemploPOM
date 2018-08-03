package com.sura.reclamaciones.definitions.notificacionaviso;

import com.sura.reclamaciones.models.ReclamacionEmpresariales;
import com.sura.reclamaciones.steps.generics.CSVStep;
import com.sura.reclamaciones.steps.notificacionaviso.*;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import net.thucydides.core.annotations.Steps;

public class NotificacionAvisoDefinition {

  ReclamacionEmpresariales reclamo;
  @Steps BuscarPolizaStep buscarPolizaStep;
  @Steps NuevaReclamacionStep nuevaReclamacionStep;
  @Steps PropiedadesImplicadasStep propiedadesImplicadasStep;
  @Steps InformacionBasicaStep informacionBasicaStep;
  @Steps InformacionReclamacionStep informacionReclamacionStep;
  @Steps CSVStep CSVStep;

  @Dado("que se recibe un reclamo por parte de un afectado")
  public void queSeRecibeUnReclamoPorParteDeUnAfectado() throws Throwable {
    reclamo =
        new ReclamacionEmpresariales(
            CSVStep.getFilasModelo("reclamacion_empresarial", "escenarioEmpresariales"));
    nuevaReclamacionStep.seleccionarNuevaReclamacion("Re", "Nueva");
    buscarPolizaStep.buscarPolizaEmpresarial(reclamo.getLstReclamo());
  }

  @Cuando("se tomen los datos del siniestro")
  public void seTomenLosDatosDelSiniestro() {
    reclamo.getLstReclamo();
    propiedadesImplicadasStep.seleccionarPropiedadImplicada();
    informacionBasicaStep.informacionPersonal(reclamo.getLstReclamo());
  }

  @Entonces("^se le brindara al reclamante un numero de reclamacion radicada")
  public void seLeBrindaraAlReclamanteUnNumeroDeReclamacionRadicada() {
    reclamo.getLstReclamo();
    informacionReclamacionStep.informacionIncidente(reclamo.getLstReclamo());
  }
}

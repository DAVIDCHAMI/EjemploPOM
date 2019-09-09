package com.sura.reclamaciones.definitions.empresariales.procesoreclamaciones;

import static com.sura.reclamaciones.utils.VariablesSesion.SESION_CC_TIPO_PRODUCTO_EMPRESARIAL;

import com.sura.reclamaciones.constantes.MenuConstante;
import com.sura.reclamaciones.constantes.ReclamacionConstante;
import com.sura.reclamaciones.models.ReclamacionEmpresarial;
import com.sura.reclamaciones.steps.generics.GenericStep;
import com.sura.reclamaciones.steps.generics.MenuClaimStep;
import com.sura.reclamaciones.steps.notificacionaviso.BuscarPolizaStep;
import com.sura.reclamaciones.steps.notificacionaviso.InformacionBasicaStep;
import com.sura.reclamaciones.steps.notificacionaviso.InformacionReclamacionStep;
import com.sura.reclamaciones.steps.notificacionaviso.NuevaReclamacionEmpresarialStep;
import com.sura.reclamaciones.steps.notificacionaviso.PropiedadesImplicadasStep;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import java.io.IOException;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;

public class NotificacionAvisoSiniestroDefinition {

  @Steps ReclamacionEmpresarial reclamacionEmpresarial;

  @Steps NuevaReclamacionEmpresarialStep nuevaReclamacionEmpresarialStep;

  @Steps GenericStep genericStep;

  @Steps MenuClaimStep menuClaimStep;

  @Steps BuscarPolizaStep buscarPolizaStep;

  @Steps InformacionReclamacionStep informacionReclamacionStep;

  @Steps InformacionBasicaStep informacionBasicaStep;

  @Steps PropiedadesImplicadasStep propiedadesImplicadasStep;

  @Dado("^que se tiene una póliza de (.*)$")
  public void buscarPoliza(String tipoCobertura) throws IOException {
    Serenity.setSessionVariable(SESION_CC_TIPO_PRODUCTO_EMPRESARIAL.getValor()).to(tipoCobertura);
    reclamacionEmpresarial =
        new ReclamacionEmpresarial(
            genericStep.getFilasModelo(
                ReclamacionConstante.RECLAMACION_EMPRESARIAL, tipoCobertura));
    menuClaimStep.seleccionarNuevaReclamacion(
        MenuConstante.RECLAMACION_MENU, MenuConstante.NUEVA_RECLAMACION_MENU);
    buscarPolizaStep.buscarPolizaEmpresarial(reclamacionEmpresarial.getLstReclamo());
  }

  @Cuando("^se genere un siniestro por causal (.*) con un valor de pretensión de (.*)$")
  public void tomarDatosSiniestro(String causaSiniestro, String valorPretension) {
    propiedadesImplicadasStep.seleccionarPropiedadImplicada();
    informacionBasicaStep.diligenciarInformacionBasica(reclamacionEmpresarial.getLstReclamo());
    informacionReclamacionStep.seleccionarCausalIncidente(causaSiniestro, valorPretension);
  }

  @Cuando("^un incidente de tipo (.*)$")
  public void tomarTipoIncidente(String tipoIncidente) {
    informacionReclamacionStep.diligenciarInformacionIncidente(tipoIncidente);
  }

  @Entonces("^se obtiene una reclamación que (.*) genera exposición$")
  public void verificarExposicion(String exposicion) {
    nuevaReclamacionEmpresarialStep.validarReclamacion();
    nuevaReclamacionEmpresarialStep.visualizarResumenReclamacion();
    nuevaReclamacionEmpresarialStep.validarExposicionVisualizada(exposicion);
  }

  @Entonces("^que (.*) genera reserva con un monto (.*), envía correo y se asigna a un analista$")
  public void verificarReserva(String reserva, String monto) {
    nuevaReclamacionEmpresarialStep.validarReservaDatosFinancieros(
        reclamacionEmpresarial.getLstReclamo());
  }
}

package com.sura.reclamaciones.definitions.empresariales;

import static com.sura.reclamaciones.utils.Variables.SESION_CC_TIPO_RESERVA;

import com.sura.reclamaciones.constantes.MenuConstante;
import com.sura.reclamaciones.models.Recupero;
import com.sura.reclamaciones.steps.generics.GenericStep;
import com.sura.reclamaciones.steps.notificacionaviso.NuevaReclamacionEmpresarialStep;
import com.sura.reclamaciones.steps.recupero.RecuperoStep;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Entonces;
import java.io.IOException;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;


public class RecuperoDefinition {

  @Steps RecuperoStep recuperoStep;

  @Steps GenericStep genericStep;

  @Steps NuevaReclamacionEmpresarialStep nuevaReclamacionEmpresarialStep;

  Recupero recupero;

  @Cuando("^se genere un recupero de tipo (.*) con un código de retención (.*)$")
  public void diligenciarRecupero(String tipoRecupero, String codigoRetencion) throws IOException {
    recupero =
        new Recupero(
            genericStep.getFilasModelo(
                "recupero", Serenity.sessionVariableCalled(SESION_CC_TIPO_RESERVA)));
    recuperoStep.seleccionarNumeroReclamacion(
        MenuConstante.RECLAMACION_MENU, recupero.getLstRecupero());
    recuperoStep.seleccionarRecupero();
    recuperoStep.diligenciarCreacionRecupero(
        recupero.getLstRecupero(), tipoRecupero, codigoRetencion);
  }

  @Entonces("^se obtiene un reintegro de dinero al siniestro$")
  public void verificarRecupero() {
    recuperoStep.verificarCreacionRecupero(recupero.getLstRecupero());
  }
}

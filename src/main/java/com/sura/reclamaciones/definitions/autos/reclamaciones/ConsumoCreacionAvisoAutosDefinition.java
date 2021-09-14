package com.sura.reclamaciones.definitions.autos.reclamaciones;

import static com.sura.reclamaciones.utils.UtilidadesCSV.obtenerDatosPrueba;
import static com.sura.reclamaciones.utils.enums.Filtros.*;
import static com.sura.reclamaciones.utils.enums.NombresCsv.*;
import static com.sura.reclamaciones.utils.enums.VariablesSesion.SESION_CC_NUMERO_SINIESTRO;
import static com.sura.reclamaciones.utils.enums.VariablesSesion.SESION_CC_TIPO_COBERTURA_AFECTADA;

import com.sura.reclamaciones.models.ExposicionVehiculoTercero;
import com.sura.reclamaciones.models.PersonaReclamacion;
import com.sura.reclamaciones.models.ReclamacionAuto;
import com.sura.reclamaciones.models.Vehiculo;
import com.sura.reclamaciones.steps.guidewire.claimscenter.autos.CrearExposicionStep;
import com.sura.reclamaciones.steps.guidewire.claimscenter.autos.ExposicionVehicularManualStep;
import com.sura.reclamaciones.steps.guidewire.claimscenter.autos.ResultadoCreacionExposicionStep;
import com.sura.reclamaciones.steps.guidewire.claimscenter.comunes.GenericStep;
import com.sura.reclamaciones.steps.guidewire.claimscenter.comunes.MenuClaimsStep;
import com.sura.reclamaciones.steps.maca.autos.ConsumoServicioCreacionAvisoSiniestroAutoStep;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import java.io.IOException;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;

public class ConsumoCreacionAvisoAutosDefinition {

  ReclamacionAuto parametroAviso = new ReclamacionAuto();
  PersonaReclamacion parametroPersonaReclamacionAuto = new PersonaReclamacion();
  PersonaReclamacion parametroPersonaConductorAuto = new PersonaReclamacion();
  Vehiculo reclamacionVehiculo = new Vehiculo();
  GenericStep genericStep = new GenericStep();
  ExposicionVehiculoTercero exposicionVehiculoTercero = new ExposicionVehiculoTercero();

  @Steps MenuClaimsStep menuClaimsStep;

  @Steps ConsumoServicioCreacionAvisoSiniestroAutoStep creacionAvisoSiniestroAutoStep;

  @Steps CrearExposicionStep crearExposicionStep;

  @Steps ExposicionVehicularManualStep nuevaExposicionVehiculoStep;

  @Steps ResultadoCreacionExposicionStep resultadoCreacionExposicionStep;

  @Dado(
      "^que se tiene una póliza con coberturas vigentes, se ingresa la reclamación a través de (.*) de autos$")
  public void parametrizarValoresSiniestro(String origenSinestro) throws IOException {
    parametroPersonaReclamacionAuto =
        new PersonaReclamacion(
            obtenerDatosPrueba(
                PARAMETROS_RECLAMACION_PERSONA_AUTO.getValor(), PERSONA_LESIONADA.getValor()));
    parametroPersonaConductorAuto =
        new PersonaReclamacion(
            obtenerDatosPrueba(
                PARAMETROS_RECLAMACION_PERSONA_AUTO.getValor(), PERSONA_CONDUCTOR.getValor()));
    reclamacionVehiculo =
        new Vehiculo(obtenerDatosPrueba(PARAMETROS_VEHICULO.getValor(), origenSinestro));
    parametroAviso =
        new ReclamacionAuto(
            obtenerDatosPrueba(
                PARAMETROS_SINIESTRO_AUTOS.getValor(), CREACION_AVISO_AUTOS_WS.getValor()));
  }

  @Cuando("^se genera un aviso que afecta la cobertura de (.*)$")
  public void siniestrarPolizaServicio(String tipoCobertura) {

    Serenity.setSessionVariable(SESION_CC_TIPO_COBERTURA_AFECTADA.getValor()).to(tipoCobertura);
    creacionAvisoSiniestroAutoStep.siniestrarPolizaAutos(
        parametroAviso.getLstReclamacionAuto(),
        parametroPersonaReclamacionAuto.getLstPersonaReclamacion(),
        parametroPersonaConductorAuto.getLstPersonaReclamacion(),
        reclamacionVehiculo.getLstVehiculos());
    menuClaimsStep.consultarNumeroReclamacion(
        Serenity.sessionVariableCalled(SESION_CC_NUMERO_SINIESTRO.getValor()));
  }

  @Entonces("^se le brindará al reclamante el número de reclamación$")
  public void verificarCreacionAviso() {
    creacionAvisoSiniestroAutoStep.verificarSiniestro();
  }

  @Cuando("^se cree la exposicion (.*)$")
  public void crearExposicion(int numeroVehiculosInvolucradosTercero) throws IOException {
    Vehiculo datosVehiculos = new Vehiculo();
    // crearExposicionStep.crearExposiciones(exposicon);
    nuevaExposicionVehiculoStep.consultarPlacaAsegurado();
    exposicionVehiculoTercero =
        new ExposicionVehiculoTercero(
            genericStep.getFilasModelo(
                PARAMETRO_RESPONSABILIDAD_CIVIL_VEHICULO.getValor(),
                EXPOSICION_VEHICULAR_TERCERO.getValor()));

    nuevaExposicionVehiculoStep.crearExposicionVehicularManual(
        genericStep.getFilasModelo(
            PARAMETROS_NAVEGACION_MENU_ACCIONES.getValor(), EXPOSICION_MANUAL_VEHICULAR.getValor()),
        exposicionVehiculoTercero.getLstExposicionTerceros(),
        numeroVehiculosInvolucradosTercero,
        datosVehiculos.getLstVehiculos());
  }

  @Entonces("^se debe porder viozualizar la exposicion creada$")
  public void verificarCreacionExposicion() {
    resultadoCreacionExposicionStep.buscarExposicionCreada();
  }
}

package com.sura.reclamaciones.definitions.soat.reclamaciones;

import static com.sura.reclamaciones.utils.UtilidadesCSV.obtenerDatosPrueba;
import static com.sura.reclamaciones.utils.enums.Filtros.*;
import static com.sura.reclamaciones.utils.enums.NombresCsv.*;
import static com.sura.reclamaciones.utils.enums.VariablesSesion.SESION_CC_NUMERO_PLACA_SOAT;

import com.sura.reclamaciones.models.soat.DatosGenerico;
import com.sura.reclamaciones.models.soat.DatosTecnico;
import com.sura.reclamaciones.models.soat.Personas;
import com.sura.reclamaciones.models.soat.Vehiculo;
import com.sura.reclamaciones.steps.guidewire.claimscenter.soat.ExpedirPolizaSoatRequestStep;
import cucumber.api.java.es.Dado;
import java.io.IOException;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;

public class CreacionPolizaSoatDefinition {

  Vehiculo vehiculo = new Vehiculo();
  Personas persona = new Personas();
  DatosGenerico datosGenerico = new DatosGenerico();
  DatosTecnico datosTecnico = new DatosTecnico();

  @Steps ExpedirPolizaSoatRequestStep expedirPolizaSoatRequestStep;

  @Dado("que una persona (.*) tiene un (.*) registrado en el Runt")
  public void registrarVehiculoRunt(String tipoRiesgo, String claseVehiculo) throws IOException {
    vehiculo =
        new Vehiculo(
            obtenerDatosPrueba(CARACTERISTICAS_VEHICULO.getValor(), CLASE_DE_VEHICULO.getValor()));
    persona =
        new Personas(obtenerDatosPrueba(DATOS_PERSONA.getValor(), POLIZA_SOAT_RIESGO.getValor()));
    datosGenerico =
        new DatosGenerico(
            obtenerDatosPrueba(DATOS_GENERICOS_REQUEST.getValor(), POLIZA_SOAT_RIESGO.getValor()));
    datosTecnico =
        new DatosTecnico(
            obtenerDatosPrueba(DATOS_TECNICOS.getValor(), DATOS_TECNICOS_SOAT.getValor()));

    Serenity.setSessionVariable(SESION_CC_NUMERO_PLACA_SOAT.getValor()).to(vehiculo.getNoPlaca());

    expedirPolizaSoatRequestStep.enviarDatosConsumoServicio(
        vehiculo, persona, datosGenerico, datosTecnico);
  }
}

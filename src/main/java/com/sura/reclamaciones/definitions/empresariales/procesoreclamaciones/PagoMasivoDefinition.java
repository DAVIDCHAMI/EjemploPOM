package com.sura.reclamaciones.definitions.empresariales.procesoreclamaciones;

import static com.sura.reclamaciones.constantes.Constantes.PAGO_MASIVO;
import static com.sura.reclamaciones.constantes.Filtros.CLASE_VEHICULO;
import static com.sura.reclamaciones.constantes.Filtros.EXPOSICION_MANUAL_VEHICULAR;
import static com.sura.reclamaciones.constantes.Filtros.EXPOSICION_VEHICULAR_TERCERO;
import static com.sura.reclamaciones.constantes.NombresCsv.CODIGO_FASECOLDA;
import static com.sura.reclamaciones.constantes.NombresCsv.PARAMETROS_NAVEGACION_MENU_ACCIONES;
import static com.sura.reclamaciones.constantes.NombresCsv.PARAMETRO_RESPONSABILIDAD_CIVIL_VEHICULO;
import static com.sura.reclamaciones.utils.UtilidadesCSV.obtenerDatosPrueba;

import com.sura.reclamaciones.models.*;
import com.sura.reclamaciones.steps.generics.DetalleSiniestroStep;
import com.sura.reclamaciones.steps.generics.ExposicionVehicularManualStep;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Entonces;
import java.io.IOException;
import net.thucydides.core.annotations.Steps;

public class PagoMasivoDefinition {

  ExposicionVehiculoTercero exposicionVehiculoTercero = new ExposicionVehiculoTercero();

  @Steps ExposicionVehicularManualStep nuevaExposicionVehiculoStep;

  @Steps DetalleSiniestroStep detalleSiniestroStep;

  CodigoFasecolda datosCodigoFasecolda;

  Exposicion datosExposicionPagoMasivo;

  Reserva datosReservaPagoMasivo;

  PagoSiniestro datosPagoSiniestroPagoMasivo;

  @Cuando(
      "^se registra la información de las facturas del pago masivo a un proveedor de (.*) vehículos involucrados en el siniestro con coberturas (.*)")
  public void ingresarInformacionFactura(
      int numeroVehiculosInvolucradosTercero, String coberturasPoliza) throws IOException {
    nuevaExposicionVehiculoStep.consultarPlacaAsegurado();
    exposicionVehiculoTercero =
        new ExposicionVehiculoTercero(
            obtenerDatosPrueba(
                PARAMETRO_RESPONSABILIDAD_CIVIL_VEHICULO.getValor(),
                EXPOSICION_VEHICULAR_TERCERO.getValor()));
    datosCodigoFasecolda =
        new CodigoFasecolda(
            obtenerDatosPrueba(CODIGO_FASECOLDA.getValor(), CLASE_VEHICULO.getValor()));
    nuevaExposicionVehiculoStep.crearExposicionVehicularManual(
        obtenerDatosPrueba(
            PARAMETROS_NAVEGACION_MENU_ACCIONES.getValor(), EXPOSICION_MANUAL_VEHICULAR.getValor()),
        exposicionVehiculoTercero.getLstExposicionTerceros(),
        numeroVehiculosInvolucradosTercero,
        datosCodigoFasecolda.getLstCodigoFasecolda());
    detalleSiniestroStep.consultarInformacionSiniestro();
    datosExposicionPagoMasivo =
        new Exposicion(
            obtenerDatosPrueba(String.valueOf(PAGO_MASIVO.getValor()), coberturasPoliza));
    datosReservaPagoMasivo =
        new Reserva(obtenerDatosPrueba(String.valueOf(PAGO_MASIVO.getValor()), coberturasPoliza));
    datosPagoSiniestroPagoMasivo =
        new PagoSiniestro(
            obtenerDatosPrueba(String.valueOf(PAGO_MASIVO.getValor()), coberturasPoliza));
  }

  @Cuando(
      "^se ingresa el tipo de proveedor (.*) y el nombre del proveedor (.*) con el tipo de moneda (.*) de la factura y el método de pago (.*) del cheque")
  public void crearPagoMasivo(
      String tipoContacto, String contacto, String tipoMoneda, String metodoPago) {
    //ToDo
  }

  @Entonces(
      "^se genera un número de pago individual por cada uno de los pagos registrados en el archivo de pagos masivos con un estado de pago solicitado$")
  public void validarPagoMasivo() {
    //ToDo
  }
}

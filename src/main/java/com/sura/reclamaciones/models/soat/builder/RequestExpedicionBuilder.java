package com.sura.reclamaciones.models.soat.builder;

import com.sura.reclamaciones.models.soat.DatosGenericos;
import com.sura.reclamaciones.models.soat.Personas;
import com.sura.reclamaciones.models.soat.Vehiculo;
import com.sura.reclamaciones.models.soat.comunes.RequestExpedicionSoat;
import com.sura.reclamaciones.utils.Fecha;

public class RequestExpedicionBuilder {

  private RequestExpedicionBuilder() {}

  public static RequestExpedicionSoat conLosDatos(
      DatosGenericos datosGenerico, Vehiculo vehiculo, Personas persona) {
    return RequestExpedicionSoat.builder()
        .codigoAsesor(String.valueOf(datosGenerico.getDatosGenericos().get(0).getCodigoAsesor()))
        .direccionIP(datosGenerico.getDatosGenericos().get(0).getDireccionIp())
        .fechaInicioVigencia(Fecha.disminuirDiasFechaActual(2))
        .placa(vehiculo.getVehiculos().get(0).getNoPlaca())
        .propietario(PropietarioBuilder.conLosDatos(persona))
        .retroactiva(datosGenerico.getDatosGenericos().get(0).getRetroactiva())
        .tenant(datosGenerico.getDatosGenericos().get(0).getTenant())
        .tomador(TomadorBuilder.conLosDatos(persona))
        .urlRetorno(datosGenerico.getDatosGenericos().get(0).getUrlRetorno())
        .build();
  }
}

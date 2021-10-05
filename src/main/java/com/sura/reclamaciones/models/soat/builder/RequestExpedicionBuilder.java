package com.sura.reclamaciones.models.soat.builder;

import com.sura.reclamaciones.models.soat.DatosGenerico;
import com.sura.reclamaciones.models.soat.Personas;
import com.sura.reclamaciones.models.soat.Vehiculo;
import com.sura.reclamaciones.models.soat.comunes.RequestExpedicionSoat;
import com.sura.reclamaciones.utils.Fecha;

public class RequestExpedicionBuilder {

  public static RequestExpedicionSoat conLosDatos(
      DatosGenerico datosGenerico, Vehiculo vehiculo, Personas persona) {
    return RequestExpedicionSoat.builder()
        .codigoAsesor(String.valueOf(datosGenerico.getCodigoAsesor()))
        .direccionIP(datosGenerico.getDireccionIp())
        .fechaInicioVigencia(Fecha.disminuirDiasFechaActual(1))
        .placa(vehiculo.getNoPlaca())
        .propietario(PropietarioBuilder.conLosDatos(persona))
        .retroactiva(datosGenerico.getRetroactiva())
        .tenant(datosGenerico.getTenant())
        .tomador(TomadorBuilder.conLosDatos(persona))
        .urlRetorno(datosGenerico.getUrlRetorno())
        .build();
  }
}

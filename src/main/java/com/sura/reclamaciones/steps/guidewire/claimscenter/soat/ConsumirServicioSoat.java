package com.sura.reclamaciones.steps.guidewire.claimscenter.soat;

import com.sura.reclamaciones.models.soat.comunes.RequestExpedicionSoat;
import com.sura.reclamaciones.utils.enums.EnumCredencialesServicios;
import java.util.Map;

public class ConsumirServicioSoat {

  private ConsumirServicioSoat() {}

  public static ConsumirServicioSoapPostConHeaders postConHeadeers(
      String recurso,
      EnumCredencialesServicios enumCredenciales,
      RequestExpedicionSoat request,
      Map<String, String> header) {

    return new ConsumirServicioSoapPostConHeaders(recurso, enumCredenciales, request, header);
  }
}

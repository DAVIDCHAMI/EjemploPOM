package com.sura.reclamaciones.steps.guidewire.claimscenter.soat;

import static com.sura.reclamaciones.utils.enums.EnumCredencialesServicios.SERVICIOS_SOAT;
import static com.sura.reclamaciones.utils.enums.EnumRecursosServicios.EXPEDICION;

import com.sura.reclamaciones.models.soat.DatosGenerico;
import com.sura.reclamaciones.models.soat.DatosTecnico;
import com.sura.reclamaciones.models.soat.Personas;
import com.sura.reclamaciones.models.soat.Vehiculo;
import com.sura.reclamaciones.models.soat.builder.PropietarioBuilder;
import com.sura.reclamaciones.models.soat.builder.RequestExpedicionBuilder;
import com.sura.reclamaciones.models.soat.builder.TomadorBuilder;
import java.util.HashMap;
import java.util.Map;

public class ExpedirPolizaSoatRequestStep {

  Map<String, String> header = new HashMap<>();

  public ExpedirPolizaSoatRequestStep() {
    header.put("X-Consumer-Key", "Bancolombia");
  }

  public void enviarDatosConsumoServicio(
      Vehiculo vehiculo, Personas persona, DatosGenerico datosGenerico, DatosTecnico datosTecnico) {
    ExpedirPolizaSoatRequestStep expedirPolizaSoatRequestStep = new ExpedirPolizaSoatRequestStep();
    PropietarioBuilder.conLosDatos(persona);
    TomadorBuilder.conLosDatos(persona);
    // RequestExpedicionBuilder.conLosDatos(datosGenerico,vehiculo,persona);
    ConsumirServicioSoat.postConHeadeers(
        EXPEDICION.getRecurso(),
        SERVICIOS_SOAT,
        RequestExpedicionBuilder.conLosDatos(datosGenerico, vehiculo, persona),
        expedirPolizaSoatRequestStep.header);

    // ConsumirServicioSoapPostConHeaders.ejecutarConsumo();

  }
}

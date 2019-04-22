package com.sura.reclamaciones.definitions.empresariales;

import com.sura.reclamaciones.steps.reserva.TransaccionReservaStep;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Entonces;
import net.thucydides.core.annotations.Steps;

public class ConstitucionNuevaLineaReservaDefinition {

  @Steps
  TransaccionReservaStep transaccionReservaStep;

  @Cuando(
      "^se crea una nueva Línea de reserva por la Exposición de (.*) por (.*) con un tipo de costo (.*) por un valor de (.*)$")
  public void crearNuevaLineaReserva(
      String lineaReserva, String categoriaCosto, String tipoCosto, String valorNuevaReserva) {
    transaccionReservaStep.crearNuevaLineaReserva(
        lineaReserva, tipoCosto, categoriaCosto, valorNuevaReserva);
  }

  @Entonces("^se genera una nueva Línea de reserva de (.*) con un deducible de (.*)$")
  public void verificarConstitucionNuevaLineaReserva(String categoriaCosto, String deducible) {
    transaccionReservaStep.verificarAjusteReserva(categoriaCosto, deducible);
  }
}

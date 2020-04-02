package com.sura.reclamaciones.definitions.comunes.pagos;

import static com.sura.reclamaciones.utils.UtilidadesCSV.obtenerDatosPrueba;
import static com.sura.reclamaciones.utils.enums.NombresCsv.PAGO_SINIESTRO;
import static com.sura.reclamaciones.utils.enums.VariablesSesion.SESION_CC_TIPO_PRODUCTO_EMPRESARIAL;

import com.sura.reclamaciones.models.PagoSiniestro;
import com.sura.reclamaciones.steps.guidewire.claimscenter.comunes.AnulacionPagoStep;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Entonces;
import java.io.IOException;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;

public class AnulacionPagoDefinition {

  @Steps AnulacionPagoStep anulacionPagoStep;

  PagoSiniestro pagoSiniestro;

  @Cuando("^se realice la anulación del pago$")
  public void anularTransaccionPagoEmpresariales() throws IOException {
    pagoSiniestro =
        new PagoSiniestro(
            (obtenerDatosPrueba(
                PAGO_SINIESTRO.getValor(),
                Serenity.sessionVariableCalled(SESION_CC_TIPO_PRODUCTO_EMPRESARIAL.getValor()))));
    anulacionPagoStep.ingresarAnulacionPago(pagoSiniestro.getLstPago());
  }

  @Cuando("^se anula dicho pago con cobertura (.*)$")
  public void anularTransaccionPagoAutos(String cobertura) throws IOException {
    pagoSiniestro = new PagoSiniestro(obtenerDatosPrueba(PAGO_SINIESTRO.getValor(), cobertura));
    anulacionPagoStep.ingresarAnulacionPago(pagoSiniestro.getLstPago());
  }

  @Entonces("^se debe obtener la anulación del pago, quedando en estado anulado$")
  public void verificarAnulacionPago() {
    anulacionPagoStep.verificarAnulacionPago();
  }
}

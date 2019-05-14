package com.sura.reclamaciones.definitions.empresariales.procesoreclamaciones;

import static com.sura.reclamaciones.constantes.Constantes.ESTADO_ANULACION;
import static com.sura.reclamaciones.constantes.NombresCsv.ANULACION_EMPRESARIAL;
import static com.sura.reclamaciones.constantes.NombresCsv.PAGO_SINIESTRO;
import static com.sura.reclamaciones.utils.VariablesSesion.SESION_CC_TIPO_PRODUCTO_EMPRESARIAL;

import com.sura.reclamaciones.models.AnulacionEmpresarial;
import com.sura.reclamaciones.models.PagoSiniestro;
import com.sura.reclamaciones.steps.anulaciontransaccion.AnulacionTransaccionStep;
import com.sura.reclamaciones.steps.generics.GenericStep;
import com.sura.reclamaciones.steps.pagos.NuevoPagoStep;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Entonces;
import cucumber.api.java.es.Y;
import java.io.IOException;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;

public class AnulacionPagoDefinition {

  @Steps GenericStep genericStep;

  @Steps
  AnulacionTransaccionStep anulacionTransaccionStep;

  @Steps NuevoPagoStep nuevoPagoStep;

  PagoSiniestro pagoSiniestro;

  @Y(
        "^que se realice un pago, de un siniestro de una póliza empresarial con producto (.*) y código de retención (.*)$")
    public void crearPago(String strTipoProducto, String strCodigoRetencion) throws IOException {
      pagoSiniestro =
          new PagoSiniestro(
              (genericStep.getFilasModelo(
                  PAGO_SINIESTRO.getValor(),
                  Serenity.sessionVariableCalled(SESION_CC_TIPO_PRODUCTO_EMPRESARIAL.getValor()))));
      AnulacionEmpresarial anulacionEmpresarial =
          new AnulacionEmpresarial(
              (genericStep.getFilasModelo(
                  ANULACION_EMPRESARIAL.getValor(),
                  Serenity.sessionVariableCalled(SESION_CC_TIPO_PRODUCTO_EMPRESARIAL.getValor()))));
      anulacionEmpresarial
          .getLstAnulacionEmpresarial()
          .forEach(
              ajustador -> {
                nuevoPagoStep.consultarNumeroReclamacion();
                nuevoPagoStep.ingresarInformacionBeneficiarioPago(
                    ajustador.getLineaReserva(),
                    ajustador.getTipoPago(),
                    ajustador.getBeneficiarioPago(),
                    ajustador.getMetodoPago(),
                    ajustador.getSoloSura(),
                    strCodigoRetencion,
                    pagoSiniestro.getLstPago());
              });
    }

  @Cuando("^se realice la anulación del pago$")
  public void anularPago() throws IOException {
    pagoSiniestro =
        new PagoSiniestro(
            (genericStep.getFilasModelo(
                PAGO_SINIESTRO.getValor(),
                Serenity.sessionVariableCalled(SESION_CC_TIPO_PRODUCTO_EMPRESARIAL.getValor()))));
    anulacionTransaccionStep.ingresarAnulacionPago(pagoSiniestro.getLstPago());
  }

  @Cuando("^se anula dicho pago con cobertura (.*)$")
  public void anularTransaccionPagoAutos(String cobertura) throws IOException {
    pagoSiniestro =
        new PagoSiniestro((genericStep.getFilasModelo(PAGO_SINIESTRO.getValor(), cobertura)));
    anulacionTransaccionStep.ingresarAnulacionPago(pagoSiniestro.getLstPago());
  }

  @Entonces("^se debe obtener la anulación del pago, quedando en estado anulado$")
  public void verificarAnulacionPago() {
    anulacionTransaccionStep.verificarAnulacionRealizada(ESTADO_ANULACION.getValor());
  }

}

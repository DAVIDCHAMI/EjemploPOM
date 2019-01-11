package com.sura.reclamaciones.definitions.empresariales;

import static com.sura.reclamaciones.constantes.Constantes.PAGO;
import static com.sura.reclamaciones.constantes.Constantes.RECUPERO;
import static com.sura.reclamaciones.constantes.Constantes.RESERVA;
import static com.sura.reclamaciones.constantes.NombresCsv.CONTRATO;
import static com.sura.reclamaciones.constantes.NombresCsv.PAGO_SINIESTRO;
import static com.sura.reclamaciones.utils.VariablesSesion.SESION_CC_TIPO_PRODUCTO_EMPRESARIAL;

import com.sura.reclamaciones.models.Contrato;
import com.sura.reclamaciones.models.PagoSiniestro;
import com.sura.reclamaciones.models.Recupero;
import com.sura.reclamaciones.steps.generics.GenericStep;
import com.sura.reclamaciones.steps.notificacionaviso.NuevaReclamacionEmpresarialStep;
import com.sura.reclamaciones.steps.pagos.NuevoPagoStep;
import com.sura.reclamaciones.steps.reaseguro.ReaseguroStep;
import com.sura.reclamaciones.steps.recupero.RecuperoStep;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Entonces;
import cucumber.api.java.es.Y;
import java.io.IOException;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;

public class ReaseguroDefinition {

  private String strTipoContrato =
      Serenity.sessionVariableCalled(SESION_CC_TIPO_PRODUCTO_EMPRESARIAL.getValor());
  private String strTransaccion = RESERVA.getValor();

  @Steps ReaseguroStep reaseguroStep;

  @Steps GenericStep genericStep;

  @Steps NuevoPagoStep nuevoPagoStep;

  @Steps RecuperoStep recuperoStep;

  @Steps NuevaReclamacionEmpresarialStep nuevaReclamacionEmpresarialStep;

  @Cuando(
      "^se realice al siniestro un pago (.*) a un (.*) por medio de (.*) el cual cuenta con una línea de reserva (.*) donde el responsable (.*) es Sura por una retención de (.*)$")
  public void realizarPagoSiniestroEmpresarial(
      String lineaReserva,
      String tipoPago,
      String beneficiarioPago,
      String metodoPago,
      String aplicaSoloSura,
      String codigoRetencion)
      throws IOException {
    strTransaccion = PAGO.getValor();
    PagoSiniestro pagoSiniestro =
        new PagoSiniestro((genericStep.getFilasModelo(PAGO_SINIESTRO.getValor(), strTipoContrato)));
    nuevoPagoStep.consultarNumeroReclamacion();
    nuevoPagoStep.ingresarInformacionBeneficiarioPago(
        lineaReserva,
        tipoPago,
        beneficiarioPago,
        metodoPago,
        aplicaSoloSura,
        codigoRetencion,
        pagoSiniestro.getLstPago());
  }

  @Y("^se realice al siniestro un recupero de tipo (.*) con un código de retención (.*)$")
  public void realizarRecuperoSiniestroEmpresarial(
      String strTipoRecupero, String strCodigoRetencionRecupero) throws IOException {
    strTransaccion = RECUPERO.getValor();
    Recupero recupero =
        new Recupero(genericStep.getFilasModelo(RECUPERO.getValor(), strTipoContrato));
    recuperoStep.seleccionarRecupero();
    recuperoStep.diligenciarCreacionRecupero(
        recupero.getLstRecupero(), strTipoRecupero, strCodigoRetencionRecupero);
  }

  @Entonces(
      "^para la transacción (.*) se distribuye el reaseguro según el retenido y el cedido de manera adecuada$")
  public void verificarReaseguro(String tipoTransaccion) throws IOException {
    if (strTransaccion.equals(RESERVA.getValor())) {
      nuevaReclamacionEmpresarialStep.visualizarResumenReclamacion();
    }
    Contrato contrato =
        new Contrato(genericStep.getFilasModelo(CONTRATO.getValor(), strTipoContrato));
    reaseguroStep.verificarReaseguro(contrato.getLstContrato(), strTransaccion);
  }
}

package com.sura.reclamaciones.definitions.empresariales;

import static com.sura.reclamaciones.constantes.Constantes.ESTADO_ANULACION;
import static com.sura.reclamaciones.constantes.NombresCsv.ANULACION_EMPRESARIAL;
import static com.sura.reclamaciones.constantes.NombresCsv.PAGO_SINIESTRO;
import static com.sura.reclamaciones.constantes.NombresCsv.RECUPERO;

import com.sura.reclamaciones.models.AnulacionEmpresarial;
import com.sura.reclamaciones.models.PagoSiniestro;
import com.sura.reclamaciones.models.Recupero;
import com.sura.reclamaciones.steps.anulacionempresarial.AnulacionEmpresarialStep;
import com.sura.reclamaciones.steps.generics.GenericStep;
import com.sura.reclamaciones.steps.notificacionaviso.ConsumoServicioCreacionSiniestroStep;
import com.sura.reclamaciones.steps.pagos.NuevoPagoStep;
import com.sura.reclamaciones.steps.recupero.RecuperoStep;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import cucumber.api.java.es.Y;
import java.io.IOException;
import net.thucydides.core.annotations.Steps;

public class AnulacionEmpresarialDefinition {

  @Steps GenericStep genericStep;

  @Steps AnulacionEmpresarialStep anulacionEmpresarialStep;

  @Steps RecuperoStep recuperoStep;

  @Steps NuevoPagoStep nuevoPagoStep;

  @Steps ConsumoServicioCreacionSiniestroStep crearSiniestro;

  Recupero recupero;
  AnulacionEmpresarial anulacionEmpresarial;
  PagoSiniestro pagoSiniestro;

  @Dado("^que se cree un siniestro de (.*)$")
  public void crearSiniestro(String strTipoProducto) throws IOException {
    crearSiniestro.asignarValoresSiniestro(strTipoProducto);
    crearSiniestro.siniestrarPolizaEmpresarialAtr();
  }

  @Y(
      "^que se realice un pago, de un siniestro de una póliza empresarial con producto (.*) y código de retención (.*)$")
  public void crearPago(String strTipoProducto, String strCodigoRetencion) throws IOException {
    pagoSiniestro =
        new PagoSiniestro((genericStep.getFilasModelo(PAGO_SINIESTRO.getValor(), strTipoProducto)));
    anulacionEmpresarial =
        new AnulacionEmpresarial(
            (genericStep.getFilasModelo(ANULACION_EMPRESARIAL.getValor(), strTipoProducto)));
    anulacionEmpresarial
        .getLstAnulacionEmpresarial()
        .forEach(
            ajustador -> {
              nuevoPagoStep.consultarNumeroReclamacion();
              nuevoPagoStep.ingresarInformacionBeneficiarioPago(
                  ajustador.getTipoPago(),
                  ajustador.getBeneficiarioPago(),
                  ajustador.getMetodoPago(),
                  ajustador.getLineaReserva(),
                  ajustador.getSoloSura(),
                  strCodigoRetencion,
                  pagoSiniestro.getLstPago());
            });
  }

  @Cuando("^se realice la anulación del pago$")
  public void anularPago() {
    anulacionEmpresarialStep.ingresarAnulacionPago(pagoSiniestro.getLstPago());
  }

  @Entonces("^se debe obtener la anulación del pago, quedando en estado anulado$")
  public void verificarAnulacionPago() {
    anulacionEmpresarialStep.verificarAnulacionRealizada(ESTADO_ANULACION.getValor());
  }

  @Y(
      "^que se realice una transacción de pago y una transacción de recupero, de un siniestro de una póliza empresarial con producto (.*) y código de retención (.*)$")
  public void crearPagoRecupero(String strTipoProducto, String strCodigoRetencion)
      throws IOException {
    pagoSiniestro =
        new PagoSiniestro((genericStep.getFilasModelo(PAGO_SINIESTRO.getValor(), strTipoProducto)));
    anulacionEmpresarial =
        new AnulacionEmpresarial(
            (genericStep.getFilasModelo(ANULACION_EMPRESARIAL.getValor(), strTipoProducto)));
    anulacionEmpresarial
        .getLstAnulacionEmpresarial()
        .forEach(
            ajustador -> {
              nuevoPagoStep.consultarNumeroReclamacion();
              nuevoPagoStep.ingresarInformacionBeneficiarioPago(
                  ajustador.getTipoPago(),
                  ajustador.getBeneficiarioPago(),
                  ajustador.getMetodoPago(),
                  ajustador.getLineaReserva(),
                  ajustador.getSoloSura(),
                  strCodigoRetencion,
                  pagoSiniestro.getLstPago());
            });
    recupero = new Recupero(genericStep.getFilasModelo(RECUPERO.getValor(), strTipoProducto));
    recuperoStep.seleccionarRecupero();
    recuperoStep.diligenciarCreacionRecupero(
        recupero.getLstRecupero(), recupero.getCategoriaRecupero(), strCodigoRetencion);
  }

  @Cuando("^se realice la anulación del recupero$")
  public void realizarAnulacionTransaccion() {
    anulacionEmpresarialStep.ingresarAnulacionRecupero(recupero.getLstRecupero());
  }

  @Entonces("^se debe obtener la anulación del recupero, quedando en estado anulado$")
  public void verificarAnulacionRecupero() {
    anulacionEmpresarialStep.verificarAnulacionRealizada(ESTADO_ANULACION.getValor());
  }
}

package com.sura.reclamaciones.steps.pagos;

import static com.sura.reclamaciones.constantes.Constantes.CANTIDAD;
import static com.sura.reclamaciones.constantes.Constantes.CODIGO_RETENCION;
import static com.sura.reclamaciones.constantes.Constantes.COMODIN;
import static com.sura.reclamaciones.constantes.Constantes.CUENTA;
import static com.sura.reclamaciones.constantes.Constantes.EXPOSICIONES;
import static com.sura.reclamaciones.constantes.Constantes.ITERACIONES_PAGO;
import static com.sura.reclamaciones.constantes.Constantes.LINEA_RESERVA_LESIONES_CORPORALES;
import static com.sura.reclamaciones.constantes.Constantes.OPCION_MENU;
import static com.sura.reclamaciones.constantes.Constantes.PAGOS;
import static com.sura.reclamaciones.constantes.Constantes.PLACA;
import static com.sura.reclamaciones.constantes.Constantes.RECLAMANTE_CONDUCTOR_AFECTADO;
import static com.sura.reclamaciones.constantes.Constantes.SELECCIONAR;
import static com.sura.reclamaciones.constantes.Constantes.UBICACION_ESTADO_PAGO;
import static com.sura.reclamaciones.constantes.Constantes.VALOR_CERO;
import static com.sura.reclamaciones.utils.VariablesSesion.SESION_CC_CONDUCTOR_AFECTADO_SINIESTRO;
import static com.sura.reclamaciones.utils.VariablesSesion.SESION_CC_TOTAL_PAGO_RESERVAS;

import com.sura.reclamaciones.models.ExposicionVehiculoTercero;
import com.sura.reclamaciones.models.PagoSiniestro;
import com.sura.reclamaciones.pages.autos.reclamacion.CreacionServicioPage;
import com.sura.reclamaciones.pages.autos.reclamacion.DetalleExposicionAutomaticaPage;
import com.sura.reclamaciones.pages.autos.reclamacion.DetalleVehiculoPage;
import com.sura.reclamaciones.pages.autos.reclamacion.ExposicionAutomaticaPage;
import com.sura.reclamaciones.pages.autos.reclamacion.NuevaExposicionPage;
import com.sura.reclamaciones.pages.autos.reclamacion.NuevoIncidenteVehicularPage;
import com.sura.reclamaciones.pages.generics.GeneralPage;
import com.sura.reclamaciones.pages.generics.MenuClaimPage;
import com.sura.reclamaciones.pages.generics.VerificacionDatosFinancierosPage;
import com.sura.reclamaciones.pages.notificacionaviso.ResumenReclamacionPage;
import com.sura.reclamaciones.pages.pagos.EstablecerInstruccionPagoPage;
import com.sura.reclamaciones.pages.pagos.IntroducirInformacionBeneficiarioPage;
import com.sura.reclamaciones.pages.pagos.IntroducirInformacionPagoPage;
import com.sura.reclamaciones.pages.procesoauditoria.AuditoriaPage;
import java.util.List;
import java.util.Map;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Step;
import org.fluentlenium.core.annotation.Page;
import org.hamcrest.MatcherAssert;
import org.openqa.selenium.WebElement;

public class NuevoPagoStep {

  List<WebElement> lstFilaPago;

  @Page MenuClaimPage menuClaimPage;

  @Page DetalleExposicionAutomaticaPage detalleExposicionAutomaticaPage;

  @Page IntroducirInformacionPagoPage introducirInformacionPagoPage;

  @Page IntroducirInformacionBeneficiarioPage introducirInformacionBeneficiarioPage;

  @Page VerificacionDatosFinancierosPage verificacionDatosFinancierosPage;

  @Page ExposicionAutomaticaPage exposicionAutomaticaPage;

  @Page EstablecerInstruccionPagoPage establecerInstruccionPagoPage;

  @Page GeneralPage generalPage;

  @Page ResumenReclamacionPage resumenReclamacionPage;

  @Page AuditoriaPage auditoriaPage;

  private static final String MENSAJE_RECHAZO_PAGO =
      "Elementos de línea : Para realizar el pago, primero debe verificar los detalles de investigación de auditoría";

  @Page NuevaExposicionPage nuevaExposicionManualPage;

  @Page NuevoIncidenteVehicularPage nuevoIncidenteVehicularPage;

  @Page DetalleVehiculoPage detalleVehiculoPage;

  @Page CreacionServicioPage crearServicioPage;

  @Step
  public void consultarNumeroReclamacion() {
    resumenReclamacionPage.obtenerNumeroReclamacion();
  }

  @Step
  public void ingresarInformacionBeneficiarioPago(
      String strBeneficiarioPago,
      String strMetodoPago,
      String strPagoSoloSura,
      List<PagoSiniestro> lstPago) {
    for (PagoSiniestro diligenciador : lstPago) {
      introducirInformacionBeneficiarioPage.seleccionarNombreBeneficiario(strBeneficiarioPago);
      introducirInformacionBeneficiarioPage.seleccionarTipoBeneficiario(
          diligenciador.getTipoBeneficiario());
      introducirInformacionBeneficiarioPage.seleccionarMetodoPago(
          strMetodoPago, CUENTA.getValor(), SELECCIONAR.getValor());
      introducirInformacionBeneficiarioPage.seleccionarPagoSura(strPagoSoloSura);
      introducirInformacionBeneficiarioPage.seleccionarPais(diligenciador.getPais());
      introducirInformacionBeneficiarioPage.seleccionarDepartamento(
          diligenciador.getDepartamento());
      introducirInformacionBeneficiarioPage.seleccionarCiudad(diligenciador.getCiudad());
      introducirInformacionBeneficiarioPage.seleccionarTipoDireccion(
          diligenciador.getTipoDireccion());
      generalPage.irSiguientePagina();
    }
  }

  @Step
  public void ingresarInformacionPago(
      String lineaReserva, String tipoPago, String codigoRetencion, List<PagoSiniestro> lstPago) {
    introducirInformacionPagoPage.seleccionarLineaReserva(lineaReserva);
    introducirInformacionPagoPage.seleccionarTipoPago(tipoPago);
    introducirInformacionPagoPage.ingresarComentario(lstPago.listIterator().next().getComentario());
    introducirInformacionPagoPage.ingresarCodigoRetencion(
        codigoRetencion, CODIGO_RETENCION.getValor());
    introducirInformacionPagoPage.ingresarCantidadPago(tipoPago, CANTIDAD.getValor());
  }

  @Step
  public void ingresarInstruccionesPago(String lineaReserva, List<PagoSiniestro> lstPago) {
    generalPage.irSiguientePagina();
    if (auditoriaPage.verificarMensajeRechazo()) {
      MatcherAssert.assertThat(
          "No generó la validación de NO pago a asegurado por proceso de auditoría",
          auditoriaPage.capturarMensajeRechazo().equalsIgnoreCase(MENSAJE_RECHAZO_PAGO));
    } else if (!lineaReserva.equals(LINEA_RESERVA_LESIONES_CORPORALES.getValor())) {
      establecerInstruccionPagoPage.obtenerPagoReservas();
      establecerInstruccionPagoPage.ingresarFechaFactura();
      establecerInstruccionPagoPage.ingresarNumeroFactura(
          lstPago.listIterator().next().getNumeroFactura());
      establecerInstruccionPagoPage.finalizarProceso();
    }
  }

  @Step
  public void agregarPagoNuevaLineaReserva() {
    introducirInformacionPagoPage.agregarNuevoPago();
  }

  @Step
  public void verificarPagoRealizado(List<PagoSiniestro> lstPago) {
    lstPago.forEach(
        (PagoSiniestro validador) -> {
          for (int i = 0; i <= Integer.parseInt(ITERACIONES_PAGO.getValor()); i++) {
            generalPage.realizarEsperaCarga();
            String strNumeroTransaccion =
                verificacionDatosFinancierosPage.obtenerNumeroPagoRealizado();
            lstFilaPago =
                verificacionDatosFinancierosPage.obtenerFilaTabla(
                    strNumeroTransaccion, verificacionDatosFinancierosPage.getTblPago());
            WebElement elementoXpath =
                lstFilaPago.get(Integer.parseInt(UBICACION_ESTADO_PAGO.getValor()));
            boolean estadoTransaccionPantalla =
                generalPage.actualizarPantalla(validador.getEstadoTransaccion(), elementoXpath);
            if (estadoTransaccionPantalla) break;
          }
          String strValorReserva =
              (Serenity.sessionVariableCalled(SESION_CC_TOTAL_PAGO_RESERVAS.getValor()).toString());
          MatcherAssert.assertThat(
              "El valor reservado no es igual al enviado",
              verificacionDatosFinancierosPage.verificarPagoMenuTransaccion(
                  strValorReserva, lstFilaPago));
          MatcherAssert.assertThat(
              "No llego a SAP el pago",
              verificacionDatosFinancierosPage.verificarPagoMenuTransaccion(
                  validador.getEstadoTransaccion(), lstFilaPago));
        });
  }

  @Step
  public void crearNuevoPago() {
    menuClaimPage.seleccionarBotonAcciones();
    menuClaimPage.seleccionarOpcionMenuAccionesPrimerNivel(PAGOS.getValor());
  }

  @Step
  public void seleccionarExposicionVehicularAsegurado() {
    menuClaimPage.seleccionarOpcionMenuLateralPrimerNivel(EXPOSICIONES.getValor());
    exposicionAutomaticaPage.seleccionarExposicion();
  }

  @Step
  public void declararReclamacionPerdidaTotal() {
    detalleExposicionAutomaticaPage.seleccionarCalculadoraPerdidaTotal();
    detalleExposicionAutomaticaPage.editarCalculadoraPerdidaTotal();
    detalleExposicionAutomaticaPage.seleccionarIncineracionTotalVehiculo();
    detalleExposicionAutomaticaPage.seleccionarMotorDestruidoFuego();
    detalleExposicionAutomaticaPage.seleccionarHabitaculoPasajerosIncinerado();
    detalleExposicionAutomaticaPage.actualizarCalculadoraPerdidaTotal();
  }

  @Step
  public void ingresarEstadoLegalReclamacion() {
    detalleExposicionAutomaticaPage.seleccionarDetalleExposicion();
    detalleExposicionAutomaticaPage.editarDetalleExposicion();
    detalleExposicionAutomaticaPage.ingresarEstadoLegalReclamacion();
    detalleExposicionAutomaticaPage.actualizarDetalleExposicion();
  }

  public void compararMensajesRechazoPago() {
    MatcherAssert.assertThat(
        "No generó la validación de NO pago a asegurado" + "por proceso de auditoría",
        auditoriaPage.capturarMensajeRechazo().equalsIgnoreCase(MENSAJE_RECHAZO_PAGO));
  }

  @Step
  public void consultarPlacaAsegurado() {
    Serenity.setSessionVariable(PLACA.getValor()).to(resumenReclamacionPage.consultarNumeroPlaca());
  }

  @Step
  public void crearExposicionVehicularManual(
      List<Map<String, String>> opcionesCrearExposicion,
      List<ExposicionVehiculoTercero> datosVehiculoTercero) {
    menuClaimPage.seleccionarBotonAcciones();
    for (int i = 0; i < opcionesCrearExposicion.size(); i++) {
      if (opcionesCrearExposicion
          .listIterator(i)
          .next()
          .get(OPCION_MENU.getValor())
          .equals(COMODIN.getValor())) {
        opcionesCrearExposicion
            .listIterator(i)
            .next()
            .replace(
                OPCION_MENU.getValor(),
                COMODIN.getValor(),
                Serenity.sessionVariableCalled(PLACA.getValor()));
      }
      String opcionMenu =
          opcionesCrearExposicion.listIterator(i).next().get(OPCION_MENU.getValor());
      menuClaimPage.seleccionarOpcionMenuAccionesPrimerNivel(opcionMenu);
    }
    nuevaExposicionManualPage.seleccionarReclamanteExposicion(
        Serenity.sessionVariableCalled(SESION_CC_CONDUCTOR_AFECTADO_SINIESTRO.getValor()));
    nuevaExposicionManualPage.seleccionarTipoReclamanteExposicion(
        RECLAMANTE_CONDUCTOR_AFECTADO.getValor());
    nuevaExposicionManualPage.crearNuevoIncidenteVehicular();
    nuevoIncidenteVehicularPage.ingresarPlacaVehiculoAfectado(datosVehiculoTercero);
    nuevoIncidenteVehicularPage.consultarInformacionVehiculoAfectado();
    nuevoIncidenteVehicularPage.seleccionarConductoVehiculoAfectado();
    nuevoIncidenteVehicularPage.seleccionarServiciosTaller();
    nuevoIncidenteVehicularPage.seleccionarTaller();
    detalleVehiculoPage.buscarProveedor();
    detalleVehiculoPage.realizarEsperaCarga();
    crearServicioPage.seleccionarProveedor(
        datosVehiculoTercero
            .get(Integer.parseInt(VALOR_CERO.getValor()))
            .getTallerReparacionAsignado());
    detalleVehiculoPage.aceptarOpcion();
    nuevoIncidenteVehicularPage.aceptarOpcion();
    nuevaExposicionManualPage.actualizarNuevaExposicion();
  }

  public void ingresarInformacionDetallePago(
      String strLineaReserva,
      String strTipoPago,
      String strCodigoRetencion,
      List<PagoSiniestro> lstPago) {
    for (PagoSiniestro diligenciador : lstPago) {
      introducirInformacionPagoPage.seleccionarLineaReserva(strLineaReserva);
      introducirInformacionPagoPage.seleccionarTipoPago(strTipoPago);
      introducirInformacionPagoPage.ingresarComentario(diligenciador.getComentario());
      introducirInformacionPagoPage.ingresarCodigoRetencion(
          strCodigoRetencion, CODIGO_RETENCION.getValor());
      introducirInformacionPagoPage.ingresarCantidadPago(strTipoPago, CANTIDAD.getValor());
      generalPage.irSiguientePagina();
      if (auditoriaPage.verificarMensajeRechazo()) {
        MatcherAssert.assertThat(
            "No generó la validación de NO pago a asegurado por proceso de auditoría",
            auditoriaPage.capturarMensajeRechazo().equalsIgnoreCase(MENSAJE_RECHAZO_PAGO));
      } else if (!strLineaReserva.equals(LINEA_RESERVA_LESIONES_CORPORALES.getValor())) {
        establecerInstruccionPagoPage.ingresarFechaFactura();
        establecerInstruccionPagoPage.ingresarNumeroFactura(diligenciador.getNumeroFactura());
        establecerInstruccionPagoPage.finalizarProceso();
      }
    }
  }
}

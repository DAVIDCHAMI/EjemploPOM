package com.sura.reclamaciones.steps.notificacionaviso;

import com.sura.reclamaciones.constantes.ReclamacionConstante;
import com.sura.reclamaciones.models.ReclamacionEmpresariales;
import com.sura.reclamaciones.pages.generics.MenuClaimPage;
import com.sura.reclamaciones.pages.notificacionaviso.BuscarPolizaPage;
import com.sura.reclamaciones.pages.notificacionaviso.InformacionBasicaPage;
import com.sura.reclamaciones.pages.notificacionaviso.InformacionReclamacionPage;
import com.sura.reclamaciones.pages.notificacionaviso.PropiedadesImplicadasPage;
import com.sura.reclamaciones.pages.notificacionaviso.ResumenReclamacionPage;
import com.sura.reclamaciones.steps.generics.UbicacionStep;
import java.util.List;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.steps.StepInterceptor;
import org.fluentlenium.core.annotation.Page;
import org.hamcrest.MatcherAssert;
import org.slf4j.LoggerFactory;

public class NuevaReclamacionEmpresarialStep {

  @Page BuscarPolizaPage buscarPolizaPage;
  @Page MenuClaimPage menuClaimPage;
  @Page InformacionReclamacionPage informacionReclamacionPage;
  @Page InformacionBasicaPage informacionBasicaPage;
  @Page PropiedadesImplicadasPage seleccionarPropiedadesImplicadasPage;
  @Page ResumenReclamacionPage resumenReclamacionPage;
  @Steps UbicacionStep ubicacionStep;
  public static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(StepInterceptor.class);

  public void diligenciarInformacionIncidente(
      List<ReclamacionEmpresariales> datosIncidente, String incidente) {
    datosIncidente.forEach(
        datos -> {
          informacionReclamacionPage.cerrarReclamosDuplicados();
          informacionReclamacionPage.seleccionarTipoIncidente(incidente);
          informacionReclamacionPage.finalizarSiniestro();
        });
  }

  public void seleccionarCausalIncidente(String causa, String valorPretension) {
    informacionReclamacionPage.seleccionarCausaSiniestro(causa);
    informacionReclamacionPage.escribirValorPretension(valorPretension);
  }

  public void validarReclamacion() {
    String verificar;
    verificar = informacionReclamacionPage.obtenerTituloReclamacionGenerada();
    MatcherAssert.assertThat(
        "No se ha obtenido el número de reclamación",
        verificar.equals(ReclamacionConstante.VALIDADOR_NUEVA_RECLAMACION));
  }

  public void seleccionarNuevaReclamacion(String nombreOpcion, String subItem) {
    menuClaimPage.seleccionarOpcionMenuSegundoNivel(nombreOpcion, subItem);
  }

  public void diligenciarInformacionPersonal(List<ReclamacionEmpresariales> datosAutor) {
    datosAutor.forEach(
        autor -> {
          informacionBasicaPage.seleccionarAutorReporte();
          informacionBasicaPage.escribirDetallehechos(autor.getDetalleHechos());
        });
  }

  public void seleccionarPropiedadImplicada() {
    seleccionarPropiedadesImplicadasPage.seleccionarPropiedad();
  }

  public void visualizarResumenReclamacion() {
    resumenReclamacionPage.obtenerNumeroReclamacion();
  }

  public void validarExposicionVisualizada(String exposicion) {
    String validar = resumenReclamacionPage.validarExposicion();
    MatcherAssert.assertThat(
        "No generó exposición, verificar las reglas de administración de exposiciones o data ingresada",
        validar.equals(exposicion));
  }

  public void validarReservaVisualizada(String monto) {
    String validar = resumenReclamacionPage.obtenerValorReserva();
    MatcherAssert.assertThat(
        "No generó reserva, verificar las reglas de administración de reserva o data ingresada",
        validar.equals(monto));
  }

  public void buscarPolizaEmpresarial(List<ReclamacionEmpresariales> datosPolizaEmpresarial) {
    datosPolizaEmpresarial.forEach(
        poliza -> {
          buscarPolizaPage.seleccionarOpcionBuscarPoliza();
          buscarPolizaPage.escribirNumeroPoliza(poliza.getNumPoliza());
          if (ReclamacionConstante.FECHA_HOY.equals(poliza.getFechaSiniestro())) {
            buscarPolizaPage.seleccionarFechaHoySiniestro();
          } else {
            buscarPolizaPage.escribirFechaSiniestro(poliza.getFechaSiniestro());
          }
          ubicacionStep.seleccionarUbicacion(datosPolizaEmpresarial);
          buscarPolizaPage.buscarPoliza();
        });
  }

  public void validarReservaDatosFinancieros(
      List<ReclamacionEmpresariales> datoReserva, String monto) {
    datoReserva.forEach(
        reserva -> {
          menuClaimPage.seleecionarOpcionMenuLateralPrimerNivel(
              ReclamacionConstante.DATOS_FINANCIEROS);
          String validar = resumenReclamacionPage.validarReservaResumen(monto);
          MatcherAssert.assertThat(
              "Se esperaba una reserva de: "
                  + monto
                  + ", pero se ha obtenido una reserva de: "
                  + validar,
              monto.equals(validar));
          menuClaimPage.seleccionarOpcionMenuLateralSegundoNivel(
              ReclamacionConstante.DATOS_FINANCIEROS, ReclamacionConstante.TRANSACCIONES);
          validar =
              resumenReclamacionPage.validarReservaTransaccion(reserva.getReservaTransaccion());
          MatcherAssert.assertThat(
              "Se esperaba una reserva de: "
                  + reserva.getReservaTransaccion()
                  + ", pero se ha obtenido una reserva de: "
                  + validar,
              reserva.getReservaTransaccion().equals(validar));
        });
  }
}

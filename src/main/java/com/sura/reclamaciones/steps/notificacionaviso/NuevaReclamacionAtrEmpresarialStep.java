package com.sura.reclamaciones.steps.notificacionaviso;

import static com.sura.reclamaciones.constantes.Constantes.EXPEDIENTE_CREADO_EXITOSAMENTE;

import com.sura.reclamaciones.constantes.MenuConstante;
import com.sura.reclamaciones.models.PersonaReclamacion;
import com.sura.reclamaciones.models.ReclamacionEmpresarial;
import com.sura.reclamaciones.pages.general.MenuClaimPage;
import com.sura.reclamaciones.pages.notificacionaviso.AsistenteVirtualAtrPage;
import com.sura.reclamaciones.pages.notificacionaviso.BuscarPolizaPage;
import com.sura.reclamaciones.pages.notificacionaviso.InformacionBasicaPage;
import com.sura.reclamaciones.pages.notificacionaviso.InformacionReclamacionPage;
import com.sura.reclamaciones.pages.reservas.ConsultaReclamacionPage;
import java.util.List;
import net.thucydides.core.annotations.Step;
import org.fluentlenium.core.annotation.Page;
import org.hamcrest.MatcherAssert;

public class NuevaReclamacionAtrEmpresarialStep {

  @Page AsistenteVirtualAtrPage asistenteVirtualAtrPage;

  @Page BuscarPolizaPage buscarPolizaPage;

  @Page InformacionBasicaPage informacionBasicaPage;

  @Page InformacionReclamacionPage informacionReclamacionPage;

  @Page ConsultaReclamacionPage consultaReclamacionPage;

  @Page MenuClaimPage menuClaimPage;

  @Step
  public void accederAvisoAtr() {
    asistenteVirtualAtrPage.accederAsistenteVirtual();
    asistenteVirtualAtrPage.accederAvisoEmpresa();
  }

  @Step
  public void diligenciarInformacionAsegurado(List<PersonaReclamacion> datosPersona) {
    asistenteVirtualAtrPage.seleccionarPlanListaProducto();
    buscarPolizaPage.enfocarVistaAutomatizacion();
    buscarPolizaPage.realizarEsperaCarga();
    datosPersona.forEach(
        asegurado ->
            buscarPolizaPage.seleccionarDocumentoAseguradoAtr(asegurado.getTipoDocumento()));
    datosPersona.forEach(
        asegurado -> buscarPolizaPage.digitarDocumentoAseguradoAtr(asegurado.getNumDocumento()));
    buscarPolizaPage.consultarDocumentoAseguradoAtr();
  }

  @Step
  public void diligenciarInformacionReclamacion(
      String causaSiniestro, List<ReclamacionEmpresarial> datosSiniestro) {
    datosSiniestro.forEach(
        datos -> informacionBasicaPage.seleccionarFechaAviso(datos.getFechaSiniestro()));
    informacionReclamacionPage.seleccionarCausaSiniestroAtr(causaSiniestro);
    datosSiniestro.forEach(
        datos -> informacionReclamacionPage.diligenciarDetalleHechosAtr(datos.getDetalleHechos()));
    informacionReclamacionPage.seleccionarCiudadSiniestro();
  }

  @Step
  public void consultarPolizaAtr() {
    buscarPolizaPage.consultarPolizaAseguradoAtr();
    buscarPolizaPage.seleccionarPolizaAtr();
    buscarPolizaPage.seleccionarRiegoPolizaAtr();
  }

  @Step
  public void diligenciarValorPretension(String valorPretension) {
    informacionReclamacionPage.ingresarValorPretensionAtr(valorPretension);
    informacionReclamacionPage.enviarReclamacion();
  }

  @Step
  public String verificarSiniestroCreadoAtr() {
    MatcherAssert.assertThat(
        "No se generó el número de siniestro en ATR",
        asistenteVirtualAtrPage
            .getLblTituloExpedienteCreado()
            .equalsIgnoreCase(EXPEDIENTE_CREADO_EXITOSAMENTE.getValor()));
    return informacionReclamacionPage.obtenerNumeroSiniestroAtr();
  }

  @Step
  public void consultarSiniestro(String numeroReclamacion) {
    consultaReclamacionPage.buscarReclamacion(numeroReclamacion);
    menuClaimPage.seleccionarOpcionMenuLateralPrimerNivel(MenuConstante.DETALLES_SINIESTRO);
    MatcherAssert.assertThat(
        "No se encontró el número de siniestro generado en ATR",
        consultaReclamacionPage.getLblNumeroSiniestro().equalsIgnoreCase(numeroReclamacion));
  }
}

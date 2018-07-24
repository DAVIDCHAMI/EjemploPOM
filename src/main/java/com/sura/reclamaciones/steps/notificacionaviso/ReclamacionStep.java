package com.sura.reclamaciones.steps.notificacionaviso;

import com.sura.reclamaciones.models.Lugar;
import com.sura.reclamaciones.models.Reclamacion;
import com.sura.reclamaciones.pages.autos.reclamacion.AgregarInformacionPage;
import com.sura.reclamaciones.pages.autos.reclamacion.DetalleVehiculoPage;
import com.sura.reclamaciones.pages.autos.reclamacion.InformacionBasicaPage;
import com.sura.reclamaciones.pages.autos.reclamacion.NuevaReclamacionGuardadaPage;
import com.sura.reclamaciones.pages.notificacionaviso.BuscarPolizaPage;
import net.thucydides.core.annotations.Step;
import org.fluentlenium.core.annotation.Page;
import org.hamcrest.MatcherAssert;

import java.util.List;

public class ReclamacionStep {

    @Page
    private InformacionBasicaPage informacionBasicaPage;

    @Page
    private BuscarPolizaPage buscarPolizaPage;

    @Page
    private AgregarInformacionPage agregarInformacionPage;

    @Page
    private DetalleVehiculoPage detalleVehiculoPage;

    @Page
    private NuevaReclamacionGuardadaPage nuevaReclamacionGuardadaPage;

    @Step
    public void completarDetalleSiniestro(List<Reclamacion> datosReclamacion) {
        datosReclamacion.forEach(
                dato -> {
                    if (agregarInformacionPage.getBtnCerrarVentanaEmergente().isVisible()) {
                        agregarInformacionPage.cliquearBotonCerrar();
                    }
                    agregarInformacionPage.seleccionarLugar();
                    agregarInformacionPage.escribirSucedido(dato.getSucedido());
                    agregarInformacionPage.seleccionarCausa(dato.getCausa());
                    agregarInformacionPage.seleccionarOrigen(dato.getOrigen());
                    agregarInformacionPage.escribirValorPretension(dato.getValorPredeterminado());
                    agregarInformacionPage.seleccionarIntervinoAutoridad(dato.getAutoridad());
                });
    }

    @Step
    public void completarCategorizacion(List<Reclamacion> datosReclamacion) {
        datosReclamacion.forEach(
                dato -> {
                    agregarInformacionPage.seleccionarCulpabilidad(dato.getCulpabilidad());
                }
        );
    }

    @Step
    public void editarVehiculo() {
        agregarInformacionPage.cliquearBotonEditarVehiculo();
        detalleVehiculoPage.agregarConductor();
        detalleVehiculoPage.seleccionarTaller();
    }


    public void seleccionarNombreAutorReporte() {
        informacionBasicaPage.seleccionarNombre();
        buscarPolizaPage.cliquearSiguiente();
    }


    public void validarReclamacion(List<Reclamacion> reclamaciones) {
        reclamaciones.forEach(
                dato -> {
                    String mensajeValidado =  nuevaReclamacionGuardadaPage.obtenerMensajeValidador();
                    MatcherAssert.assertThat("No se encontro el mensaje a validar", mensajeValidado.equals(dato.getMensajeValidar()));
                }
        );

    }
}

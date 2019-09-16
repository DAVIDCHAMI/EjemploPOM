package com.sura.reclamaciones.steps.pagos;

import com.sura.reclamaciones.models.ExposicionVehiculoTercero;
import com.sura.reclamaciones.pages.autos.reclamacion.*;
import com.sura.reclamaciones.pages.generics.MenuClaimPage;
import com.sura.reclamaciones.pages.notificacionaviso.ResumenReclamacionPage;
import com.sura.reclamaciones.pages.pagos.IntroducirInformacionPagoPage;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Step;
import org.fluentlenium.core.annotation.Page;

import java.util.List;
import java.util.Map;

import static com.sura.reclamaciones.constantes.Constantes.*;
import static com.sura.reclamaciones.utils.VariablesSesion.SESION_CC_CONDUCTOR_AFECTADO_SINIESTRO;

public class NuevoPagoStep {

    @Page
    MenuClaimPage menuClaimPage;

    @Page
    DetalleExposicionAutomaticaPage detalleExposicionAutomaticaPage;

    @Page
    IntroducirInformacionPagoPage introducirInformacionPagoPage;

    @Page
    ExposicionAutomaticaPage exposicionAutomaticaPage;

    @Page
    ResumenReclamacionPage resumenReclamacionPage;

    @Page
    NuevaExposicionPage nuevaExposicionManualPage;

    @Page
    NuevoIncidenteVehicularPage nuevoIncidenteVehicularPage;

    @Page
    DetalleVehiculoPage detalleVehiculoPage;

    @Page
    CreacionServicioPage crearServicioPage;

    @Step
    public void consultarNumeroReclamacion() {
        resumenReclamacionPage.obtenerNumeroReclamacion();
    }

    @Step
    public void agregarPagoNuevaLineaReserva() {
        introducirInformacionPagoPage.agregarNuevoPago();
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
}

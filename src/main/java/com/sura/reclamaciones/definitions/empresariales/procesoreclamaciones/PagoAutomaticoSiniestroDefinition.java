package com.sura.reclamaciones.definitions.empresariales.procesoreclamaciones;

import com.sura.reclamaciones.constantes.MenuConstante;
import com.sura.reclamaciones.constantes.NombresCsv;
import com.sura.reclamaciones.models.ReclamacionEmpresarial;
import com.sura.reclamaciones.models.Reserva;
import com.sura.reclamaciones.steps.generics.MenuClaimsStep;
import com.sura.reclamaciones.steps.notificacionaviso.BuscarPolizaStep;
import com.sura.reclamaciones.steps.notificacionaviso.DatosFinancierosStep;
import com.sura.reclamaciones.steps.notificacionaviso.InformacionBasicaStep;
import com.sura.reclamaciones.steps.notificacionaviso.InformacionReclamacionStep;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import cucumber.api.java.es.Y;
import net.thucydides.core.annotations.Steps;

import java.io.IOException;

import static com.sura.reclamaciones.constantes.Constantes.DATOS_FINANCIEROS;
import static com.sura.reclamaciones.constantes.MenuConstante.TRANSACCIONES;
import static com.sura.reclamaciones.utils.UtilidadesCSV.obtenerDatosPrueba;

public class PagoAutomaticoSiniestroDefinition {

    ReclamacionEmpresarial reclamacionEmpresarial;

    Reserva reserva;

    @Steps
    MenuClaimsStep menuClaimsStep;

    @Steps
    BuscarPolizaStep buscarPolizaStep;

    @Steps
    InformacionBasicaStep informacionBasicaStep;

    @Steps
    InformacionReclamacionStep informacionReclamacionStep;

    @Steps
    DatosFinancierosStep datosFinancierosStep;

    String productoPoliza = "";

    @Dado("^que se tiene una póliza del producto (.*)$")
    public void obtenerPoliza(String producto) throws IOException {
        productoPoliza = producto;
        reclamacionEmpresarial =
                new ReclamacionEmpresarial(
                        obtenerDatosPrueba(NombresCsv.RECLAMACION_EMPRESARIAL.getValor(), productoPoliza));
        menuClaimsStep.seleccionarOpcionMenuSegundoNivel(
                MenuConstante.RECLAMACION_MENU, MenuConstante.NUEVA_RECLAMACION_MENU);
        buscarPolizaStep.buscarPolizaEmpresarial(reclamacionEmpresarial.getLstReclamo());
    }

    @Cuando("^se realiza un siniestro por causa (.*) con valor de pretensión (.*) e incidente (.*)$")
    public void realizarSiniestro(String causa, String valorPretension, String tipoIncidente) {
        informacionBasicaStep.diligenciarInformacionBasica(reclamacionEmpresarial.getLstReclamo());
        informacionReclamacionStep.diligenciarInformacionReclamacion(
                causa, valorPretension, tipoIncidente);
    }

    @Entonces("^se genera una reclamación con exposición automática (.*)$")
    public void verificarGeneracionExposicionAutomatica(String tipoExposicion) throws Throwable {
        //TO DO
    }

    @Y("^una reserva automática$")
    public void verificarGeneracionReservaAutomatica() throws IOException {
        reserva =
                new Reserva(
                        obtenerDatosPrueba(NombresCsv.PARAMETRO_LINEA_RESERVA.getValor(), productoPoliza));
        menuClaimsStep.seleccionarOpcionMenuLateralSegundoNivel(DATOS_FINANCIEROS.getValor(), TRANSACCIONES);
        datosFinancierosStep.verificarMontoReservaAutomatica(reserva.getLstReserva());
    }

    @Y("^un pago automático con un monto de (.*)$")
    public void verificarGeneracionPagoAutomatico(String montoPago) throws Throwable {
        //TO DO
    }
}

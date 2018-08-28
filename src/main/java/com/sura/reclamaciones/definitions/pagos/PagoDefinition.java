package com.sura.reclamaciones.definitions.pagos;

import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import com.sura.reclamaciones.steps.pagos.NuevoPagoStep;
import net.thucydides.core.annotations.Steps;

public class PagoDefinition {

    @Steps NuevoPagoStep nuevoPagoStep;

    @Dado("^que se tiene el siniestro (.*)  del producto (.*)$")
    public void que_se_tiene_el_siniestro_del_producto(String numeroReclamacion, String producto) throws Exception {
        // Write code here that turns the phrase above into concrete actions

        nuevoPagoStep.consultarNumeroReclamacion(numeroReclamacion);
    }


    @Cuando("^se realice un pago (.*) a un (.*) por medio de (.*) el cual cuenta con una linea de reserva (.*) donde el responsable (.*) es Sura por una retención de (.*)$")
    public void se_realice_un_pago_a_un_por_medio_de_el_cual_cuenta_con_una_linea_de_reserva_donde_el_responsable_es_Sura_por_una_retención_de(String tipoPago, String beneficiarioPago, String metodoPago, String lineaReserva, String soloSura, String codigoRetencion) throws Exception {
        // Write code here that turns the phrase above into concrete actions
        nuevoPagoStep.ingresarInformacionBeneficiarioPago(tipoPago, beneficiarioPago, metodoPago, lineaReserva, soloSura, codigoRetencion);
    }

    @Entonces("^se genera una orden de pago para que le sea entregado al usuario$")
    public void se_genera_una_orden_de_pago_para_que_le_sea_entregado_al_usuario() throws Exception {
        // Write code here that turns the phrase above into concrete actions

    }

}

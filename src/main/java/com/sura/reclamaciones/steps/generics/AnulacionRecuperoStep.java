package com.sura.reclamaciones.steps.generics;

import com.sura.reclamaciones.constantes.MenuConstante;
import com.sura.reclamaciones.models.Recupero;
import com.sura.reclamaciones.pages.anulaciontransaccion.DatoRecuperacionPage;
import com.sura.reclamaciones.pages.generics.DatoFinancieroTransaccionPage;
import com.sura.reclamaciones.pages.generics.MenuClaimPage;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Step;
import org.fluentlenium.core.annotation.Page;
import org.hamcrest.MatcherAssert;

import java.util.List;

import static com.sura.reclamaciones.constantes.Constantes.TIPO_TRANSACCION;
import static com.sura.reclamaciones.utils.VariablesSesion.SESION_CC_NUMERO_TRANSACCION;

public class AnulacionRecuperoStep {

    @Page
    MenuClaimPage menuClaimPage;

    @Page
    DatoRecuperacionPage datoRecuperacionPage;

    @Page
    DatoFinancieroTransaccionPage datoFinancieroTransaccionPage;

    @Step
    public void ingresarAnulacionRecupero(List<Recupero> lstRecupero) {
        menuClaimPage.seleccionarOpcionMenuLateralSegundoNivel(
                MenuConstante.DATOS_FINANCIEROS, MenuConstante.TRANSACCIONES);
        for (Recupero diligenciador : lstRecupero) {
            String strNumeroTransaccion =
                    datoRecuperacionPage.obtenerDatoTablaCabecera(
                            SESION_CC_NUMERO_TRANSACCION.getValor(), 1);
            menuClaimPage.seleccionarOpcionMenuLateralSegundoNivel(
                    MenuConstante.DATOS_FINANCIEROS, MenuConstante.TRANSACCIONES);
            datoFinancieroTransaccionPage.seleccionarTipoTransaccion(TIPO_TRANSACCION.getValor());
            MatcherAssert.assertThat(
                    "El estado de la transaccion no permite que sea anulada",
                    datoFinancieroTransaccionPage.ingresarDatoRecuperacion(
                            strNumeroTransaccion, diligenciador.getEstadoTransaccion()));
            MatcherAssert.assertThat(
                    "El número de transaccion, no tiene habilitado el boton de anular",
                    datoRecuperacionPage.realizarAnulacionRecupero());
            Serenity.setSessionVariable(SESION_CC_NUMERO_TRANSACCION.getValor()).to(strNumeroTransaccion);
        }
    }

    @Step
    public void verificarAnulacionRecupero(String strAnulacionPago) {
        String strNumeroTransaccion =
                Serenity.sessionVariableCalled(SESION_CC_NUMERO_TRANSACCION.getValor());
        menuClaimPage.seleccionarOpcionMenuLateralSegundoNivel(
                MenuConstante.DATOS_FINANCIEROS, MenuConstante.TRANSACCIONES);
        datoFinancieroTransaccionPage.seleccionarTipoTransaccion(TIPO_TRANSACCION.getValor());
        MatcherAssert.assertThat(
                "El recupero no quedo en estado anulado",
                datoFinancieroTransaccionPage.verificarEstadoAnuladoRecupero(
                        strAnulacionPago, strNumeroTransaccion, datoRecuperacionPage.getTblTransaccion()));
    }
}

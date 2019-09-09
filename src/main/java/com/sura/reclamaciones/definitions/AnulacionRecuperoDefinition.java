package com.sura.reclamaciones.definitions;

import com.sura.reclamaciones.models.Recupero;
import com.sura.reclamaciones.steps.generics.AnulacionTransaccionStep;
import com.sura.reclamaciones.steps.generics.GenericStep;
import com.sura.reclamaciones.steps.recupero.RecuperoStep;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Entonces;
import cucumber.api.java.es.Y;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;

import java.io.IOException;

import static com.sura.reclamaciones.constantes.Constantes.ESTADO_ANULACION;
import static com.sura.reclamaciones.constantes.NombresCsv.RECUPERO_SINIESTRO;
import static com.sura.reclamaciones.utils.VariablesSesion.SESION_CC_TIPO_PRODUCTO_EMPRESARIAL;

public class AnulacionRecuperoDefinition {

    @Steps
    GenericStep genericStep;

    @Steps
    AnulacionTransaccionStep anulacionTransaccionStep;

    @Steps
    RecuperoStep recuperoStep;

    Recupero recupero;

    @Cuando("^se realice la anulación del recupero$")
    public void anularTransaccionRecuperoEmpresariales() throws IOException {
        recupero =
                new Recupero(
                        genericStep.getFilasModelo(
                                RECUPERO_SINIESTRO.getValor(),
                                Serenity.sessionVariableCalled(SESION_CC_TIPO_PRODUCTO_EMPRESARIAL.getValor())));
        anulacionTransaccionStep.ingresarAnulacionRecupero(recupero.getLstRecupero());
    }

    @Cuando("^se anula el ingreso con cobertura (.*)$")
    public void anularTransaccionRecuperoAutos(String cobertura) throws IOException {
        recupero = new Recupero((genericStep.getFilasModelo(RECUPERO_SINIESTRO.getValor(), cobertura)));
        anulacionTransaccionStep.ingresarAnulacionRecupero(recupero.getLstRecupero());
    }

    @Y(
            "^una transacción de recupero, de un siniestro de una póliza empresarial con producto (.*) y código de retención (.*)$")
    public void crearRecuperoAvisoSiniestro(String strTipoProducto, String strCodigoRetencion)
            throws IOException {
        recupero =
                new Recupero(
                        genericStep.getFilasModelo(
                                RECUPERO_SINIESTRO.getValor(),
                                Serenity.sessionVariableCalled(SESION_CC_TIPO_PRODUCTO_EMPRESARIAL.getValor())));
        recuperoStep.diligenciarCreacionRecupero(
                recupero.getLstRecupero(), recupero.getCategoriaRecupero(), strCodigoRetencion);
    }

    @Entonces("^se debe obtener la anulación del recupero, quedando en estado anulado$")
    public void verificarAnulacionRecupero() {
        anulacionTransaccionStep.verificarAnulacionRealizada(ESTADO_ANULACION.getValor());
    }
}

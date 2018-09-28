package com.sura.reclamaciones.definitions.modelosimplificado;

import com.sura.reclamaciones.models.TransaccionModeloSimplificado;
import com.sura.reclamaciones.steps.generics.GenericStep;
import com.sura.reclamaciones.steps.modelosimplificado.ConsultarTransaccionModeloSimplificadoStep;
import cucumber.api.java.ast.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import java.io.IOException;
import java.sql.SQLException;
import net.thucydides.core.annotations.Steps;

public class ConsultaTransaccionModeloSimplificadoDefinition {

  String movimientoFinanciero;

  @Steps TransaccionModeloSimplificado transaccionModeloSimplificado;

  @Steps TransaccionModeloSimplificado transaccionModeloSimplificadoBD;

  @Steps private GenericStep genericStep;

  @Steps ConsultarTransaccionModeloSimplificadoStep conexionBDStep;

  @Dado("^que se realiza un (.*)$")
  public void realizarConexionModeloSimplificado(String movimientoFinanciero) {
    this.movimientoFinanciero = movimientoFinanciero;
  }

  @Cuando("^la transaccion se ha efectuado$")
  public void ejecutarConsultaModeloSimplificado() throws SQLException, IOException {
    transaccionModeloSimplificado =
        new TransaccionModeloSimplificado(
            genericStep.getFilasModelo("reaseguro_modelo_simplificado", movimientoFinanciero));
    transaccionModeloSimplificadoBD =
        new TransaccionModeloSimplificado(
            conexionBDStep.consultarModeloSimplificado(
                transaccionModeloSimplificado.getlstModeloSimplificado(), movimientoFinanciero));
  }

  @Entonces("^en las fuentes del tablero deben quedar correctos los valores de reaseguro$")
  public void obtenerDatosModeloSimplificado() {
    conexionBDStep.verficarConsultaModeloSimplificado(
        transaccionModeloSimplificadoBD.getlstModeloSimplificado(),
        transaccionModeloSimplificado.getlstModeloSimplificado());
  }
}

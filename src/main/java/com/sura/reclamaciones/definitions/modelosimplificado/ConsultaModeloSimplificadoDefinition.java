package com.sura.reclamaciones.definitions.modelosimplificado;

import com.sura.reclamaciones.models.ModeloSimplificado;
import com.sura.reclamaciones.models.ModeloSimplificadoBD;
import com.sura.reclamaciones.steps.generics.GenericStep;
import com.sura.reclamaciones.steps.modelosimplificado.ConsultarModeloSimplificadoStep;
import cucumber.api.java.ast.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import java.io.IOException;
import java.sql.SQLException;
import net.thucydides.core.annotations.Steps;

public class ConsultaModeloSimplificadoDefinition {

  String movimientoFinanciero;

  @Steps ModeloSimplificado modeloSimplificado;

  @Steps private GenericStep genericStep;

  @Steps ConsultarModeloSimplificadoStep conexionBDStep;

  ModeloSimplificadoBD modeloSimplificadoBD;

  @Dado("^que se realiza un (.*)$")
  public void realizarConexionModeloSimplificado(String movimientoFinanciero) throws IOException {
    this.movimientoFinanciero = movimientoFinanciero;
    modeloSimplificado =
        new ModeloSimplificado(
            genericStep.getFilasModelo("reaseguro_modelo_simplificado", movimientoFinanciero));
  }

  @Cuando("^la transaccion se ha efectuado$")
  public void ejecutarConsultaModeloSimplificado() throws SQLException, IOException {
    modeloSimplificadoBD =
        new ModeloSimplificadoBD(
            conexionBDStep.consultarModeloSimplificado(
                modeloSimplificado.getlstModeloSimplificado(),
                movimientoFinanciero));
  }

  @Entonces("^en las fuentes del tablero deben quedar correctos los valores de reaseguro$")
  public void obtenerDatosModeloSimplificado() {
    conexionBDStep.verficarConsultaModeloSimplificado(
        modeloSimplificadoBD.getLstModeloSimplificadoBD(),
        modeloSimplificado.getlstModeloSimplificado());
  }
}

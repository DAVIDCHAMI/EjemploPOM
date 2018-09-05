package com.sura.reclamaciones.definitions.modelosimplificado;

import com.sura.reclamaciones.models.Credencial;
import com.sura.reclamaciones.models.ModeloSimplificado;
import com.sura.reclamaciones.models.TablaModeloSimplificado;
import com.sura.reclamaciones.steps.generics.GenericStep;
import com.sura.reclamaciones.steps.modelosimplificado.ConsultarModeloSimplificadoStep;
import cucumber.api.java.ast.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import net.thucydides.core.annotations.Steps;

public class ConsultaModeloSimplificadoDefinition {

  Connection conexion = null;

  String movimientoFinanciero;

  @Steps Credencial credencial;

  @Steps ModeloSimplificado modeloSimplificado;

  @Steps private GenericStep genericStep;

  @Steps ConsultarModeloSimplificadoStep conexionBDStep;

  TablaModeloSimplificado tablaModeloSimplificado;

  @Dado("^que se realiza un (.*)$")
  public void realizarConexionModeloSimplificado(String transaccionFinanciera) throws IOException {
    movimientoFinanciero= transaccionFinanciera;
    modeloSimplificado =
        new ModeloSimplificado(
            genericStep.getFilasModelo("reaseguro_modelo_simplificado", transaccionFinanciera));
  }

  @Cuando("^la transaccion se ha efectuado$")
  public void ejecutarConsultaModeloSimplificado() throws SQLException, IOException {
    credencial = new Credencial(genericStep.getFilasModelo("credencial", "conexionGWBD"));
    List<Credencial> datosCredencial = credencial.getCredenciales();
    conexion = conexionBDStep.conectarBaseDatos(datosCredencial);
    tablaModeloSimplificado =
        new TablaModeloSimplificado(
            conexionBDStep.consultarModeloSimplificado(
                conexion, modeloSimplificado.getlstModeloSimplificado(), movimientoFinanciero));
  }

  @Entonces("^en las fuentes del tablero deben quedar correctos los valores de reaseguro$")
  public void obtenerDatosModeloSimplificado() {
    conexionBDStep.verficarConsultaModeloSimplificado(
        tablaModeloSimplificado.getLstTablaModeloSimplificado(), modeloSimplificado.getlstModeloSimplificado());
  }
}

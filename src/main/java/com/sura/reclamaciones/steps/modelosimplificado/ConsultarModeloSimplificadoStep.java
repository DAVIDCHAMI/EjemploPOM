package com.sura.reclamaciones.steps.modelosimplificado;

import com.sura.reclamaciones.models.CredencialBD;
import com.sura.reclamaciones.models.ModeloSimplificado;
import com.sura.reclamaciones.models.ModeloSimplificadoBD;
import com.sura.reclamaciones.pages.modelosimplificado.ConsultarModeloSimplificado;
import com.sura.reclamaciones.utils.ConexionBaseDatosUtil;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import net.thucydides.core.annotations.Step;
import org.fluentlenium.core.annotation.Page;
import org.hamcrest.MatcherAssert;

public class ConsultarModeloSimplificadoStep {

  Connection conexion = null;
  String transaccionConsulta = null;
  String sql = new String();
  List<Map<String, String>> resultadoConsulta = null;

  @Page
  ConsultarModeloSimplificado consultarModeloSimplificado = new ConsultarModeloSimplificado();

  @Step
  public Connection conectarBaseDatos(List<CredencialBD> datosCredenciales) {
    datosCredenciales.forEach(
        datoCredencial ->
            conexion =
                ConexionBaseDatosUtil.conectarBaseDatos(
                    datoCredencial.getUsuario(), datoCredencial.getContrasena(),
                    datoCredencial.getURL(), datoCredencial.getDriver()));
    return conexion;
  }

  public List<Map<String, String>> consultarModeloSimplificado(
      List<CredencialBD> credenciales,
      List<ModeloSimplificado> datosTransaccion,
      String movimientoFinanciero)
      throws SQLException {
    sql = consultarModeloSimplificado.obtenerSentenciaSql(movimientoFinanciero);
    datosTransaccion.forEach(
        datoTransaccion -> transaccionConsulta = datoTransaccion.getTransaccion());
    conexion = conectarBaseDatos(credenciales);
    resultadoConsulta =
        consultarModeloSimplificado.consultarModeloSimplificado(conexion, transaccionConsulta, sql);
    return resultadoConsulta;
  }

  public void verficarConsultaModeloSimplificado(
      List<ModeloSimplificadoBD> resultadoConsulta, List<ModeloSimplificado> datosTransaccion) {
    for (int i = 0; i < resultadoConsulta.size(); i++) {
      ModeloSimplificadoBD resultadoBD = resultadoConsulta.get(i);
      ModeloSimplificado resultadoCalculado = datosTransaccion.get(i);
      MatcherAssert.assertThat(
          "No coincide el valor cedido a las reaseguradoras",
          resultadoBD
              .getValorCedidoReaseguradoras()
              .equals(resultadoCalculado.getValorCedidoReaseguradoras()));
      MatcherAssert.assertThat(
          "No coincide el valor neto",
          resultadoBD.getValorNeto().equals(resultadoCalculado.getValorNeto()));
      MatcherAssert.assertThat(
          "No coincide el valor Transacción",
          resultadoBD
              .getValorMovimientoFinanciero()
              .equals(resultadoCalculado.getValorMovimientoFinanciero()));
    }
  }
}

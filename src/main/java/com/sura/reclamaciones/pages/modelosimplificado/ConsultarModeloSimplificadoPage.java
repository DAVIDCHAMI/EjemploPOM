package com.sura.reclamaciones.pages.modelosimplificado;

import com.sura.reclamaciones.querys.Query;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConsultarModeloSimplificadoPage {

  public ConsultarModeloSimplificadoPage() {
    super();
  }

  public ResultSet consultarModeloSimplificado(Connection bd, String transaccion)
      throws SQLException {
    Query sqlConsulta = Query.SqlModeloSimplificadoReserva;
    String sql = sqlConsulta.getConsultaSql();
    PreparedStatement stmt = null;
    stmt = bd.prepareStatement(sql);
    stmt.setString(1, transaccion);
    ResultSet rs = stmt.executeQuery();
    return rs;
  }
}

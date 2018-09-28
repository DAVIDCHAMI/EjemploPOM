package com.sura.reclamaciones.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TransaccionModeloSimplificado {

  public String numeroMovimientoFinanciero;
  public String numeroReclamacion;
  public String valorCedidoReaseguradoras;
  public String valorNeto;
  public String valorMovimientoFinanciero;
  public String estadoMovimientoFinanciero;
  public List<TransaccionModeloSimplificado> lstTransaccionModeloSimplificado = new ArrayList<>();

  private TransaccionModeloSimplificado(Map<String, String> datosModeloSimplificado) {
    if (datosModeloSimplificado.containsKey("NUMERORECLAMACION")) {
      obtenerCamposBaseDatos(datosModeloSimplificado);
    } else {
      obtenerCamposCsv(datosModeloSimplificado);
    }
  }

  public void obtenerCamposBaseDatos(Map<String, String> datosModeloSimplificado) {
    this.numeroReclamacion = datosModeloSimplificado.get("NUMERORECLAMACION");
    this.numeroMovimientoFinanciero = datosModeloSimplificado.get("NUMEROMOVIMIENTOFINANCIERO");
    this.valorMovimientoFinanciero = datosModeloSimplificado.get("VALORMOVIMIENTOFINANCIERO");
    this.valorCedidoReaseguradoras = datosModeloSimplificado.get("VALORCEDIDOREASEGURADORAS");
    this.valorNeto = datosModeloSimplificado.get("VALORNETO");
    this.estadoMovimientoFinanciero = datosModeloSimplificado.get("ESTADOMOVIMIENTOFINANCIERO");
  }

  public void obtenerCamposCsv(Map<String, String> datosModeloSimplificado) {
    this.numeroReclamacion = datosModeloSimplificado.get("numeroReclamacion");
    this.numeroMovimientoFinanciero = datosModeloSimplificado.get("numeroMovimientoFinanciero");
    this.valorMovimientoFinanciero = datosModeloSimplificado.get("valorMovimientoFinanciero");
    this.valorCedidoReaseguradoras = datosModeloSimplificado.get("valorCedidoReaseguradoras");
    this.valorNeto = datosModeloSimplificado.get("valorNeto");
    this.estadoMovimientoFinanciero = datosModeloSimplificado.get("estadoMovimientoFinanciero");
  }

  public TransaccionModeloSimplificado(List<Map<String, String>> datosModeloSimplificado) {
    asignarDatos(datosModeloSimplificado);
  }

  public TransaccionModeloSimplificado() {}

  public String getTransaccion() {
    return numeroMovimientoFinanciero;
  }

  public String getValorMovimientoFinanciero() {
    return valorMovimientoFinanciero;
  }

  public String getValorCedidoReaseguradoras() {
    return valorCedidoReaseguradoras;
  }

  public String getValorNeto() {
    return valorNeto;
  }

  public String getNumeroReclamacion() {
    return numeroReclamacion;
  }

  public String getEstadoMovimientoFinanciero() {
    return estadoMovimientoFinanciero;
  }

  public List<TransaccionModeloSimplificado> getlstModeloSimplificado() {
    return lstTransaccionModeloSimplificado;
  }

  public void asignarDatos(List<Map<String, String>> datosModeloSimplificado) {
    for (Map<String, String> dato : datosModeloSimplificado) {
      lstTransaccionModeloSimplificado.add(new TransaccionModeloSimplificado(dato));
    }
  }
}

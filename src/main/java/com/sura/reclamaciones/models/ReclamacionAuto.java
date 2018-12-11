package com.sura.reclamaciones.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ReclamacionAuto extends Reclamacion {

  private String relacionAsegurado;
  private String sucedido;
  private String causa;
  private String vehiculoRetenido;
  private String autoridad;
  private String culpabilidad;
  private String taller;
  private String valorPretension;
  private List<ReclamacionAuto> lstReclamacionAuto = new ArrayList<>();

  public ReclamacionAuto() {
    super();
  }

  private ReclamacionAuto(Map<String, String> datosReclamacionAut) {
    super(datosReclamacionAut);
    this.relacionAsegurado = datosReclamacionAut.get("relacionAsegurado");
    this.sucedido = datosReclamacionAut.get("sucedido");
    this.causa = datosReclamacionAut.get("causa");
    this.vehiculoRetenido = datosReclamacionAut.get("vehiculoRetenido");
    this.autoridad = datosReclamacionAut.get("autoridad");
    this.culpabilidad = datosReclamacionAut.get("culpabilidad");
    this.taller = datosReclamacionAut.get("tallerReparacionAsignado");
    this.valorPretension = datosReclamacionAut.get("valorPretension");
  }

  public ReclamacionAuto(List<Map<String, String>> datosReclamacionAut) {
    asignarDatos(datosReclamacionAut);
  }

  public String getRelacionAsegurado() {
    return relacionAsegurado;
  }

  public String getSucedido() {
    return sucedido;
  }

  public String getCausa() {
    return causa;
  }

  public String getVehiculoRetenido() {
    return vehiculoRetenido;
  }

  public String getAutoridad() {
    return autoridad;
  }

  public String getCulpabilidad() {
    return culpabilidad;
  }

  public String getTaller() {
    return taller;
  }

  public String getValorPretension() {
    return valorPretension;
  }

  public List<ReclamacionAuto> getLstReclamacionAuto() {
    return lstReclamacionAuto;
  }

  private void asignarDatos(List<Map<String, String>> datosReclamacionAut) {
    for (Map<String, String> dato : datosReclamacionAut) {
      lstReclamacionAuto.add(new ReclamacionAuto(dato));
    }
  }
}

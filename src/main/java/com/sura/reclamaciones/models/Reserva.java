package com.sura.reclamaciones.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Reserva {

  private List<Reserva> lstReserva = new ArrayList<>();
  private String monedaReserva;
  private String tipoCosto;
  private String costType;
  private String categoriaCosto;
  private String costCategory;
  private String lineaReserva;
  private String valorReserva;
  private String valorDeducible;

  public Reserva(Map<String, String> datosReserva) {
    this.monedaReserva = datosReserva.get("monedaReserva");
    this.tipoCosto = datosReserva.get("tipoCosto");
    this.costType = datosReserva.get("costType");
    this.categoriaCosto = datosReserva.get("categoriaCosto");
    this.costCategory = datosReserva.get("costCategory");
    this.lineaReserva = datosReserva.get("lineaReserva");
    this.valorReserva = datosReserva.get("valorReserva");
    this.valorDeducible = datosReserva.get("valorDeducible");
  }

  public Reserva(List<Map<String, String>> datosReclamaciones) {
    asignarDatos(datosReclamaciones);
  }

  public String getMonedaReserva() {
    return monedaReserva;
  }

  public String getTipoCosto() {
    return tipoCosto;
  }

  public String getCostType() {
    return costType;
  }

  public String getCategoriaCosto() {
    return categoriaCosto;
  }

  public String getCostCategory() {
    return costCategory;
  }

  public List<Reserva> getLstReserva() {
    return lstReserva;
  }

  public String getValorDeducible() {
    return valorDeducible;
  }

  public String getLineaReserva() {
    return lineaReserva;
  }

  public String getValorReserva() {
    return valorReserva;
  }

  private void asignarDatos(List<Map<String, String>> datosReserva) {
    for (Map<String, String> dato : datosReserva) {
      lstReserva.add(new Reserva(dato));
    }
  }
}

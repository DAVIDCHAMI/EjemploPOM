package com.sura.reclamaciones.models.soat;

import com.sura.reclamaciones.utils.Utilidades;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DatosTecnico {

  private int capacidadCarga;
  private int pesoBrutoVehicular;
  private int idTipoCombustible;

  private List<DatosTecnico> lstDatosTecnicos = new ArrayList<>();

  public DatosTecnico() {}

  public DatosTecnico(Map<String, String> datosTecnico) {
    this.capacidadCarga =
        Utilidades.transformarCadenaEnteroCondicionado(datosTecnico.get("capacidadCarga"));
    this.pesoBrutoVehicular =
        Utilidades.transformarCadenaEnteroCondicionado(datosTecnico.get("pesoBrutoVehicular"));
    this.idTipoCombustible =
        Utilidades.transformarCadenaEnteroCondicionado(datosTecnico.get("idTipoCombustible"));
  }

  public DatosTecnico(List<Map<String, String>> datosReclamaciones) {
    asignarDatos(datosReclamaciones);
  }

  public int getCapacidadCarga() {
    return capacidadCarga;
  }

  public int getPesoBrutoVehicular() {
    return pesoBrutoVehicular;
  }

  public int getIdTipoCombustible() {
    return idTipoCombustible;
  }

  public void asignarDatos(List<Map<String, String>> datoVehiculo) {
    for (Map<String, String> dato : datoVehiculo) {
      lstDatosTecnicos.add(new DatosTecnico(dato));
    }
  }
}

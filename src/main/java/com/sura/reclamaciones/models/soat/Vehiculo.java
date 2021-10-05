package com.sura.reclamaciones.models.soat;

import com.sura.reclamaciones.utils.Utilidades;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Vehiculo {

  private int idTipoServicio;
  private int idClaseVehiculo;
  private int idMarca;
  private int idLinea;
  private int modelo;
  private String noMotor;
  private String noChasis;
  private String noVin;
  private int cilindraje;
  private String noPlaca;
  private int capacidadPasajerosSentados;
  private String datosTecnicos;

  private List<Vehiculo> vehiculos = new ArrayList<>();

  public Vehiculo() {}

  public Vehiculo(List<Map<String, String>> datoVehiculo) {
    asignarDatos(datoVehiculo);
  }

  public Vehiculo(Map<String, String> datosVehiculos) {
    idTipoServicio =
        Utilidades.transformarCadenaEnteroCondicionado(datosVehiculos.get("idTipoServicio"));
    idClaseVehiculo =
        Utilidades.transformarCadenaEnteroCondicionado(datosVehiculos.get("idClaseVehiculo"));
    idMarca = Utilidades.transformarCadenaEnteroCondicionado(datosVehiculos.get("idMarca"));
    idLinea = Utilidades.transformarCadenaEnteroCondicionado(datosVehiculos.get("idLinea"));
    modelo = Utilidades.transformarCadenaEnteroCondicionado(datosVehiculos.get("modelo"));
    noMotor = datosVehiculos.get("noMotor");
    noChasis = datosVehiculos.get("noChasis");
    noVin = datosVehiculos.get("noVin");
    cilindraje = Utilidades.transformarCadenaEnteroCondicionado(datosVehiculos.get("cilindraje"));
    noPlaca = datosVehiculos.get("noPlaca");
    capacidadPasajerosSentados =
        Utilidades.transformarCadenaEnteroCondicionado(
            datosVehiculos.get("capacidadPasajerosSentados"));
    datosTecnicos = datosVehiculos.get("datosTecnicos");
  }

  public int getIdTipoServicio() {
    return idTipoServicio;
  }

  public int getIdClaseVehiculo() {
    return idClaseVehiculo;
  }

  public int getIdMarca() {
    return idMarca;
  }

  public int getIdLinea() {
    return idLinea;
  }

  public int getModelo() {
    return modelo;
  }

  public String getNoMotor() {
    return noMotor;
  }

  public String getNoChasis() {
    return noChasis;
  }

  public String getNoVin() {
    return noVin;
  }

  public int getCilindraje() {
    return cilindraje;
  }

  public String getNoPlaca() {
    return noPlaca;
  }

  public int getCapacidadPasajerosSentados() {
    return capacidadPasajerosSentados;
  }

  public String getDatosTecnicos() {
    return datosTecnicos;
  }

  public List<Vehiculo> getVehiculos() {
    return vehiculos;
  }

  public void asignarDatos(List<Map<String, String>> datoVehiculo) {
    for (Map<String, String> dato : datoVehiculo) {
      vehiculos.add(new Vehiculo(dato));
    }
  }
}

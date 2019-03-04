package com.sura.reclamaciones.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Vehiculo {
  private String placa;
  private String claseVehiculo;
  private String modelo;
  private String marca;
  private String lineaVehiculo;
  private String motor;
  private String chasis;
  private int anio;
  private String tipoVehiculo;
  private String color;
  private String codigoFasecolda;

  private List<Vehiculo> vehiculos = new ArrayList<>();

  public Vehiculo() {}

  public Vehiculo(List<Map<String, String>> datoVehiculo) {
    super();
    asignarDatos(datoVehiculo);
  }

  private Vehiculo(Map<String, String> datosVehiculos) {
    this.placa = datosVehiculos.get("placa");
    this.claseVehiculo = datosVehiculos.get("claseVehiculo");
    this.modelo = datosVehiculos.get("modelo");
    this.marca = datosVehiculos.get("marca");
    this.lineaVehiculo = datosVehiculos.get("lineaVehiculo");
    this.motor = datosVehiculos.get("motor");
    this.chasis = datosVehiculos.get("chasis");
    this.anio = Integer.parseInt(datosVehiculos.get("anio"));
    this.color = datosVehiculos.get("color");
    this.codigoFasecolda = datosVehiculos.get("codigoFasecolda");
    this.tipoVehiculo = datosVehiculos.get("tipoVehiculo");
  }

  public String getPlaca() {
    return placa;
  }

  public String getClaseVehiculo() {
    return claseVehiculo;
  }

  public String getModelo() {
    return modelo;
  }

  public String getMarca() {
    return marca;
  }

  public String getLineaVehiculo() {
    return lineaVehiculo;
  }

  public String getMotor() {
    return motor;
  }

  public String getChasis() {
    return chasis;
  }

  public int getAnio() {
    return anio;
  }

  public void setAnio(int anio) {
    this.anio = anio;
  }

  public String getTipoVehiculo() {
    return tipoVehiculo;
  }

  public void setTipoVehiculo(String tipoVehiculo) {
    this.tipoVehiculo = tipoVehiculo;
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public String getCodigoFasecolda() {
    return codigoFasecolda;
  }

  public void setCodigoFasecolda(String codigoFasecolda) {
    this.codigoFasecolda = codigoFasecolda;
  }

  public List<Vehiculo> getLstVehiculos() {
    return vehiculos;
  }

  public void asignarDatos(List<Map<String, String>> datoVehiculo) {
    for (Map<String, String> dato : datoVehiculo) {
      vehiculos.add(new Vehiculo(dato));
    }
  }
}

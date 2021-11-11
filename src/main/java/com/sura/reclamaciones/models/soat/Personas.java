package com.sura.reclamaciones.models.soat;

import com.sura.reclamaciones.utils.Utilidades;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Personas {

  private int numeroDocumentoTomador;
  private int numeroDocumentoPropietario;
  private String primerApellido;
  private String primerNombre;
  private String razonSocial;
  private String segundoApellido;
  private String segundoNombre;
  private String tipoDocumento;
  private String celular;
  private String direccion;
  private String email;
  private String fechaNacimiento;
  private int idCiudad;
  private String idDepartamento;
  private int naturalezaJuridica;
  private List<Personas> personas = new ArrayList<>();

  public Personas() {}

  public Personas(List<Map<String, String>> datosPersona) {
    asignarDatos(datosPersona);
  }

  public Personas(Map<String, String> datosPersona) {
    this.numeroDocumentoTomador =
        Utilidades.transformarCadenaEnteroCondicionado(datosPersona.get("numeroDocumentoTomador"));
    numeroDocumentoPropietario =
        Utilidades.transformarCadenaEnteroCondicionado(
            datosPersona.get("numeroDocumentoPropietario"));
    primerApellido = datosPersona.get("primerApellido");
    primerNombre = datosPersona.get("primerNombre");
    razonSocial = datosPersona.get("razonSocial");
    segundoApellido = datosPersona.get("segundoApellido");
    segundoNombre = datosPersona.get("segundoNombre");
    tipoDocumento = datosPersona.get("tipoDocumento");
    celular = datosPersona.get("celular");
    direccion = datosPersona.get("direccion");
    email = datosPersona.get("email");
    fechaNacimiento = datosPersona.get("fechaNacimiento");
    idCiudad = Utilidades.transformarCadenaEnteroCondicionado(datosPersona.get("idCiudad"));
    idDepartamento = (datosPersona.get("idDepartamento"));
    naturalezaJuridica =
        Utilidades.transformarCadenaEnteroCondicionado(datosPersona.get("naturalezaJuridica"));
  }

  public int getNumeroDocumentoTomador() {
    return numeroDocumentoTomador;
  }

  public int getNumeroDocumentoPropietario() {
    return numeroDocumentoPropietario;
  }

  public String getPrimerApellido() {
    return primerApellido;
  }

  public String getPrimerNombre() {
    return primerNombre;
  }

  public String getRazonSocial() {
    return razonSocial;
  }

  public String getSegundoApellido() {
    return segundoApellido;
  }

  public String getSegundoNombre() {
    return segundoNombre;
  }

  public String getTipoDocumento() {
    return tipoDocumento;
  }

  public String getCelular() {
    return celular;
  }

  public String getDireccion() {
    return direccion;
  }

  public String getEmail() {
    return email;
  }

  public String getFechaNacimiento() {
    return fechaNacimiento;
  }

  public int getIdCiudad() {
    return idCiudad;
  }

  public String getIdDepartamento() {
    return idDepartamento;
  }

  public int getNaturalezaJuridica() {
    return naturalezaJuridica;
  }

  public List<Personas> getPersonas() {
    return personas;
  }

  public void asignarDatos(List<Map<String, String>> datosPersona) {
    for (Map<String, String> dato : datosPersona) {
      personas.add(new Personas(dato));
    }
  }
}

package com.sura.reclamaciones.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ReclamacionEmpresariales extends Reclamacion {

  private List<ReclamacionEmpresariales> lstReclamoEmp = new ArrayList<>();
  private String numeroContrato;
  private String detalleHechos;
  private String pais;
  private String departamento;
  private String ciudad;
  private String direccion;
  private String tipoIncidente;
  private String causaDelSiniestro;
  private String validarNumeroReclamacion;

  public ReclamacionEmpresariales() {
    super();
  }

  private ReclamacionEmpresariales(Map<String, String> datosReclamacionEmp) {
    super(datosReclamacionEmp);
    this.numeroContrato = datosReclamacionEmp.get("numeroContrato");
    this.detalleHechos = datosReclamacionEmp.get("detalleHechos");
    this.pais = datosReclamacionEmp.get("pais");
    this.departamento = datosReclamacionEmp.get("departamento");
    this.ciudad = datosReclamacionEmp.get("ciudad");
    this.direccion = datosReclamacionEmp.get("direccion");
    this.tipoIncidente = datosReclamacionEmp.get("tipoIncidente");
    this.causaDelSiniestro = datosReclamacionEmp.get("causaDelSiniestro");
    this.validarNumeroReclamacion = datosReclamacionEmp.get("validadorNumReclamacion");
  }

  public ReclamacionEmpresariales(List<Map<String, String>> datosReclamacionesEmp) {
    asignarDatos(datosReclamacionesEmp);
  }

  public String getPais() {
    return pais;
  }

  public String getDepartamento() {
    return departamento;
  }

  public String getCiudad() {
    return ciudad;
  }

  public String getDireccion() {
    return direccion;
  }

  public String getTipoIncidente() {
    return tipoIncidente;
  }

  public String getNumeroContrato() {
    return numeroContrato;
  }

  public String getDetalleHechos() {
    return detalleHechos;
  }

  public String getCausaDelSiniestro() {
    return causaDelSiniestro;
  }

  public String getValidarNumeroReclamacion() {
    return validarNumeroReclamacion;
  }

  public List<ReclamacionEmpresariales> getLstReclamo() {
    return lstReclamoEmp;
  }

  private void asignarDatos(List<Map<String, String>> datosReclamacionesEmp) {
    for (Map<String, String> dato : datosReclamacionesEmp) {
      lstReclamoEmp.add(new ReclamacionEmpresariales(dato));
    }
  }
}

package com.sura.reclamaciones.utils.enums;

public enum EnumRecursosServicios {
  COTIZACION("/cotizaciones"),
  EXPEDICION("/polizas"),
  VALIDACIONES_PREPOLIZA("/validaciones-prepoliza"),
  ANULAR_PREPOLIZA("/anular"),
  BASE_URL_SOAP("http://appslab.suranet.com:80"),
  RECURSO_RIESGOS_CONSULTABLES_SOAP(
      "/ServiciosRiesgosConsultablesWS/services/IngresoRiesgosFacadeWSImpl");

  private final String recurso;

  EnumRecursosServicios(String recurso) {
    this.recurso = recurso;
  }

  public String getRecurso() {
    return recurso;
  }
}

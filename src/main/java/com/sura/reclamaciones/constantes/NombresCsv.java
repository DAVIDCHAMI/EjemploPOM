package com.sura.reclamaciones.constantes;

public enum NombresCsv {
  ANULACION_EMPRESARIAL("anulacion_empresarial"),
  CONTRATO("contrato"),
  PAGO_SINIESTRO("pago_siniestro"),
  RECUPERO("recupero_siniestro");
  public static final String PARAMETROS_SINIESTRO = "parametros_siniestro";
  public static final String PARAMETROS_PERSONA = "parametros_persona";
  public static final String PARAMETROS_RECLAMACION_PERSONA = "persona_reclamacion_auto";
  public static final String PARAMETROS_RECLAMACION = "reclamacion_auto";
  public static final String PARAMETROS_VEHICULO = "vehiculo";
  public static final String PARAMETRO_PERSONA_LESIONADA = "lesionado";
  public static final String PARAMETRO_PERSONA_CONDUCTOR = "conductor";
  public static final String PARAMETRO_RESPONSABILIDAD_CIVIL_VEHICULO =
      "responsabilidad_civil_vehiculo";
  public static final String PARAMETRO_RESPONSABILIDAD_CIVIL_LESIONES =
      "responsabilidad_civil_lesiones";
  public static final String PARAMETROS_SINIESTRO_AUTOS = "parametros_siniestro_autos";
  public static final String PARAMETROS_EXPOSICION_AUTOMATICA = "exposicion_automatica";
  public static final String PARAMETRO_LINEA_RESERVA = "linea_reserva";
  public static final String PARAMETROS_DIRECCION_SINIESTRO = "direccion_reclamacion";
  public static final String PARAMETRO_CREACION_AVISO_AUTOS_WS = "creacionAvisoWS";

  private String valor;

  private NombresCsv(String valor) {
    this.valor = valor;
  }

  public String getValor() {
    return valor;
  }
}

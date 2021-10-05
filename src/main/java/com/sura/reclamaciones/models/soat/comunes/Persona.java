package com.sura.reclamaciones.models.soat.comunes;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.io.Serializable;
import lombok.Builder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
  "celular",
  "direccion",
  "email",
  "fechaNacimiento",
  "idCiudad",
  "idDepartamento",
  "naturalezaJuridica",
  "numeroDocumento",
  "primerApellido",
  "primerNombre",
  "razonSocial",
  "segundoApellido",
  "segundoNombre",
  "tipoDocumento"
})
@Builder
public class Persona implements Serializable {
  @JsonProperty("celular")
  private final String celular;

  @JsonProperty("direccion")
  private final String direccion;

  @JsonProperty("email")
  private final String email;

  @JsonProperty("fechaNacimiento")
  private final String fechaNacimiento;

  @JsonProperty("idCiudad")
  private final String idCiudad;

  @JsonProperty("idDepartamento")
  private final String idDepartamento;

  @JsonProperty("naturalezaJuridica")
  private final String naturalezaJuridica;

  @JsonProperty("numeroDocumento")
  private final String numeroDocumento;

  @JsonProperty("primerApellido")
  private final String primerApellido;

  @JsonProperty("primerNombre")
  private final String primerNombre;

  @JsonProperty("razonSocial")
  private final String razonSocial;

  @JsonProperty("segundoApellido")
  private final String segundoApellido;

  @JsonProperty("segundoNombre")
  private final String segundoNombre;

  @JsonProperty("tipoDocumento")
  private final String tipoDocumento;
}

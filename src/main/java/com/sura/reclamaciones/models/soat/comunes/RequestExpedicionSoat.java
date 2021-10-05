package com.sura.reclamaciones.models.soat.comunes;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.io.Serializable;
import lombok.Builder;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
  "codigoAsesor",
  "direccionIP",
  "fechaInicioVigencia",
  "placa",
  "propietario",
  "retroactiva",
  "tenant",
  "tomador",
  "urlRetorno"
})
@Builder
@Setter
public class RequestExpedicionSoat implements Serializable {

  @JsonProperty("codigoAsesor")
  private String codigoAsesor;

  @JsonProperty("direccionIP")
  private String direccionIP;

  @JsonProperty("fechaInicioVigencia")
  private String fechaInicioVigencia;

  @JsonProperty("placa")
  private String placa;

  @JsonProperty("propietario")
  private Persona propietario;

  @JsonProperty("retroactiva")
  private String retroactiva;

  @JsonProperty("tenant")
  private String tenant;

  @JsonProperty("tomador")
  private Persona tomador;

  @JsonProperty("urlRetorno")
  private String urlRetorno;

  private static final long serialVersionUID = 2221590886969913165L;
}

package com.sura.reclamaciones.models.soat.builder;

import com.sura.reclamaciones.models.soat.Personas;
import com.sura.reclamaciones.models.soat.comunes.Persona;

public class PropietarioBuilder {

  public static Persona conLosDatos(Personas persona) {
    return Persona.builder()
        .numeroDocumento(String.valueOf(persona.getNumeroDocumentoPropietario()))
        .primerApellido(persona.getPrimerApellido())
        .primerNombre(persona.getPrimerNombre())
        .razonSocial(persona.getRazonSocial())
        .segundoApellido(persona.getSegundoApellido())
        .segundoNombre(persona.getSegundoNombre())
        .tipoDocumento(persona.getTipoDocumento())
        .build();
  }
}

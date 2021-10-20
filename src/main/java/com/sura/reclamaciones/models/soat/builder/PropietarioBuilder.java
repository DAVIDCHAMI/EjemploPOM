package com.sura.reclamaciones.models.soat.builder;

import com.sura.reclamaciones.models.soat.Personas;
import com.sura.reclamaciones.models.soat.comunes.Persona;

public class PropietarioBuilder {

  public static Persona conLosDatos(Personas persona) {
    return Persona.builder()
        .numeroDocumento(
            String.valueOf(persona.getPersonas().get(0).getNumeroDocumentoPropietario()))
        .primerApellido(persona.getPersonas().get(0).getPrimerApellido())
        .primerNombre(persona.getPersonas().get(0).getPrimerNombre())
        .razonSocial(persona.getPersonas().get(0).getRazonSocial())
        .segundoApellido(persona.getPersonas().get(0).getSegundoApellido())
        .segundoNombre(persona.getPersonas().get(0).getSegundoNombre())
        .tipoDocumento(persona.getPersonas().get(0).getTipoDocumento())
        .build();
  }
}

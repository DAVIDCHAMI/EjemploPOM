package com.sura.reclamaciones.models.soat.builder;

import com.sura.reclamaciones.models.soat.Personas;
import com.sura.reclamaciones.models.soat.comunes.Persona;

public class TomadorBuilder {

  private TomadorBuilder() {}

  public static Persona conLosDatos(Personas persona) {
    return Persona.builder()
        .celular(String.valueOf(persona.getPersonas().get(0).getCelular()))
        .direccion(persona.getPersonas().get(0).getDireccion())
        .email(persona.getPersonas().get(0).getEmail())
        .fechaNacimiento(persona.getPersonas().get(0).getFechaNacimiento())
        .idCiudad(String.valueOf(persona.getPersonas().get(0).getIdCiudad()))
        .idDepartamento(String.valueOf(persona.getPersonas().get(0).getIdDepartamento()))
        .naturalezaJuridica(String.valueOf(persona.getPersonas().get(0).getNaturalezaJuridica()))
        .numeroDocumento(String.valueOf(persona.getPersonas().get(0).getNumeroDocumentoTomador()))
        .primerApellido(persona.getPersonas().get(0).getPrimerApellido())
        .primerNombre(persona.getPersonas().get(0).getPrimerNombre())
        .razonSocial(persona.getPersonas().get(0).getRazonSocial())
        .segundoApellido(persona.getPersonas().get(0).getSegundoApellido())
        .segundoNombre(persona.getPersonas().get(0).getSegundoNombre())
        .tipoDocumento(persona.getPersonas().get(0).getTipoDocumento())
        .build();
  }
}

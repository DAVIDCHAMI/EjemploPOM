package com.sura.reclamaciones.models.soat.builder;

import com.sura.reclamaciones.models.soat.Personas;
import com.sura.reclamaciones.models.soat.comunes.Persona;

public class TomadorBuilder {

  public static Persona conLosDatos(Personas persona) {
    return Persona.builder()
        .celular(String.valueOf(persona.getCelular()))
        .direccion(persona.getDireccion())
        .email(persona.getEmail())
        .fechaNacimiento(persona.getFechaNacimiento())
        .idCiudad(String.valueOf(persona.getIdCiudad()))
        .idDepartamento(String.valueOf(persona.getIdDepartamento()))
        .naturalezaJuridica(String.valueOf(persona.getNaturalezaJuridica()))
        .numeroDocumento(String.valueOf(persona.getNumeroDocumentoTomador()))
        .primerApellido(persona.getPrimerApellido())
        .primerNombre(persona.getPrimerNombre())
        .razonSocial(persona.getRazonSocial())
        .segundoApellido(persona.getSegundoApellido())
        .segundoNombre(persona.getSegundoNombre())
        .tipoDocumento(persona.getTipoDocumento())
        .build();
  }
}

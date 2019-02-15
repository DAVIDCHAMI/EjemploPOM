# language: es
Característica: Realizar pago de un siniestro

  Como analista de reclamación
  Quiero efectuar un pago a una reclamación
  Para responderle al cliente por su siniestro

  @claimsEmpresarial

  Esquema del escenario: Pago siniestro empresarial
    Dado que se tiene una póliza de <Tipo y Cobertura>
    Y se genere un siniestro por causal <Causa> con un valor de pretensión de <Valor de Pretensión>
    Y un incidente de tipo <Tipo de incidente>
    Cuando se realice un pago <Tipo de pago> a <Beneficiario del pago> por medio de <Método del pago> el cual cuenta con una línea de reserva <Línea de Reserva> donde el responsable <¿Es pago soloSura?> es Sura por una retención de <Código de Retención>
    Entonces se genera una orden de pago para que le sea entregado al usuario

    Ejemplos:
      | Línea de Reserva      | Tipo de pago | Beneficiario del pago             | Método del pago | ¿Es pago soloSura? | Código de Retención | Tipo y Cobertura                                     | Causa                               | Valor de Pretensión | Tipo de incidente |
      | (1) 1ª partePropiedad | Parcial      | MARTHA ENID ROJAS MARIACA CQLII   | Pago por banco  | Sí                 | 0099                | Incendio con cobertura Daños materiales              | Daños por agua                      | 5000000             | Propiedad         |
      | (1) 1ª partePropiedad | Parcial      | CLUB LOS TRIUNFADORES CQLII       | Pago por banco  | No                 | 0099                | Multiriesgo corporativo con cobertura básica         | Incendio                            | 5000000             | Propiedad         |
      | (1) 1ª partePropiedad | Final        | AURA JUDITH LOPEZ JULIO CQLII     | Caja Sura       | Si                 | 0099                | Hogar con cobertura básica                           | Incendio                            | 2000000             | Propiedad         |
      | (1) 1ª parteGeneral   | Final         | TODO EN VERDE CQLII               | Caja Sura       | No                 | 0099                | Cumplimiento con cobertura Cumplimiento del contrato | Incumplimiento                      | 3000000             | General |
      | (1) 1ª parteGeneral   | Parcial      | HERMANOS LTDA. CQLII              | Pago por banco  | No                 | 0023                | Responsabilidad Civil Predios y operaciones          | Responsabilidad civil del asegurado | 3000000             | General           |
      | (1) 1ª parteContenido | Parcial      | JUAN CARLOS PALACIO RAMIREZ CQLII | Pago por banco  | Si                 | 0023                | Transportes automáticos de mercancía                 | Amit/ huelga, conmoción civil       | 4000000             | Contenido         |
      | (1) 1ª parteContenido | Final        | CUATRO TEMPORADAS S.A. CQLII      | Pago por banco  | No                 | 0023                | Sustracción con cobertura Sustracción con violencia  | Causas varias                       | 4000000             | Contenido         |
      | (1) 1ª partePropiedad | Final        | MARTHA ENID ROJAS MARIACA CQLII   | Pago por banco  | Sí                 | 0023                | Incendio con cobertura Daños materiales              | Daños por agua                      | 5000000             | Propiedad         |
      | (1) 1ª partePropiedad |Parcial       | CARMEN CECILIA DIAZ SALGADO CQLII | Caja Sura       |Sí                   | 0028                |	PES Emergente Incendio                               |  Incendio                           | 5000000             | Propiedad         |
      | (1) 1ª parteContenido |Final         |LUCAS VELEZ                        |Pago por banco   |No                  |0099                 |PES Emergente Amit                                    |Amit/ huelga, conmoción civil        | 2500000             | Contenido         |
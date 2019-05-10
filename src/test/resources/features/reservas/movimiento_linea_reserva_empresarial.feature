# language: es
Característica: Constitución de una línea de reserva de un siniestro

  Como analista de reclamaciones
  Quiero que sea posible realizar ajustes en las reservas
  Para que se pueda cubrir el monto del valor del siniestro

  @claimsEmpresarial
  Esquema del escenario: creación de nueva línea de reserva
    Dado que se genera un siniestro del producto <Tipo y Cobertura> con causa <Causa>, valor de pretensión <Valor de Pretensión> y tipo incidente de <Tipo de incidente>
    Cuando se crea una nueva línea de reserva por la Exposición de <Exposición> por <Categoría> con un tipo de costo <Tipo costo> por un valor de <Valor de Pretensión>
    Entonces se genera una nueva línea de reserva de <Categoría> con un deducible de <Deducible>
    Ejemplos:

      | Tipo y Cobertura                                     | Causa          | Tipo de incidente | Exposición                                           | Categoría               | Tipo costo                                    | Valor de Pretensión | Deducible |
      | Sustracción con cobertura Sustracción con violencia  | Causas varias  | Contenido         | (1) 1ª parteContenido - CUATRO TEMPORADAS S.A. CQLII | Gastos de siniestro     | Gasto - A&O (ajuste y otros)                  | 4000000             | 0         |
      | Cumplimiento con cobertura Cumplimiento del contrato | Incumplimiento | General           | (1) 1ª parteGeneral - TODO EN VERDE CQLII            | Gastos de siniestro     | Gasto - A&O (ajuste y otros)                  | 3000000             | 0         |
      | Cumplimiento con cobertura Cumplimiento del contrato | Incumplimiento | General           | (1) 1ª parteGeneral - TODO EN VERDE CQLII            | Gastos proceso jurídico | Gasto - D&CC (defensa y contención de gastos) | 3000000             | 0         |

  @claimsEmpresarial
  Esquema del escenario: reversión de constitución
    Dado que se genera un siniestro del producto <Tipo y Cobertura> con causa <causa>, valor de pretensión <valor de pretension> y tipo incidente de <Tipo de incidente>
    Cuando se ajuste la reserva con un valor de <Monto del ajuste>
    Entonces se obtiene una reversión de constitución y el deducible es generado por un valor <Deducible>

    Ejemplos:
      | Tipo y Cobertura                             | causa             | valor de pretension | Tipo de incidente | Monto del ajuste | Deducible |
      | Multiriesgo corporativo con cobertura básica | Rotura de vidrios | 2000000             | Propiedad         | 4000000          | -1562484  |
      | Multiriesgo corporativo con cobertura básica | Rotura de vidrios | 2000000             | Propiedad         | 3800000          | -1562484  |


  @claimsAuto
    Esquema del escenario: creación de nueva línea de reserva por honorarios en una reclamaciòn de autos
      Dado que se tiene una póliza Servicio de Maca de autos
      Y se genera un aviso
      Cuando se crea una nueva línea de reserva por la Exposición de <Exposición> por <Categoría> con un tipo de costo <Tipo costo> por un valor de <Valor de Pretensión>
      Entonces se genera una nueva línea de reserva de <Categoría> con un deducible de <Deducible>

      Ejemplos:

       | Exposición                                          | Categoría                                    | Tipo costo                                     | Valor de Pretensión | Deducible |
       |(2) 1ª parteVehículo                                 | Gastos proceso jurídico                      | Gasto - D&CC (defensa y contención de gastos)  | 4000000             | 0         |


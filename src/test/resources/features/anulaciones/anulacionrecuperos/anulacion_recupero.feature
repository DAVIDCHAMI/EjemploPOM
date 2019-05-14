# language: es
Característica: Anulacion de recuperos.

  Como analista de reclamaciones
  Quiero generar una anulación de pago y de recupero
  Para verificar que cambie su estado a anulado

  @claimsEmpresarial
  Esquema del escenario: anulación de un recupero de empresariales.
    Dado que se tiene una póliza de <Tipo y Cobertura>
    Y se genere un siniestro por causal <Causa> con un valor de pretensión de <Valor de Pretensión>
    Y un incidente de tipo <Tipo de incidente>
    Y se genere un recupero de tipo <Tipo de recupero> con un código de retención <Código de retención recupero>
    Y se obtiene un reintegro de dinero al siniestro
    Cuando se realice la anulación del recupero
    Entonces se debe obtener la anulación del recupero, quedando en estado anulado

    Ejemplos:
      | Tipo y Cobertura                                     | Causa          | Valor de Pretensión | Tipo de incidente | Tipo de recupero | Código de retención recupero |
      | Hogar con cobertura básica                           | Incendio       | 2000000             | Propiedad         | Ingreso (otro)   | 0099                         |
      | Cumplimiento con cobertura Cumplimiento del contrato | Incumplimiento | 3000000             | General           | Subrogación      | 0099                         |


  @claimsAuto
  Esquema del escenario: anulación de un recupero de autos.
    Dado que se tiene una reclamación de <Origen de siniestro> con un tipo de cobertura de <Tipo de cobertura>
    Y se cree un pago <Tipo de pago> al beneficiario <Beneficiario de pago> por el medio de pago de <Método de pago> sobre la linea de reserva <Línea de reserva> donde el responsable <Solo Sura> es Sura con una retención de <Código de retención pago>
    Y se cree el recupero por el tipo de <Tipo de recupero> con un código de retención <Código de retención recupero>
    Y se obtiene un ingreso de dinero sobre el siniestro
    Cuando se anula el ingreso con cobertura <Tipo de cobertura>
    Entonces se debe obtener la anulación del recupero, quedando en estado anulado

    Ejemplos:
      | Origen de siniestro | Línea de reserva                | Tipo de pago | Beneficiario de pago                    | Método de pago | Código de retención pago | Solo Sura | Tipo de cobertura   | Tipo de recupero | Código de retención recupero |
      | Servicio de Maca    | (1) 3ª parteLesiones corporales | Parcial      | JHON FEOR FEOR FEOR                     | Pago por banco | 0099                     | No        | RC Lesión a Persona | Ingreso (otro)   | 0099                         |
      | Servicio de Maca    | (2) 1ª parteVehículo            | Parcial      | DIOGENES MANUEL BETANCOURT MADERA CQLII | Caja Sura      | 0099                     | No        | Perdida total Daños | Subrogación      | 0099                         |

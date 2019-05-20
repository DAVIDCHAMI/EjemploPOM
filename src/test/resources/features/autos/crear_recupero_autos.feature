# language: es
Característica: Crear un recupero de un siniestro

  Como analista de reclamación
  Quiero crear un recupero a partir de una línea de reserva
  Para que Suramericana recupere una parte del valor pagado sobre el siniestro

  @claimsAuto
  Esquema del escenario: crear recupero de subrogación o ingreso (otro)
    Dado que se tiene una póliza creacionAvisoMACA de autos
    Y se genera un aviso que afecta la cobertura de <Tipo de cobertura>
    Y se cree un pago <Tipo de pago> al beneficiario <Beneficiario de pago> por el medio de pago de <Método de pago> sobre la linea de reserva <Línea de reserva> donde el responsable <Solo Sura> es Sura con una retención de <Código de retención pago>
    Cuando se cree el recupero por el tipo de <Tipo de recupero> con un código de retención <Código de retención recupero>
    Entonces se obtiene un ingreso de dinero sobre el siniestro

    Ejemplos:
      | Línea de reserva                | Tipo de pago| Beneficiario de pago                    | Método de pago  | Código de retención pago | Solo Sura| Tipo de cobertura   | Tipo de recupero | Código de retención recupero |
      | (1) 3ª parteLesiones corporales | Parcial     | JHON FEOR FEOR FEOR                     | Pago por banco  | 0099                     | No       | RC Lesión a Persona |  Ingreso (otro)  |        0099                  |
      | (2) 1ª parteVehículo            | Parcial     | DIOGENES MANUEL BETANCOURT MADERA CQLII | Caja Sura       | 0099                     | No       | Perdida total Daños |  Subrogación     |        0099                  |

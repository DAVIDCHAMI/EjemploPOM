# language: es
Característica: Realizar pago de un siniestro

  @claims
  Esquema del escenario: Pago
    Dado que se tiene el siniestro <numeroReclamacion>  del producto <producto>
    Cuando se realice un pago <tipoPago> a un <beneficiarioPago> por medio de <metodoPago> el cual cuenta con una linea de reserva <lineaReserva> donde el responsable <soloSura> es Sura por una retención de <codigoRetencion>
    Entonces se genera una orden de pago para que le sea entregado al usuario

    Ejemplos:
      | numeroReclamacion  | producto                  | lineaReserva           |tipoPago    | beneficiarioPago                       | metodoPago       | soloSura  | codigoRetencion    |
      | 9180000014929      | Multiriesgo corporativo 1 |(1) 1ª partePropiedad   | Parcial    |JOSE ALFREDO MARTINEZ HERRERA CQLII     | Transferencia    | Sí        | 0099               |
      | 9180000015675      | Multiriesgo corporativo 2 |(1) 1ª parteContenido   | Parcial    |JOSE ALFREDO MARTINEZ HERRERA CQLII     | Caja Sura        | No        | 0022               |
      | 9180000017524      | Multiriesgo corporativo 3 |(1) 1ª partePropiedad   | Parcial    |VICTOR HUGO SEPULVEDA VALLEJO CQLII     | Pago por banco   | Sí        | 0023               |
      | 9180000015884      | Multiriesgo corporativo 4 |(1) 1ª parteContenido   | Parcial    |VICTOR HUGO SEPULVEDA VALLEJO CQLII     | Caja Sura        | No        | 0028               |
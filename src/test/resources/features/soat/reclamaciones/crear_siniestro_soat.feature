# language: es
Característica: Generación avisos de siniestros soat

  Yo como funcionario de la línea de solución
  Quiero que se puedan generar avisos de soat
  Para afectar las coberturas de una póliza, cuando un asegurado tenga un siniestro

  Antecedentes: Crear poliza
    Dado que una persona riesgo estandar tiene un Auto familiar con menos de 1500 c.c y modelo 2015 registrado en el Runt

  @claimsAuto
  @pruebaRegresion
  Escenario: generación de reclamación de tipo Responsabilidad Civil
    Dado que se tiene una póliza con las coberturas
      |coberturas|
      |Daños     |
      |Vehículo de reemplazo|
      |responsabilidadCivil                     |
    Cuando se genere un siniestro por la causa y la culpabilidad Responsabilidad civil daños persona y Responsabilidad civil daños vehículo
      |Causa|Culpabilidad|Responsabilidad civil daños persona|Responsabilidad civil daños vehículo|
      |Colisión con vehículo|responsabilidad Civil|peaton daños persona|conductor daños vehículo|
    Entonces se obtendrán exposiciones automáticas y cada una con su respectiva reserva, según la culpabilidad marcada Responsabilidad Civil

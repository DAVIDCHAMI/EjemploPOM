# language: es
Característica: Generación avisos de siniestros soat

  Yo como funcionario de la línea de solución
  Quiero que se puedan generar avisos de soat
  Para afectar las coberturas de una póliza, cuando un asegurado tenga un siniestro

  Antecedentes: Crear poliza
    Dado que una persona riesgo estandar tiene un Auto familiar con menos de 1500 c.c y modelo 2015 registrado en el Runt

  @claimsAuto
  @pruebaRegresion
  Escenario: generación de reclamación soat
    Dado que se quiere generar un aviso de siniestro

# language: es
Característica: Notificacion de aviso de una reclamacion

  Como Analista reclamaciones, coordinador atención reclamaciones, call_center
  quiero que se generen avisos internos de los diferentes productos que tiene la compañía en empresariales
  para permitir la afectación de las pólizas que han adquirido los usuarios.

  @claimsEmpresarial
  Esquema del escenario: aviso
    Dado que se tiene una poliza de <Tipo y Cobertura>
    Cuando se genere un siniestro por causal <Causa> con un valor de pretension de <Valor de Pretensión>
    Y un incidente de tipo <Tipo de incidente>
    Entonces se obtiene una reclamacion que <¿Genera exposición?> genera exposicion
    Y que <¿Genera reserva?> genera reserva con un monto <Monto de la reserva>, envia correo y se asigna a un analista

    Ejemplos:
      | Tipo y Cobertura                             | Causa             | Valor de Pretensión | Tipo de incidente | ¿Genera exposición? | ¿Genera reserva? | Monto de la reserva |
      | Multiriesgo corporativo con cobertura basica | Rotura de vidrios | 2000000             | Propiedad         | si                  | si               | 1218758             |
      | Multiriesgo corporativo con cobertura basica | Rotura de vidrios | 2000000             | ""                | no                  | no               | 0                   |



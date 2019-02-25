package com.sura.reclamaciones.constantes;

public enum Constantes {
  ACTIVIDADES("Actividades"),
  ACTIVITIES("Activities"),
  ANULACION("Anulacion"),
  CANTIDAD("Cantidad"),
  CLAVE("cor3sur4"),
  CODIGO_RETENCION("Código de retención"),
  COMODIN("COMODIN"),
  COP("COP"),
  CUENTA(""),
  DATOS_FINANCIEROS("Datos financieros"),
  DRIVER("oracle.jdbc.driver.OracleDriver"),
  ENGLISH("English (US)"),
  ESTADO_ANULACION("Anulado"),
  EXPOSICIONES("Exposiciones"),
  FECHA_HOY("Hoy"),
  ITERACIONES_ANULACION("20"),
  ITERACIONES_PAGO("10"),
  ITERACIONES_RECUPERO("3"),
  NUMERO_PAGO("Número de pago"),
  NUMERO_TRANSACCION("Número de transacción"),
  PAGO("Pago"),
  PAGOS("Pagos"),
  TIPO_POLIZA("póliza de auto"),
  PORCENTAJE("0.20"),
  PORCIENTO("100"),
  REASEGURO_DETALLADO("Reaseguro detallado"),
  RECUPERO("Recupero"),
  LINEA_RESERVA_LESIONES_CORPORALES("(1) 3ª parteLesiones corporales"),
  RESERVA("Reserva"),
  RETENCION_PURA("10"),
  SELECCIONAR("Seleccionar"),
  TIPO_PAGO("Parcial"),
  TIPO_TRANSACCION("Recuperaciones"),
  TRANSFERENCIA_ELECTRONICA("Transferencia"),
  UBICACION_ESTADO_PAGO("5"),
  UBICACION_ESTADO_RECUPERO("9"),
  URL("jdbc:oracle:thin:@clustercsl01:1537/labgwcc"),
  USD("USD"),
  USUARIO("GW_CONF"),
  ESTADO_LEGAL("Rematricula a nombre de Suramericana"),
  VALIDADOR_NUEVA_RECLAMACION("Nueva reclamación guardada"),
  SEPARADOR_VARIABLES("->"),
  ACCION_ASIGNAR_COBERTURAS("view-cover"),
  ACCION_DATOS_ADICIONALES("view-edit"),
  ACCION_VER_RESULTADO_COTIZACION("view-quotation"),
  ACCION_VER_RESULTADO_EXPEDICION("view-expedition"),
  FORMATO_FECHA_DDMMYYYY("dd/MM/yyyy"),
  MSG_NO_CUMPLE_RETROACTIVIDAD("retroactividad"),
  APROBAR_CONTROL_POLICY("Aprobar"),
  CANCELAR_CONTROL_POLICY("Cancelar"),
  ACEPTAR("Aceptar"),
  EXPEDIR("Expedir"),
  RENOVAR("Renovar"),
  SIN_COBERTURAS("SIN COBERTURAS"),
  INICIO("Inicio"),
  PRODUCTOS_AUTOS_RENOVACION("Producto->Autos->Renovación"),
  PRODUCTO_AUTOS_MODIFICACION("Producto->Autos->Modificación"),
  PRODUCTO_AUTOS_COTIZACION("Producto->Autos->Cotización"),
  TASA_COMISION("Tasa de comisión"),
  DETALLE_COMISIONES_ASESOR("Detalle de comisiones del asesor"),
  COLUMNA_FILTRO_CSV("idFiltro"),
  FORMATEAR_MONTOS("[$.()A-Z ]"),
  POLIZA("Póliza"),
  NO_COINCIDE_CON_EL_ESPERADO(" no coincide con el esperado: "),
  NOMBRE_REASEGURADOR("Nombre del reasegurador"),
  PORCENTAJE_DE_CESION("Porcentaje de cesión (%)"),
  PRIMA_BRUTA_CEDIDA("Prima bruta cedida"),
  LIMITE_INFERIOR("Límite inferior"),
  RIESGO_CEDIDO("Riesgo cedido"),
  DEPOSITO_RETENIDO("Depósito retenido"),
  PARTICIPACION("Participación (%)"),
  PROPORCION("Proporción (%)"),
  IMPUESTO_BOMBEROS("Impuesto bomberos"),
  VALOR_RETEFUENTE("Valor retefuente"),
  RETEFUENTE("Retefuente (%)"),
  COMISION("Comisión"),
  LIMITE("Límite"),
  TIPO("Tipo"),
  CUOTA_PARTE("Cuota parte"),
  REASEGURO("Reaseguro"),
  TOMADOR_PRINCIPAL("Tomador Principal"),
  TOMADOR_SECUNDARIO("Tomador Secundario"),
  VALOR("Valor"),
  MENSAJE_DUPLICIDAD(
      "El tomador principal y el tomador secundario no pueden tener el mismo número de identificación."),
  SELECT("select"),
  ACCIONES("ACCIONES"),
  PLACA("PLACA"),
  CODIGO_RIESGO("CODIGO RIESGO"),
  NRO_COTIZACION("#COTIZACIÓN"),
  ESTADO_TERMINADA_CON_EXITO("Terminada con Éxito"),
  ESTADO_EN_PROCESO("En Proceso"),
  NRO_INTENTOS("50"),
  TOTAL("Total"),
  ESTADO_POLIZA_CANCELADA("Cancelada"),
  OPERACION("OPERACIÓN"),
  PROCESO("PROCESO"),
  NRO_POLIZA("#PÓLIZA"),
  NO_RECORDS_FOUND("No records found"),
  OPERACION_RENOVACION("Renovacion"),
  OPERACION_MODIFICACION("Modificacion"),
  PROCESO_CONSULTA("CONSULTA"),
  PROCESO_TARIFACION("TARIFACION"),
  FORMATO_FECHA("yyyy-MM-dd"),
  FORMATO_FECHA_RIESGOS("yyyy/MM/dd"),
  EMISION_POLIZA("Emisión de póliza"),
  RENOVACION("Renovación"),
  PRIMA("Prima"),
  IVA("Iva"),
  DESCRIPCION_OPERACION("Descripción de la operación"),
  COTIZAR("Cotizar"),
  MSG_BONIFICACION_NO_COINCIDE("La bonificación no coincide"),
  TRANSACCIONES_POLIZA("Transacciones de póliza"),
  PROGRAMADO("Programado"),
  VOLVER_BILLINGCENTER("Volver a BillingCenter"),
  VOLVER_POLICYCENTER("Volver a PolicyCenter"),
  ESTADO_BORRADOR("Borrador"),
  OPCIONES_COMPROMISO("Opciones de compromiso"),
  EMITIR_AHORA("Emitir ahora"),
  ARCHIVO_DE_POLIZA("Archivo de póliza"),
  COTIZACION("Cotización"),
  DETALLES("Detalles"),
  CANCELACION("Cancelación"),
  NUMERO("Número"),
  CANCELAR_AHORA("Cancelar ahora"),
  VEHICULOS("Vehículos"),
  PRIMA_TOTAL("Prima total"),
  IMPUESTOS_TARIFAS("Impuestos y tarifas"),
  ACTUALIZAR("Actualizar"),
  DISPONIBLE("Disponible"),
  MARCADO("Marcado"),
  INFORMACION_COLA_TRABAJO("Información de cola de trabajo"),
  VER_POLIZA("Ver póliza"),
  FLUJO_TRABAJO_RUNNING("Flujo de trabajo (Running)"),
  PLAN_PAGOS_MENSUAL("F Mensual"),
  FACTURACION_GRUPO("Facturación por grupo"),
  MENU_PRIMER_NIVEL_ADMINISTRACION("Ad"),
  MENU_UTILIDADES("Utilidades"),
  MENU_SCRIPTER("Scripter"),
  SCRIPT_FACTURA_RIESGO("script_facturacion_riesgo"),
  SCRIPT_FACTURA_COLECTIVA("script_facturacion_colectiva"),
  TAG_FACTURA_RIESGO("<NumerofacturaRiesgo>"),
  TAG_FACTURA_COLECTIVA("<GrupoColectiva>"),
  ACUERDO_FACULTATIVO_PROPORCIONAL("Acuerdo facultativo proporcional"),
  BASE_REASEGURABLE_RIESGO("Base reasegurable riesgo"),
  BASE_DISTRIBUCION_REASEGURO("Base distribución reaseguro"),
  LIMITE_CONTRATO_CUOTA_PARTE("Límite contrato Cuota parte"),
  VALOR_RETENIDO_CUOTA_PARTE("Valor retenido cuota parte"),
  RETENCION_SOBRE_CIEN_POR_CIENTO("Retención sobre cien por ciento"),
  MENSAJE_TRABAJO_SIN_GUARDAR("Tiene trabajo sin guardar que se perderá si navega a otro sitio"),
  NUMERO_TRANSACCION_POLICY("Número transacción"),
  NRO_INTENTOS_ESPERA_CARGA("7"),
  NRO_INTENTOS_VISUALIZACION_REGISTRO_DB("5"),
  PROCESO_LOTES_FACTURA("Factura"),
  PROCESO_LOTES_FACTURACION_POLIZAS_COLECTIVAS("Proceso de facturación para polizas colectivas"),
  COLA_TRABAJO_BILLING_COLLECTIVE_POLICY_INVOICE_PROCESS("BillingCollectivePolicyInvoiceProcess"),
  ESTADO("ESTADO"),
  COLA_TRABAJO_BIILING_COLLECTIVE_POLICY_INVOICE_PROCESS("BillingCollectivePolicyInvoiceProcess"),
  DEVOLUCIONES("Devoluciones"),
  ESTADO_FACTURA_PLANIFICADO("Planificado"),
  OPERACION_CAMBIO_POLIZA("Cambio de póliza"),
  OPERACION_EMISION_POLIZA("Emisión de póliza"),
  IVA_CARGOS_FACTURAS("IVA"),
  CONSULTA_POLIZA_MASIVA_SI("Si"),
  CONSULTA_POLIZA_MASIVA_NO("No"),
  LABORATORIO("uat"),
  DESARROLLO("dllo"),
  ANALISTA_RECLAMACION_AUTO("analistaReclamacionAuto"),
  ANALISTA_RECLAMACION_EMPRESARIAL("analistaReclamacionEmp"),
  ANALISTA_RECLAMACION_ATR("analistaReclamacionEmpAtr"),
  SI("si"),
  NO("no"),
  NIT("98630089"),
  NUMERO_INTENTOS_ESPERA_ELEMENTO("180"),
  EXPEDIENTE_CREADO_EXITOSAMENTE("Expediente creado con éxito"),
  EMPRESARIALES("Empresariales"),
  AUTOS("Autos"),
  TRUE("true"),
  RUTA_LOG_EMPRESARIAL("C:\\Log\\RegistrosEmpresarial.txt"),
  RUTA_LOG_AUTO("C:\\Log\\RegistrosAutos.txt"),
  FECHA_ACTUAL("fechaActual"),
  NUMERO_DIAS_VENCIMIENTO("3"),
  VALOR_CERO("0"),
  VALOR_ANTERIOR("."),
  NUEVO_VALOR("-05:00");

  private String valor;

  Constantes(String valor) {
    this.valor = valor;
  }

  public String getValor() {
    return valor;
  }
}

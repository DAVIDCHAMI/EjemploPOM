package com.sura.reclamaciones.services;

import static com.sura.reclamaciones.constantes.Constantes.RANGO_HORA_CREACION_SINIESTRO;
import static com.sura.reclamaciones.constantes.Constantes.VALOR_ANTERIOR;
import static com.sura.reclamaciones.utils.VariablesSesion.SESION_FECHA_INICIO_VIGENCIA;
import static com.sura.reclamaciones.utils.VariablesSesion.SESION_FECHA_SINIESTRO;
import static com.sura.reclamaciones.utils.VariablesSesion.SESION_GC_PLACA;
import static com.sura.reclamaciones.utils.VariablesSesion.SESION_SERV_JOB_NUMBER;
import static com.sura.reclamaciones.utils.VariablesSesion.SESION_SERV_NRO_PLACA;
import static com.sura.reclamaciones.utils.VariablesSesion.SESION_SERV_NRO_POLIZA;

import com.sura.reclamaciones.constantes.Configuraciones;
import com.sura.reclamaciones.models.ExpedicionAuto;
import com.sura.reclamaciones.utils.Utilidades;
import com.sura.service.cliente.expedicion.ExpedicionAutosIndividualCliente;
import com.sura.service.expedicionIndividual.gen.ExpedicionAutosParametros;
import com.sura.service.expedicionIndividual.gen.ExpedicionIndividualAutosResponse;
import com.sura.service.expedicionIndividual.gen.QuotingData;
import java.util.List;
import net.serenitybdd.core.Serenity;
import org.joda.time.DateTime;

public class ConsumoServicioExpedicionIndividualAuto {

  List<ExpedicionAuto> lstParametros;
  ExpedicionAutoFactory expedicionAutoFactory;
  ExpedicionAutosIndividualCliente expedicion;
  ExpedicionIndividualAutosResponse response = null;
  Utilidades utilidades = new Utilidades();
  private static final String ESTADO_PARA_VENCERSE = "para vencerse";
  private static final String ESTADO_VENCIDA = "vencida";
  private static final String ESTADO_FECHA_ACTUAL = "fechaActual";

  public void invocarServicioExpedicion() {
    expedicion = new ExpedicionAutosIndividualCliente();
  }

  private ExpedicionAutosParametros asignarParametrosJson(
      List<ExpedicionAuto> lstParametros, int diasFaltantesVencimiento, String estadoPoliza) {
    this.lstParametros = lstParametros;
    ExpedicionAutosParametros parametros = new ExpedicionAutosParametros();
    for (ExpedicionAuto oExpedicion : this.lstParametros) {
      expedicionAutoFactory = new ExpedicionAutoFactory();
      expedicionAutoFactory.setJsonrpc(oExpedicion.getVersion());
      expedicionAutoFactory.setMethod(oExpedicion.getMetodo());
      expedicionAutoFactory.setPlanCode(oExpedicion.getCodigoPlan());
      expedicionAutoFactory.setAmount(oExpedicion.getValorCotizar());
      expedicionAutoFactory.setIdCustom(utilidades.generarAleatoriosNumeros(12));
      expedicionAutoFactory.setFechaInicioVigencia(
          diligenciarVigenciaPoliza(diasFaltantesVencimiento, estadoPoliza));
      Serenity.setSessionVariable(SESION_FECHA_INICIO_VIGENCIA.getValor())
          .to(expedicionAutoFactory.getFechaInicioVigencia());
      expedicionAutoFactory.setLicense(
          Utilidades.generarPlaca(
              Configuraciones.CANTIDAD_LETRAS.getValor(),
              Configuraciones.CANTIDAD_NUMEROS.getValor()));
      Serenity.setSessionVariable(SESION_GC_PLACA.getValor())
          .to(expedicionAutoFactory.getLicense());
      expedicionAutoFactory.setFasecoldaCode(oExpedicion.getFasecolda());
      expedicionAutoFactory.setYear(oExpedicion.getAnio());
      expedicionAutoFactory.setcityCirculationCode(oExpedicion.getCiudadCirculacion());
      expedicionAutoFactory.setAccesorios(oExpedicion.getAccesorio());
      expedicionAutoFactory.setCeroKms(oExpedicion.isCeroKms());
      expedicionAutoFactory.setBonificacionComercial(oExpedicion.getBonificacionComercial());
      expedicionAutoFactory.setBonificacionTecnica(oExpedicion.getBonificacionTecnica());
      expedicionAutoFactory.setValorLimiteDanoTercero(oExpedicion.getValorLimiteDanoTercero());
      expedicionAutoFactory.setValorDeducibleDanoTercero(
          oExpedicion.getValorDeducibleDanoTercero());
      expedicionAutoFactory.setValorPerdidaTotalDanosCarro(
          oExpedicion.getValorPerdidaTotalDanosCarro());
      expedicionAutoFactory.setValorPerdidaParcialDanosCarro(
          oExpedicion.getValorPerdidaParcialDanosCarro());
      expedicionAutoFactory.setValorGastoTransporteDanosCarro(
          oExpedicion.getValorGastoTransporteDanosCarro());
      expedicionAutoFactory.setValorHurtoParcial(oExpedicion.getValorHurtoParcial());
      expedicionAutoFactory.setValorHurtoTotal(oExpedicion.getValorHurtoTotal());
      expedicionAutoFactory.setValorHurtoGasTrans(oExpedicion.getValorHurtoGasTrans());
      expedicionAutoFactory.setValorPerdidaParcialCarroReemplazo(
          oExpedicion.getValorPerdidaParcialCarroReemplazo());
      expedicionAutoFactory.setValorPerdidaTotalCarroReemplazo(
          oExpedicion.getValorPerdidaTotalCarroReemplazo());
      expedicionAutoFactory.setValorAccidentesConductor(oExpedicion.getValorAccidentesConductor());
      expedicionAutoFactory.setValorPerdidaLlaves(oExpedicion.getValorPerdidaLlaves());
      expedicionAutoFactory.setValorAsistencia(oExpedicion.getValorAsistencia());
      parametros = expedicionAutoFactory.expedicionAutosParametrosFactory();
    }
    return parametros;
  }

  public QuotingData ejecutarExpedicion(
      List<ExpedicionAuto> listaParametros, int diasFaltantesVencimiento, String estadoPoliza) {
    response = new ExpedicionIndividualAutosResponse();
    expedicion = new ExpedicionAutosIndividualCliente();
    response =
        expedicion.expedicion(
            asignarParametrosJson(listaParametros, diasFaltantesVencimiento, estadoPoliza));
    return response.getResult().getQuotingData();
  }

  public void capturarDatosResultado(QuotingData resultadoJson) {
    String jobNumberJson = resultadoJson.getJobNumber();
    String nroPoliza = resultadoJson.getPolicyNumber();
    String nroPlaca = resultadoJson.getDetailCoverages().listIterator().next().getPlate();
    String fechaAvisoSiniestro;
    DateTime fechaSiniestro = new DateTime();
    fechaSiniestro = fechaSiniestro.toDateTime().minusDays(1);
    fechaAvisoSiniestro = fechaSiniestro.toString().substring(0, 20);
    fechaAvisoSiniestro =
        fechaAvisoSiniestro.replace(
            VALOR_ANTERIOR.getValor(), RANGO_HORA_CREACION_SINIESTRO.getValor());
    Serenity.setSessionVariable(SESION_SERV_JOB_NUMBER.getValor()).to(jobNumberJson);
    Serenity.setSessionVariable(SESION_SERV_NRO_POLIZA.getValor()).to(nroPoliza);
    Serenity.setSessionVariable(SESION_SERV_NRO_PLACA.getValor()).to(nroPlaca);
    Serenity.setSessionVariable(SESION_FECHA_SINIESTRO.getValor()).to(fechaAvisoSiniestro);
  }

  public String diligenciarVigenciaPoliza(int diasFaltantesVencimiento, String estadoPoliza) {
    DateTime fechaInicio = new DateTime();
    if (estadoPoliza.contains(ESTADO_PARA_VENCERSE)) {
      fechaInicio = fechaInicio.plusYears(-1).plusDays(diasFaltantesVencimiento);
    } else {
      if (estadoPoliza.contains(ESTADO_VENCIDA)) {
        fechaInicio = fechaInicio.plusYears(-1).minusDays(diasFaltantesVencimiento);
      } else {
        if (estadoPoliza.contains(ESTADO_FECHA_ACTUAL)) {
          fechaInicio = fechaInicio.minusDays(diasFaltantesVencimiento);
        }
      }
    }
    return fechaInicio.toString();
  }
}

package com.sura.reclamaciones.steps.guidewire.claimscenter.soat;

import static com.sura.reclamaciones.utils.enums.EnumRecursosServicios.RECURSO_URL_SERVICIO_SOAT;
import static com.sura.reclamaciones.utils.enums.VariablesSesion.SESION_PC_RESPUESTA_SERVICIO_SOAT;

import com.sura.reclamaciones.models.soat.comunes.RequestExpedicionSoat;
import com.sura.reclamaciones.utils.enums.EnumCredencialesServicios;
import io.restassured.http.ContentType;
import java.util.Map;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abiities.CallAnApi;
import net.serenitybdd.screenplay.rest.interactions.Post;

public class ConsumirServicioSoapPostConHeaders {

  private String restApiUrl = "http://appslab.suranet.com/apisoatexpedicion/api";
  Actor prueba = Actor.named("prueba servicio").whoCan(CallAnApi.at(restApiUrl));

  public String recurso;
  public String usuario;
  public String contrasena;
  public Object request;
  public Map<String, ?> header;

  public ConsumirServicioSoapPostConHeaders(
      String recurso,
      EnumCredencialesServicios enumCredenciales,
      RequestExpedicionSoat request,
      Map<String, String> header) {
    this.recurso = recurso;
    usuario = enumCredenciales.getUsuario();
    contrasena = enumCredenciales.getContrasena();
    this.request = request;
    this.header = header;
    ejecutarConsumo();
  }

  public void ejecutarConsumo() {

    Actor prueba =
        Actor.named("usuario prueba").whoCan(CallAnApi.at(RECURSO_URL_SERVICIO_SOAT.getRecurso()));
    prueba.attemptsTo(
        Post.to(recurso)
            .with(
                requestSpecification ->
                    requestSpecification
                        .log()
                        .all()
                        .headers(header)
                        .auth()
                        .preemptive()
                        .basic(usuario, contrasena)
                        .contentType(ContentType.JSON)
                        .body(request)
                        .log()
                        .all()));

    Serenity.setSessionVariable(SESION_PC_RESPUESTA_SERVICIO_SOAT)
        .to(SerenityRest.lastResponse().asString());

    System.out.println(SerenityRest.lastResponse().getBody().jsonPath().getString("poliza"));
    System.out.println(Serenity.getCurrentSession().get(SESION_PC_RESPUESTA_SERVICIO_SOAT));
  }
}

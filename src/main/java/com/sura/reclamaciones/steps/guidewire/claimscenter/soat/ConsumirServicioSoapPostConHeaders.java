package com.sura.reclamaciones.steps.guidewire.claimscenter.soat;

import com.sura.reclamaciones.models.soat.comunes.RequestExpedicionSoat;
import com.sura.reclamaciones.utils.enums.EnumCredencialesServicios;
import io.restassured.http.ContentType;
import java.util.Map;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abiities.CallAnApi;
import net.serenitybdd.screenplay.rest.interactions.Post;

public class ConsumirServicioSoapPostConHeaders {

  private static final String restApiUrl = "appslab.suranet.com/apisoatexpedicion/api";
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
                    .all());

    System.out.println(SerenityRest.lastResponse().statusCode());
  }
}

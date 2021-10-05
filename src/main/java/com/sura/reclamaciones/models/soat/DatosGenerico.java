package com.sura.reclamaciones.models.soat;

import com.sura.reclamaciones.utils.Utilidades;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DatosGenerico {

  private int codigoAsesor;
  private String direccionIp;
  private String tenant;
  private String urlRetorno;
  private String retroactiva;

  private List<DatosGenerico> datosGenericos = new ArrayList<>();

  public DatosGenerico() {}

  public int getCodigoAsesor() {
    return codigoAsesor;
  }

  public String getDireccionIp() {
    return direccionIp;
  }

  public String getTenant() {
    return tenant;
  }

  public String getUrlRetorno() {
    return urlRetorno;
  }

  public String getRetroactiva() {
    return retroactiva;
  }

  public List<DatosGenerico> getDatosGenericos() {
    return datosGenericos;
  }

  public DatosGenerico(List<Map<String, String>> datoVehiculo) {
    asignarDatos(datoVehiculo);
  }

  public DatosGenerico(Map<String, String> datosGenerico) {
    this.codigoAsesor =
        Utilidades.transformarCadenaEnteroCondicionado(datosGenerico.get("codigoAsesor"));
    this.direccionIp = datosGenerico.get("direccionIp");
    this.tenant = datosGenerico.get("tenant");
    this.urlRetorno = datosGenerico.get("urlRetorno");
    this.retroactiva = datosGenerico.get("retroactiva");
  }

  public void asignarDatos(List<Map<String, String>> datoVehiculo) {
    for (Map<String, String> dato : datoVehiculo) {
      datosGenericos.add(new DatosGenerico(dato));
    }
  }
}

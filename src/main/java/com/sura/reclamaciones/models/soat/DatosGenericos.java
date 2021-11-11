package com.sura.reclamaciones.models.soat;

import com.sura.reclamaciones.utils.Utilidades;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DatosGenericos {

  private int codigoAsesor;
  private String direccionIp;
  private String tenant;
  private String urlRetorno;
  private String retroactiva;

  private List<DatosGenericos> datosGenericos = new ArrayList<>();

  public DatosGenericos() {}

  public DatosGenericos(List<Map<String, String>> datoVehiculo) {
    asignarDatos(datoVehiculo);
  }

  public DatosGenericos(Map<String, String> datosGenerico) {
    this.codigoAsesor =
        Utilidades.transformarCadenaEnteroCondicionado(datosGenerico.get("codigoAsesor"));
    this.direccionIp = datosGenerico.get("direccionIp");
    this.tenant = datosGenerico.get("tenant");
    this.urlRetorno = datosGenerico.get("urlRetorno");
    this.retroactiva = datosGenerico.get("retroactiva");
  }

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

  public List<DatosGenericos> getDatosGenericos() {
    return datosGenericos;
  }

  public void asignarDatos(List<Map<String, String>> datoVehiculo) {
    for (Map<String, String> dato : datoVehiculo) {
      datosGenericos.add(new DatosGenericos(dato));
    }
  }
}

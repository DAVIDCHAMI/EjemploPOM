package com.sura.reclamaciones.pages.recupero;

import static com.sura.reclamaciones.constantes.Constantes.NUMERO_TRANSACCION;

import com.sura.reclamaciones.pages.generics.GeneralPage;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VerificacionRecuperoPage extends GeneralPage {

  private static String tblRecupero =
      "//tr//td//div[contains(text(),'%s')]//parent::td//parent::tr//td";

  public VerificacionRecuperoPage(WebDriver driver) {
    super(driver);
  }

  public List<WebElement> obtenerListaRecupero() {
    String strNumeroRecupero = obtenerDatoTablaCabecera(NUMERO_TRANSACCION.getValor(), 1);
    List<WebElement> lstFilaRecupero;
    lstFilaRecupero = obtenerFilaTabla(strNumeroRecupero, tblRecupero);
    return lstFilaRecupero;
  }

  public boolean verificarRecupero(String datoValidar, List<WebElement> lstFilaRecupero) {
    for (WebElement cantidadDatosListaRecupero : lstFilaRecupero) {
      if (cantidadDatosListaRecupero.getText().equals(datoValidar)) {
        return true;
      }
    }
    return false;
  }
}

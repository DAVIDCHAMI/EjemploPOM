package com.sura.reclamaciones.pages.recupero;

import com.sura.reclamaciones.constantes.MenuConstante;
import com.sura.reclamaciones.constantes.RecuperoConstante;
import com.sura.reclamaciones.pages.generics.GeneralPage;
import com.sura.reclamaciones.pages.generics.MenuClaimPage;
import java.util.List;
import org.fluentlenium.core.annotation.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VerificacionRecuperoPage extends GeneralPage {

  public VerificacionRecuperoPage(WebDriver driver) {
    super(driver);
  }

  @Page MenuClaimPage menuClaimPage;

  public static String tblRecupero = "//tr//td//div[contains(text(),'%s')]//parent::td//parent::tr//td";

  public List<WebElement> obtenerListaRecupero() {
    irUltimaPagina();
    String strNumeroRecupero = obtenerDatoTablaCabecera(RecuperoConstante.NUMERO_TRANSACCION);
    menuClaimPage.seleccionarOpcionMenuLateralSegundoNivel(
        MenuConstante.DATOS_FINANCIEROS, MenuConstante.TRANSACCIONES);
    seleccionarTipoTransaccion(RecuperoConstante.TIPO_TRANSACCION);
    irUltimaPagina();
    List<WebElement> lstFilaRecupero =
        obtenerFilaTabla(strNumeroRecupero, tblRecupero);
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

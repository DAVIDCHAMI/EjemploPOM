package com.sura.reclamaciones.pages.guidewire.claimscenter.comunes;

import static com.sura.reclamaciones.utils.enums.Constantes.ITERACIONES_ANULACION;

import com.sura.reclamaciones.pages.general.GeneralPage;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;

public class DatoRecuperacionPage extends GeneralPage {

  @FindBy(xpath = "//span[@class='x-btn-button']//span[contains(text(),'Aceptar')]")
  private WebElementFacade btnAceptar;

  public DatoRecuperacionPage(WebDriver wdriver) {
    super(wdriver);
  }

  public boolean realizarAnulacionRecupero() {
    for (int i = 0; i <= Integer.parseInt(ITERACIONES_ANULACION.getValor()); i++)
      if (btnAnular.isVisible()) {
        anularTransaccion();
        return true;
      } else {
        driver.navigate().refresh();
      }
    return false;
  }
}

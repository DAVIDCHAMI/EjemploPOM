package com.sura.reclamaciones.pages.guidewire.claimscenter.comunes;

import static com.sura.reclamaciones.utils.enums.Constantes.TIPO;

import com.sura.reclamaciones.models.ExposicionesAutomaticasAutos;
import com.sura.reclamaciones.pages.general.GeneralPage;
import com.sura.reclamaciones.utils.enums.Tablas;
import java.util.List;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;

public class ExposicionPage extends GeneralPage {

  private static final String EXPOSICION_DANOS_ASEGURADO = "Daños";

  @FindBy(id = "ClaimExposures:ClaimExposuresScreen:ExposuresLV")
  private WebElementFacade tblExposicionesAutomaticas;

  @FindBy(xpath = "//a[contains(text(),'Vehículo')]")
  private WebElementFacade exposicionAutomatica;

  public ExposicionPage(WebDriver wdriver) {
    super(wdriver);
  }

  public void seleccionarExposicion() {
    obtenerCabecerasTabla(tblExposicionesAutomaticas, Tablas.CABECERAS_CC);
    obtenerTextoElementoLista(
            tblExposicionesAutomaticas,
            Tablas.CABECERAS_CC,
            Tablas.REGISTROS_CC,
            EXPOSICION_DANOS_ASEGURADO,
            TIPO.getValor())
        .click();
    realizarEsperaCarga();
  }

  public boolean validarExposiciones(
      List<ExposicionesAutomaticasAutos> datosExposicionesAutomaticas) {
    boolean valorLineaReserva = true;
    obtenerCabecerasTabla(
        $("//div[@id='ClaimExposures:ClaimExposuresScreen:ExposuresLV']"), Tablas.CABECERAS_CC);
    for (int i = 0; i < datosExposicionesAutomaticas.size(); i++) {
      String lineaReservaTbl =
          obtenerElementoLista(
                  tblExposicionesAutomaticas,
                  Tablas.CABECERAS_CC,
                  Tablas.REGISTROS_CC,
                  datosExposicionesAutomaticas.get(i).getExposicionAutomatica(),
                  datosExposicionesAutomaticas.get(i).getDatoDevolverTablaExposiciones())
              .getText();
      if (lineaReservaTbl.equals(datosExposicionesAutomaticas.get(i).getExposicionAutomatica())) {
        obtenerElementoLista(
                tblExposicionesAutomaticas,
                Tablas.CABECERAS_CC,
                Tablas.REGISTROS_CC,
                datosExposicionesAutomaticas.get(i).getExposicionAutomatica(),
                datosExposicionesAutomaticas.get(0).getDatoDevolverTablaExposiciones())
            .getText();
      } else {
        valorLineaReserva = false;
        break;
      }
    }
    return valorLineaReserva;
  }
}

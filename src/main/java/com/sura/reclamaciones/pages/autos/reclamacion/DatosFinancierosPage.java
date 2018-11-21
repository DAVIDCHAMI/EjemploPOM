package com.sura.reclamaciones.pages.autos.reclamacion;

import com.sura.reclamaciones.constantes.DatosFinancierosConstante;
import com.sura.reclamaciones.constantes.Tablas;
import com.sura.reclamaciones.models.LineaReservaValorReservaAutos;
import com.sura.reclamaciones.pages.generics.GeneralPage;
import com.sura.reclamaciones.pages.generics.MenuClaimPage;
import com.sura.reclamaciones.utils.Variables;
import java.util.List;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.fluentlenium.core.annotation.Page;
import org.openqa.selenium.WebDriver;

public class DatosFinancierosPage extends GeneralPage {

  public DatosFinancierosPage(WebDriver wdriver) {
    super(wdriver);
  }

  @Page MenuClaimPage menuClaimPage;

  @FindBy(
    id =
        "ClaimFinancialsSummary:ClaimFinancialsSummaryScreen:FinancialsSummaryPanelSet:FinancialsSummaryLV"
  )
  WebElementFacade tblDatosFinancieros2;

  public boolean valorLineaReserva = true;

  public boolean obtenerDatosFinancieros(
      List<LineaReservaValorReservaAutos> datosLineaReservaValorReservaAutos) {
    menuClaimPage.seleccionarOpcionMenuLateralPrimerNivel(
        DatosFinancierosConstante.DATOS_FINANCIEROS);
    obtenerCabecerasDeUnaTabla(
        $(
            "//div[@id='ClaimFinancialsSummary:ClaimFinancialsSummaryScreen:FinancialsSummaryPanelSet:FinancialsSummaryLV']"),
        Tablas.CABECERAS_CC);

    datosLineaReservaValorReservaAutos.size();

    for (int i = 0; i < datosLineaReservaValorReservaAutos.size(); i++) {
      String lineaReservaTbl =
          obtenerElementoLista(
                  tblDatosFinancieros2,
                  Tablas.CABECERAS_CC,
                  Tablas.REGISTROS_CC,
                  datosLineaReservaValorReservaAutos.get(i).getLineaReserva(),
                  "")
              .getText();
      if (lineaReservaTbl.equals(datosLineaReservaValorReservaAutos.get(i).getLineaReserva())) {
        String valorReserva =
            obtenerElementoLista(
                    tblDatosFinancieros2,
                    Tablas.CABECERAS_CC,
                    Tablas.REGISTROS_CC,
                    datosLineaReservaValorReservaAutos.get(i).getLineaReserva(),
                    datosLineaReservaValorReservaAutos.get(0).getColumnaADevolver())
                .getText();

        if (valorReserva.equals(datosLineaReservaValorReservaAutos.get(i).getValorReserva())) {
          valorLineaReserva = true;
        } else if (!valorReserva.equals(
            datosLineaReservaValorReservaAutos.get(i).getValorReserva())) {
          String totalizarLineaReserva = valorReserva;
          int totalReserva = 0;
          totalizarLineaReserva =
              totalizarLineaReserva.replaceAll(Variables.FORMATEAR_MONTOS.getValor(), "");
          String valorDeducible =
              obtenerElementoLista(
                      tblDatosFinancieros2,
                      Tablas.CABECERAS_CC,
                      Tablas.REGISTROS_CC,
                      datosLineaReservaValorReservaAutos.get(i).getLineaReserva(),
                      datosLineaReservaValorReservaAutos.get(0).getValorDeducible())
                  .getText();
          valorDeducible = valorDeducible.replaceAll(Variables.FORMATEAR_MONTOS.getValor(), "");
          totalReserva = Integer.parseInt(totalizarLineaReserva) + Integer.parseInt(valorDeducible);

          if ((String.valueOf(totalReserva))
              .equals(datosLineaReservaValorReservaAutos.get(i).getValorReserva())) {
            valorLineaReserva = true;
          }
        }
      } else {
        valorLineaReserva = false;
        break;
      }
    }
    return valorLineaReserva;
  }
}

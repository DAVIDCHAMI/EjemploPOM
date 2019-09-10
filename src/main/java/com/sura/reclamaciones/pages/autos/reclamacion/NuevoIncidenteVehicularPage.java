package com.sura.reclamaciones.pages.autos.reclamacion;

import static com.sura.reclamaciones.utils.VariablesSesion.SESION_CC_CONDUCTOR_AFECTADO_SINIESTRO;

import com.sura.reclamaciones.models.ExposicionVehiculoTercero;
import com.sura.reclamaciones.pages.generics.GeneralPage;
import java.util.List;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;

public class NuevoIncidenteVehicularPage extends GeneralPage {

  private int campoDato = 0;

  @FindBy(
    id =
        "NewVehicleIncidentPopup:NewVehicleIncidentScreen:FNOLSuraVehIncidentDetailDV:FNOLSuraVehicleIncidentDV:Vehicle_LicensePlate-inputEl"
  )
  private WebElementFacade txtPlacaVehiculo;

  @FindBy(
    id =
        "NewVehicleIncidentPopup:NewVehicleIncidentScreen:FNOLSuraVehIncidentDetailDV:FNOLSuraVehicleIncidentDV:fasecolda-btnInnerEl"
  )
  private WebElementFacade btnRecuperarInformacion;

  @FindBy(
    xpath =
        "//input[@id='NewVehicleIncidentPopup:NewVehicleIncidentScreen:FNOLSuraVehIncidentDetailDV:FNOLSuraVehicleIncidentDV:Driver_Picker-inputEl'][contains(@class,'x-form-field x-form-text')]"
  )
  private WebElementFacade cmbNombreConductor;

  @FindBy(
    id =
        "NewVehicleIncidentPopup:NewVehicleIncidentScreen:FNOLSuraVehIncidentDetailDV:FNOLSuraVehicleIncidentDV:OtherServicesLVInputGroupInputSet:OtherServicesInputGroup:_checkbox"
  )
  private WebElementFacade chkServicioTaller;

  @FindBy(
    id =
        "NewVehicleIncidentPopup:NewVehicleIncidentScreen:FNOLSuraVehIncidentDetailDV:FNOLSuraVehicleIncidentDV:OtherServicesLVInputGroupInputSet:OtherServicesInputGroup:OtherServicesLVInputSet:OtherServicesLV_tb:AddAutoRepairShopServiceRequest-btnInnerEl"
  )
  private WebElementFacade btnAgregarTaller;

  @FindBy(id = "NewVehicleIncidentPopup:NewVehicleIncidentScreen:FNOLSuraVehIncidentDetailDV:FNOLSuraVehicleIncidentDV:fasecoldaPopup-btnInnerEl"
  )
  private WebElementFacade btnGenerarCodigoFasecolda;

  public NuevoIncidenteVehicularPage(WebDriver wdriver) {
    super(wdriver);
  }

  public void ingresarPlacaVehiculoAfectado(List<ExposicionVehiculoTercero> datosVehiculoTercero, int j)
  {
    int consecutivoPlacaTercero = Integer.parseInt(datosVehiculoTercero.get(campoDato).getPlacaTercero().substring(3,6));
    consecutivoPlacaTercero = consecutivoPlacaTercero + j;
    String placaVehiculoTercero = datosVehiculoTercero.get(campoDato).getPlacaTercero().substring(0,5)+Integer.toString(consecutivoPlacaTercero);
    txtPlacaVehiculo.waitUntilClickable().sendKeys(placaVehiculoTercero);
    realizarEsperaCarga();




    //String placaAsegurado=lblPlacaAsegurado.getText();
    //String placaAseguradoSiniestro= placaAsegurado.substring(7,13);
    /*txtPlacaVehiculo
        .waitUntilClickable()
        .sendKeys(datosVehiculoTercero.get(campoDato).getPlacaTercero());
    realizarEsperaCarga();*/
  }

  public void consultarInformacionVehiculoAfectado() {
    btnRecuperarInformacion.waitUntilVisible().waitUntilClickable().click();
    realizarEsperaCarga();
  }

  public void validarPlacaExisteFasecolda()
  {
    if(btnGenerarCodigoFasecolda.isVisible())
    {
      btnGenerarCodigoFasecolda.click();
    }
    else
    {
      seleccionarConductoVehiculoAfectado();
    }
  }

  public void seleccionarConductoVehiculoAfectado() {
    cmbNombreConductor.waitUntilVisible().waitUntilClickable().click();
    seleccionarOpcionCombobox(
        Serenity.sessionVariableCalled(SESION_CC_CONDUCTOR_AFECTADO_SINIESTRO.getValor()));
    realizarEsperaCarga();
  }

  public void seleccionarServiciosTaller() {
    chkServicioTaller.waitUntilClickable().click();
    realizarEsperaCarga();
  }

  public void seleccionarTaller() {
    btnAgregarTaller.waitUntilClickable().click();
  }
}

package com.sura.reclamaciones.pages.generics;

import static com.sura.reclamaciones.constantes.Constantes.COMODIN;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;

public class UbicacionPage extends GeneralPage {

  @FindBy(
    xpath =
        "//input[@id='FNOLWizard:FNOLWizard_FindPolicyScreen:FNOLWizardFindPolicyPanelSet:locationSearchSura:FNOLWizard_PolicySearchInputSet:CCAddressInputSet:globalAddressContainer:globalAddress:GlobalAddressInputSet:Country-inputEl']"
  )
  private WebElementFacade mnuPais;

  @FindBy(
    xpath =
        "//td[.='Departamento']//div[@class='x-trigger-index-0 x-form-trigger x-form-arrow-trigger x-form-trigger-first']"
  )
  private WebElementFacade mnuDepartamento;

  @FindBy(
    xpath =
        "//input[@id='FNOLWizard:FNOLWizard_FindPolicyScreen:FNOLWizardFindPolicyPanelSet:locationSearchSura:FNOLWizard_PolicySearchInputSet:CCAddressInputSet:globalAddressContainer:globalAddress:GlobalAddressInputSet:Sura_Colombian_City-inputEl']"
  )
  private WebElementFacade txtCiudad;

  private String lstUbicacion = "//li[.='COMODIN']";
  private String auxLstUbicacion = "";

  public UbicacionPage(WebDriver driver) {
    super(driver);
  }

  public void seleccionarPais(String pais) {
    mnuPais.waitUntilVisible();
    mnuPais.click();
    auxLstUbicacion = lstUbicacion.replace(COMODIN.getValor(), pais);
    $(auxLstUbicacion).click();
  }

  public void seleccionarDepartamento(String departamento) {
    mnuDepartamento.waitUntilVisible();
    mnuDepartamento.click();
    auxLstUbicacion = lstUbicacion.replace(COMODIN.getValor(), departamento);
    $(auxLstUbicacion).click();
  }

  public void seleccionarCiudad(String ciudad) {
    txtCiudad.waitUntilVisible();
    realizarEsperaCarga();
    txtCiudad.waitUntilClickable().clear();
    txtCiudad.type(ciudad);
  }
}

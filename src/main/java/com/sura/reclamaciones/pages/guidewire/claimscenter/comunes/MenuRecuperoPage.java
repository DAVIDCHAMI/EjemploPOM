package com.sura.reclamaciones.pages.guidewire.claimscenter.comunes;

import com.sura.reclamaciones.pages.general.GeneralPage;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;

public class MenuRecuperoPage extends GeneralPage {

  @FindBy(xpath = "//span[@id ='Claim:ClaimMenuActions-btnInnerEl']")
  private WebElementFacade btnAcciones;

  @FindBy(
      xpath =
          "//a[@id='Claim:ClaimMenuActions:ClaimMenuActions_NewTransaction:ClaimMenuActions_NewOtherTrans-itemEl']")
  private WebElementFacade mnuOtros;

  @FindBy(
      xpath =
          "//span[@id='Claim:ClaimMenuActions:ClaimMenuActions_NewTransaction:ClaimMenuActions_NewOtherTrans:ClaimMenuActions_NewTransaction_RecoverySet-textEl']")
  private WebElementFacade mnuRecuperos;

  public MenuRecuperoPage(WebDriver driver) {
    super(driver);
  }

  public void ingresarMenuRecupero() {
    btnAcciones.waitUntilClickable();
    btnAcciones.click();
    mnuOtros.waitUntilClickable();
    mnuOtros.click();
    mnuRecuperos.waitUntilClickable();
    mnuRecuperos.click();
  }
}

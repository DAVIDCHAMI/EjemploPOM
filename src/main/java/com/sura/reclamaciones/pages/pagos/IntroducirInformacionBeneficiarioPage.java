package com.sura.reclamaciones.pages.pagos;

import com.sura.reclamaciones.pages.generics.GeneralPage;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;

public class IntroducirInformacionBeneficiarioPage extends GeneralPage {

    public IntroducirInformacionBeneficiarioPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@id='NormalCreateCheckWizard:CheckWizard_CheckPayeesScreen:NewCheckPayeeDV:PrimaryPayee_Name-inputEl']")
    private WebElementFacade selNombreBeneficiario;

    @FindBy(xpath = "//input[@id='NormalCreateCheckWizard:CheckWizard_CheckPayeesScreen:NewCheckPayeeDV:PrimaryPayee_Type-inputEl']")
    private WebElementFacade selTipoBeneficiario;

    @FindBy(xpath = "//input[@id='NormalCreateCheckWizard:CheckWizard_CheckPayeesScreen:NewCheckPayeeDV:PaymentMethod_option1-inputEl']")
    private WebElementFacade rbnTransferenciaElectronica;

    @FindBy(xpath = "//input[@id='NormalCreateCheckWizard:CheckWizard_CheckPayeesScreen:NewCheckPayeeDV:PaymentMethod_option2-inputEl']")
    private WebElementFacade rbnPagoBanco;

    @FindBy(xpath = "//input[@id='NormalCreateCheckWizard:CheckWizard_CheckPayeesScreen:NewCheckPayeeDV:PaymentMethod_option3-inputEl']")
    private WebElementFacade rbnPagoCajaSura;

    @FindBy(xpath = "//input[@id='NormalCreateCheckWizard:CheckWizard_CheckPayeesScreen:NewCheckPayeeDV:PayCoinsuranceOnlySura_Ext_true-inputEl']")
    private WebElementFacade rbnPagoSoloSuraSi;

    @FindBy(xpath = "//input[@id='NormalCreateCheckWizard:CheckWizard_CheckPayeesScreen:NewCheckPayeeDV:PayCoinsuranceOnlySura_Ext_false-inputEl']")
    private WebElementFacade rbnPagoSoloSuraNo;


    public void seleccionarNombreBeneficiario(String strNombreBeneficiario) {
        strNombreBeneficiario  = "Victor Hugo Sepulveda Vallejo";
        selNombreBeneficiario.selectByValue(strNombreBeneficiario);
    }


    public void seleccionarTipoBeneficiario(String strTipoBeneficiario) {
        strTipoBeneficiario  = "Proveedor";
        selTipoBeneficiario.selectByValue(strTipoBeneficiario);
    }

    public void seleccionarMetodoPago(String strMetodoPago){

        strMetodoPago = "transferencia";

        switch (strMetodoPago){

            case "transferencia":
                rbnTransferenciaElectronica.click();
                break;
            case "pago por banco":
                rbnPagoBanco.click();
                break;
            case "caja sura":
                rbnPagoCajaSura.click();
                break;


        }

    }

    public void seleccionarPagoSura(String strPagoSura) {
        strPagoSura = "si";

        if (strPagoSura=="si")
        {
            rbnPagoSoloSuraSi.click();
        }
        rbnPagoSoloSuraNo.click();

    }


}

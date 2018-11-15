package com.sura.reclamaciones.pages.autos.reclamacion;

import com.sura.reclamaciones.models.ExposicionPersona;
import com.sura.reclamaciones.models.ExposicionVehiculoTercero;
import com.sura.reclamaciones.pages.generics.GeneralPage;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class AgregarExposicionPersonaPage extends GeneralPage {

    @FindBy(xpath = "//input[@id='FNOLContactPopup:FNOLContactScreen:ContactDV:InjuredBoolean_true-inputEl']")
    WebElementFacade chkLesiones;

    @FindBy(xpath = "//span[@id='FNOLWizard:AutoWorkersCompWizardStepSet:FNOLWizard_NewLossDetailsScreen:AddPedestrianButton-btnInnerEl']")
    WebElementFacade btnAgregarPeaton;

    @FindBy(xpath = "//td[@id='FNOLContactPopup:FNOLContactScreen:ContactDV:DocumentType_Ext-inputCell']//input")
    WebElementFacade cmbTipoDocumento;

    @FindBy(xpath = "//input[@id='FNOLContactPopup:FNOLContactScreen:ContactDV:TaxID-inputEl']")
    WebElementFacade txtNumeroDocumento;

    @FindBy(xpath = "//input[@id='FNOLContactPopup:FNOLContactScreen:ContactDV:FNOLContactInputSet:GlobalPersonNameInputSet:FirstName-inputEl']")
    WebElementFacade txtPrimerNombre;

    @FindBy(xpath = "//input[@id='FNOLContactPopup:FNOLContactScreen:ContactDV:FNOLContactInputSet:GlobalPersonNameInputSet:LastName-inputEl']")
    WebElementFacade txtPrimerApellido;

    @FindBy(xpath = "//td[@id='FNOLContactPopup:FNOLContactScreen:ContactDV:FNOLContactInputSet:CCAddressInputSet:globalAddressContainer:globalAddress:GlobalAddressInputSet:State-inputCell']//input")
    WebElementFacade cmbDepartamento;

    @FindBy(xpath = "//td[@id='FNOLContactPopup:FNOLContactScreen:ContactDV:FNOLContactInputSet:CCAddressInputSet:globalAddressContainer:globalAddress:GlobalAddressInputSet:Sura_Colombian_City-inputCell']//input")
    WebElementFacade cmbCiudad;

    @FindBy(xpath = "//td[@id='FNOLContactPopup:FNOLContactScreen:ContactDV:FNOLContactInputSet:CCAddressInputSet:globalAddressContainer:Address_AddressType-inputCell']//input")
    WebElementFacade cmbTipoDireccion;

    @FindBy(xpath = "//input[@id='FNOLContactPopup:FNOLContactScreen:ContactDV:FNOLContactInputSet:CCAddressInputSet:globalAddressContainer:globalAddress:GlobalAddressInputSet:AddressLine1-inputEl']")
    WebElementFacade txtDireccion;

    @FindBy(xpath = "//input[@id='FNOLContactPopup:FNOLContactScreen:ContactDV:InjuryIncidentInputSet:Severity-inputEl']")
    WebElementFacade cmbGravedad;

    @FindBy(xpath = "//textarea[@id='FNOLContactPopup:FNOLContactScreen:ContactDV:InjuryIncidentInputSet:InjuryDescription-inputEl']")
    WebElementFacade txtDescibirLesiones;

    @FindBy(xpath = "//input[@id='FNOLContactPopup:FNOLContactScreen:ContactDV:InjuryIncidentInputSet:PrimaryInjuryType-inputEl']")
    WebElementFacade cmbTipoLesion;

    @FindBy(xpath = "//input[@id='FNOLContactPopup:FNOLContactScreen:ContactDV:InjuryIncidentInputSet:DetailedInjuryType-inputEl']")
    WebElementFacade cmbDetalleLesion;

    @FindBy(xpath = "//span[@id='FNOLContactPopup:FNOLContactScreen:ContactDV:InjuryIncidentInputSet:EditableBodyPartDetailsLV_tb:Add-btnInnerEl']")
    WebElementFacade btnAgregarParteCuerpo;

    @FindBy(xpath = "//td[@class='x-grid-cell x-grid-td x-grid-cell-headerId-gridcolumn-1552  g-cell-edit']")
    WebElementFacade btnA;

    public AgregarExposicionPersonaPage(WebDriver wdriver) {
        super(wdriver);
    }

    public void agregarPeaton(List<ExposicionPersona> datosExposicionPersona){
        datosExposicionPersona.forEach(
                dato -> {
                    btnAgregarPeaton.waitUntilVisible().click();
                    cmbTipoDocumento.clear();
                    cmbTipoDocumento.sendKeys(dato.getTipoDocumento());
                    cmbTipoDocumento.sendKeys(Keys.ENTER);
                    realizarEsperaCarga();
                    txtNumeroDocumento.sendKeys(dato.getNumeroDocumentoPeaton());
                    txtPrimerNombre.sendKeys(dato.getPrimerNombrePeaton());
                    txtPrimerApellido.sendKeys(dato.getPrimerApellidoPeaton());
                    cmbDepartamento.clear();
                    cmbDepartamento.sendKeys(dato.getDepartamento());
                    cmbDepartamento.sendKeys(Keys.ENTER);
                    realizarEsperaCarga();
                    cmbCiudad.clear();
                    cmbCiudad.sendKeys(dato.getCiudad());
                    cmbCiudad.sendKeys(Keys.ENTER);
                    realizarEsperaCarga();
                    txtDireccion.sendKeys(dato.getDireccionPeaton());
                    realizarEsperaCarga();
                    cmbTipoDireccion.clear();
                    cmbTipoDireccion.sendKeys(dato.getTipoDireccion());
                    cmbTipoDireccion.sendKeys(Keys.ENTER);
                    chkLesiones.waitUntilVisible().click();
                    cmbGravedad.clear();
                    cmbGravedad.sendKeys(dato.getGravedadLesion());
                    cmbGravedad.sendKeys(Keys.ENTER);
                    realizarEsperaCarga();
                    txtDescibirLesiones.sendKeys(dato.getDescribirLesiones());
                    cmbTipoLesion.clear();
                    cmbTipoLesion.sendKeys(dato.getTipoLesion());
                    cmbTipoLesion.sendKeys(Keys.ENTER);
                    realizarEsperaCarga();
                    cmbDetalleLesion.clear();
                    cmbDetalleLesion.sendKeys(dato.getDetallesTipoLesion());
                    cmbDetalleLesion.sendKeys(Keys.ENTER);
                    realizarEsperaCarga();
                    aceptarOpcion();
                    realizarEsperaCarga();
                }
        );
    }
}

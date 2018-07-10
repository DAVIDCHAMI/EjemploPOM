package com.sura.reclamaciones.pages.notificacionaviso;

import com.sura.reclamaciones.pages.generics.GeneralPage;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;

import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class NuevaReclamacionPage extends GeneralPage {

    public NuevaReclamacionPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = ".//*[@id=':tabs-innerCt']")
    WebElementFacade mnuPrimerNivel;

    @FindBy(xpath = ".//div[contains(@id,'menu-') and @class='x-panel x-layer x-panel-default x-menu x-border-box']")
    WebElementFacade mnuSegundoNivel;

    public void seleccionarOpcionMenuPrimerNivel(String nombreOpcion) {
        mnuPrimerNivel.findElement(By.xpath("//span[contains(text(), '" + nombreOpcion + "')]"));
        clickElemento(mnuPrimerNivel);
    }

    public void seleccionarOpcionMenuSegundoNivel(String nombreOpcion, String subItem) {
        mnuPrimerNivel.findElement(By.xpath(".//a[contains(.,'" + nombreOpcion + "')]"))
                .sendKeys(Keys.ARROW_DOWN);
        mnuSegundoNivel.findElement(By.xpath(".//a[contains(.,'" + subItem + "')]")).click();
    }

}



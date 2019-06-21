package com.sura.reclamaciones.definitions.empresariales.procesoreclamaciones;

import com.sura.reclamaciones.constantes.MenuConstante;
import com.sura.reclamaciones.steps.pagomasivo.CargaArchivoXlsStep;
import com.sura.reclamaciones.steps.pagomasivo.ResultadoValidacionArchivoStep;
import cucumber.api.java.es.Cuando;
import net.thucydides.core.annotations.Steps;

public class PagoMasivoDefinition {
  @Steps CargaArchivoXlsStep cargarArchivoXlsStep;

  @Steps ResultadoValidacionArchivoStep resultadoValidacionArchivoStep;

  @Cuando("^se crea uno o varios pagos a un mismo proveedor")
  public void crearPagoMasivo()
  {
    cargarArchivoXlsStep.cargarArchivoXls(MenuConstante.ESCRITORIO_MENU, MenuConstante.FACTURAS_VOLUMEN_MENU);
    resultadoValidacionArchivoStep.validarNumeroRegistrosArchivo();
  }
}

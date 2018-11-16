package com.sura.reclamaciones.definitions.empresariales;

import com.sura.reclamaciones.models.ReclamacionEmpresarial;
import com.sura.reclamaciones.steps.generics.GenericStep;
import com.sura.reclamaciones.steps.notificacionaviso.NuevaReclamacionAtrEmpresarialStep;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import cucumber.api.java.es.Y;
import net.thucydides.core.annotations.Steps;

public class NotificacionAvisoAtrDefinition {

  @Steps
  NuevaReclamacionAtrEmpresarialStep nuevaReclamacionAtrEmpresarialStep;
  @Steps ReclamacionEmpresarial reclamo;
  @Steps GenericStep genericStep;

    @Dado("^que tenemos una poliza de (.*)$")
    public void NotificacionAvisoAtrDefinition(String cobertura) throws Throwable{
      reclamo =
          new ReclamacionEmpresarial(
              genericStep.getFilasModelo("reclamacion_empresarial", "ATR"));
      nuevaReclamacionAtrEmpresarialStep.accederAvisoEmpresa();
      nuevaReclamacionAtrEmpresarialStep.buscarPolizaAtr(reclamo.getLstReclamo());
      nuevaReclamacionAtrEmpresarialStep.diligenciarFechaAtr();
  }

  @Cuando("^se genere un siniestro por causa (.*) con un valor de pretension de (.*)$")
  public void seGenereUnSiniestroPorCausaCausaConUnValorDePretensionDeValorDePretensión(){


  }

  @Y("^se ajusta la reserva de la categoria de costo (.*)$")
  public void seAjustaLaReservaDeLaCategoriaDeCostoCategoriaDeCosto()  {


  }

  @Entonces("^se obtiene una reclamacion que podrá ser consultada en ClaimCenter$")
  public void seObtieneUnaReclamacionQuePodráSerConsultadaEnClaimCenter()  {


  }
}

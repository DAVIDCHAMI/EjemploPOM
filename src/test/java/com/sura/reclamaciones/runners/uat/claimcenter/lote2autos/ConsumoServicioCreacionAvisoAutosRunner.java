package com.sura.reclamaciones.runners.uat.claimcenter.lote2autos;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
  features = "src/test/resources/features/autos/consumir_servicio_creacion_aviso_autos.feature",
  glue = {"com.sura.reclamaciones.definitions"}
)
public class ConsumoServicioCreacionAvisoAutosRunner {}

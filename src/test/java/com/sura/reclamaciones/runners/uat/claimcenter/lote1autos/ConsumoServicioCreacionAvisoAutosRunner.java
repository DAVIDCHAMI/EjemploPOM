package com.sura.reclamaciones.runners.uat.claimcenter.lote1autos;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
  features = "src/test/resources/features/autos/crear_aviso_autos.feature",
  glue = {"com.sura.reclamaciones.definitions"},
  tags = {"@avisoServicioMaca"}
)
public class ConsumoServicioCreacionAvisoAutosRunner {}

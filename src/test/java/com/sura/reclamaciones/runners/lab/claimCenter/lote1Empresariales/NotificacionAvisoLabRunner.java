package com.sura.reclamaciones.runners.lab.claimcenter.lote1empresariales;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
  features = "src/test/resources/features/notificacionaviso/notificaraviso.feature",
  glue = {"com.sura.reclamaciones.definitions"}
)
public class NotificacionAvisoLabRunner {}

package com.sura.reclamaciones.runners.uat.reclamaciones.soat.e2eTest;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
    features = "src/test/resources/features/soat/reclamaciones/crear_siniestro_soat.feature",
    glue = {"com.sura.reclamaciones.definitions"})
public class CrearSiniestroSoatRunner {}

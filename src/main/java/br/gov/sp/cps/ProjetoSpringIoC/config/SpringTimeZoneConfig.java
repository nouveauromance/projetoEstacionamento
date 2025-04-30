package br.gov.sp.cps.ProjetoSpringIoC.config;

import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Configuration;
import java.util.TimeZone;

@Configuration
public class SpringTimeZoneConfig {

    @PostConstruct // garante que ao iniciar a app "executa" o TimeZoneConfig
    public void TimeZoneConfig() {
        TimeZone.setDefault(TimeZone.getTimeZone("America/Sao_Paulo"));
    }
}

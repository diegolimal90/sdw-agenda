package br.com.sdweb.agenda.configuration.bean.entrypoint;

import br.com.sdweb.agenda.entrypoint.controller.AgendaController;
import br.com.sdweb.agenda.usecase.CadastrarEventoUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ControllerBeanConfiguration {


    @Bean
    public AgendaController agendaController(CadastrarEventoUseCase cadastrarAgendaUseCase){
        return new AgendaController(cadastrarAgendaUseCase);
    }
}

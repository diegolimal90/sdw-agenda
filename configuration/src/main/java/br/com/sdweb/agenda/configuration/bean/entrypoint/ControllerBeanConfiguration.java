package br.com.sdweb.agenda.configuration.bean.entrypoint;

import br.com.sdweb.agenda.entrypoint.controller.AgendaController;
import br.com.sdweb.agenda.usecase.FindEventUseCase;
import br.com.sdweb.agenda.usecase.SaveEventUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ControllerBeanConfiguration {

    @Bean
    public AgendaController agendaController(SaveEventUseCase cadastrarAgendaUseCase, FindEventUseCase findEventUseCase){
        return new AgendaController(cadastrarAgendaUseCase, findEventUseCase);
    }
}

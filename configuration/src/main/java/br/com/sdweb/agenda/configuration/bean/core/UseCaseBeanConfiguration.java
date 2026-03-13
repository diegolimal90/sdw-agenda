package br.com.sdweb.agenda.configuration.bean.core;

import br.com.sdweb.agenda.CalendarDataProvider;
import br.com.sdweb.agenda.usecase.FindEventUseCase;
import br.com.sdweb.agenda.usecase.SaveEventUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseBeanConfiguration {

    @Bean
    public SaveEventUseCase cadastrarEventoUseCase(CalendarDataProvider agendaDataProvider){
        return new SaveEventUseCase(agendaDataProvider);
    }

    @Bean
    public FindEventUseCase findEventUseCase(CalendarDataProvider agendaDataProvider){
        return new FindEventUseCase(agendaDataProvider);
    }
}

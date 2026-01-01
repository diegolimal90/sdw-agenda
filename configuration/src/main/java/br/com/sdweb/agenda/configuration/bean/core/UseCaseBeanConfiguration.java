package br.com.sdweb.agenda.configuration.bean.core;

import br.com.sdweb.agenda.AgendaDataProvider;
import br.com.sdweb.agenda.usecase.CadastrarEventoUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseBeanConfiguration {

    @Bean
    public CadastrarEventoUseCase cadastrarEventoUseCase(AgendaDataProvider agendaDataProvider){
        return new CadastrarEventoUseCase(agendaDataProvider);
    }
}

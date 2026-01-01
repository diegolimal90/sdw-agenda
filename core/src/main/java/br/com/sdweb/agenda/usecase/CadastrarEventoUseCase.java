package br.com.sdweb.agenda.usecase;

import br.com.sdweb.agenda.AgendaGateway;
import br.com.sdweb.agenda.validator.EventoValidator;
import br.com.sdweb.domains.Agenda;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class CadastrarEventoUseCase implements AgendaGateway {

    private final AgendaGateway agendaGateway;

    @Override
    public Agenda cadastrarAgenda(Agenda agenda) {
        EventoValidator.valid(agenda);
        return agendaGateway.cadastrarAgenda(agenda);
    }
}

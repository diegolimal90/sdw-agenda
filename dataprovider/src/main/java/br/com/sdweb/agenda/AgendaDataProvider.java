package br.com.sdweb.agenda;

import br.com.sdweb.agenda.mapper.AgendaMapper;
import br.com.sdweb.agenda.repository.AgendaRepository;
import br.com.sdweb.domains.Agenda;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Slf4j
@Component
@RequiredArgsConstructor
public class AgendaDataProvider implements AgendaGateway {

    private final AgendaRepository agendaRepository;

    @Override
    public Agenda cadastrarAgenda(Agenda agenda) {

        var entity = AgendaMapper.to(agenda);
        entity.setUuid(UUID.randomUUID());
        entity = agendaRepository.save(entity);

        return AgendaMapper.from(entity);
    }
}

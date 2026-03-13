package br.com.sdweb.agenda;

import br.com.sdweb.agenda.mapper.AgendaMapper;
import br.com.sdweb.agenda.out.CalendarOut;
import br.com.sdweb.agenda.repository.CalendarRepository;
import br.com.sdweb.domains.Agenda;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Component
@RequiredArgsConstructor
public class CalendarDataProvider implements CalendarOut {

    private final CalendarRepository calendarRepository;

    @Override
    public Agenda saveEvent(Agenda agenda) {

        var entity = AgendaMapper.to(agenda);
        entity.setUuid(UUID.randomUUID());
        entity = calendarRepository.save(entity);

        return AgendaMapper.from(entity);
    }

    @Override
    public List<Agenda> findByDate(LocalDateTime dateTime){
        return Optional.ofNullable(calendarRepository.findByDtInicioAndDtFimGreater(dateTime))
                .stream()
                .flatMap(List::stream)
                .map(AgendaMapper::from)
                .toList();
    }
}

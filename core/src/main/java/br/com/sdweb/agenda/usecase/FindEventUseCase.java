package br.com.sdweb.agenda.usecase;

import br.com.sdweb.agenda.in.EventIn;
import br.com.sdweb.agenda.out.CalendarOut;
import br.com.sdweb.domains.Agenda;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
public class FindEventUseCase implements EventIn {

    private final CalendarOut gateway;

    public List<Agenda> findEventAll()  throws RuntimeException{
        return gateway.findByDate(LocalDateTime.now());
    }
}

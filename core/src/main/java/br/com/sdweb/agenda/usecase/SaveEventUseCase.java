package br.com.sdweb.agenda.usecase;

import br.com.sdweb.agenda.in.EventIn;
import br.com.sdweb.agenda.out.CalendarOut;
import br.com.sdweb.agenda.validator.EventValidator;
import br.com.sdweb.domains.Agenda;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class SaveEventUseCase implements EventIn {

    private final CalendarOut gateway;

    @Override
    public Agenda saveEvent(Agenda agenda) throws RuntimeException{
        EventValidator.valid(agenda);

        return gateway.saveEvent(agenda);
    }
}

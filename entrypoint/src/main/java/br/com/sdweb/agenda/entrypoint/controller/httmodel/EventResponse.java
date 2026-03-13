package br.com.sdweb.agenda.entrypoint.controller.httmodel;

import br.com.sdweb.agenda.entrypoint.controller.httmodel.enums.RecorrencyEnum;
import br.com.sdweb.agenda.entrypoint.controller.httmodel.enums.TypeEventEnum;

import java.time.LocalDateTime;

public record EventResponse(
        String id,
        String title,
        TypeEventEnum typeEvent,
        RecorrencyEnum recorrency,
        LocalDateTime startDate,
        LocalDateTime endDate,
        String description
) {
}

package br.com.sdweb.agenda.entrypoint.controller.httmodel;

import br.com.sdweb.agenda.entrypoint.controller.httmodel.enums.RecorrencyEnum;
import br.com.sdweb.agenda.entrypoint.controller.httmodel.enums.TypeEventEnum;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

public record SaveEventRequest(
        @NotNull(message = "A propriedade title deve ser informado")
        String title,
        @NotNull(message = "A propriedade typeEvent deve ser informado.")
        TypeEventEnum typeEvent,
        @NotNull(message = "A propriedade recorrency deve ser informado.")
        RecorrencyEnum recorrency,
        @NotNull(message = "A propriedade startDate de ser informada.")
        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
        LocalDateTime startDate,
        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
        LocalDateTime endDate,
        String description
) {
}

package br.com.sdweb.agenda.entrypoint.controller.httmodel;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record IncluirAgendaRequest(
        @NotNull(message = "O titulo deve ser informado") String titulo,
        @NotNull(message = "Tipo de agenda deve ser informado.") String tipoAgenda,
        @NotNull(message = "Data de inicio de ser informada.") LocalDateTime dataInicio,
        LocalDateTime dataFim,
        String descricao
) {
}

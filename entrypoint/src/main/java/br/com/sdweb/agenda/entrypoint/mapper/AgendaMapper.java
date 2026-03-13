package br.com.sdweb.agenda.entrypoint.mapper;

import br.com.sdweb.agenda.entrypoint.controller.httmodel.EventResponse;
import br.com.sdweb.agenda.entrypoint.controller.httmodel.enums.RecorrencyEnum;
import br.com.sdweb.agenda.entrypoint.controller.httmodel.enums.TypeEventEnum;
import br.com.sdweb.domains.Agenda;

import java.time.LocalDateTime;
import java.util.Optional;

public class AgendaMapper {

    public static EventResponse from(Agenda domain){
        return Optional.ofNullable(domain)
                .map(source -> new EventResponse(
                        source.getId(),
                        source.getTitulo(),
                        TypeEventEnum.findByValue(source.getTipoAgenda()),
                        RecorrencyEnum.findByValue(source.getRecorrencia()),
                        source.getDataInicio(),
                        source.getDataFim(),
                        source.getDescricao()))
                .orElseThrow(() -> new RuntimeException("deve retorno um bad request pelo campo estar errado"));
    }
}
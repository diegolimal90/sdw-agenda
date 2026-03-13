package br.com.sdweb.agenda.entrypoint.mapper;

import br.com.sdweb.agenda.entrypoint.controller.httmodel.SaveEventRequest;
import br.com.sdweb.domains.Agenda;

import java.util.Optional;

public class IncluiAgendaMapper {

    public static Agenda to(SaveEventRequest httpmodel){
        return Optional.ofNullable(httpmodel)
                .map(source -> Agenda.builder()
                        .titulo(source.title())
                        .descricao(source.description())
                        .dataInicio(source.startDate())
                        .dataFim(source.endDate())
                        .tipoAgenda(source.typeEvent().getValue())
                        .recorrencia(source.recorrency().getValue())
                        .build())
                .orElseThrow(() -> new RuntimeException("deve retorno um bad request pelo campo estar errado"));
    }
}

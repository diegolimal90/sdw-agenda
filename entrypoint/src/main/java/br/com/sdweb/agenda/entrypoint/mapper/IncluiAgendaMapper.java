package br.com.sdweb.agenda.entrypoint.mapper;

import br.com.sdweb.agenda.entrypoint.controller.httmodel.IncluirAgendaRequest;
import br.com.sdweb.domains.Agenda;

import java.util.Optional;

public class IncluiAgendaMapper {

    public static Agenda to(IncluirAgendaRequest httpmodel){
        return Optional.ofNullable(httpmodel)
                .map(source -> Agenda.builder()
                        .titulo(source.titulo())
                        .descricao(source.descricao())
                        .dataInicio(source.dataInicio())
                        .dataFim(source.dataFim())
                        .tipoAgenda(source.tipoAgenda())
                        .build())
                .orElseThrow(() -> new RuntimeException("deve retorno um bad request poelo campo estar errado"));
    }
}

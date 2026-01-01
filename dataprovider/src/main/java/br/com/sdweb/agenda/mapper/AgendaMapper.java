package br.com.sdweb.agenda.mapper;

import br.com.sdweb.agenda.entities.AgendaDocument;
import br.com.sdweb.domains.Agenda;

import java.util.Optional;
import java.util.UUID;

public class AgendaMapper {

    public static AgendaDocument to(Agenda agenda) {
        return Optional.ofNullable(agenda)
                .map(source -> AgendaDocument.builder()
                        .uuid(Optional.ofNullable(source.getId())
                                .map(UUID::fromString)
                                .orElse(null)
                        )
                        .nmTitulo(source.getTitulo())
                        .dsAgenda(source.getDescricao())
                        .dtInicio(source.getDataInicio())
                        .dtFim(source.getDataFim())
                        .tpAgenda(source.getTipoAgenda())
                        .build())
                .orElse(null);
    }

    public static Agenda from(AgendaDocument entity) {
        return Optional.ofNullable(entity)
                .map(s -> Agenda.builder()
                        .id(s.getUuid().toString())
                        .titulo(s.getNmTitulo())
                        .descricao(s.getDsAgenda())
                        .dataInicio(s.getDtInicio())
                        .dataFim(s.getDtFim())
                        .tipoAgenda(s.getTpAgenda())
                        .build())
                .orElse(null);
    }

}

package br.com.sdweb.agenda.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "agendas")
public class AgendaDocument {
    @Id
    private UUID uuid;

    private String nmTitulo;
    private String dsAgenda;
    private LocalDateTime dtInicio;
    private LocalDateTime dtFim;
    private String tpAgenda;
}

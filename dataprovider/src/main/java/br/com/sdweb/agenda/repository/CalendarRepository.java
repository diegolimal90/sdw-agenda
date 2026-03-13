package br.com.sdweb.agenda.repository;

import br.com.sdweb.agenda.entities.AgendaDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public interface CalendarRepository extends MongoRepository<AgendaDocument, UUID> {

    @Query(value = """
                {
                    $or: [
                        { \"dtInicio\": { $gte: ?0 } },
                        { \"dtFim\": { $gte: ?0 } }
                    ]
                }
            """)
    List<AgendaDocument> findByDtInicioAndDtFimGreater(LocalDateTime dtInicio);
}

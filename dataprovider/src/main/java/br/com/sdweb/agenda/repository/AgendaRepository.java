package br.com.sdweb.agenda.repository;

import br.com.sdweb.agenda.entities.AgendaDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface AgendaRepository extends MongoRepository<AgendaDocument, UUID> {
}

package models;

import com.google.inject.ImplementedBy;

import java.util.concurrent.CompletionStage;
import java.util.stream.Stream;

/**
 * This interface provides a non-blocking API for possibly blocking operations.
 */
@ImplementedBy(JPAPersonaRepository.class)
public interface PersonaRepository {

    CompletionStage<persona> add(persona persona);
    CompletionStage<Stream<persona>> list();
    CompletionStage<Stream<persona>>  findId(Long id);
}

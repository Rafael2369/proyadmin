package models;

import com.google.inject.ImplementedBy;

import java.util.concurrent.CompletionStage;
import java.util.stream.Stream;

/**
 * This interface provides a non-blocking API for possibly blocking operations.
 */
@ImplementedBy(JPAUnidadMedidaRepository.class)
public interface unidadMedidaRepository {

    CompletionStage<unidadMedida> add(unidadMedida unidadMedida);

    CompletionStage<Stream<unidadMedida>> list();
}

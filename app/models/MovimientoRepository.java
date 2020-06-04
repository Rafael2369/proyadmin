package models;

import com.google.inject.ImplementedBy;

import java.util.concurrent.CompletionStage;
import java.util.stream.Stream;

/**
 * This interface provides a non-blocking API for possibly blocking operations.
 */
@ImplementedBy(JPAMovimientoRepository.class)
public interface MovimientoRepository {
    CompletionStage<movimiento> add(movimiento movimiento);
    CompletionStage<Stream<movimiento>> list();
	CompletionStage<Stream<movimiento>> findId(movimiento m);
}

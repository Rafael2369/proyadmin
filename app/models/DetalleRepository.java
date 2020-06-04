package models;

import com.google.inject.ImplementedBy;

import java.util.concurrent.CompletionStage;
import java.util.stream.Stream;

/**
 * This interface provides a non-blocking API for possibly blocking operations.
 */
@ImplementedBy(JPADetalleRepository.class)
public interface DetalleRepository {
    CompletionStage<detalle> add(detalle detalle);
    CompletionStage<Stream<detalle>> list();
	CompletionStage<Stream<movimientoDetalle>> listmovimientoDetalle(movimientoDetalle movimientoDetalle);
}

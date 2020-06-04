package models;

import com.google.inject.ImplementedBy;

import java.util.concurrent.CompletionStage;
import java.util.stream.Stream;

/**
 * This interface provides a non-blocking API for possibly blocking operations.
 */
@ImplementedBy(JPAProductoRepository.class)
public interface ProductoRepository {

    CompletionStage<producto> add(producto producto);
    CompletionStage<producto> edit(producto producto);
    CompletionStage<producto> del(producto producto);

    CompletionStage<Stream<producto>> list(producto producto);
    CompletionStage<Stream<producto>> findCodigoBarra(producto producto);
}

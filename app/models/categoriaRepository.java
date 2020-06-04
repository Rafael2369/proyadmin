package models;

import com.google.inject.ImplementedBy;

import java.util.concurrent.CompletionStage;
import java.util.stream.Stream;

/**
 * This interface provides a non-blocking API for possibly blocking operations.
 */
@ImplementedBy(JPACategoriaRepository.class)
public interface categoriaRepository {

    CompletionStage<categoria> add(categoria categoria);
    CompletionStage<Stream<categoria>> list();
    CompletionStage<Stream<categoria>> listCategoriaArea();
}

package models;

import com.google.inject.ImplementedBy;

import java.util.concurrent.CompletionStage;
import java.util.stream.Stream;

/**
 * This interface provides a non-blocking API for possibly blocking operations.
 */
@ImplementedBy(JPAPantallaRepository.class)
public interface PantallaRepository {

    CompletionStage<pantalla> add(pantalla persona);

    CompletionStage<Stream<pantalla>> list(String usuario);
}

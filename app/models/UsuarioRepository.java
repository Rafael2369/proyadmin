package models;

import com.google.inject.ImplementedBy;

import java.util.List;
import java.util.concurrent.CompletionStage;
import java.util.stream.Stream;

/**
 * This interface provides a non-blocking API for possibly blocking operations.
 */
@ImplementedBy(JPAUsuarioRepository.class)
public interface UsuarioRepository {

    CompletionStage<usuario> add(usuario Usuario);
    CompletionStage<Stream<usuario>> list();
    CompletionStage<Stream<usuario>> findId(usuario usuario);
    CompletionStage<Stream<colonia>> findColonia(colonia colonia);
}

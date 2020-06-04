package models;

import play.db.jpa.JPAApi;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;
import java.util.concurrent.CompletionStage;
import java.util.function.Function;
import java.util.stream.Stream;

import static java.util.concurrent.CompletableFuture.supplyAsync;

/**
 * Provide JPA operations running inside of a thread pool sized to the connection pool
 */
public class JPAUnidadMedidaRepository implements unidadMedidaRepository {
    private final JPAApi jpaApi;
    private final DatabaseExecutionContext executionContext;
    @Inject
    public JPAUnidadMedidaRepository(JPAApi jpaApi, DatabaseExecutionContext executionContext) {
        this.jpaApi = jpaApi;
        this.executionContext = executionContext;
    }

    @Override
    public CompletionStage<unidadMedida> add(unidadMedida unidadMedida) {
        return supplyAsync(() -> wrap(em -> insert(em, unidadMedida)), executionContext);
    }

    @Override
    public CompletionStage<Stream<unidadMedida>> list() {
        return supplyAsync(() -> wrap(em -> list(em)), executionContext);
    }

    private <T> T wrap(Function<EntityManager, T> function) {
        return jpaApi.withTransaction(function);
    }

    private unidadMedida insert(EntityManager em, unidadMedida unidadMedida) {

            //unidadMedida.PER_IDPERSONA = System.currentTimeMillis(); // not ideal, but it works
         em.persist(unidadMedida);
        em.flush();

        em.refresh(unidadMedida);
            return unidadMedida;

        //em.persist(unidadMedida);

        //return unidadMedida;
    }

    private Stream<unidadMedida> list(EntityManager em) {
        List<unidadMedida> persons = em.createQuery("select p from unidadMedida p", unidadMedida.class).getResultList();
        return persons.stream();
    }
}

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
public class JPAMarcaRepository implements MarcaRepository {
    private final JPAApi jpaApi;
    private final DatabaseExecutionContext executionContext;
    @Inject
    public JPAMarcaRepository(JPAApi jpaApi, DatabaseExecutionContext executionContext) {
        this.jpaApi = jpaApi;
        this.executionContext = executionContext;
    }

    @Override
    public CompletionStage<marca> add(marca marca) {
        return supplyAsync(() -> wrap(em -> insert(em, marca)), executionContext);
    }

    @Override
    public CompletionStage<Stream<marca>> list() {
        return supplyAsync(() -> wrap(em -> list(em)), executionContext);
    }

    private <T> T wrap(Function<EntityManager, T> function) {
        return jpaApi.withTransaction(function);
    }

    private marca insert(EntityManager em, marca marca) {

            //marca.PER_IDPERSONA = System.currentTimeMillis(); // not ideal, but it works
         em.persist(marca);
        em.flush();

        em.refresh(marca);
            return marca;

        //em.persist(marca);

        //return marca;
    }

    private Stream<marca> list(EntityManager em) {
        List<marca> persons = em.createQuery("select p from marca p", marca.class).getResultList();
        return persons.stream();
    }
}

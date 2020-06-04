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
public class JPAPresentacionRepository implements PresentacionRepository {
    private final JPAApi jpaApi;
    private final DatabaseExecutionContext executionContext;
    @Inject
    public JPAPresentacionRepository(JPAApi jpaApi, DatabaseExecutionContext executionContext) {
        this.jpaApi = jpaApi;
        this.executionContext = executionContext;
    }

    @Override
    public CompletionStage<presentacion> add(presentacion presentacion) {
        return supplyAsync(() -> wrap(em -> insert(em, presentacion)), executionContext);
    }

    @Override
    public CompletionStage<Stream<presentacion>> list() {
        return supplyAsync(() -> wrap(em -> list(em)), executionContext);
    }

    private <T> T wrap(Function<EntityManager, T> function) {
        return jpaApi.withTransaction(function);
    }

    private presentacion insert(EntityManager em, presentacion presentacion) {

            //presentacion.PER_IDPERSONA = System.currentTimeMillis(); // not ideal, but it works
         em.persist(presentacion);
        em.flush();

        em.refresh(presentacion);
            return presentacion;

        //em.persist(presentacion);

        //return presentacion;
    }

    private Stream<presentacion> list(EntityManager em) {
        List<presentacion> persons = em.createQuery("select p from presentacion p", presentacion.class).getResultList();
        return persons.stream();
    }
}

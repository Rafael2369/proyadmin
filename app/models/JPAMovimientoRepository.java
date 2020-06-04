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
public class JPAMovimientoRepository implements MovimientoRepository {
    private final JPAApi jpaApi;
    private final DatabaseExecutionContext executionContext;
    @Inject
    public JPAMovimientoRepository(JPAApi jpaApi, DatabaseExecutionContext executionContext) {
        this.jpaApi = jpaApi;
        this.executionContext = executionContext;
    }

    @Override
    public CompletionStage<movimiento> add(movimiento movimiento) {
        return supplyAsync(() -> wrap(em -> insert(em, movimiento)), executionContext);
    }

    @Override
    public CompletionStage<Stream<movimiento>> list() {
        return supplyAsync(() -> wrap(em -> list(em)), executionContext);
    }
	
	@Override
    public CompletionStage<Stream<movimiento>> findId(movimiento m) {
        return supplyAsync(() -> wrap(em -> findId(em, m)), executionContext);
    }

    private <T> T wrap(Function<EntityManager, T> function) {
        return jpaApi.withTransaction(function);
    }

    private movimiento insert(EntityManager em, movimiento movimiento) {

            //movimiento.PER_IDPERSONA = System.currentTimeMillis(); // not ideal, but it works
        em.persist(movimiento);
        em.flush();

        em.refresh(movimiento);
            return movimiento;

        //em.persist(movimiento);

        //return movimiento;
    }

    private Stream<movimiento> list(EntityManager em) {
        List<movimiento> persons = em.createQuery("select p from movimiento p", movimiento.class).getResultList();
        return persons.stream();
    }
	private Stream<movimiento> findId(EntityManager em,movimiento m ) {
		System.out.println("-------->"+m.getMOV_IDPERSONA());
        List<movimiento> persons = em.createQuery("SELECT p FROM movimiento p WHERE mov_idpersona='"+m.getMOV_IDPERSONA()+"'", movimiento.class).getResultList();
        return persons.stream();
    }
}

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
public class JPACategoriaRepository implements categoriaRepository {
    private final JPAApi jpaApi;
    private final DatabaseExecutionContext executionContext;
    @Inject
    public JPACategoriaRepository(JPAApi jpaApi, DatabaseExecutionContext executionContext) {
        this.jpaApi = jpaApi;
        this.executionContext = executionContext;
    }

    @Override
    public CompletionStage<categoria> add(categoria categoria) {
        return supplyAsync(() -> wrap(em -> insert(em, categoria)), executionContext);
    }

    @Override
    public CompletionStage<Stream<categoria>> listCategoriaArea(){
        return supplyAsync(() -> wrap(em -> listCategoriaArea(em)), executionContext);
    }
	@Override
    public CompletionStage<Stream<categoria>> list() {
        return supplyAsync(() -> wrap(em -> list(em)), executionContext);
    }

    private <T> T wrap(Function<EntityManager, T> function) {
        return jpaApi.withTransaction(function);
    }

    private categoria insert(EntityManager em, categoria categoria) {

            //categoria.PER_IDPERSONA = System.currentTimeMillis(); // not ideal, but it works
         em.persist(categoria);
        em.flush();

        em.refresh(categoria);
            return categoria;

        //em.persist(categoria);

        //return categoria;
    }

    private Stream<categoria> listCategoriaArea(EntityManager em) {
        List<categoria> persons = em.createQuery("select p from categoria p", categoria.class).getResultList();
        return persons.stream();
    }
	
    private Stream<categoria> list(EntityManager em) {
        List<categoria> persons = em.createQuery("select p from categoria p group by p.CAT_NOMBRE", categoria.class).getResultList();
        return persons.stream();
    }
}

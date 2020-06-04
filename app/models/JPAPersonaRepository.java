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
public class JPAPersonaRepository implements PersonaRepository {
    private final JPAApi jpaApi;
    private final DatabaseExecutionContext executionContext;
    @Inject
    public JPAPersonaRepository(JPAApi jpaApi, DatabaseExecutionContext executionContext) {
        this.jpaApi = jpaApi;
        this.executionContext = executionContext;
    }

    @Override
    public CompletionStage<persona> add(persona persona) {
        return supplyAsync(() -> wrap(em -> insert(em, persona)), executionContext);
    }

    @Override
    public CompletionStage<Stream<persona>> list() {
        return supplyAsync(() -> wrap(em -> list(em)), executionContext);
    }
	@Override
    public CompletionStage<Stream<persona>> findId(Long id){
        return supplyAsync(() -> wrap(em -> findId(em, id)), executionContext);
    }

    private <T> T wrap(Function<EntityManager, T> function) {
        return jpaApi.withTransaction(function);
    }

    private persona insert(EntityManager em, persona persona) {
        em.persist(persona);
        em.flush();
        em.refresh(persona);
        return persona;
    }

    private Stream<persona> list(EntityManager em) {
        List<persona> persons = em.createQuery("select p from persona p", persona.class).getResultList();
        return persons.stream();
    }
	
    private Stream<persona> findId(EntityManager em, Long id) {
        List<persona> persons = em.createQuery("SELECT p FROM persona p WHERE p.PER_IDPERSONA  = '"+id+"'", persona.class).getResultList();
        return persons.stream();
    }
}

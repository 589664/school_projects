package pakke1;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class Kontor_DAO {
	
	@PersistenceContext(name = "deltagerPU")
    private EntityManager em;
	
	public void leggTil(Kontor kontor) {
		em.persist(kontor);
	}
	
	public List<Kontor> hente_alle_kontor() {
		return em.createQuery("SELECT k FROM Kontor k", Kontor.class).getResultList();
	}

}

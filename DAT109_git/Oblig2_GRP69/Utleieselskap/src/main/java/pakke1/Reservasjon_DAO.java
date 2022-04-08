package pakke1;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class Reservasjon_DAO {
	
	@PersistenceContext(name = "deltagerPU")
    private EntityManager em;
	
	public void leggTil(Reservasjon res) {
		em.persist(res);
	}
	
	public List<Reservasjon> hente_alle_res() {
		return em.createQuery("SELECT r FROM Reservasjon r", Reservasjon.class).getResultList();
	}
}

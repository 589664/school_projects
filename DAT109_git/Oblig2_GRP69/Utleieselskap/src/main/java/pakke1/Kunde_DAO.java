package pakke1;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class Kunde_DAO {
	
	@PersistenceContext(name = "deltagerPU")
    private EntityManager em;
	
	public void leggTil(Kunde nydeltager) {
		em.persist(nydeltager);
	}
	
	public Kunde hentKunde(Integer mobil) {
		return em.find(Kunde.class, mobil);
	}
	
	public List<Kunde> hente_alle_kunder() {
		return em.createQuery("SELECT k FROM Kunde k", Kunde.class).getResultList();
	}
	
}//class end

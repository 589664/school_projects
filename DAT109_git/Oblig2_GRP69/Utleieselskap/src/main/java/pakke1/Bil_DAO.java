package pakke1;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class Bil_DAO {
	
	@PersistenceContext(name = "deltagerPU")
    private EntityManager em;
	
	public List<Bil> hente_alle_biler() {
		return em.createQuery("SELECT b FROM Bil b", Bil.class).getResultList();
	}

}

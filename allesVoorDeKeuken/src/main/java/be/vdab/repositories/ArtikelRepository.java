package be.vdab.repositories;

import java.util.List;
import java.util.Optional;

import be.vdab.entities.Artikel;

public class ArtikelRepository extends AbstractRepository{

	public Optional<Artikel> read(Long id) {
			return Optional.ofNullable(getEntityManager().find(Artikel.class, id));
	}
	
	public void create(Artikel artikel){
		getEntityManager().persist(artikel);
	}
	
	public List<Artikel> findByNameContains(String woord){
		return getEntityManager().createNamedQuery("Artikel.findByNameContains", Artikel.class).setParameter("zoals", '%' + woord + '%').getResultList();
	}
	
}

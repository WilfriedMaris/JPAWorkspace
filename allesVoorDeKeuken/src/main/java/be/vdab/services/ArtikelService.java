package be.vdab.services;

import java.util.List;
import java.util.Optional;

import be.vdab.entities.Artikel;
import be.vdab.repositories.ArtikelRepository;

public class ArtikelService extends AbstractService {
	private final ArtikelRepository artikelRepository = new ArtikelRepository();

	public void createArtikel(Artikel artikel) {
		begin();
		try {
			artikelRepository.create(artikel);
			commit();
		} catch (RuntimeException ex) {
			rollback();
			throw ex;
		}
	}

	public Optional<Artikel> read(long id) {
			return artikelRepository.read(id);
	}
	
	public List<Artikel> findByNameContains(String woord){
		return artikelRepository.findByNameContains(woord);
	}
	
	public List<Artikel> findAll(){
		return artikelRepository.findAll();
	}
}
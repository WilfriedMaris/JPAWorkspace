package be.vdab.services;

import java.util.Optional;

import javax.persistence.EntityManager;

import be.vdab.entities.Artikel;
import be.vdab.filters.JPAFilter;
import be.vdab.repositories.ArtikelRepository;

public class ArtikelService {
	private final ArtikelRepository artikelRepository = new ArtikelRepository();

	public void createArtikel(Artikel artikel) {
		EntityManager entityManager = JPAFilter.getEntitymanager();
		entityManager.getTransaction().begin();
		try {
			artikelRepository.create(artikel, entityManager);
			entityManager.getTransaction().commit();
		} catch (RuntimeException ex) {
			entityManager.getTransaction().rollback();
			throw ex;
		} finally {
			entityManager.close();
		}
	}

	public Optional<Artikel> read(long id) {
		EntityManager entityManager = JPAFilter.getEntitymanager();
		try {
			return artikelRepository.read(id, entityManager);
		} finally {
			entityManager.close();
		}
	}
}

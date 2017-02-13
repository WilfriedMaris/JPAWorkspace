package be.vdab.entities;

import java.io.Serializable;
import java.util.Collections;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="artikelgroepen")
public class ArtikelGroep implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String naam;
	@OneToMany(mappedBy = "artikelgroep")
	private Set<Artikel> artikels;

	public long getId() {
		return id;
	}

	public String getNaam() {
		return naam;
	}

	@Override
	public int hashCode() {
		return naam.toUpperCase().hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof ArtikelGroep))
			return false;
		ArtikelGroep other = (ArtikelGroep) obj;
		return naam.equalsIgnoreCase(other.naam);
	}

	public Set<Artikel> getArtikels() {
		return Collections.unmodifiableSet(artikels);
	}
	
	public void addArtikel(Artikel artikel){
		artikels.add(artikel);
		if(artikel.getArtikelgroep() != this){
			artikel.setArtikelGroep(this);
		}
	}
	
	public void remove(Artikel artikel){
		artikels.remove(artikel);
		if(artikel.getArtikelgroep() == this){
			artikel.setArtikelGroep(null);
		}
	}

}

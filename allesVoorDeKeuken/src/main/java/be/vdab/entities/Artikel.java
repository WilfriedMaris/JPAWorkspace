package be.vdab.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import be.vdab.valueobjects.Korting;

@Entity
@Inheritance (strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "artikels")
@DiscriminatorColumn(name = "soort")
@NamedEntityGraph(name=Artikel.MET_ARTIKELGROEP, 
	attributeNodes = @NamedAttributeNode("artikelgroep"))
public abstract class Artikel implements Serializable{
	private static final long serialVersionUID = 1L;
	public static final String MET_ARTIKELGROEP = "Artikel.metArtikelGroep";
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String naam;
	private BigDecimal aankoopprijs;
	private BigDecimal verkoopprijs;
	@ElementCollection
	@CollectionTable(name ="kortingen",
	joinColumns = @JoinColumn(name="artikelid"))
	@OrderBy("vanafAantal")
	private Set<Korting> kortingen;
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "artikelgroepid")
	private ArtikelGroep artikelgroep;
	
	protected Artikel() {}
	
	public Artikel(String naam, BigDecimal aankoopprijs, BigDecimal verkooppprijs, ArtikelGroep artikelgroep){
		setNaam(naam);
		setAankoopprijs(aankoopprijs);
		setVerkoopprijs(verkooppprijs);
		kortingen = new LinkedHashSet<>();
		setArtikelGroep(artikelgroep);
	}
	
	public static boolean isNaamValid(String naam){
		return !naam.isEmpty() && naam != null;
	}
	
	public static boolean isAankoopprijsValid(BigDecimal aankoopprijs){
		return aankoopprijs != null && aankoopprijs.compareTo(BigDecimal.valueOf(0.01)) >= 0;
	}
	
	public static boolean isVerkoopprijsValid(BigDecimal verkoopprijs, BigDecimal aankoopprijs){
		return verkoopprijs != null && verkoopprijs.compareTo(aankoopprijs) >= 0;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNaam() {
		return naam;
	}
	public void setNaam(String naam) {
		this.naam = naam;
	}
	public BigDecimal getAankoopprijs() {
		return aankoopprijs;
	}
	public void setAankoopprijs(BigDecimal aankoopprijs) {
		this.aankoopprijs = aankoopprijs;
	}
	public BigDecimal getVerkoopprijs() {
		return verkoopprijs;
	}
	public void setVerkoopprijs(BigDecimal verkoopprijs) {
		this.verkoopprijs = verkoopprijs;
	}
	
	public Set<Korting> getKortingen(){
		return Collections.unmodifiableSet(kortingen);
	}

	public void setArtikelGroep(ArtikelGroep artikelGroep) {
		if(this.artikelgroep != null && this.artikelgroep.getArtikels().contains(this)){
			this.artikelgroep.remove(this);
		}
		this.artikelgroep = artikelGroep;
		if(artikelGroep != null && ! artikelGroep.getArtikels().contains(this)){
			artikelGroep.addArtikel(this);
		}
	}
	
	@Override
	public boolean equals(Object obj){
		if(!(obj instanceof Artikel)){
			return false;
		}
		Artikel other = (Artikel) obj;
		return naam.equalsIgnoreCase(other.naam);
	}
	
	@Override
	public int hashCode(){
		return naam.toUpperCase().hashCode();
	}

	public ArtikelGroep getArtikelgroep() {
		return artikelgroep;
	}
	
}

package be.vdab.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "artikels")
public class Artikel implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String naam;
	private BigDecimal aankoopprijs;
	private BigDecimal verkoopprijs;
	
	protected Artikel() {}
	
	public Artikel(String naam, BigDecimal aankoopprijs, BigDecimal verkooppprijs){
		setNaam(naam);
		setAankoopprijs(aankoopprijs);
		setVerkoopprijs(verkooppprijs);
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
	
}
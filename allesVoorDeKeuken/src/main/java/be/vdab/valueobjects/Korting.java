package be.vdab.valueobjects;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Embeddable;

@Embeddable
public class Korting implements Serializable{
	private static final long serialVersionUID = 1L;
	private int vanafAantal;
	private BigDecimal kortingspercentage;

	public int getVanafAantal() {
		return vanafAantal;
	}

	public BigDecimal getKortingspercentage() {
		return kortingspercentage;
	}
	
	public boolean equals(Object object){
		if( ! (object instanceof Korting)){
			return false;
		}
		Korting korting = (Korting) object;
		return vanafAantal == korting.vanafAantal;
	}
	
	public int hashCode(){
		return vanafAantal;
	}

}

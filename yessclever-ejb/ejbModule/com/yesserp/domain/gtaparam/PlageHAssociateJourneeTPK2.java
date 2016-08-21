package com.yesserp.domain.gtaparam;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class PlageHAssociateJourneeTPK2 implements Serializable{
	
	
private static final long serialVersionUID =1L ;
private int idPlageHorraire ;
private int idJourneeType ;
private int heureDeb ;

public PlageHAssociateJourneeTPK2 () {	
	
}

public int getIdPlageHorraire() {
	return idPlageHorraire;
}

public int getIdJourneeType() {
	return idJourneeType;
}

public int getHeureDeb() {
	return heureDeb;
}

public void setIdPlageHorraire(int idPlageHorraire) {
	this.idPlageHorraire = idPlageHorraire;
}

public void setIdJourneeType(int idJourneeType) {
	this.idJourneeType = idJourneeType;
}

public void setHeureDeb(int heureDeb) {
	this.heureDeb = heureDeb;
}

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + heureDeb;
	result = prime * result + idJourneeType;
	result = prime * result + idPlageHorraire;
	return result;
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	PlageHAssociateJourneeTPK2 other = (PlageHAssociateJourneeTPK2) obj;
	if (heureDeb != other.heureDeb)
		return false;
	if (idJourneeType != other.idJourneeType)
		return false;
	if (idPlageHorraire != other.idPlageHorraire)
		return false;
	return true;
}


	

}

package com.yesserp.sessionbean.pg.gestionPerson;

import java.util.List;
import javax.ejb.Local;
import com.yesserp.domain.pg.Person;



@Local
public interface GestionPersonLocal {
	
	
	public void ajouterPerson(Person i);
	public void supprimerPerson(Person i);
	public void modifierPerson(Person i);
	public List<Person> AfficherTousPerson();
	
/*
	
	public List<Person> trouverParNumPerson(String numPerson);
	public List<Person> trouverParNom(String nom);
	*/
	

	

}

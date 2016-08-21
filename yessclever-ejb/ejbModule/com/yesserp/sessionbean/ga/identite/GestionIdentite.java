package com.yesserp.sessionbean.ga.identite;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.yesserp.domain.ga.Adresse;
import com.yesserp.domain.ga.Affectation;
import com.yesserp.domain.ga.Certification;
import com.yesserp.domain.ga.Contrat;
import com.yesserp.domain.ga.CoordonneeBancaire;
import com.yesserp.domain.ga.Cycle;
import com.yesserp.domain.ga.DiplomeGa;
import com.yesserp.domain.ga.Embauche;
import com.yesserp.domain.ga.Experience;
import com.yesserp.domain.ga.Identite;
import com.yesserp.domain.ga.InfosIndividuelles;
import com.yesserp.domain.ga.InfosPhysiques;
import com.yesserp.domain.ga.Mail;
import com.yesserp.domain.ga.Naissance;
import com.yesserp.domain.ga.Nationalite;
import com.yesserp.domain.ga.PersonneACharge;
import com.yesserp.domain.ga.PieceIdentite;
import com.yesserp.domain.ga.Profil;
import com.yesserp.domain.ga.SituationCivile;
import com.yesserp.domain.ga.SituationMedicale;
import com.yesserp.domain.ga.Statut;
import com.yesserp.domain.ga.Telephone;
import com.yesserp.domain.ga.Vehicule;
import com.yesserp.domain.gta.ClasseEmp;
import com.yesserp.domain.gta.ContratGta;
import com.yesserp.domain.gtaparam.GroupeActivite;
import com.yesserp.domain.gtaparam.GroupeCompteur;
import com.yesserp.domain.gtaparam.GroupeImputation;
import com.yesserp.domain.pg.Age;
import com.yesserp.domain.pg.DateEmbauche;

/**
 * Session Bean implementation class GestionIdentite
 */
@Stateless
@LocalBean
public class GestionIdentite implements GestionIdentiteLocal {

	/**
	 * Default constructor.
	 */
	@PersistenceContext(unitName = "yessclever")
	private EntityManager em;

	public GestionIdentite() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean ajouterIdentite(Identite i) {
		try {
			em.persist(i);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public void ajouterFicheIndividuelle(Identite identite,
			InfosIndividuelles infosIndividuelles) {
		try {
			infosIndividuelles.setIdentite(identite);
			em.persist(infosIndividuelles);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void supprimerIdentite(Identite i) {

		em.remove(em.merge(i));
	}

	@Override
	public void modifierIdentite(Identite i) {

		em.merge(i);
	}

	@Override
	public Identite trouverParNumeroDossier(Long numdoss) {
		Identite i = em.find(Identite.class, numdoss);
		return i;
	}

	@Override
	public Identite trouverParMatricule(String matricule) {
		Query q = em
				.createQuery("select i from Identite i where matricul = :matricule");
		q.setParameter("matricule", matricule);
		Identite i = null;
		try {
			i = (Identite) q.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}
	
	@Override
	public List<Identite> trouverParNom(String nom) {
		Query q = em.createQuery("select i from Identite i where nom LIKE :nom");
		q.setParameter("nom", nom);
		List<Identite> li = null;
		try {
			li = (List<Identite>) q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return li;
	} 
	
	

	@Override
	public void ajouterFichePhysique(Identite identite,
			InfosPhysiques infosPhysiques) {
		try {
			infosPhysiques.setIdentite(identite);
			em.persist(infosPhysiques);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void ajouterCycle(Identite identite, Cycle cycle) {
		try {
			cycle.setIdentite(identite);
			em.persist(cycle);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void ajouterProfil(Identite identite, Profil profil) {
		try {
			profil.setIdentite(identite);
			em.persist(profil);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void ajouterAdresse(Identite identite, Adresse adresse) {
		try {
			adresse.setIdentite(identite);
			em.persist(adresse);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void ajouterSituationCivile(Identite identite,
			SituationCivile situationCivile) {
		try {
			situationCivile.setIdentite(identite);
			em.persist(situationCivile);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void ajouterPersonneACharge(Identite identite,
			PersonneACharge aCharge) {
		try {
			aCharge.setIdentite(identite);
			em.persist(aCharge);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void ajouterListePersonneACharge(Identite identite,
			List<PersonneACharge> aCharges) {
		try {
			ArrayList<PersonneACharge> personnesACharges = (ArrayList<PersonneACharge>) aCharges;
			for (int i = 0; i < personnesACharges.size(); i++) {
				PersonneACharge aCharge = personnesACharges.get(i);
				aCharge.setIdentite(identite);
				em.persist(aCharge);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void ajouterEmbauche(Identite identite, Embauche embauche) {

		try {
			embauche.setIdentite(identite);
			em.persist(embauche);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void ajouterTelephone(Identite identite, Telephone telephone) {
		try {
			telephone.setIdentite(identite);
			em.persist(telephone);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void ajouterListeTelephones(Identite identite,
			List<Telephone> telephones) {
		try {
			ArrayList<Telephone> teArrayList = (ArrayList<Telephone>) telephones;
			for (int i = 0; i < teArrayList.size(); i++) {
				Telephone telephone = teArrayList.get(i);
				telephone.setIdentite(identite);
				em.persist(telephone);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void ajouterMail(Identite identite, Mail mail) {
		try {
			mail.setIdentite(identite);
			em.persist(mail);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void ajouterListeMails(Identite identite, List<Mail> mails) {
		try {
			ArrayList<Mail> maArrayList = (ArrayList<Mail>) mails;
			for (int i = 0; i < maArrayList.size(); i++) {
				Mail mail = maArrayList.get(i);
				mail.setIdentite(identite);
				em.persist(mail);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void ajouterStatut(Identite identite, Statut statut) {
		try {
			statut.setIdentite(identite);
			em.persist(statut);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public List<Identite> findAll() {
		Query query = em.createQuery("select i from Identite i");
		return query.getResultList();
	}

	@Override
	public void ajouterListeAdresses(Identite identite, List<Adresse> adresses) {
		try {
			ArrayList<Adresse> adresses2 = (ArrayList<Adresse>) adresses;
			for (int i = 0; i < adresses2.size(); i++) {
				Adresse adresse = adresses2.get(i);
				adresse.setIdentite(identite);
				em.persist(adresse);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void ajouterNaissance(Identite identite, Naissance naissance) {
		try {
			naissance.setIdentite(identite);
			em.persist(naissance);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void ajouterCoordonneeBancaire(Identite identite,
			CoordonneeBancaire coordonneeBancaire) {
		try {
			coordonneeBancaire.setIdentite(identite);
			em.persist(coordonneeBancaire);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void ajouterNationalite(Identite identite, Nationalite nationalite) {
		try {
			nationalite.setIdentite(identite);
			em.persist(nationalite);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void ajouterSituationMedicale(Identite identite,
			SituationMedicale situationMedicale) {
		try {
			situationMedicale.setIdentite(identite);
			em.persist(situationMedicale);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void ajouterVehicule(Identite identite, Vehicule vehicule) {
		try {
			vehicule.setIdentite(identite);
			em.persist(vehicule);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void ajouterListCoordonneeBancaires(Identite identite,
			List<CoordonneeBancaire> coordonneeBancaires) {
		try {
			ArrayList<CoordonneeBancaire> maArrayList = (ArrayList<CoordonneeBancaire>) coordonneeBancaires;
			for (int i = 0; i < maArrayList.size(); i++) {
				CoordonneeBancaire coordonneeBancaire = maArrayList.get(i);
				coordonneeBancaire.setIdentite(identite);
				em.persist(coordonneeBancaire);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void ajouterListNationalites(Identite identite,
			List<Nationalite> nationalites) {
		try {
			ArrayList<Nationalite> maArrayList = (ArrayList<Nationalite>) nationalites;
			for (int i = 0; i < maArrayList.size(); i++) {
				Nationalite nationalite = maArrayList.get(i);
				nationalite.setIdentite(identite);
				em.persist(nationalite);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void ajouterListSituationMedicales(Identite identite,
			List<SituationMedicale> situationMedicales) {
		try {
			ArrayList<SituationMedicale> maArrayList = (ArrayList<SituationMedicale>) situationMedicales;
			for (int i = 0; i < maArrayList.size(); i++) {
				SituationMedicale situationMedicale = maArrayList.get(i);
				situationMedicale.setIdentite(identite);
				em.persist(situationMedicale);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void ajouterListVehicules(Identite identite, List<Vehicule> vehicules) {
		try {
			ArrayList<Vehicule> maArrayList = (ArrayList<Vehicule>) vehicules;
			for (int i = 0; i < maArrayList.size(); i++) {
				Vehicule vehicule = maArrayList.get(i);
				vehicule.setIdentite(identite);
				em.persist(vehicule);
			}
		} catch (Exception e) {
			e.printStackTrace();

		}

	}

	@Override
	public void ajouterDiplome(Identite identite, DiplomeGa diplome) {
		try {
			diplome.setIdentite(identite);
			em.persist(diplome);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void ajouterCertification(Identite identite,
			Certification certification) {
		try {
			certification.setIdentite(identite);
			em.persist(certification);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void ajouterExperience(Identite identite, Experience experience) {
		try {
			experience.setIdentite(identite);
			em.persist(experience);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void ajouterListDiplomes(Identite identite, List<DiplomeGa> diplomes) {
		try {
			ArrayList<DiplomeGa> maArrayList = (ArrayList<DiplomeGa>) diplomes;
			for (int i = 0; i < maArrayList.size(); i++) {
				DiplomeGa diplome = maArrayList.get(i);
				diplome.setIdentite(identite);
				em.persist(diplome);
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
		
	}

	@Override
	public void ajouterListExperiences(Identite identite,
			List<Experience> experiences) {
		try {
			ArrayList<Experience> maArrayList = (ArrayList<Experience>) experiences;
			for (int i = 0; i < maArrayList.size(); i++) {
				Experience experience = maArrayList.get(i);
				experience.setIdentite(identite);
				em.persist(experience);
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
		
	}

	@Override
	public void ajouterListCertifications(Identite identite,
			List<Certification> certifications) {
		try {
			ArrayList<Certification> maArrayList = (ArrayList<Certification>) certifications;
			for (int i = 0; i < maArrayList.size(); i++) {
				Certification certification = maArrayList.get(i);
				certification.setIdentite(identite);
				em.persist(certification);
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
		
	}
	
	@Override
	public int trouverNextMatriculeParPrefixe(String prefixe, int taillePrefixe) {
		Query q = em
				.createQuery("select i.matricul from Identite i where matricul like :prefixe");
		q.setParameter("prefixe", "%" + prefixe + "%");
		List<String> li = null; int n1=0;
		try {
			li = (List<String>) q.getResultList();
			
			if (li.size() > 0) {
				String num1 = li.get(0).substring(taillePrefixe);
				n1 = Integer.parseInt(num1);
				for (int i = 1; i < li.size(); i++) {
					String num2 = li.get(i).substring(taillePrefixe);
					int n2 = Integer.parseInt(num2);
					if(n2>n1)
						n1=n2;
						
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return n1+1;
	}

	@Override
	public List<Identite> trouverParLikeMatricule(String matricul, int n) {
		Query q = em
				.createQuery("select i from Identite i where matricul like :matricule");
		q.setParameter("matricule", matricul);
		q.setMaxResults(n);
		List<Identite> li = null;
		try {
			li = (List<Identite>) q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return li;
	}

	@Override
	public List<Identite> trouverParLikeMatriculeNomPrenomSexe(String matricul,
			String nom, String prenom, String sexe, int n) {
		Query q = em
				.createQuery("select i from Identite i where nom like :nom and prenom like :prenom and matricul like :matricule and sexe like :sexe");
		q.setParameter("matricule", matricul);
		q.setParameter("nom", nom);
		q.setParameter("prenom", prenom);
		q.setParameter("sexe", sexe);
		q.setMaxResults(n);
		List<Identite> li = null;
		try {
			li = (List<Identite>) q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return li;
	}


	@Override
	public List<Identite> trouverParLikeMatriculePosteUo(
			String matricul, String poste, String uo, int n) {
		Query q = em
				.createQuery("select i from Identite i inner join i.embauches e inner join e.affectations aff where aff.poste like :poste and aff.uniteorga like :uo and matricul like :matricule");
		q.setParameter("matricule", matricul);
		q.setParameter("poste", poste);
		q.setParameter("uo", uo);
		q.setMaxResults(n);
		
		List<Identite> li = null;
		try {
			li = (List<Identite>) q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return li;
	}

	
	@Override
	public List<Identite> trouverParLikeMatriculeNomPrenomSexePosteUo(
			String matricul, String nom, String prenom, String sexe, String poste, String uo, int n) {
		Query q = em
				.createQuery("select i from Identite i inner join i.embauches e inner join e.affectations aff where aff.poste like :poste and aff.uniteorga like :uo and nom like :nom and prenom like :prenom and matricul like :matricule and sexe like :sexe");
		q.setParameter("matricule", matricul);
		q.setParameter("nom", nom);
		q.setParameter("prenom", prenom);
		q.setParameter("poste", poste);
		q.setParameter("sexe", sexe);
		q.setParameter("uo", uo);
		q.setMaxResults(n);
		
		List<Identite> li = null;
		try {
			li = (List<Identite>) q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return li;
	}


	@Override
	public void ajouterGroupeimputation(Identite identite,
			GroupeImputation groupeImputation) {
		try {
			groupeImputation.setIdentite(identite);
			em.persist(groupeImputation);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void ajouterGroupeactivite(Identite identite,
			GroupeActivite groupeActivite) {
		try {
			groupeActivite.setIdentite(identite);
			em.persist(groupeActivite);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void ajouterGroupeCompteur(Identite identite,
			GroupeCompteur groupeCompteur) {
		try {
			groupeCompteur.setIdentite(identite);
			em.persist(groupeCompteur);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void ajouterSoumissionGta(Identite identite, ContratGta contratGta) {
			try {
				contratGta.setIdentite(identite);
				em.persist(contratGta);
			} catch (Exception e) {
				e.printStackTrace();
			}
		
	}

	@Override
	public void ajouterClasseEmp(Identite identite, ClasseEmp classeEmp) {
		try {
			classeEmp.setIdentite(identite);
			em.persist(classeEmp);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}


	@Override
	public List<Identite> trouverByCriteria(String matricul, String nom,
			String prenom, String sexe, String poste, String uo, String emploi,
			String  valeurPieceIdentite, String  typePieceIdentite, String situaFam, String typeContrat,
			String nationalitePays, String niveauDiplome, String certificat,
			 String experiencePoste, String experienceSociete,List<DateEmbauche> intervallesDateEmbauche,List<Age> intervallesAge) {
		 CriteriaBuilder builder = em.getCriteriaBuilder();
		 CriteriaQuery<Identite> query = builder.createQuery(Identite.class);

		Root<Identite> fromIdentite = query.from(Identite.class);
		Join<Identite, Embauche> embauches = fromIdentite.join("embauches");
		Join<Embauche, Contrat > contrats =embauches.join("contrats");
		Join<Embauche, Affectation> affectations = embauches.join("affectations");
		Join<Identite, PieceIdentite > piecesIdentite = fromIdentite.join("piecesIdentite");
		Join<Identite, SituationCivile> situationCiviles = fromIdentite.join("situationCiviles");
		Join<Identite, Nationalite> nationalites = fromIdentite.join("nationalites");
		Join<Identite, DiplomeGa> diplomes = fromIdentite.join("diplomes");
		Join<Identite, Certification> certifications = fromIdentite.join("certifications");
		Join<Identite, Experience> experiences = fromIdentite.join("experiences");
		Join<Identite, Naissance> naissance = fromIdentite.join("naissance");
		List<Predicate> conditions = new ArrayList();	
		conditions.add(builder.like((Expression)fromIdentite.get("nom"), nom));
		conditions.add(builder.like((Expression)fromIdentite.get("prenom"), prenom));
		conditions.add(builder.like((Expression)fromIdentite.get("matricul"), matricul));
		conditions.add(builder.like((Expression)fromIdentite.get("sexe"), sexe));		
		conditions.add(builder.like((Expression)affectations.get("poste"), poste));
		conditions.add(builder.like((Expression)affectations.get("emploi"), emploi));
		conditions.add(builder.like((Expression)affectations.get("uniteorga"), uo));
		conditions.add(builder.like((Expression)piecesIdentite.get("valeur"), valeurPieceIdentite));
		conditions.add(builder.like((Expression)piecesIdentite.get("type"),  typePieceIdentite));
		conditions.add(builder.like((Expression)situationCiviles.get("etat"), situaFam));
		conditions.add(builder.like((Expression)nationalites.get("pays"), nationalitePays));
		conditions.add(builder.like((Expression)contrats.get("type"), typeContrat));
		conditions.add(builder.like((Expression)certifications.get("nom"), certificat));
		conditions.add(builder.like((Expression)diplomes.get("niveau"), niveauDiplome));
		conditions.add(builder.like((Expression)experiences.get("poste"), experiencePoste));
		conditions.add(builder.like((Expression)experiences.get("societe"), experienceSociete));
		conditions.add(builder.like((Expression)experiences.get("societe"), experienceSociete));
		if((intervallesDateEmbauche!=null) || (intervallesDateEmbauche.get(0)!=null) )
		{
			for(DateEmbauche de:intervallesDateEmbauche)
			{
				conditions.add(builder.between(embauches.<Date>get("datedeb"), de.getMinDateEmbauche(), de.getMaxDateEmbauche()));
				}}
		
		if((intervallesAge!=null) || (intervallesAge.get(0)!=null))
		{
			for(Age a:intervallesAge)
			{
				conditions.add(builder.between(naissance.<Date>get("datenais"), a.getMaxDateNaissance(), a.getMinDateNaissance()));
				}}
		TypedQuery<Identite> typedQuery = em.createQuery(query
		        .select(fromIdentite)
		        .where(conditions.toArray(new Predicate[] {}))
		        .orderBy(builder.asc(fromIdentite.get("nom")))
		       // .distinct(true)
		);

			List<Identite> li = null;
		try {
			li = (List<Identite>) typedQuery.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return li;
	}

	@Override
	public void ajouterListPiecesIdentite(Identite identite,
			List<PieceIdentite> piecesidentite) {
		try {
			ArrayList<PieceIdentite> teArrayList = (ArrayList<PieceIdentite>) piecesidentite;
			for (int i = 0; i < teArrayList.size(); i++) {
				PieceIdentite pi = teArrayList.get(i);
				pi.setIdentite(identite);
				em.persist(pi);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void ajouterPieceIdentite(Identite identite,
			PieceIdentite nouveauPieceIdentite) {
		try {
			nouveauPieceIdentite.setIdentite(identite);
			em.persist(nouveauPieceIdentite);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void modifierSitutationCivile(Identite identite, SituationCivile a) {
		try {
			a.setIdentite(identite);
			em.merge(a);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void modifierStatut(Identite identite, Statut a) {
		try {
			a.setIdentite(identite);
			em.merge(a);

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void modifierNationalite(Identite identite, Nationalite a) {
		try {
			a.setIdentite(identite);
			em.merge(a);

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void modifierSituationMedicale(Identite identite, SituationMedicale a) {
		try {
			a.setIdentite(identite);
			em.merge(a);

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void modifierVehicule(Identite identite, Vehicule sc) {
		try {
			sc.setIdentite(identite);
			em.merge(sc);

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void modifierAdresse(Identite identite, Adresse sc) {
		try {
			sc.setIdentite(identite);
			em.merge(sc);

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void modifierCoordonneeBancaire(Identite identite,
			CoordonneeBancaire sc) {
		try {
			sc.setIdentite(identite);
			em.merge(sc);

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void modifierEmbauche(Identite identite, Embauche sc) {
		try {
			sc.setIdentite(identite);
			em.merge(sc);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	

	@Override
	public void modifierExperience(Identite identite, Experience sc) {
		try {
			sc.setIdentite(identite);
			em.merge(sc);

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void modifierCertification(Identite identite, Certification sc) {
		try {
			sc.setIdentite(identite);
			em.merge(sc);

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void modifierDiplome(Identite identite, DiplomeGa c) {
		try {
			c.setIdentite(identite);
			em.merge(c);

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Identite> trouverIdentitesSortis() {
		 CriteriaBuilder builder = em.getCriteriaBuilder();
		 CriteriaQuery<Identite> query = builder.createQuery(Identite.class);

		Root<Identite> fromIdentite = query.from(Identite.class);
		Join<Identite, Embauche> embauches = fromIdentite.join("embauches");
		List<Predicate> conditions = new ArrayList();
		conditions.add(builder.isNotNull(embauches.<Date>get("datefin")));
	//	conditions.add(builder.max(embauches.get("datedeb")));
		TypedQuery<Identite> typedQuery = em.createQuery(query
		        .select(fromIdentite)
		        .where(conditions.toArray(new Predicate[] {}))
		        .orderBy(builder.desc(embauches.get("datedeb")))
		        .distinct(true)
		);

			List<Identite> li = null;
		try {
			li = (List<Identite>) typedQuery.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return li;
		
	}

	@Override
	public boolean ajouterObjet(Object o) {
		System.out.println("Methode ajouter ");
		try {
			System.out.println("Ajout en cours");
			em.persist(o);
			return true;
		
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
}

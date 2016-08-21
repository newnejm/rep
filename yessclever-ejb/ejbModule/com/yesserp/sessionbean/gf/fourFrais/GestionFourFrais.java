package com.yesserp.sessionbean.gf.fourFrais;

import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.yesserp.domain.gf.FourFrais;
import com.yesserp.domain.gf.FournisseurFrais;
import com.yesserp.domain.gf.Frais;

/**
 * Session Bean implementation class GestionFourFrais
 */
@Stateless
@LocalBean
public class GestionFourFrais implements GestionFourFraisLocal {

	/**
	 * Default constructor.
	 */

	@PersistenceContext
	EntityManager entityManager;

	public GestionFourFrais() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void ajouterFourfrais(FourFrais fourFrais) {
		entityManager.persist(fourFrais);

	}

	@Override
	public void modifierFourFrais(FourFrais fourFrais) {
		entityManager.merge(fourFrais);

	}

	@Override
	public void supprimerFourFrais(FourFrais fourFrais) {
		entityManager.remove(entityManager.merge(fourFrais));

	}

	@Override
	public FourFrais findById(Long id) {

		return entityManager.find(FourFrais.class, id);
	}

	@Override
	public List<FourFrais> findAll() {
		Query query = entityManager.createQuery("select f from FourFrais f");
		return query.getResultList();
	}

	@Override
	public void ajouterFournisseursFrais(Long idFrais,
			List<FournisseurFrais> fournisseurFraiss, List<Date> datesDebut,
			List<Date> datesFin) {

		{
			for (int i = 0; i < fournisseurFraiss.size(); i++) {
				Query query = entityManager
						.createNativeQuery("insert into FourFrais (idfrais,idfournisseur,datedebut,datefin)"
								+ "values(?,?,?,?)");
				query.setParameter(1, idFrais);
				query.setParameter(2, fournisseurFraiss.get(i).getId());
				query.setParameter(3, datesDebut.get(i));
				query.setParameter(4, datesFin.get(i));
				query.executeUpdate();
			}

		}
	}

	@Override
	public List<FourFrais> findByFrais(Frais frais) {
		Query query = entityManager
				.createQuery("select ff from FourFrais ff join ff.frais fr where fr.id = :id");
		query.setParameter("id", frais.getId());
		List<FourFrais> fourFraiss = null;
		try {
			fourFraiss = (List<FourFrais>) query.getResultList();
		} catch (Exception e) {
			// TODO: handle exception
		}
		if (fourFraiss.size() > 0)
			return fourFraiss;
		return null;
	}

	@Override
	public void ajouterFournisseurFrais(Long idFrais,
			FournisseurFrais fournisseur, Date dateDebut, Date dateFin) {

		Query query = entityManager
				.createNativeQuery("insert into FourFrais (idfrais,idfournisseur,datedebut,datefin)"
						+ "values(?,?,?,?)");
		query.setParameter(1, idFrais);
		query.setParameter(2, fournisseur.getId());
		query.setParameter(3, dateDebut);
		query.setParameter(4, dateFin);
		query.executeUpdate();

	}

	@Override
	public List<FourFrais> findByFournisseur(FournisseurFrais fournisseurFrais) {
		Query query = entityManager
				.createQuery("select ff from FourFrais ff join ff.fournisseurFrais fr where fr.id = :id");
		query.setParameter("id", fournisseurFrais.getId());
		List<FourFrais> fourFraiss = null;
		try {
			fourFraiss = (List<FourFrais>) query.getResultList();
		} catch (Exception e) {
			// TODO: handle exception
		}
		if (fourFraiss.size() > 0)
			return fourFraiss;
		return null;
	}

}

package com.yesserp.sessionbean.paramgta.gestionhorairesdereference;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.yesserp.domain.gtaparam.HoraireDeReference;

/**
 * Session Bean implementation class GestionHeureDeReference
 */
@Stateless
@LocalBean
public class GestionHeureDeReference implements GestionHeureDeReferenceLocal {

	/**
	 * Default constructor.
	 */
	public GestionHeureDeReference() {
		// TODO Auto-generated constructor stub
	}

	@PersistenceContext(unitName = "yessclever")
	EntityManager entityManager;

	@Override
	public void ajouterHoraireDeRef(List<HoraireDeReference> horaireDeReferences) {
		for(HoraireDeReference hdr:horaireDeReferences)
			entityManager.persist(hdr);

	}

	@Override
	public void modifierHoraireDeRef(HoraireDeReference horaireDeReference) {
		entityManager.merge(horaireDeReference);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<HoraireDeReference> findAll() {
		Query query = entityManager
				.createQuery("select hdr from HoraireDeReference hdr");
		return query.getResultList();
	}

}

package com.yesserp.sessionbean.paramgta.gestionDescSemaineType;

import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;

import com.yesserp.domain.dao.impl.BaseDaoImpl;
import com.yesserp.domain.gtaparam.CodeJour;
import com.yesserp.domain.gtaparam.DescJourneeType;
import com.yesserp.domain.gtaparam.DescSemaineType;
import com.yesserp.domain.gtaparam.JourneeType;
import com.yesserp.domain.gtaparam.SemaineType;

@Stateless
@LocalBean
public class GestionDescSemaineType extends BaseDaoImpl<DescSemaineType>
		implements GestionDescSemaineTypeLocal {
	
	@Override
	public List<DescSemaineType> getDescSemaineTypesBySemaineType(SemaineType semaineType){
		Query query = em
				.createQuery("SELECT c FROM DescSemaineType c where c.semaineType = :st");
				query.setParameter("st", semaineType);
				return query.getResultList();
	}

	
	
	public void ajouterDescSemaineType(DescSemaineType i) {
		configDateEffet(i.getDateEffet(),i.getSemaineType());
		em.persist(i);
	}
	
	
	
	@Override
	public void supprimerDescSemaineType(DescSemaineType i) {

		Query query = em.createNativeQuery("delete from JourneeTypeDescSemaineType where idDescSemaineType = ? ");
		query.setParameter(1, i.getIdDescST());
		query.executeUpdate();
	
		i = em.merge(i);
		em.remove(i);
	}
	
	
	
	
	public List<DescSemaineType> getSortedDescSemaineType() {

		Query query = em
				.createQuery("SELECT c FROM DescSemaineType c ORDER BY c.dateEffet ASC");
		return query.getResultList();
	}
	
	public void configDateEffet(Date newDateEffet, SemaineType semaineType) {
		
		Query query = em.createQuery("SELECT c FROM DescSemaineType c where c.semaineType = :st ORDER BY c.idDescST ASC ");
		query.setParameter("st", semaineType);
		
		List<DescSemaineType> descSemaineTypes = query.getResultList() ;
				
		DescSemaineType descSemaineType = null;
		if (descSemaineTypes != null && !descSemaineTypes.isEmpty()) {
			descSemaineType = descSemaineTypes.get(descSemaineTypes.size() - 1);
		}
		if (descSemaineType != null) { // s'il n'est pas null alors on a
										// récuperé le dernier enregistrement
			descSemaineType.setDateFin(new Date(
					newDateEffet.getTime() - 24 * 3600 * 1000));
		}
	}

	@Override
	public void associateJourneeTypeToDescSemaineType(Integer id,
			JourneeType journeeType, Integer idcj) {
		
		
Query query = em.createNativeQuery("insert into journeetypedescsemainetype (iddescsemainetype,idjourneetype,idcodejour)"+ "values(?,?,?)");
		
		query.setParameter(1, id);
		query.setParameter(2, journeeType.getIdjt());
		query.setParameter(3, idcj);
		query.executeUpdate();

		
		
	}
	

}

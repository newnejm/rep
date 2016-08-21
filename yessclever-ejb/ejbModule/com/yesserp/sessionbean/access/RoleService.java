package com.yesserp.sessionbean.access;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.yesserp.domain.access.Groupe;
import com.yesserp.domain.access.Role;

/**
 * Session Bean implementation class RoleService
 */
@Stateless
public class RoleService implements RoleServiceRemote {


	@PersistenceContext
	private EntityManager em;
	
    public RoleService() {
        // TODO Auto-generated constructor stub
    }

	public void createRole(Role role) {
		em.persist(role);
	}

	public void updateRole(Role role) {
		em.merge(role);
	}

	public void deleteRole(Role role) {
		em.remove(em.merge(role));
	}

	public Role findRoleById(int id) {
		return em.find(Role.class, id);
	}

	public List<Role> getAllRoles() {
		return em.createQuery("select r from Role r", Role.class).getResultList();
	}

	public List<Role> listRolesByGroupe(Groupe groupe) {
		return em.createQuery("select r from Role r where r.groupe=:g").setParameter("g", groupe).getResultList();
	}

}

package com.yesserp.sessionbean.access;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;






import com.yesserp.domain.access.Groupe;
import com.yesserp.domain.access.Menu;
import com.yesserp.domain.access.Operation;

/**
 * Session Bean implementation class MenuService
 */
@Stateless
public class MenuService implements MenuServiceRemote, MenuServiceLocal {

	@PersistenceContext
	private EntityManager em;
	
    public MenuService() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void creeMenu(Menu menu) {
		
		em.persist(menu);
		
	}

	@Override
	public void modifierMenu(Menu menu) {
		
		em.merge(menu);
		
	}

	@Override
	public void supprimerMenu(Menu menu) {
		em.remove(em.merge(menu));
	}

	@Override
	public Menu trouverMenuById(int id) {

		return em.find(Menu.class, id);
	}

	@Override
	public List<Menu> listMenus() {
		return em.createQuery("select g from Menu g", Menu.class).getResultList();

	}

	@Override
	public void assignMenusToOperation(List<Menu> menus, Operation operation) {
		// TODO Auto-generated method stub
		for(Menu menu: menus){
			operation.addMenu(menu);
			em.merge(menu);
		}
	}

	public List<Menu> listMenuSansParentee() {
		return em.createQuery("select m from Menu m where m.parentee IS NULL", Menu.class).getResultList();
	}

	public List<Menu> listMenuAvecParentee() {
		return em.createQuery("select m from Menu m where m.parentee IS NOT NULL").getResultList();
	}

}

package com.yesserp.sessionbean.access;

import java.util.List;

import javax.ejb.Local;

import com.yesserp.domain.access.Habilitation;
import com.yesserp.domain.access.Menu;
import com.yesserp.domain.access.Operation;

@Local
public interface MenuServiceLocal {

	public void creeMenu(Menu menu);

	public void modifierMenu(Menu menu);

	public void supprimerMenu(Menu menu);

	public Menu trouverMenuById(int id);

	public List<Menu> listMenus();

	public void assignMenusToOperation(List<Menu> menus, Operation operation);

	public List<Menu> listMenuSansParentee();

	public List<Menu> listMenuAvecParentee();
}

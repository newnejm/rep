package com.yesserp.sessionbean.access;

import java.util.List;

import javax.ejb.Remote;

import com.yesserp.domain.access.Groupe;
import com.yesserp.domain.access.Role;

@Remote
public interface RoleServiceRemote {

	public void createRole(Role role);

	public void updateRole(Role role);

	public void deleteRole(Role role);

	public Role findRoleById(int id);

	public List<Role> getAllRoles();
	
	public List<Role> listRolesByGroupe(Groupe groupe);
	
}

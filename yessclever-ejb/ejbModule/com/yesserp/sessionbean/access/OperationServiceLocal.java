package com.yesserp.sessionbean.access;

import java.util.List;

import javax.ejb.Local;

import com.yesserp.domain.access.Groupe;
import com.yesserp.domain.access.Habilitation;
import com.yesserp.domain.access.Operation;

@Local
public interface OperationServiceLocal {

	public void creeOperation(Operation operation);

	public void modifierOperation(Operation operation);

	public void supprimerOperation(Operation operation);

	public Operation trouverOperationById(int id);

	public List<Operation> listOperations();
}

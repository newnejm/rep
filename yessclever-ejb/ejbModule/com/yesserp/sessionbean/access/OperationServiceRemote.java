package com.yesserp.sessionbean.access;

import java.util.List;

import javax.ejb.Remote;

import com.yesserp.domain.access.Habilitation;
import com.yesserp.domain.access.Operation;

@Remote
public interface OperationServiceRemote {

	public void creeOperation(Operation operation);

	public void modifierOperation(Operation operation);

	public void supprimerOperation(Operation operation);

	public Operation trouverOperationById(int id);

	public List<Operation> listOperations();

}

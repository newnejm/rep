package com.yesserp.sessionbean.crm.gestionAction;

import java.util.List;

import javax.ejb.Local;

import com.yesserp.domain.crm.Action;
import com.yesserp.domain.crm.SuivieAction;
import com.yesserp.domain.crm.TypeAction;
import com.yesserp.domain.crm.TypeCompagne;

@Local
public interface GestionActionLocal {
		public void ajouterAction (Action Action);
		public void supprimerAction(Action Action);
		public void modifierAction(Action Action);
		public List<Action> AfficherTousAction();
		public Action afficherActionParId(Long id);
		public void ajouterTypeAction(TypeAction type);
		public Action afficherActionParDescription(String description);
		public List<TypeAction> getTypes();

		public List<SuivieAction> FindActionBySuivie(Action action);
		public TypeAction ChercherTypeAction(String type);
}

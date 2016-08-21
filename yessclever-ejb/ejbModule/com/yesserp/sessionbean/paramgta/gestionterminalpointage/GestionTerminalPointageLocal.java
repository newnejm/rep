package com.yesserp.sessionbean.paramgta.gestionterminalpointage;

import java.util.List;

import javax.ejb.Local;

import com.yesserp.domain.gta.Terminal;

@Local
public interface GestionTerminalPointageLocal {
	public void ajouterTerminalPointage(Terminal terminal);

	public void modifierTerminalPointage(Terminal terminal);

	public void supprimerTerminalPointage(Terminal terminal);

	public List<Terminal> findAll();

}

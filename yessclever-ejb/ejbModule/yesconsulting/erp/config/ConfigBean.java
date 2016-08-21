package yesconsulting.erp.config;


import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import com.yesserp.domain.access.Groupe;
import com.yesserp.sessionbean.access.AuthentificationServiceRemote;
import com.yesserp.sessionbean.access.GroupeServiceRemote;
import com.yesserp.sessionbean.access.UtilisateurServiceRemote;


@Singleton
@Startup
public class ConfigBean {
	
	@EJB
	private AuthentificationServiceRemote authentificationServiceRemote;
	@EJB
	private UtilisateurServiceRemote utilisateurServiceRemote;
    @EJB
    private GroupeServiceRemote groupeServiceRemote;
    
    public ConfigBean() {
    }
    
    @PostConstruct
    public void createData(){
    	if (!authentificationServiceRemote.loginExists("admin")) {
    		utilisateurServiceRemote.modifierUtilisateur(new com.yesserp.domain.access.Admin(1, "fray", "fray", "fray", "aymen", "inf", "fray@gmail.fr"));
		}
    	if (!authentificationServiceRemote.loginExists("manager")) {
    		utilisateurServiceRemote.modifierUtilisateur(new com.yesserp.domain.access.Manager(2, "ramzi", "ramzi", "mouelhi", "ramzi", "zzzz", "ramzi@gmail.fr"));
		}
    	//groupeServiceRemote.creeGroupe(new Groupe(1, "AAAA"));
    
    }
}

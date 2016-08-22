package converter;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import com.yesserp.domain.gta.GroupeIdentity;
import com.yesserp.domain.gtaparam.GroupeImputation;
import com.yesserp.sessionbean.paramgta.gestiongroupeimputation.GestionGroupeImputationLocal;
import com.yesserp.sessionbean.paramgta.gestiongroupeselect.gestionGroupeSelect;

@ManagedBean(name="jobsGroupeConvertor")
@RequestScoped
public class JobsGroupeConvertor implements Converter {
	@EJB
	gestionGroupeSelect gestionGroupeSelect;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {
		GroupeIdentity groupeIdentity=null;
		if (!value.trim().equals(""))
			groupeIdentity = gestionGroupeSelect
					.findGroupeSelectByCode(value);

		return groupeIdentity;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object value) {
		if (value == null || value.equals(""))
			return "";
		else
			return String.valueOf(((GroupeIdentity) value).getId());
	}

}

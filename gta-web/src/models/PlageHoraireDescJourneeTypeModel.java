package models;

import com.yesserp.domain.gtaparam.PlageHoraireDescJourneeType;

public class PlageHoraireDescJourneeTypeModel {

	private PlageHoraireDescJourneeType plageHoraireDescJourneeType;
	private Boolean createMode;

	public PlageHoraireDescJourneeTypeModel() {
		plageHoraireDescJourneeType = new PlageHoraireDescJourneeType();
		createMode = false;
	}

	public Boolean getCreateMode() {
		return createMode;
	}

	public void setCreateMode(Boolean createMode) {
		this.createMode = createMode;
	}

	public PlageHoraireDescJourneeType getPlageHoraireDescJourneeType() {
		return plageHoraireDescJourneeType;
	}

	public void setPlageHoraireDescJourneeType(
			PlageHoraireDescJourneeType plageHoraireDescJourneeType) {
		this.plageHoraireDescJourneeType = plageHoraireDescJourneeType;
	}

}

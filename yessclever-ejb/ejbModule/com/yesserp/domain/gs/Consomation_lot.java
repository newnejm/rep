package com.yesserp.domain.gs;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.persistence.*;

import com.yesserp.sessionbean.gs.GestionCons;
import com.yesserp.sessionbean.gs.GestionConso_lotLocal;
import com.yesserp.sessionbean.gs.GestionLotLocal;

/**
 * Entity implementation class for Entity: consomation_lot
 * 
 */
@Entity
@Table(name = "gs_consomation_lot")
public class Consomation_lot implements Serializable {

	private Consomation_lot_pk pk;
	private Consomation consomation;
	private Lot lot;
	private double qte;
	private static final long serialVersionUID = 1L;

	@EJB
	GestionLotLocal ejbl;

	public Consomation_lot() {
		super();
	}

	public Consomation_lot(double qte, Consomation c, Lot l, Cond cond) {

		this.setConsomation(c);
		this.setLot(l);
		Consomation_lot_pk pk = new Consomation_lot_pk();
		pk.setIdConsomation(c.getId());
		pk.setIdLot(l.getId());
		this.setPk(pk);
		if (qte - (l.getQte() - l.getQteconso() - l.getQterebu()) > 0) {
			cond.qte = cond.qte
					- (l.getQte() - l.getQteconso() - l.getQterebu());
			l.setQteconso(l.getQteconso()
					+ (l.getQte() - l.getQteconso() - l.getQterebu()));
			this.setQte((l.getQte() - l.getQteconso() - l.getQterebu()));
			cond.setCond(true);
		} else if (qte - (l.getQte() - l.getQteconso() - l.getQterebu()) < 0) {
			l.setQteconso(l.getQteconso() + qte);
			this.setQte(qte);
			cond.setCond(false);
		}
	}

	@EmbeddedId
	public Consomation_lot_pk getPk() {
		return pk;
	}

	public void setPk(Consomation_lot_pk pk) {
		this.pk = pk;
	}

	@ManyToOne
	@JoinColumn(name = "idConsomation", referencedColumnName = "id", insertable = false, updatable = false)
	public Consomation getConsomation() {
		return consomation;
	}

	public void setConsomation(Consomation consomation) {
		this.consomation = consomation;
	}

	@ManyToOne
	@JoinColumn(name = "idLot", referencedColumnName = "id", insertable = false, updatable = false)
	public Lot getLot() {
		return lot;
	}

	public void setLot(Lot lot) {
		this.lot = lot;
	}

	public double getQte() {
		return qte;
	}

	public void setQte(double qte) {
		this.qte = qte;
	}

}

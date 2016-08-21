package com.yesserp.domain.pg;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.yesserp.domain.gtaparam.Libelle;




@Entity
@Table(name="pg_Filiale")
public class Filiale implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	public Filiale() {	
	}
	
	private	int code;
	private List<Libelle> libelles;
	private Societe societe ;
	private String description ;
	private String localistation ;
	private List<Module> module;
	
	private String Pays ;
	private String Regions ;
	private String Devises ;
	private String Langues ;
	private String Fuseaux_horaires;
	private String Format_de_date ;
	
	private String Pattern ;
	private SimpleDateFormat  SelectedDate;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getCode() {
		return this.code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	
	
	@OneToMany(mappedBy = "filiale",cascade=CascadeType.REMOVE,fetch = FetchType.EAGER)
	public List<Libelle> getLibelles() {
		return libelles;
	}
	public void setLibelles(List<Libelle> libelles) {
		this.libelles = libelles;
	}

	@ManyToOne
	public Societe getSociete() {
		return societe;
	}
	public void setSociete(Societe societe) {
		this.societe = societe;
	}
	
	
	@OneToMany(mappedBy = "filiale")
	public List<Module> getModule() {
		return module;
	}
	public void setModule(List<Module> module) {
		this.module = module;
	}
	
public void SelectionPatern() {
		
		SelectedDate.applyPattern(Pattern);
		
	}

	public String getDescription() {
		return description;
	}
	public String getLocalistation() {
		return localistation;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	public void setLocalistation(String localistation) {
		this.localistation = localistation;
	}
	public String getPays() {
		return Pays;
	}
	public void setPays(String pays) {
		Pays = pays;
	}
	public String getRegions() {
		return Regions;
	}
	public void setRegions(String regions) {
		Regions = regions;
	}
	public String getDevises() {
		return Devises;
	}
	public void setDevises(String devises) {
		Devises = devises;
	}
	public String getLangues() {
		return Langues;
	}
	public void setLangues(String langues) {
		Langues = langues;
	}
	public String getFuseaux_horaires() {
		return Fuseaux_horaires;
	}
	public void setFuseaux_horaires(String fuseaux_horaires) {
		Fuseaux_horaires = fuseaux_horaires;
	}
	public String getFormat_de_date() {
		return Format_de_date;
	}
	public void setFormat_de_date(String format_de_date) {
		Format_de_date = format_de_date;
	}
	public String getPattern() {
		return Pattern;
	}
	public void setPattern(String pattern) {
		Pattern = pattern;
	}
	public SimpleDateFormat getSelectedDate() {
		return SelectedDate;
	}
	public void setSelectedDate(SimpleDateFormat selectedDate) {
		SelectedDate = selectedDate;
	}
	
}
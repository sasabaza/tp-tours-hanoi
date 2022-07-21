package fr.base.models;

import java.util.LinkedList;

/**
 * Classe qui définit le modèle Tour
 * <br>- Attribut nom de type String
 * <br>- Attribut listDisques de type liste chainée de Disque
 */
public class Tour {
	
	private String nom;
	private LinkedList<Disque> listDisques;
	
	public Tour(String nom) {
		this.setNom(nom);
		this.setListDisques(new LinkedList<Disque>());
	}

	public Tour(String nom, LinkedList<Disque> listDisques) {
		this.setNom(nom);
		this.setListDisques(listDisques);
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}	

	public LinkedList<Disque> getListDisques() {
		return listDisques;
	}

	public void setListDisques(LinkedList<Disque> listDisques) {
		this.listDisques = listDisques;
	}

	@Override
	public String toString() {
		return "Tour " + this.nom;
	}	
}

package fr.base;

/**
 * TP Tours de Hanoï en groupe POO et récursivité en Java
 * 
 * @author Amina Thiam, Salem Krab, Stéphane Abaza
 * 
 * L'objectif de ce programme est de résoudre le problème des tours d'Hanoï.
 */
public class StartTourHanoi {

	/**
	 * Méthode d'entrée du programme
	 * 
	 * @param args tableau de String
	 */
	public static void main(String[] args) {
		
		TourHanoi tourHanoi = new TourHanoi();
		tourHanoi.run();
	}
}
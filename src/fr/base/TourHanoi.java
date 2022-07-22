package fr.base;

import java.util.ArrayList;
import java.util.LinkedList;

import fr.base.models.Disque;
import fr.base.models.Tour;
import fr.base.utils.Utils;
import fr.base.view.DisplayConsole;

/**
 * Classe qui instancie la classe TourHanoi et lance le programme
 */
class TourHanoi {
	
	private static int count = 0;
	private static final String CHEMIN_FICHIER;
	
	static {
		count = 0;
		CHEMIN_FICHIER = "resultat.txt";
	}
	
	/**
	 * Méthode qui lance le programme
	 */
	void run() {
		
		Utils.creerFichier(CHEMIN_FICHIER);
		
		int nombreDisque = DisplayConsole.nombreDisque();
		
		LinkedList<Disque> listDisque = new LinkedList<>();
		
		initialisationListDisques(nombreDisque, listDisque);
		
		ArrayList<Tour> listTours = new ArrayList<>();		
		TourHanoi.initialisationTours(listDisque, listTours);
		
		TourHanoi.deplacementDisques(nombreDisque, listTours.get(0), listTours.get(1), listTours.get(2));
		
		DisplayConsole.affichageTotalDeplacement(TourHanoi.count, nombreDisque);
		Utils.enregistrerTotalDeplacement(nombreDisque, nombreDisque, CHEMIN_FICHIER);
	}
	
	/**
	 * Méthode qui initialise la variable listDisque
	 * 
	 * @param nombreDisque nombre de disques
	 * @param listDisque liste chainée de disques
	 */
	private static void initialisationListDisques(int nombreDisque, LinkedList<Disque> listDisque) {
		for (int i = 0; i < nombreDisque; i++) {
			listDisque.add(new Disque(nombreDisque - i, nombreDisque - i));
		}
	}
	
	/**
	 * Méthode qui initialise la variable listTours
	 * 
	 * @param listDisque liste chainée de disques
	 * @param listTours liste de objets Tour
	 */
	private static void initialisationTours(LinkedList<Disque> listDisque, ArrayList<Tour> listTours) {
		for (int i = 0; i < 3; i++) {
			String nom = DisplayConsole.nomTour(i);
			
			if (i == 0) {
				listTours.add(new Tour(nom, listDisque));
			} else {
				listTours.add(new Tour(nom));
			}
		}
	}
	
	/**
	 * Méthode qui effectue le déplacement de disque
	 * 
	 * @param diskNumber correspond au numéro de disque
	 * @param sourceTower correspond à l'objet Tour source
	 * @param destinationTower correspond à l'objet Tour destination
	 * @param auxiliaryTower correspond à l'objet Tour auxiliaire
	 */
	private static void deplacementDisques(int diskNumber, Tour sourceTower, Tour destinationTower, Tour auxiliaryTower) {
		if (diskNumber == 1) {
			
			Disque disque = sourceTower.getListDisques().removeLast();
			destinationTower.getListDisques().add(disque);
			
			DisplayConsole.affichageDeplacement(diskNumber, sourceTower, destinationTower);
			Utils.enregistrerDeplacement(diskNumber, sourceTower, destinationTower, CHEMIN_FICHIER);
			TourHanoi.count++;
		} else {
			deplacementDisques(diskNumber - 1, sourceTower, auxiliaryTower, destinationTower);
			
			Disque disque = sourceTower.getListDisques().removeLast();
			destinationTower.getListDisques().add(disque);
			
			DisplayConsole.affichageDeplacement(diskNumber, sourceTower, destinationTower);
			Utils.enregistrerDeplacement(diskNumber, sourceTower, destinationTower, CHEMIN_FICHIER);
			
			deplacementDisques(diskNumber - 1, auxiliaryTower, destinationTower, sourceTower);
			TourHanoi.count++;
		}
	}
}

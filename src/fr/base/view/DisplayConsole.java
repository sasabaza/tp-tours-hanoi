package fr.base.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import fr.base.models.Tour;
import fr.base.utils.Utils;

/**
 * Classe qui gère les affichages dans la console
 */
public final class DisplayConsole {
	
	private static BufferedReader bufferedReader;
	
	static {
		 bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	}
	
	private DisplayConsole() {
		
	}
	
	/**
	 * Méthode qui demande à l'utilisateur d'entrer le nombre de disques
	 * 
	 * @return nombre de disques
	 */
	public static int nombreDisque() {
		System.out.print("Entrez nombre de disques: ");
		
		int nombreDisque = -1;
		
		try {
			nombreDisque = Integer.parseInt(bufferedReader.readLine());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return nombreDisque;
	}
	
	/**
	 * Méthode qui demande à l'utilisateur d'entrer un nom pour chaque tour
	 * 
	 * @param i correspond au numéro de la tour
	 * @return nom de tour
	 */
	public static String nomTour(int i) {
		String tourType = null;
		if (i == 0) {
			tourType = "de départ";
		} else if (i == 1) {
			tourType = "de destination";
		} else {
			tourType = "auxiliaire";
		}
		System.out.println("Entrez le nom de la tour " + tourType);
		
		String nom = null;
		
		try {
			nom = bufferedReader.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return nom;
	}
	
	/**
	 * Méthode qui affiche le déplacement d'un disque
	 * 
	 * @param diskNumber numéro de disque
	 * @param source tour de source
	 * @param destination tour de destination
	 */
	public static void affichageDeplacement(int diskNumber, Tour source, Tour destination) {
		System.out.println("Déplacement disque n°" + diskNumber + " de " + source + " à " + destination);
	}
	
	/**
	 * Méthode qui affiche le nombre de déplacements total et affiche le résultat de calcul de déplacements optimal
	 * 
	 * @param count correspond au nombre de déplacements
	 * @param nombreDisque correspond au nombre de disques
	 */
	public static void affichageTotalDeplacement(int count, int nombreDisque) {
		System.out.println("Nombre de déplacements = " + count + " - Nombre de déplacements optimal = " + Utils.calculOptimal(nombreDisque));
	}
}

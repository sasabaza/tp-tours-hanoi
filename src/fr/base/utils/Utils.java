package fr.base.utils;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import fr.base.models.Tour;

/**
 * Classe utilitaire qui regroupe toutes les méthodes utilisées dans le
 * programme
 */
public final class Utils {

	private Utils() {
		
	}
	
	/**
	 * Méthode qui calcule le nombre de déplacements optimal
	 * 
	 * @param nombreDisque correspond au nombre de disques
	 * @return entier
	 */
	public static int calculOptimal(int nombreDisque) {
		return (int) (Math.pow(nombreDisque, 2) - 1);
	}
	
	/**
	 * Méthode qui ajoute le nom des tours au fichier donné au paramètre
	 * 
	 * @param nom texte à ajouter
	 * @param cheminFichier chemin du fichier
	 */
	public static void enregistrerNomTour(String nom, String cheminFichier) {
	    try (Writer writer = new FileWriter(cheminFichier, true)) {
	        writer.append(nom + "\n");
	      } catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Méthode qui ajoute une description du déplacement d'un disque au fichier donné au paramètre
	 * 
	 * @param diskNumber numéro de disque
	 * @param source tour de source
	 * @param destination tour de destination
	 * @param cheminFichier chemin du fichier
	 */
	public static void enregistrerDeplacement(int diskNumber, Tour source, Tour destination, String cheminFichier) {
	    try (Writer writer = new FileWriter(cheminFichier, true)) {
	        writer.append("Déplacement disque n°" + diskNumber + " de " + source + " à " + destination + "\n");
	      } catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Méthode qui ajoute le nombre de déplacements total et affiche le résultat de calcul de déplacements optimal au fichier donné au paramètre
	 * 
	 * @param count correspond au nombre de déplacements
	 * @param nombreDisque correspond au nombre de disques
	 * @param cheminFichier chemin du fichier
	 */
	public static void enregistrerTotalDeplacement(int count, int nombreDisque, String cheminFichier) {		
	    try (Writer writer = new FileWriter(cheminFichier, true)) {
	        writer.append("Nombre de déplacements = " + count + " - Nombre de déplacements optimal = " + Utils.calculOptimal(nombreDisque));
	      } catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Méthode qui crée un fichier si celui ci n'existe pas, ou ajoute aucun caractère au fichier
	 * 
	 * @param cheminFichier chemin du fichier
	 */
	public static void creerFichier(String cheminFichier) {
	    try (Writer writer = new FileWriter(cheminFichier)) {
	        writer.append("");
	      } catch (IOException e) {
			e.printStackTrace();
		}
	}
}
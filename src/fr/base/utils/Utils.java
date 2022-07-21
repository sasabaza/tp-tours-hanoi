package fr.base.utils;

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
}
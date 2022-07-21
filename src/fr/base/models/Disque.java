package fr.base.models;

/**
 * Classe qui définit le modèle Disque
 * <br>- Attribut numéro de type entier
 * <br>- Attribut diametre de type entier
 */
public class Disque {
	
	private int numero;
	private int diametre;

	public Disque(int numero, int diametre) {
		this.setNumero(numero);
		this.setDiametre(diametre);
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getDiametre() {
		return diametre;
	}

	public void setDiametre(int diametre) {
		this.diametre = diametre;
	}
}

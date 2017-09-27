package Beowulf;

public class Dragão {

	private int healthPoints;
	private double esquivaNatural;
	private int bolaDeFogo;
	private int armadura;
	
	public Dragão(){
		healthPoints=100;
		esquivaNatural=25;
		bolaDeFogo=15;
		armadura=10;
	}
	
	public int getHealthPoints() {
		return healthPoints;
	}
	public void setHealthPoints(int healthPoints) {
		this.healthPoints = healthPoints;
	}
	public double getEsquivaNatural() {
		return esquivaNatural/200;
	}
	public void setEsquivaNatural(double esquivaNatural) {
		this.esquivaNatural = esquivaNatural;
	}
	public int getBolaDeFogo() {
		return bolaDeFogo;
	}
	public void setBolaDeFogo(int bolaDeFogo) {
		this.bolaDeFogo = bolaDeFogo;
	}
	public int getArmadura() {
		return armadura;
	}
	public void setArmadura(int armadura) {
		this.armadura = armadura;
	}

	
}

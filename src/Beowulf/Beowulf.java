package Beowulf;

public class Beowulf {

	private int dinheiro;
	private int healthPoints;
	private int pesoMáximo;
	private int defesa;
	private double esquiva;
	private Arma []armaBeowulf;
	private int pesoAtual;

	public Beowulf(){
		armaBeowulf=new Arma[3];
		cadastrarArmas(armaBeowulf);
		defesa = 12;
		dinheiro = 1500;
		healthPoints = 50;
		pesoMáximo = 23;
		calcularPesoAtual();
		esquiva = (30-pesoAtual)/200;

	}

	private void cadastrarArmas(Arma[] armaBeowulf) {
		armaBeowulf[0]=new Arma("Escudo de Madeira", 0, 12, 4, 200);
		armaBeowulf[1]=new Arma("Machado Simples", 12,0, 12, 500);
		armaBeowulf[2]=new Arma("Vazio", 0,0,0,0);
	}

	public void calcularPesoAtual() {
		pesoAtual = 0;
		for (int i = 0; i < 3; i++) {
			pesoAtual = pesoAtual+armaBeowulf[i].getPeso();
		}
	}


	public int getDinheiro() {
		return dinheiro;
	}

	public void setDinheiro(int dinheiro) {
		this.dinheiro = dinheiro;
	}

	public int getHealthPoints() {
		return healthPoints;
	}

	public void setHealthPoints(int healthPoints) {
		this.healthPoints = healthPoints;
	}

	public int getPesoMaximo() {
		return pesoMáximo;
	}

	public void setPesoMaximo(int pesoMáximo) {
		this.pesoMáximo = pesoMáximo;	

	}

	public int getDefesa() {
		return defesa;
	}

	public void setDefesa(int defesa) {
		this.defesa = defesa;
	}

	public double getEsquiva() {
		return esquiva;
	}

	public void setEsquiva(double esquiva) {
		this.esquiva = esquiva;
	}

	public Arma[] getArmaBeowulf() {
		return armaBeowulf;
	}

	public void setArmaBeowulf(Arma[] armaBeowulf) {
		this.armaBeowulf = armaBeowulf;
	}

	public int getPesoAtual() {
		return pesoAtual;
	}

	public void setPesoAtual(int pesoAtual) {
		this.pesoAtual = pesoAtual;
	}

	public Arma getArmaBeowulfEspecifica(int i){
		return armaBeowulf[i];
	}

	public void setArmaEspecifica(Arma arma, int i) {
		armaBeowulf[i] = arma;

	}

}
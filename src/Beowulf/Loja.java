package Beowulf;

public class Loja {
	private Arma[] armas;

	public Loja(){
		armas = new Arma[10];

		preencherArma();

	}

	private void preencherArma() {
		armas[0]=new Arma("Machado Simples", 12,0, 12, 500);
		armas[1]=new Arma("Machado Duplo",15,0, 15, 1000);
		armas[2]=new Arma("Espada Curta", 13,0, 13, 800);
		armas[3]=new Arma("Espada Longa", 20,0, 22, 1100);
		armas[4]=new Arma("Arco Longo", 9,0, 8, 600);
		armas[5]=new Arma("Espada Flamejante", 26,0, 20, 1800);
		armas[6]=new Arma("Machado Duplo Pesado", 29,0, 33, 1500);
		armas[7]=new Arma("Escudo de Madeira", 0,12, 4, 200);
		armas[8]=new Arma("Escudo de Ferro", 0,20, 10,400);
		armas[9]=new Arma("Escudo Milenar do rei Brasz", 0,31, 15, 1500);
	}

	public Arma[] getArmas() {
		return armas;
	}
	
	public Arma getVisualizarArma(int i){
		return armas[i];
		
	}

	
	
}
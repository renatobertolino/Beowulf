package Beowulf;

public class Arma {

	private String nome;
	private int dano;
	private int defesa;
	private int peso;
	private int valor;
	
	public Arma(String nome, int dano, int defesa,int peso, int valor){
		this.nome=nome;
		this.dano=dano;
		this.defesa=defesa;
		this.peso=peso;
		this.valor=valor;
	}
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getDano() {
		return dano;
	}
	public void setDano(int dano) {
		this.dano = dano;
	}
	public int getPeso() {
		return peso;
	}
	public void setPeso(int peso) {
		this.peso = peso;
	}
	public int getValor() {
		return valor;
	}
	public void setValor(int valor) {
		this.valor = valor;
	}
	public int getDefesa() {
		return defesa;
	}
	public void setDefesa(int defesa) {
		this.defesa = defesa;
	}
	
}

package Beowulf;

import java.util.Random;
import java.util.Scanner;

public class Main {

	static Random random = new Random();
	static Scanner scanner = new Scanner(System.in);
	static Drag�o drag�o = new Drag�o();
	static Beowulf beo = new Beowulf();
	static Loja loja = new Loja();

	public static void main(String[] args) {

		iniciarMenuJogo();
	}

	private static void iniciarMenuJogo() {

		int op��o=0;

		do {
			System.out.println("1.Loja\n2.Batalha\n3.Desistir");
			op��o=scanner.nextInt();

			switch (op��o) {
			
			case 0:
				trollada();
				
				break;
				
			case 1:
				menuLoja();

				break;

			case 2:
				batalha();

				break;

			case 3:

				System.out.println("Ele desistiu e p�");

				break;
			default:

				System.out.println("Inv�lida");
				break;
			}


		} while (op��o>3);

	}

	private static void trollada() {
		System.out.println("Digite um nome: ");
		String nome = scanner.next();
		
		System.out.println(nome + " �...");
		System.out.println();
		System.out.println(" \\\\        //  ||     //\\\\            ||  ||===||");
		System.out.println("  \\\\      //   ||    //  \\\\        ___||  ||   ||");
		System.out.println("   \\\\    //    ||   //    \\\\     ||   ||  ||   ||");
		System.out.println("    \\\\  //     ||  //======\\\\    ||   ||  ||   ||");
		System.out.println("     \\\\//      || //        \\\\   ||___||  ||___||");
		
	}

	private static void batalha() {

		int arma = selecionarArma();
		int op��o;
		boolean fimDoJogo=false;

		do {
			System.out.println("Arma Atual: "+beo.getArmaBeowulfEspec�fica(arma).getNome()+" Dano: "+beo.getArmaBeowulfEspec�fica(arma).getDano());
			System.out.println("1.Atacar\n2.Trocar Arma\n3.Fugir como garotinha");
			op��o=scanner.nextInt();

			switch (op��o) {
			case 1:

				fimDoJogo = atacarDrag�o(arma);

				break;

			case 2: 
				arma=trocarArma(arma);

				break;

			case 3:
			
				System.out.println("Beowulf � fraco, fugiu e chorou");				
				iniciarMenuJogo();

				break;
		
			default:
				
				System.out.println("Op��o inv�lida");

				break;
			}

		} while (op��o!=3&&fimDoJogo==false);
	}

	private static int trocarArma(int arma) {
		int escolha;

		do {
			System.out.println("Op��es:\n");

			for (int i = 0; i < 3; i++) {
			
				System.out.println((i+1)+"- "+beo.getArmaBeowulfEspec�fica(i).getNome());
			
			}
			escolha=scanner.nextInt();

		} while (escolha>3);

		return escolha-1;
	}

	private static boolean atacarDrag�o(int arma) {
		boolean morreu = false;
		double probabilidadeAcerto=0.0+random.nextInt(2);

		if(probabilidadeAcerto>drag�o.getEsquivaNatural()){
			drag�o.setHealthPoints(drag�o.getHealthPoints()-(beo.getArmaBeowulfEspec�fica(arma).getDano()-drag�o.getArmadura()/2));
			System.out.println("Voc� acertou");
		}else{
			System.out.println("Voc� errou");
		}

		if(drag�o.getHealthPoints()<=0){

			System.out.println("Parab�ns!!! voc� merece ser chamado de Deus por matar o Drag�o Smaug");
			perguntarContinua��o();
			morreu=true;
		}else{
			morreu=receberAtaque(arma);
		}



		return morreu;
	}

	private static boolean receberAtaque(int arma) {
		boolean morreu=false;
		double probabilidadeAcerto=0.0+random.nextInt(2);

		if(probabilidadeAcerto>beo.getEsquiva()){

			beo.setHealthPoints(beo.getHealthPoints()-(drag�o.getBolaDeFogo()-(beo.getDefesa()/2)+beo.getArmaBeowulfEspec�fica(arma).getDefesa()));
			System.out.println("Beowulf foi atingido por uma bola de fogo");
		}else{
			System.out.println("Beowulf esquivou do ataque do drag�o");
		}


		if(beo.getHealthPoints()<=0){
			System.out.println("Voc� n�o Upou o suficiente e foi morto de maneira tr�gica pelo drag�o");
			System.out.println("Vai cry?");
			morreu=true;
		}else{
			System.out.println("HP Drag�o: " + drag�o.getHealthPoints());
			System.out.println("HP Beowulf: "+ beo.getHealthPoints());
		}

		return morreu;
	}

	private static void perguntarContinua��o() {
		int op��o=0;

		do {
			System.out.println("Deseja continuar com 1000 de moedas a mais?\n1.Sim\n2.N�o ");
			op��o=scanner.nextInt();

			switch (op��o) {
			case 1:
				System.out.println("Voc� recebeu 1000 de gold adicional");
				beo.setDinheiro(beo.getDinheiro()+1000);
				iniciarMenuJogo();

				break;

			case 2: 
				System.out.println("Beowulf voltou para a vila vitorioso e vai encher a cara com Hidromel o resto da vida");
				break;
			default:
				System.out.println("op��o inv�lida");
				break;
			}

		} while (op��o>2);

	}

	private static int selecionarArma() {
		int arma=0;
		for (int i = 0; i < 3; i++) {
			if(!(beo.getArmaBeowulfEspec�fica(i).getNome().equals("Vazio"))){
				arma = i;
				break;
			}
		}
		return arma;
	}

	private static void menuLoja() {

		int op��o;

		do{
			System.out.println("1.Comprar\n2.Vender\n3.Sair da loja");
			op��o=scanner.nextInt();

			switch (op��o) {
			case 1:
				comprarArma();

				break;
			case 2:
				venderArma();
				break;

			case 3:
				iniciarMenuJogo();
				break;

			default:

				System.out.println("op��o inv�lida");

				break;
			}





		} while (op��o>3);

	}

	private static void venderArma() {
		Arma espa�oVazio = new Arma("Vazio",0,0,0,0);

		int op��o;
		
		do{
		
		System.out.println("Nome-Dano-Peso-Valor");
		for (int i = 0; i < 3; i++) {
			System.out.println((i)+". "+beo.getArmaBeowulfEspec�fica(i).getNome()+" - "+beo.getArmaBeowulfEspec�fica(i).getDano()
					+" - "+beo.getArmaBeowulfEspec�fica(i).getPeso()+" - "+beo.getArmaBeowulfEspec�fica(i).getValor());
		}
		op��o=scanner.nextInt();

		}while(op��o>=3);
		
		
		if(beo.getArmaBeowulfEspec�fica(op��o).getNome().equalsIgnoreCase("Vazio")){
			System.out.println("N�o se vende espa�o vazio");
		}else if(op��o>2){
			System.out.println("Op��o de arma inv�lida");
		}else{

			beo.setDinheiro(beo.getDinheiro()+beo.getArmaBeowulfEspec�fica(op��o).getValor()/2);
			beo.setArmaEspecifica(espa�oVazio, op��o);
		}

		beo.calcularPesoAtual();
		menuLoja();

	}

	private static void comprarArma() {

		int op��oCompra;

		do{
			System.out.println("Voc� tem "+beo.getDinheiro()+ " de Ouro");

			System.out.println("Nome-Dano-Peso-Pre�o");
			for (int i = 0; i < 10; i++) {
				System.out.println((i)+". "+loja.getVisualizarArma(i).getNome()+" - "+loja.getVisualizarArma(i).getDano()
						+" - "+loja.getVisualizarArma(i).getPeso()+" - "+loja.getVisualizarArma(i).getValor());
			}
			op��oCompra=scanner.nextInt();

		}while(op��oCompra>=10);

		if(compraV�lida(op��oCompra)){

			beo.setArmaEspecifica(loja.getVisualizarArma(op��oCompra), verificarPosi��oVazia());
			beo.setDinheiro(beo.getDinheiro()-loja.getVisualizarArma(op��oCompra-1).getValor());

			beo.calcularPesoAtual();
		}
		menuLoja();
	}

	private static boolean compraV�lida(int op��oCompra) {
		boolean v�lida=true;

		if(loja.getVisualizarArma(op��oCompra).getPeso()+beo.getPesoAtual()>beo.getPesoM�ximo()){
			System.out.println("Voc� est� pesado demais para carregar esta arma");
			v�lida=false;
		}else if(!verificarBolsa()){
			System.out.println("N�o tem espa�o suficiente na bolsa");
			v�lida=false;
		}else if(loja.getVisualizarArma(op��oCompra).getValor()>beo.getDinheiro()){
			System.out.println("Voc� n�o tem Gold suficiente");
			v�lida=false;
		}


		return v�lida;
	}

	private static boolean verificarBolsa() {
		boolean verifica��o=false;

		for (int i = 0; i < 3; i++) {
			if(beo.getArmaBeowulfEspec�fica(i).getNome().equalsIgnoreCase("Vazio")){
				verifica��o = true;
			}
		}

		return verifica��o;
	}

	private static int verificarPosi��oVazia() {

		int posicaoVazia=0;
		for (int i = 0; i < 3; i++) {
			if(beo.getArmaBeowulfEspec�fica(i).equals("Espa�o Vazio")){

				posicaoVazia=i;
			}
		}
		return posicaoVazia;
	}
}


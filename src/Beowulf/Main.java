package Beowulf;

import java.util.Random;
import java.util.Scanner;

public class Main {

	static Random random = new Random();
	static Scanner scanner = new Scanner(System.in);
	static Dragao dragao = new Dragao();
	static Beowulf beo = new Beowulf();
	static Loja loja = new Loja();

	public static void main(String[] args) {

		iniciarMenuJogo();
	}

	private static void iniciarMenuJogo() {

		int op�ao=0;

		do {
			System.out.println("1.Loja\n2.Batalha\n3.Desistir");
			op�ao=scanner.nextInt();

			switch (op�ao) {

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


		} while (op�ao>3);

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
		int op�ao;
		boolean fimDoJogo=false;

		do {
			System.out.println("Arma Atual: "+beo.getArmaBeowulfEspecifica(arma).getNome()+" Dano: "+beo.getArmaBeowulfEspecifica(arma).getDano());
			System.out.println("1.Atacar\n2.Trocar Arma\n3.Fugir como garotinha");
			op�ao=scanner.nextInt();

			switch (op�ao) {
			case 1:

				fimDoJogo = atacarDragao(arma);

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

		} while (op�ao!=3&&fimDoJogo==false);
	}

	private static int trocarArma(int arma) {
		int escolha;

		do {
			System.out.println("Op��es:\n");

			for (int i = 0; i < 3; i++) {

				System.out.println((i+1)+"- "+beo.getArmaBeowulfEspecifica(i).getNome());

			}
			escolha=scanner.nextInt();

		} while (escolha>3);

		return escolha-1;
	}

	private static boolean atacarDragao(int arma) {
		boolean morreu = false;
		double probabilidadeAcerto=0.0+random.nextInt(2);

		if(probabilidadeAcerto>dragao.getEsquivaNatural()){

			dragao.setHealthPoints(dragao.getHealthPoints()-(beo.getArmaBeowulfEspecifica(arma).getDano()-dragao.getArmadura()/2));
			System.out.println("Voc� acertou");

		}else{

			System.out.println("Voc� errou");

		}

		if(dragao.getHealthPoints()<=0){

			System.out.println("Parab�ns!!! voc� merece ser chamado de Deus por matar o Drag�o desgra�ado do Smaug");
			perguntarContinuacao();
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

			beo.setHealthPoints(beo.getHealthPoints()-(dragao.getBolaDeFogo()-(beo.getDefesa()/2)+beo.getArmaBeowulfEspecifica(arma).getDefesa()));
			System.out.println("Beowulf foi atingido por uma bola de fogo");

		}else{

			System.out.println("Beowulf esquivou do ataque do drag�o");

		}


		if(beo.getHealthPoints()<=0){

			System.out.println("Voc� n�o Upou o suficiente e foi morto de maneira tr�gica pelo drag�o");
			System.out.println("Vai cry?");
			morreu=true;

		}else{

			System.out.println("HP Drag�o: " + dragao.getHealthPoints());
			System.out.println("HP Beowulf: "+ beo.getHealthPoints());

		}

		return morreu;
	}

	private static void perguntarContinuacao() {
		int opcao=0;

		do {
			System.out.println("Deseja continuar com 1000 de moedas a mais?\n1.Sim\n2.N�o ");
			opcao=scanner.nextInt();

			switch (opcao) {
			
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

		} while (opcao>2);

	}

	private static int selecionarArma() {
		int arma=0;
		for (int i = 0; i < 3; i++) {
			if(!(beo.getArmaBeowulfEspecifica(i).getNome().equals("Vazio"))){
				arma = i;
				break;
			}
		}
		return arma;
	}

	private static void menuLoja() {

		int opcao;

		do{
			System.out.println("1.Comprar\n2.Vender\n3.Sair da loja");
			opcao=scanner.nextInt();

			switch (opcao) {
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





		} while (opcao>3);

	}

	private static void venderArma() {
		Arma espacoVazio = new Arma("Vazio",0,0,0,0);

		int opcao;

		do{

			System.out.println("Nome-Dano-Peso-Valor");
			for (int i = 0; i < 3; i++) {
				System.out.println((i)+". "+beo.getArmaBeowulfEspecifica(i).getNome()+" - "+beo.getArmaBeowulfEspecifica(i).getDano()
						+" - "+beo.getArmaBeowulfEspecifica(i).getPeso()+" - "+beo.getArmaBeowulfEspecifica(i).getValor());
			}
			opcao=scanner.nextInt();

		}while(opcao>=3);


		if(beo.getArmaBeowulfEspecifica(opcao).getNome().equalsIgnoreCase("Vazio")){
			
			System.out.println("N�o se vende espa�o vazio, anta!");
			
		}else if(opcao>2){
			
			System.out.println("Op��o de arma inv�lida");
	
		}else{

			beo.setDinheiro(beo.getDinheiro()+beo.getArmaBeowulfEspecifica(opcao).getValor()/2);
			beo.setArmaEspecifica(espacoVazio, opcao);
		}

		beo.calcularPesoAtual();
		menuLoja();

	}

	private static void comprarArma() {

		int opcaoCompra;

		do{
			System.out.println("Voc� tem "+beo.getDinheiro()+ " de Ouro");

			System.out.println("Nome-Dano-Peso-Pre�o");
			for (int i = 0; i < 10; i++) {
				System.out.println((i)+". "+loja.getVisualizarArma(i).getNome()+" - "+loja.getVisualizarArma(i).getDano()
						+" - "+loja.getVisualizarArma(i).getPeso()+" - "+loja.getVisualizarArma(i).getValor());
			}
			opcaoCompra=scanner.nextInt();

		}while(opcaoCompra>=10);

		if(compraValida(opcaoCompra)){

			beo.setArmaEspecifica(loja.getVisualizarArma(opcaoCompra), verificarPosicaoVazia());
			beo.setDinheiro(beo.getDinheiro()-loja.getVisualizarArma(opcaoCompra-1).getValor());

			beo.calcularPesoAtual();
		}
		menuLoja();
	}

	private static boolean compraValida(int opcaoCompra) {
		boolean valida=true;

		if(loja.getVisualizarArma(opcaoCompra).getPeso()+beo.getPesoAtual()>beo.getPesoMaximo()){
			System.out.println("Voc� est� pesado demais para carregar esta arma");
			valida=false;
		}else if(!verificarBolsa()){
			System.out.println("N�o tem espa�o suficiente na bolsa");
			valida=false;
		}else if(loja.getVisualizarArma(opcaoCompra).getValor()>beo.getDinheiro()){
			System.out.println("Voc� n�o tem Gold suficiente");
			valida=false;
		}


		return valida;
	}

	private static boolean verificarBolsa() {
		boolean verificacao=false;

		for (int i = 0; i < 3; i++) {
			if(beo.getArmaBeowulfEspecifica(i).getNome().equalsIgnoreCase("Vazio")){
				verificacao = true;
			}
		}

		return verificacao;
	}

	private static int verificarPosicaoVazia() {

		int posicaoVazia=0;
		for (int i = 0; i < 3; i++) {
			if(beo.getArmaBeowulfEspecifica(i).equals("Espa�o Vazio")){

				posicaoVazia=i;
			}
		}
		return posicaoVazia;
	}
}


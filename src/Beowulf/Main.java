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

		int opçao=0;

		do {
			System.out.println("1.Loja\n2.Batalha\n3.Desistir");
			opçao=scanner.nextInt();

			switch (opçao) {

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

				System.out.println("Ele desistiu e pá");

				break;
			default:

				System.out.println("Inválida");
				break;
			}


		} while (opçao>3);

	}

	private static void trollada() {
		System.out.println("Digite um nome: ");
		String nome = scanner.next();

		System.out.println(nome + " é...");
		System.out.println();
		System.out.println(" \\\\        //  ||     //\\\\            ||  ||===||");
		System.out.println("  \\\\      //   ||    //  \\\\        ___||  ||   ||");
		System.out.println("   \\\\    //    ||   //    \\\\     ||   ||  ||   ||");
		System.out.println("    \\\\  //     ||  //======\\\\    ||   ||  ||   ||");
		System.out.println("     \\\\//      || //        \\\\   ||___||  ||___||");

	}

	private static void batalha() {

		int arma = selecionarArma();
		int opçao;
		boolean fimDoJogo=false;

		do {
			System.out.println("Arma Atual: "+beo.getArmaBeowulfEspecifica(arma).getNome()+" Dano: "+beo.getArmaBeowulfEspecifica(arma).getDano());
			System.out.println("1.Atacar\n2.Trocar Arma\n3.Fugir como garotinha");
			opçao=scanner.nextInt();

			switch (opçao) {
			case 1:

				fimDoJogo = atacarDragao(arma);

				break;

			case 2: 
				arma=trocarArma(arma);

				break;

			case 3:

				System.out.println("Beowulf é fraco, fugiu e chorou");				
				iniciarMenuJogo();

				break;

			default:

				System.out.println("Opção inválida");

				break;
			}

		} while (opçao!=3&&fimDoJogo==false);
	}

	private static int trocarArma(int arma) {
		int escolha;

		do {
			System.out.println("Opções:\n");

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
			System.out.println("Você acertou");

		}else{

			System.out.println("Você errou");

		}

		if(dragao.getHealthPoints()<=0){

			System.out.println("Parabéns!!! você merece ser chamado de Deus por matar o Dragão desgraçado do Smaug");
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

			System.out.println("Beowulf esquivou do ataque do dragão");

		}


		if(beo.getHealthPoints()<=0){

			System.out.println("Você não Upou o suficiente e foi morto de maneira trágica pelo dragão");
			System.out.println("Vai cry?");
			morreu=true;

		}else{

			System.out.println("HP Dragão: " + dragao.getHealthPoints());
			System.out.println("HP Beowulf: "+ beo.getHealthPoints());

		}

		return morreu;
	}

	private static void perguntarContinuacao() {
		int opcao=0;

		do {
			System.out.println("Deseja continuar com 1000 de moedas a mais?\n1.Sim\n2.Não ");
			opcao=scanner.nextInt();

			switch (opcao) {
			
			case 1:
			
				System.out.println("Você recebeu 1000 de gold adicional");
				beo.setDinheiro(beo.getDinheiro()+1000);
				iniciarMenuJogo();

				break;

			case 2: 
				
				System.out.println("Beowulf voltou para a vila vitorioso e vai encher a cara com Hidromel o resto da vida");
				break;
				
			default:
				
				System.out.println("opção inválida");
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

				System.out.println("opção inválida");

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
			
			System.out.println("Não se vende espaço vazio, anta!");
			
		}else if(opcao>2){
			
			System.out.println("Opção de arma inválida");
	
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
			System.out.println("Você tem "+beo.getDinheiro()+ " de Ouro");

			System.out.println("Nome-Dano-Peso-Preço");
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
			System.out.println("Você está pesado demais para carregar esta arma");
			valida=false;
		}else if(!verificarBolsa()){
			System.out.println("Não tem espaço suficiente na bolsa");
			valida=false;
		}else if(loja.getVisualizarArma(opcaoCompra).getValor()>beo.getDinheiro()){
			System.out.println("Você não tem Gold suficiente");
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
			if(beo.getArmaBeowulfEspecifica(i).equals("Espaço Vazio")){

				posicaoVazia=i;
			}
		}
		return posicaoVazia;
	}
}


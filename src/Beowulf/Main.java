package Beowulf;

import java.util.Random;
import java.util.Scanner;

public class Main {

	static Random random = new Random();
	static Scanner scanner = new Scanner(System.in);
	static Dragão dragão = new Dragão();
	static Beowulf beo = new Beowulf();
	static Loja loja = new Loja();

	public static void main(String[] args) {

		iniciarMenuJogo();
	}

	private static void iniciarMenuJogo() {

		int opção=0;

		do {
			System.out.println("1.Loja\n2.Batalha\n3.Desistir");
			opção=scanner.nextInt();

			switch (opção) {
			
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


		} while (opção>3);

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
		int opção;
		boolean fimDoJogo=false;

		do {
			System.out.println("Arma Atual: "+beo.getArmaBeowulfEspecífica(arma).getNome()+" Dano: "+beo.getArmaBeowulfEspecífica(arma).getDano());
			System.out.println("1.Atacar\n2.Trocar Arma\n3.Fugir como garotinha");
			opção=scanner.nextInt();

			switch (opção) {
			case 1:

				fimDoJogo = atacarDragão(arma);

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

		} while (opção!=3&&fimDoJogo==false);
	}

	private static int trocarArma(int arma) {
		int escolha;

		do {
			System.out.println("Opções:\n");

			for (int i = 0; i < 3; i++) {
			
				System.out.println((i+1)+"- "+beo.getArmaBeowulfEspecífica(i).getNome());
			
			}
			escolha=scanner.nextInt();

		} while (escolha>3);

		return escolha-1;
	}

	private static boolean atacarDragão(int arma) {
		boolean morreu = false;
		double probabilidadeAcerto=0.0+random.nextInt(2);

		if(probabilidadeAcerto>dragão.getEsquivaNatural()){
			dragão.setHealthPoints(dragão.getHealthPoints()-(beo.getArmaBeowulfEspecífica(arma).getDano()-dragão.getArmadura()/2));
			System.out.println("Você acertou");
		}else{
			System.out.println("Você errou");
		}

		if(dragão.getHealthPoints()<=0){

			System.out.println("Parabéns!!! você merece ser chamado de Deus por matar o Dragão Smaug");
			perguntarContinuação();
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

			beo.setHealthPoints(beo.getHealthPoints()-(dragão.getBolaDeFogo()-(beo.getDefesa()/2)+beo.getArmaBeowulfEspecífica(arma).getDefesa()));
			System.out.println("Beowulf foi atingido por uma bola de fogo");
		}else{
			System.out.println("Beowulf esquivou do ataque do dragão");
		}


		if(beo.getHealthPoints()<=0){
			System.out.println("Você não Upou o suficiente e foi morto de maneira trágica pelo dragão");
			System.out.println("Vai cry?");
			morreu=true;
		}else{
			System.out.println("HP Dragão: " + dragão.getHealthPoints());
			System.out.println("HP Beowulf: "+ beo.getHealthPoints());
		}

		return morreu;
	}

	private static void perguntarContinuação() {
		int opção=0;

		do {
			System.out.println("Deseja continuar com 1000 de moedas a mais?\n1.Sim\n2.Não ");
			opção=scanner.nextInt();

			switch (opção) {
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

		} while (opção>2);

	}

	private static int selecionarArma() {
		int arma=0;
		for (int i = 0; i < 3; i++) {
			if(!(beo.getArmaBeowulfEspecífica(i).getNome().equals("Vazio"))){
				arma = i;
				break;
			}
		}
		return arma;
	}

	private static void menuLoja() {

		int opção;

		do{
			System.out.println("1.Comprar\n2.Vender\n3.Sair da loja");
			opção=scanner.nextInt();

			switch (opção) {
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





		} while (opção>3);

	}

	private static void venderArma() {
		Arma espaçoVazio = new Arma("Vazio",0,0,0,0);

		int opção;
		
		do{
		
		System.out.println("Nome-Dano-Peso-Valor");
		for (int i = 0; i < 3; i++) {
			System.out.println((i)+". "+beo.getArmaBeowulfEspecífica(i).getNome()+" - "+beo.getArmaBeowulfEspecífica(i).getDano()
					+" - "+beo.getArmaBeowulfEspecífica(i).getPeso()+" - "+beo.getArmaBeowulfEspecífica(i).getValor());
		}
		opção=scanner.nextInt();

		}while(opção>=3);
		
		
		if(beo.getArmaBeowulfEspecífica(opção).getNome().equalsIgnoreCase("Vazio")){
			System.out.println("Não se vende espaço vazio");
		}else if(opção>2){
			System.out.println("Opção de arma inválida");
		}else{

			beo.setDinheiro(beo.getDinheiro()+beo.getArmaBeowulfEspecífica(opção).getValor()/2);
			beo.setArmaEspecifica(espaçoVazio, opção);
		}

		beo.calcularPesoAtual();
		menuLoja();

	}

	private static void comprarArma() {

		int opçãoCompra;

		do{
			System.out.println("Você tem "+beo.getDinheiro()+ " de Ouro");

			System.out.println("Nome-Dano-Peso-Preço");
			for (int i = 0; i < 10; i++) {
				System.out.println((i)+". "+loja.getVisualizarArma(i).getNome()+" - "+loja.getVisualizarArma(i).getDano()
						+" - "+loja.getVisualizarArma(i).getPeso()+" - "+loja.getVisualizarArma(i).getValor());
			}
			opçãoCompra=scanner.nextInt();

		}while(opçãoCompra>=10);

		if(compraVálida(opçãoCompra)){

			beo.setArmaEspecifica(loja.getVisualizarArma(opçãoCompra), verificarPosiçãoVazia());
			beo.setDinheiro(beo.getDinheiro()-loja.getVisualizarArma(opçãoCompra-1).getValor());

			beo.calcularPesoAtual();
		}
		menuLoja();
	}

	private static boolean compraVálida(int opçãoCompra) {
		boolean válida=true;

		if(loja.getVisualizarArma(opçãoCompra).getPeso()+beo.getPesoAtual()>beo.getPesoMáximo()){
			System.out.println("Você está pesado demais para carregar esta arma");
			válida=false;
		}else if(!verificarBolsa()){
			System.out.println("Não tem espaço suficiente na bolsa");
			válida=false;
		}else if(loja.getVisualizarArma(opçãoCompra).getValor()>beo.getDinheiro()){
			System.out.println("Você não tem Gold suficiente");
			válida=false;
		}


		return válida;
	}

	private static boolean verificarBolsa() {
		boolean verificação=false;

		for (int i = 0; i < 3; i++) {
			if(beo.getArmaBeowulfEspecífica(i).getNome().equalsIgnoreCase("Vazio")){
				verificação = true;
			}
		}

		return verificação;
	}

	private static int verificarPosiçãoVazia() {

		int posicaoVazia=0;
		for (int i = 0; i < 3; i++) {
			if(beo.getArmaBeowulfEspecífica(i).equals("Espaço Vazio")){

				posicaoVazia=i;
			}
		}
		return posicaoVazia;
	}
}


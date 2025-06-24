package br.com.edgar.cm.visao;

import java.util.Scanner;

import br.com.edgar.cm.modelo.Tabuleiro;
import execao.ExplosaoExeception;
import execao.SairException;

public class TabuleiroConsole {
	
	private  Tabuleiro tabuleiro;
	private Scanner entrada = new Scanner(System.in);

	public TabuleiroConsole(Tabuleiro tabuleiro) {
		this.tabuleiro = tabuleiro;
		
		executarJogo();
	}

	private void executarJogo() {
	   
		try {
			boolean continuar = true;
			
			while(continuar) {
				cicloDoJogo();
				
				System.out.println("Outra Partida? (S/n)");
				String resposta = entrada.nextLine();
				
				if("n".equalsIgnoreCase(resposta));
			}
			
		} catch (SairException e) {
			System.out.println("Tchau!!!");
		}finally {
			entrada.close();
		}
		
	}

	private void cicloDoJogo() {
		
		try {
			
			while (tabuleiro.objetivoAlcancado()) {
				System.out.println(tabuleiro);
				
				String digitado = capturarValorDigitado("Digite {x,y}: ");
			}
			
			
			System.out.println("Voce ganhou");
		} catch (ExplosaoExeception e) {
			
			System.out.println("Voce perdeu");
			
		}
		

		
	}
	
	private String capturarValorDigitado(String texto) {
		System.out.print(texto);
		String digitado = entrada.nextLine();
		
		if("sair".equalsIgnoreCase(digitado)) {
			throw new SairException();
		}
		return digitado;
	}
	
	

}

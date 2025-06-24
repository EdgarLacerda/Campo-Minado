package br.com.edgar.cm.aplicacao;

import br.com.edgar.cm.modelo.Tabuleiro;
import br.com.edgar.cm.visao.TabuleiroConsole;

public class Aplicacao {

	public static void main(String[] args) {
		
		Tabuleiro tabuleiro = new Tabuleiro(6,6,6);
		new TabuleiroConsole(tabuleiro);
		
		
		System.out.println(tabuleiro);

	}

}

package br.com.edgar.cm.modelo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import execao.ExplosaoExeception;

class CampoTeste {
	
	private Campo campo;
	
	@BeforeEach
	public void iniciarCampo() {
		campo = new Campo(3,3);
	}

	@Test
	void testeVizinhoRealDistancia1Esquerda() {
		Campo viznho = new Campo(3,2);
		boolean resultado = campo.adicionarVizinhos(viznho);
		assertTrue(resultado);
	}
	
	@Test
	void testeVizinhoRealDistancia1Direita() {
		Campo viznho = new Campo(3,4);
		boolean resultado = campo.adicionarVizinhos(viznho);
		assertTrue(resultado);
	}
	
	@Test
	void testeVizinhoRealDistancia1EmCima() {
		Campo viznho = new Campo(2,3);
		boolean resultado = campo.adicionarVizinhos(viznho);
		assertTrue(resultado);
	}
	
	@Test
	void testeVizinhoRealDistancia1EmBaixo() {
		Campo viznho = new Campo(4,3);
		boolean resultado = campo.adicionarVizinhos(viznho);
		assertTrue(resultado);
	}
	
	@Test
	void testeVizinhoRealDistancia2() {
		Campo viznho = new Campo(2,2);
		boolean resultado = campo.adicionarVizinhos(viznho);
		assertTrue(resultado);
	}
	
	@Test
	void testeNaoVizinho() {
		Campo viznho = new Campo(1,1);
		boolean resultado = campo.adicionarVizinhos(viznho);
		assertFalse(resultado);
	}
	
	@Test
	void testeValorPadraoAtributoMarcado() {
		assertFalse(campo.isMarcado());
	}
	
	@Test 
	void testeAlternarMarcacao() {
		campo.alterarMarcacao();
		assertTrue(campo.isMarcado());
	}
	
	@Test
	void testeAlterarMarcacaoDuasChamadas() {
		campo.alterarMarcacao();
		campo.alterarMarcacao();
		assertFalse(campo.isMarcado());
	}
	
	@Test
	void testeAbrirMinadoNaoMarcado() {
		assertTrue(campo.abrir());
	}
	
	@Test
	void testeAbrirMinadoMarcado() {
		campo.alterarMarcacao();
		campo.minar();
		assertFalse(campo.abrir());
	}
	
	@Test
	void testeAbrirMinadoNaoMarcadoo() {
		campo.minar();
      assertThrows(ExplosaoExeception.class, () -> {
    	  campo.abrir();
      });
  	}
	

	
	@Test
	void abirComVizinhos1() {
	   Campo campo11 = new Campo(1,1);
	   Campo campo22 = new Campo(2,2);
	   
	   
	   campo22.adicionarVizinhos(campo11);
	   campo.adicionarVizinhos(campo22);
	   campo.abrir();
		
	    assertTrue(campo22.isAberto() && campo11.isAberto());
}
	
	void abrirComVizinhos2() {
		   Campo campo11 = new Campo(1,1);
		   Campo campo12 = new Campo(2,2);
		   campo.minar();
		   
		   
		   Campo campo22 = new Campo(2,2);
		   campo22.adicionarVizinhos(campo11);
		   campo22.adicionarVizinhos(campo12);
		   
		   
		   campo.adicionarVizinhos(campo22);
		   campo.abrir();
		   
		   assertTrue(campo22.isAberto() && campo11.isFechado());
			
	}

}

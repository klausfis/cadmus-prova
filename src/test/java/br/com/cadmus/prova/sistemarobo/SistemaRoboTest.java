package br.com.cadmus.prova.sistemarobo; 

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Klaus
 *
 */
public class SistemaRoboTest {

	@Test
	public void executaSistemaRobo() throws Exception {
		SistemaRobo sistemaRobo = new SistemaRobo();
		String posicaoRobo = sistemaRobo.executar("/input_instrucoes_teste.txt");
		Assert.assertEquals("2 1 OESTE", posicaoRobo);
		System.out.println("Executa Sistema Robo baseado em arquivo de input do problema. Robo Posição Final: " + posicaoRobo);
	}

	@Test
	public void roboVirarEsquerda() {
		Robo robo = new Robo(2, 5, Direcao.NORTE);
		String posicaoInicial = robo.getDirecao().toString();
		robo.virarEsquerda();
		Assert.assertEquals(Direcao.OESTE, robo.getDirecao());
		System.out.println("Executa Robo Virar Esquerda. Robo Posição Inicial: "+ posicaoInicial + " Robo Posição Final: " + robo.getDirecao().toString());
	}

	@Test
	public void roboVirar180GrausEsquerda() {
		Robo robo = new Robo(2, 5, Direcao.NORTE);
		String posicaoInicial = robo.getDirecao().toString();
		robo.virarEsquerda();
		robo.virarEsquerda();
		Assert.assertEquals(Direcao.SUL, robo.getDirecao());
		System.out.println("Executa Robo Virar 180 Graus Esquerda. Robo Posição Inicial: "+ posicaoInicial + " Robo Posição Final: " + robo.getDirecao().toString());
	}

	@Test
	public void roboVirar180GrausDireita() {
		Robo robo = new Robo(2, 5, Direcao.NORTE);
		String posicaoInicial = robo.getDirecao().toString();
		robo.virarDireita();
		robo.virarDireita();
		Assert.assertEquals(Direcao.SUL, robo.getDirecao());
		System.out.println("Executa Robo Virar 180 Graus Direita. Robo Posição Inicial: "+ posicaoInicial + " Robo Posição Final: " + robo.getDirecao().toString());
	}

	@Test
	public void roboVirar180GrausEsquerda90GrausDireita() {
		Robo robo = new Robo(2, 5, Direcao.NORTE);
		String posicaoInicial = robo.getDirecao().toString();
		robo.virarEsquerda();
		robo.virarEsquerda();
		robo.virarDireita();
		Assert.assertEquals(Direcao.OESTE, robo.getDirecao());
		System.out.println("Executa Robo Virar 180 Graus Esquerda 90 Graus Direita. Robo Posição Inicial: "+ posicaoInicial + " Robo Posição Final: " + robo.getDirecao().toString());
	}

	@Test
	public void roboMoverPeloMapa() {
		Mapa mapa = new Mapa(10, 10);
		Robo robo = new Robo(2, 5, Direcao.NORTE);
		String localizacaoInicial = robo.posicaoAtual();
		robo.setMapa(mapa);
		robo.mover();
		robo.mover();
		robo.virarDireita();
		robo.mover();
		Assert.assertEquals("3 7 LESTE", robo.posicaoAtual());
		System.out.println("Executa Robo Mover Pelo Mapa. Robo Localização Inicial: "+ localizacaoInicial + " Robo Localização Final: " +  robo.posicaoAtual());
	}

	@Test
	public void roboTeleTransportar() {
		Mapa mapa = new Mapa(10, 10);
		Robo robo = new Robo(2, 5, Direcao.NORTE);
		String localizacaoInicial = robo.posicaoAtual();
		robo.setMapa(mapa);
		String instrucao = "T 5 6";
		robo.instrucao(instrucao);
		Assert.assertEquals("5 6 NORTE", robo.posicaoAtual());
		System.out.println("Executa Robo Tele Transportar. Instrução = " + instrucao + " Robo Localização Inicial: "+ localizacaoInicial + " Robo Localização Final: " +  robo.posicaoAtual());
	}

	@Test
	public void roboExecutaInstrucao() {
		Mapa mapa = new Mapa(10, 10);
		Robo robo = new Robo(2, 5, Direcao.NORTE);
		String localizacaoInicial = robo.posicaoAtual();
		robo.setMapa(mapa);
		String instrucao = "LLRRMMMRMRMRM";
		robo.instrucao(instrucao);
		Assert.assertEquals("2 7 OESTE", robo.posicaoAtual());
		System.out.println("Executa Robo Executa Instrução. Instrução = " + instrucao + " Robo Localização Inicial: "+ localizacaoInicial + " Robo Localização Final:" +  robo.posicaoAtual());
	}

	@Test
	public void roboExecutaInstrucaoTeleTransporteForaMapa() {
		Mapa mapa = new Mapa(5, 5);
		Robo robo = new Robo(2, 5, Direcao.NORTE);
		String localizacaoInicial = robo.posicaoAtual();
		robo.setMapa(mapa);
		robo.instrucao("MMMMMMMMRM");
		Assert.assertEquals("3 5 LESTE", robo.posicaoAtual());
		robo.instrucao("T 8 8");
		Assert.assertEquals("3 5 LESTE", robo.posicaoAtual());
		System.out.println("Executa Robo Executa Instrução Tele transporte Fora do Mapa. Robo Localização Inicial: "+ localizacaoInicial + " Robo Localização Final:" +  robo.posicaoAtual());
	}
}

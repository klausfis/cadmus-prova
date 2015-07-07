package br.com.cadmus.prova.sistemarobo;

import java.util.Arrays;

/**
 * @author Klaus
 *
 */
public class Robo {

	private Integer x;

	private Integer y;

	private Direcao direcao;

	private Mapa mapa;

	public Robo(Integer x, Integer y, Direcao direcao) {
		this.x = x;
		this.y = y;
		this.direcao = direcao;
	}

	public void setMapa(Mapa mapa) {
		this.mapa = mapa;
	}

	public void virarEsquerda() {
		this.direcao = this.direcao.virarEsquerda();
	}

	public void virarDireita() {
		this.direcao = this.direcao.virarDireita();
	}

	public void instrucao(String linha) {

		String[] comandos = linha.split("");

		//Windows File Format Bug Fix
		if (comandos[0].equals("")) {
			comandos = Arrays.copyOfRange(comandos, 1, comandos.length);
		}

		if (comandos[0].equals("T")) {
			teleTransporte(Integer.parseInt(comandos[2]), Integer.parseInt(comandos[4]));
			return;
		}

		for (int i = 0; i < comandos.length; i++) {

			if (comandos[i].equals("L")) {
				virarEsquerda();
			}

			if (comandos[i].equals("R")) {
				virarDireita();
			}

			if (comandos[i].equals("M")) {
				mover();
			}
		}

	}

	public void mover() {
		if (this.direcao.equals(Direcao.NORTE)) {
			if (this.y < this.mapa.getY()) {
				this.y++;
			}
		}

		if (this.direcao.equals(Direcao.LESTE)) {
			if (this.x < this.mapa.getX()) {
				this.x++;
			}
		}

		if (this.direcao.equals(Direcao.SUL)) {
			if (this.y > 0) {
				this.y--;
			}
		}

		if (this.direcao.equals(Direcao.OESTE)) {
			if (this.x > 0) {
				this.x--;
			}
		}
	}

	public String posicaoAtual() {
		return String.format("%d %d %s", x, y, direcao);
	}

	public void teleTransporte(Integer x, Integer y) {
		if (this.mapa.getX() >= x && this.mapa.getY() >= y) {
			this.x = x;
			this.y = y;
		}
	}

	public Direcao getDirecao() {
		return direcao;
	}

}

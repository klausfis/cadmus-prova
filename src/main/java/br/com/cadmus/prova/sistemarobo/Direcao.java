package br.com.cadmus.prova.sistemarobo;

/**
 * @author Klaus
 *
 */
public enum Direcao {
	NORTE(0), LESTE(1), SUL(2), OESTE(3);

	private Integer direcaoOrdinal;

	Direcao(Integer direcaoOrdinal) {
		this.direcaoOrdinal = direcaoOrdinal;
	}

	public Direcao virarEsquerda() {
		if (direcaoOrdinal == 0) {
			return Direcao.getDirecao(3);
		} else {
			return Direcao.getDirecao(direcaoOrdinal - 1);
		}
	}

	public Direcao virarDireita() {
		if (direcaoOrdinal == 3) {
			return Direcao.getDirecao(0);
		} else {
			return Direcao.getDirecao(direcaoOrdinal + 1);
		}
	}

	private Integer getDirecao() {
		return direcaoOrdinal;
	}

	private static Direcao getDirecao(Integer direcaoOrdinalParametro) {

		for (Direcao Direcao : Direcao.values()) {
			if (Direcao.getDirecao() == direcaoOrdinalParametro) {
				return Direcao;
			}
		}
		throw new IllegalArgumentException("Indice invalido!");
	}

	public static Direcao getDirecao(String direcaoParametroInstrucao) {
		String direcaoConvertido = converteDirecaoPortugues(direcaoParametroInstrucao);

		for (Direcao Direcao : Direcao.values()) {
			if (Direcao.name().equals(direcaoConvertido)) {
				return Direcao;
			}
		}
		throw new IllegalArgumentException("Indice invalido!");
	}

	public static String converteDirecaoPortugues(String direcaoParametroInstrucao) {
		String retorno = "";
		switch (direcaoParametroInstrucao) {
		case "N":
			retorno = "NORTE";
			break;
		case "E":
			retorno = "LESTE";
			break;
		case "W":
			retorno = "OESTE";
			break;
		case "S":
			retorno = "SUL";
			break;
		default:
			break;
		}
		return retorno;
	}
}

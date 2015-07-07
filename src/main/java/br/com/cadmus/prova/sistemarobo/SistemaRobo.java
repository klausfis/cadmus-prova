package br.com.cadmus.prova.sistemarobo;

import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * @author Klaus
 *
 */
public class SistemaRobo {

	public static void main(String[] args) throws Exception {
		SistemaRobo sistemaRobo = new SistemaRobo();
		String posicaoRobo = sistemaRobo.executar("/input_instrucoes.txt");
		System.out.println("Executa Sistema Robo baseado em arquivo de input do problema. Robo Posição Final: " + posicaoRobo);
	}

	public String executar(String caminhoArquivoInstrucoes) throws Exception {
		List<String> comandos = lerArquivoInstrucoes(caminhoArquivoInstrucoes);

		Mapa mapa = inicializaMapa(comandos);
		Robo robo = inicializaRobo(comandos);
		robo.setMapa(mapa);

		for (String linha : comandos.subList(2, comandos.size())) {
			robo.instrucao(linha);
		}

		return robo.posicaoAtual();

	}

	private Mapa inicializaMapa(List<String> comandos) {
		String[] primeiraLinha = comandos.get(0).split("\\s+");
		Mapa mapa = new Mapa(Integer.parseInt(primeiraLinha[0]), Integer.parseInt(primeiraLinha[1]));
		return mapa;
	}

	private Robo inicializaRobo(List<String> comandos) {
		String[] segundaLinha = comandos.get(1).split("\\s+");
		Robo robo = new Robo(Integer.parseInt(segundaLinha[0]), Integer.parseInt(segundaLinha[1]),
				Direcao.getDirecao(segundaLinha[2]));
		return robo;
	}

	public List<String> lerArquivoInstrucoes(String caminhoArquivoInstrucoes) throws Exception {
		return Files.readAllLines(Paths.get(this.getClass().getResource(caminhoArquivoInstrucoes).toURI()), Charset.defaultCharset());
	}
}

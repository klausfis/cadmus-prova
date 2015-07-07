package br.com.cadmus.prova.subcadeiasomamaxima;

/**
 * @author Klaus
 *
 */
public class SubCadeiaSomaMaxima {

	public static void main(String[] args) {
		Integer[] conjuntoElementos = new Integer[] { 2, -4, 6, 8, -10, 100, -6, 5 };
		SubCadeiaSomaMaximaDTO resultado = calculaSubCadeiaSomaMaxima(conjuntoElementos);
		System.out.println(String.format("O subconjunto de soma máxima é dado pelo indice inicial %d e final %d", resultado.getPrimeiroElemento(),
				resultado.getUltimoElemento()));
	}

	public static SubCadeiaSomaMaximaDTO calculaSubCadeiaSomaMaxima(Integer[] conjuntoElementos) {
		SubCadeiaSomaMaximaDTO retorno = new SubCadeiaSomaMaximaDTO();
		Integer maiorSoma = 0;
		Integer primeiroElemento = 0;
		Integer ultimoElemento = 0;
		for (int i = 0; i < conjuntoElementos.length - 1; i++) {
			Integer subMaior = conjuntoElementos[i];
			for (int j = i + 1; j < conjuntoElementos.length; j++) {
				subMaior += conjuntoElementos[j];
				if (maiorSoma < subMaior && !(i == 0 && j == (conjuntoElementos.length - 1))) {
					maiorSoma = subMaior;
					primeiroElemento = i;
					ultimoElemento = j;
				}
			}
		}
		retorno.setPrimeiroElemento(primeiroElemento);
		retorno.setUltimoElemento(ultimoElemento);
		return retorno;
	}
}
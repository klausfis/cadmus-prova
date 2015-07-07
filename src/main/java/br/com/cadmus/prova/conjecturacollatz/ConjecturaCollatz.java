package br.com.cadmus.prova.conjecturacollatz;

/**
 * @author Klaus
 *
 */
public class ConjecturaCollatz {

	public static Long MILHAO = 1000000L;

	public static Long ABAIXO_MILHAO = 999999L;

	public static void main(String[] args) {
		System.out.println("Conjectura de Collatz de 1 Milhao: " + calculaConjecturaCollatz(MILHAO));
		System.out.println("Conjectura de Collatz de 999999: " + calculaConjecturaCollatz(ABAIXO_MILHAO));
		System.out.println("Maior inteiro abaixo Um Milhao eh: " + calculaMaiorInteiroAbaixoMilhao());
	}

	public static Integer calculaMaiorInteiroAbaixoMilhao() {
		Integer retorno = 0;
		Integer maiorQuantidadeItens = 0;
		for (int i = ABAIXO_MILHAO.intValue(); i > 1; i--) {
			Integer valorConjecturaCollatz = calculaConjecturaCollatz(Long.valueOf(i));
			if (maiorQuantidadeItens < valorConjecturaCollatz) {
				maiorQuantidadeItens = valorConjecturaCollatz;
				retorno = i;
			}
		}
		return retorno;
	}

	public static Integer calculaConjecturaCollatz(Long parametroCalculo) {
		Integer retorno = 1;
		while (parametroCalculo > 1) {
			if ((parametroCalculo % 2) == 0) {
				parametroCalculo /= 2;
			} else {
				parametroCalculo = (parametroCalculo * 3) + 1;
			}
			retorno++;
		}
		return retorno;
	}
}

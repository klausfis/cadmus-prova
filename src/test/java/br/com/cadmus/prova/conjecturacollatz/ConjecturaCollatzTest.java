package br.com.cadmus.prova.conjecturacollatz;

import java.util.Calendar;

import org.junit.Assert;
import org.junit.Test;

public class ConjecturaCollatzTest {

	@Test
	public void calculaConjecturaCollatz13() {
		Integer valorCollatz = ConjecturaCollatz.calculaConjecturaCollatz(13L);
		Assert.assertEquals(Integer.valueOf(10), valorCollatz);
		System.out.println("Conjectura de Collatz de 13: " + valorCollatz);
	}

	@Test
	public void calculaConjecturaCollatz1000000() {
		Integer valorCollatz = ConjecturaCollatz.calculaConjecturaCollatz(ConjecturaCollatz.MILHAO);
		Assert.assertEquals(Integer.valueOf(153), valorCollatz);
		System.out.println("Conjectura de Collatz de 1 milhao: " + valorCollatz);
	}

	@Test
	public void calculaConjecturaCollatzMaiorInteiroAbaixoMilhao() {
		Integer valorCollatz = ConjecturaCollatz.calculaMaiorInteiroAbaixoMilhao();
		Assert.assertEquals(Integer.valueOf(837799), valorCollatz);
		System.out.println("Qual inteiro positivo abaixo de 1 milhão, produz a sequência com mais itens?: " + valorCollatz);
	}

	@Test
	public void testaPerformanceConjecturaCollatz() {
		long tempoInicial = Calendar.getInstance().getTimeInMillis();
		Assert.assertEquals(Integer.valueOf(153), ConjecturaCollatz.calculaConjecturaCollatz(ConjecturaCollatz.MILHAO));
		long tempoFinal = Calendar.getInstance().getTimeInMillis();
		long tempoExecucao = (tempoFinal - tempoInicial);
		Assert.assertTrue(tempoExecucao < 5000);
		System.out.println("Tempo para executar calculo Conjectura Collatz para o caso de 1 milhão: " +tempoExecucao);
	}
}

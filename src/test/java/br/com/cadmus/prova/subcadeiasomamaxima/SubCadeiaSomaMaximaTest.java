package br.com.cadmus.prova.subcadeiasomamaxima;

import org.junit.Assert;
import org.junit.Test;

import br.com.cadmus.prova.subcadeiasomamaxima.SubCadeiaSomaMaxima;
import br.com.cadmus.prova.subcadeiasomamaxima.SubCadeiaSomaMaximaDTO;

/**
 * @author Klaus
 *
 */
public class SubCadeiaSomaMaximaTest {

    @Test
    public void calculaSubCadeiaSomaMaxima() {
        Integer[] conjuntoElementos = new Integer[] { 2, -4, 6, 8, -10, 100, -6, 5 };
        SubCadeiaSomaMaximaDTO resultado = SubCadeiaSomaMaxima.calculaSubCadeiaSomaMaxima(conjuntoElementos);
        Assert.assertEquals(Integer.valueOf(2), resultado.getPrimeiroElemento());
        Assert.assertEquals(Integer.valueOf(5), resultado.getUltimoElemento());
        System.out.println(String.format("O subconjunto de soma máxima é dado pelo indice inicial %d e final %d", resultado.getPrimeiroElemento(),
                resultado.getUltimoElemento()));
    }
}

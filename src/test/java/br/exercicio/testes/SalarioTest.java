package br.exercicio.testes;

import org.junit.Test;

import br.exercicio.salario.modelo.Salario;
import br.exercicio.salario.servico.FolhaPagamento;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.Console;

import org.junit.Before;

public class SalarioTest {
	
	private Salario salario;
	
	@Before
	public void before(){
		this.salario = new FolhaPagamento()
				.para("João")
				.queRecebePorHora(30)
				.queTrabalhaEmHorasSemanais(40)
				.queTemComoDependente("Maria")
				.queTemComoDependente("José")
				.constroi();
	}
	
	@Test
	public void salarioBrutoDeveSerIgual(){
		assertEquals(1300.0, this.salario.getSalarioBruto());
	}
	
	@Test
	public void descontoInssDeveSerIgual(){
		assertEquals(117.0, this.salario.getDescontoInss());
	}	
	
	@Test
	public void descontoIrDeveSerIgual(){
		assertEquals(91.0, this.salario.getDescontoIr());
	}	
	
	@Test
	public void salarioLiquidoDeveSerIgual(){
		assertEquals(1092.0, this.salario.getSalarioLiquido());
	}		
	
	@Test
	public void salarioLiquidoDeveSerMenorQueSalarioBruto(){
		assertTrue(this.salario.getSalarioLiquido() < this.salario.getSalarioBruto());
	}
}

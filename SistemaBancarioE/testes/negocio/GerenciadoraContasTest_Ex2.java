package negocio;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class GerenciadoraContasTest_Ex2 {
	@Test
	public void testeTranfereValor() {
		ContaCorrente conta1 = new ContaCorrente(1, 200.00, true);
		ContaCorrente conta2 = new ContaCorrente(2, 0.00, true);

		List<ContaCorrente> contas = new ArrayList<>();

		contas.add(conta1);
		contas.add(conta2);

		GerenciadoraContas gerenciadoraContas = new GerenciadoraContas(contas);

		assertThat(gerenciadoraContas.transfereValor(1, 100, 2), is(true));

		assertThat(gerenciadoraContas.pesquisaConta(1).getSaldo(), is(100.0));

		assertThat(gerenciadoraContas.pesquisaConta(2).getSaldo(), is(100.0));

	}

	@Test
	public void testTransfereValor_SaldoInsuficiente() {
		ContaCorrente conta1 = new ContaCorrente(1, 100.00, true);
		ContaCorrente conta2 = new ContaCorrente(2, 0.00, true);

		List<ContaCorrente> contas = new ArrayList<>();

		contas.add(conta1);
		contas.add(conta2);

		GerenciadoraContas gerenciadoraContas = new GerenciadoraContas(contas);

		assertThat(gerenciadoraContas.transfereValor(1, 200, 2), is(true));

		assertThat(gerenciadoraContas.pesquisaConta(1).getSaldo(), is(-100.0));

		assertThat(gerenciadoraContas.pesquisaConta(2).getSaldo(), is(200.0));
	}
	
	@Test
	public void testTransfereValor_SaldoNegativo() {
		ContaCorrente conta1 = new ContaCorrente(1, -100.00, true);
		ContaCorrente conta2 = new ContaCorrente(2, 0.00, true);

		List<ContaCorrente> contas = new ArrayList<>();

		contas.add(conta1);
		contas.add(conta2);

		GerenciadoraContas gerenciadoraContas = new GerenciadoraContas(contas);

		assertThat(gerenciadoraContas.transfereValor(1, 200, 2), is(true));

		assertThat(gerenciadoraContas.pesquisaConta(1).getSaldo(), is(-300.0));

		assertThat(gerenciadoraContas.pesquisaConta(2).getSaldo(), is(200.0));
	}
	
	@Test
	public void testTransfereValor_SaldoNegativoParaNegativo() {
		ContaCorrente conta1 = new ContaCorrente(1, -100.00, true);
		ContaCorrente conta2 = new ContaCorrente(2, -100.00, true);

		List<ContaCorrente> contas = new ArrayList<>();

		contas.add(conta1);
		contas.add(conta2);

		GerenciadoraContas gerenciadoraContas = new GerenciadoraContas(contas);

		assertThat(gerenciadoraContas.transfereValor(1, 200, 2), is(true));

		assertThat(gerenciadoraContas.pesquisaConta(1).getSaldo(), is(-300.0));

		assertThat(gerenciadoraContas.pesquisaConta(2).getSaldo(), is(100.0));
	}


}

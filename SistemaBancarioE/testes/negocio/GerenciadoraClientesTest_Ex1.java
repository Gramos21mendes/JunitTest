package negocio;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class GerenciadoraClientesTest_Ex1 {

	@Test
	public void testPesquisaClient() {
		Cliente cliente01 = new Cliente(1, "Maria Fernanda", 31, "abacaxilaranja@feira.com.br", 1, true);
		Cliente cliente02 = new Cliente(2, "Guilherme Ramos", 21, "mamaolaranja@feira.com.br", 1, true);

		List<Cliente> clientesBanco = new ArrayList<>();

		clientesBanco.add(cliente01);
		clientesBanco.add(cliente02);

		GerenciadoraClientes gerClientes = new GerenciadoraClientes(clientesBanco);

		Cliente cliente = gerClientes.pesquisaCliente(1);

		assertThat(cliente.getId(), is(1));
		
		assertThat(cliente.getEmail(), is("abacaxilaranja@feira.com.br"));

		assertThat(gerClientes.removeCliente(2), is(true));

		assertThat(gerClientes.getClientesDoBanco().size(), is(1));
		
		assertNull(gerClientes.pesquisaCliente(2));
		
		
//		if (!gerClientes.getClientesDoBanco().contains(cliente02)) {
//			System.out.println("Cliente foi removido");
//		}
//
//		if (gerClientes.getClientesDoBanco().size() == 1) {
//			System.out.println("Cliente foi removido");
//		}

	}

}

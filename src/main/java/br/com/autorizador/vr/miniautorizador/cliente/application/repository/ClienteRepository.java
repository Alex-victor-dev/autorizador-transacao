package br.com.autorizador.vr.miniautorizador.cliente.application.repository;

import java.util.List;
import java.util.UUID;

import br.com.autorizador.vr.miniautorizador.cliente.domain.Cliente;

public interface ClienteRepository {

	Cliente salvaCliente(Cliente cliente);

	Cliente buscaClientePorId(UUID idCliente);

	List<Cliente> buscaTodosClientes();

}

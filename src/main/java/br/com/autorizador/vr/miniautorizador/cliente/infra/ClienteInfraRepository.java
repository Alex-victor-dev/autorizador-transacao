package br.com.autorizador.vr.miniautorizador.cliente.infra;

import java.util.UUID;

import org.springframework.stereotype.Repository;

import br.com.autorizador.vr.miniautorizador.cliente.application.repository.ClienteRepository;
import br.com.autorizador.vr.miniautorizador.cliente.domain.Cliente;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Repository
@Log4j2
@RequiredArgsConstructor
public class ClienteInfraRepository implements ClienteRepository {

	private final ClienteInfraJpaRepository clienteInfraJpaRepository;

	@Override
	public Cliente salvaCliente(Cliente cliente) {
		log.info("[inicia] ClienteInfraRepository - salvaCliente");
		clienteInfraJpaRepository.save(cliente);
		log.info("[finaliza] ClienteInfraRepository- salvaCliente");
		return cliente;
	}

	@Override
	public Cliente buscaClientePorId(UUID idCliente) {
		log.info("[inicia] ClienteInfraRepository - buscaClientePorId");
		Cliente cliente = clienteInfraJpaRepository.findById(idCliente).orElseThrow();
		log.info("[finaliza] ClienteInfraRepository- buscaClientePorId");
		return cliente;
	}

}

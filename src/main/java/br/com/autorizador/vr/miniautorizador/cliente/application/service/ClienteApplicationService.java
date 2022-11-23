package br.com.autorizador.vr.miniautorizador.cliente.application.service;

import java.util.UUID;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import br.com.autorizador.vr.miniautorizador.cliente.application.api.ClienteDetalhadoResponse;
import br.com.autorizador.vr.miniautorizador.cliente.application.api.ClienteRequest;
import br.com.autorizador.vr.miniautorizador.cliente.application.api.ClienteResponse;
import br.com.autorizador.vr.miniautorizador.cliente.application.repository.ClienteRepository;
import br.com.autorizador.vr.miniautorizador.cliente.domain.Cliente;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
@RequiredArgsConstructor
public class ClienteApplicationService implements ClienteService {

	private final ClienteRepository clienteRepository;

	@Override
	public ClienteResponse criaCliente(@Valid ClienteRequest clienteRequest) {
		log.info("[inicia] ClienteApplicationService - criaCliente");
		Cliente cliente = clienteRepository.salvaCliente(new Cliente(clienteRequest));
		log.info("[finaliza] ClienteApplicationService - criaCliente");
		return ClienteResponse.builder()
				.idCliente(cliente.getIdCliente())
				.build();
	}

	@Override
	public ClienteDetalhadoResponse getClientePorId(UUID idCliente) {
		log.info("[inicia] ClienteApplicationService - getClientePorId");
		Cliente cliente = clienteRepository.buscaClientePorId(idCliente);
		log.info("[finaliza] ClienteApplicationService - getClientePorId");
		return new ClienteDetalhadoResponse(cliente);
	}

}

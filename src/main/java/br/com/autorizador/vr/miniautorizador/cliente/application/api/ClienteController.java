package br.com.autorizador.vr.miniautorizador.cliente.application.api;

import java.util.UUID;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.RestController;

import br.com.autorizador.vr.miniautorizador.cliente.application.service.ClienteService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@Log4j2
@RequiredArgsConstructor
public class ClienteController implements ClienteAPI {

	private final ClienteService clienteService;

	@Override
	public ClienteResponse criaCliente(@Valid ClienteRequest clienteRequest) {
		log.info("[inicia] ClienteController - criaCliente");
		ClienteResponse cliente = clienteService.criaCliente(clienteRequest);
		log.info("[finaliza] ClienteController - criaCliente");
		return cliente;
	}

	@Override
	public ClienteDetalhadoResponse getClientePorId(UUID idCliente) {
		log.info("[inicia] ClienteController - criaCliente");
		ClienteDetalhadoResponse cliente = clienteService.getClientePorId(idCliente);
		log.info("[finaliza] ClienteController - criaCliente");
		return cliente;
	}

}

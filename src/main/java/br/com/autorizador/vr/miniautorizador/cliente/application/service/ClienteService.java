package br.com.autorizador.vr.miniautorizador.cliente.application.service;

import java.util.UUID;

import javax.validation.Valid;

import br.com.autorizador.vr.miniautorizador.cliente.application.api.ClienteDetalhadoResponse;
import br.com.autorizador.vr.miniautorizador.cliente.application.api.ClienteRequest;
import br.com.autorizador.vr.miniautorizador.cliente.application.api.ClienteResponse;

public interface ClienteService {

	ClienteResponse criaCliente(@Valid ClienteRequest clienteRequest);

	ClienteDetalhadoResponse getClientePorId(UUID idCliente);

}

package br.com.autorizador.vr.miniautorizador.cliente.application.service;

import javax.validation.Valid;

import br.com.autorizador.vr.miniautorizador.cliente.application.api.ClienteRequest;
import br.com.autorizador.vr.miniautorizador.cliente.application.api.ClienteResponse;

public interface ClienteService {

	ClienteResponse criaCliente(@Valid ClienteRequest clienteRequest);

}

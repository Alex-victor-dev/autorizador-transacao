package br.com.autorizador.vr.miniautorizador.cliente.application.api;

import java.util.UUID;

import br.com.autorizador.vr.miniautorizador.cliente.domain.Cliente;
import br.com.autorizador.vr.miniautorizador.cliente.domain.Sexo;
import lombok.Value;

@Value
public class ClienteDetalhadoResponse {

	private UUID idCliente;
	private String nomeCompleto;
	private String email;
	private Sexo sexo;

	public ClienteDetalhadoResponse(Cliente cliente) {
		this.idCliente = cliente.getIdCliente();
		this.nomeCompleto = cliente.getNomeCompleto();
		this.email = cliente.getEmail();
		this.sexo = cliente.getSexo();
	}

}

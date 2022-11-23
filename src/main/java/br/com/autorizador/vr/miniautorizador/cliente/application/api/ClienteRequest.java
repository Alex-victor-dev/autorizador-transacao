package br.com.autorizador.vr.miniautorizador.cliente.application.api;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import br.com.autorizador.vr.miniautorizador.cliente.domain.Sexo;
import lombok.Value;

@Value
public class ClienteRequest {

	@NotBlank
	private String nomeCompleto;
	@NotBlank
	@Email
	@Column(unique = true)
	private String email;
	@Enumerated(EnumType.STRING)
	private Sexo sexo;
}

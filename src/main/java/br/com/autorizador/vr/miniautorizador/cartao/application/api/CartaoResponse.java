package br.com.autorizador.vr.miniautorizador.cartao.application.api;

import java.time.LocalDate;
import java.util.UUID;

import lombok.Value;

@Value
public class CartaoResponse {

	private UUID idCartao;
	private LocalDate validadeCartao;
}

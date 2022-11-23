package br.com.autorizador.vr.miniautorizador.cartao.application.api;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Value;

@Value
public class CartaoRequest {

	@NotNull
	@Size(max = 4)
	private String senha;
	private LocalDate validadeCartao;
	private LocalDate dataHoraCriacaoCartao;
}

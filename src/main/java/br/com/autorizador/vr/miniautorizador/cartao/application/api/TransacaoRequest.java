package br.com.autorizador.vr.miniautorizador.cartao.application.api;

import lombok.Value;

@Value
public class TransacaoRequest {

	private Double valorCompra;
	private Double limiteCartao;

}

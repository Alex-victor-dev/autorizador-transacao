package br.com.autorizador.vr.miniautorizador.cartao.application.service;

import java.util.UUID;

import br.com.autorizador.vr.miniautorizador.cartao.application.api.CartaoDetalhadoResponse;
import br.com.autorizador.vr.miniautorizador.cartao.application.api.CartaoRequest;
import br.com.autorizador.vr.miniautorizador.cartao.application.api.CartaoResponse;

public interface CartaoService {

	CartaoResponse criaCartao(UUID idCliente, CartaoRequest cartaoRequest);

	CartaoDetalhadoResponse getCartaoPorNumero(String numeroCartao);

}

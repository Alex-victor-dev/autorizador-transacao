package br.com.autorizador.vr.miniautorizador.cartao.application.service;

import java.util.UUID;

import javax.validation.Valid;

import br.com.autorizador.vr.miniautorizador.cartao.application.api.CartaoDetalhadoResponse;
import br.com.autorizador.vr.miniautorizador.cartao.application.api.CartaoRequest;
import br.com.autorizador.vr.miniautorizador.cartao.application.api.CartaoResponse;
import br.com.autorizador.vr.miniautorizador.cartao.application.api.TransacaoRequest;
import br.com.autorizador.vr.miniautorizador.cartao.application.api.TransacaoResponse;

public interface CartaoService {

	CartaoResponse criaCartao(UUID idCliente, CartaoRequest cartaoRequest);

	CartaoDetalhadoResponse getCartaoPorNumero(String numeroCartao);

	TransacaoResponse realizaTransacao(@Valid TransacaoRequest transacaoRequest, String numeroCartao, String senha) ;

}

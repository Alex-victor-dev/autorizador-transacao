package br.com.autorizador.vr.miniautorizador.cartao.application.service;

import java.util.UUID;

import javax.validation.Valid;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.autorizador.vr.miniautorizador.cartao.application.api.CartaoDetalhadoResponse;
import br.com.autorizador.vr.miniautorizador.cartao.application.api.CartaoRequest;
import br.com.autorizador.vr.miniautorizador.cartao.application.api.CartaoResponse;
import br.com.autorizador.vr.miniautorizador.cartao.application.api.TransacaoRequest;
import br.com.autorizador.vr.miniautorizador.cartao.application.api.TransacaoResponse;
import br.com.autorizador.vr.miniautorizador.cartao.application.repository.CartaoRepository;
import br.com.autorizador.vr.miniautorizador.cartao.domain.Cartao;
import br.com.autorizador.vr.miniautorizador.cartao.domain.StatusCompra;
import br.com.autorizador.vr.miniautorizador.cartao.domain.Transacao;
import br.com.autorizador.vr.miniautorizador.cliente.application.service.ClienteService;
import br.com.autorizador.vr.miniautorizador.cliente.handler.HandleException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
@RequiredArgsConstructor
public class CartaoApplicationService implements CartaoService {

	private final ClienteService clienteService;
	private final CartaoRepository cartaoRepository;
	private final HandleException handleException;

	@Override
	public CartaoResponse criaCartao(UUID idCliente, CartaoRequest cartaoRequest) {
		log.info("[inicia] CartaoApplicationService - criaCartao");
		clienteService.getClientePorId(idCliente);
		Cartao cartao = cartaoRepository.salvaCartao(new Cartao(idCliente, cartaoRequest));
		log.info("[finaliza] CartaoApplicationService - criaCartao");
		return new CartaoResponse(cartao.getIdCartao(), cartao.getValidadeCartao(), cartao.getNumeroCartao());
	}

	@Override
	public CartaoDetalhadoResponse getCartaoPorNumero(String numeroCartao) {
		log.info("[inicia] CartaoApplicationService - getCartaoPorNumero");
		Cartao cartao = cartaoRepository.buscaCartaoPorNumero(numeroCartao);
		log.info("[finaliza] CartaoApplicationService - getCartaoPorNumero");
		return new CartaoDetalhadoResponse(cartao);
	}

	@Override
	@Transactional
	public TransacaoResponse realizaTransacao(@Valid TransacaoRequest transacaoRequest, String numeroCartao,
			String senha) {
		log.info("[inicia] CartaoApplicationService - realizaTransacao");
		Cartao cartao = cartaoRepository.buscaCartaoPorNumero(numeroCartao);
		Transacao transacao = cartaoRepository.salvaTransacao(new Transacao(transacaoRequest));
		cartao.validarAtribuirNovoSaldo(transacao.getValorCompra(), handleException);
		cartaoRepository.salvaCartao(cartao);
		log.info("[finaliza] CartaoApplicationService - realizaTransacao");
		return TransacaoResponse.builder().statusCompra(StatusCompra.APROVADA).valor(transacao.getValorCompra())
				.numeroCartao(cartao.getNumeroCartao()).idTransacao(transacao.getIdTransacao()).build();
	}

}

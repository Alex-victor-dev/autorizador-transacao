package br.com.autorizador.vr.miniautorizador.cartao.application.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import br.com.autorizador.vr.miniautorizador.cartao.application.api.CartaoRequest;
import br.com.autorizador.vr.miniautorizador.cartao.application.api.CartaoResponse;
import br.com.autorizador.vr.miniautorizador.cartao.application.repository.CartaoRepository;
import br.com.autorizador.vr.miniautorizador.cartao.domain.Cartao;
import br.com.autorizador.vr.miniautorizador.cliente.application.service.ClienteService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
@RequiredArgsConstructor
public class CartaoApplicationService implements CartaoService {

	private final ClienteService clienteService;
	private final CartaoRepository cartaoRepository;

	@Override
	public CartaoResponse criaCartao(UUID idCliente, CartaoRequest cartaoRequest) {
		log.info("[inicia] CartaoApplicationService - criaCartao");
		clienteService.getClientePorId(idCliente);
		Cartao cartao = cartaoRepository.salvaCartao(new Cartao(idCliente, cartaoRequest));
		log.info("[finaliza] CartaoApplicationService - criaCartao");
		return new CartaoResponse(cartao.getIdCartao(), 
				cartao.getValidadeCartao());
	}

}

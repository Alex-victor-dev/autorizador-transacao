package br.com.autorizador.vr.miniautorizador.cartao.application.api;

import java.util.UUID;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.RestController;

import br.com.autorizador.vr.miniautorizador.cartao.application.service.CartaoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@Log4j2
@RequiredArgsConstructor
public class CartaoController implements CartaoAPI {

	private final CartaoService cartaoService;

	@Override
	public CartaoResponse criaCartao(UUID idCliente, @Valid CartaoRequest cartaoRequest) {
		log.info("[inicia] CartaoController - criaCartao");
		log.info("[idCliente] {}",idCliente);
		CartaoResponse cartao = cartaoService.criaCartao(idCliente,cartaoRequest);
		log.info("[finaliza] CartaoController - criaCartao");
		return cartao;
	}

}

package br.com.autorizador.vr.miniautorizador.cartao.infra;

import org.springframework.stereotype.Repository;

import br.com.autorizador.vr.miniautorizador.cartao.application.repository.CartaoRepository;
import br.com.autorizador.vr.miniautorizador.cartao.domain.Cartao;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Repository
@Log4j2
@RequiredArgsConstructor
public class CartaoInfraRepository implements CartaoRepository {

	private final CartaoInfraJpaRepository cartaoInfraJpaRepository;
	@Override
	public Cartao salvaCartao(Cartao cartao) {
		log.info("[inicia] CartaoInfraRepository - salvaCartao");
		cartaoInfraJpaRepository.save(cartao);
		log.info("[finaliza] CartaoInfraRepository - salvaCartao");
		return cartao;
	}
	@Override
	public Cartao buscaCartaoPorNumero(String numeroCartao) {
		log.info("[inicia] CartaoInfraRepository - buscaCartaoPorNumero");
		Cartao cartao = cartaoInfraJpaRepository.findByNumeroCartao(numeroCartao);
		log.info("[finaliza] CartaoInfraRepository - buscaCartaoPorNumero");
		return cartao;
	}

}

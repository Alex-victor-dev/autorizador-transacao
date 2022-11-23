package br.com.autorizador.vr.miniautorizador.cartao.application.repository;

import br.com.autorizador.vr.miniautorizador.cartao.domain.Cartao;
import br.com.autorizador.vr.miniautorizador.cartao.domain.Transacao;

public interface CartaoRepository {

	Cartao salvaCartao(Cartao cartao);

	Cartao buscaCartaoPorNumero(String numeroCartao);

	Transacao salvaTransacao(Transacao transacao);

}

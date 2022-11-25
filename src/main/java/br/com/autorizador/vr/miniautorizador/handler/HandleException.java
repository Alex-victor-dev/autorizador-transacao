package br.com.autorizador.vr.miniautorizador.handler;

import org.springframework.stereotype.Component;

import br.com.autorizador.vr.miniautorizador.cartao.domain.Validacao;

@Component
public class HandleException {

	public Object throwExcecaoDeValidacao(Validacao erro) {
		switch (erro) {
		case SALDO_INSUFICIENTE:
			throw new InsuficienteException();
		default:
			return null;
		}
	}
}

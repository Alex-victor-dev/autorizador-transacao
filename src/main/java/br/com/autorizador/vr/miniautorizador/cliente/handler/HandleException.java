package br.com.autorizador.vr.miniautorizador.cliente.handler;

import org.springframework.stereotype.Component;

import br.com.autorizador.vr.miniautorizador.cartao.domain.Validacao;

@Component
public class HandleException {

	public Object throwExcecaoDeValidacao(Validacao erro) {
		switch (erro) {
		case SENHA_INVALIDA:
			throw new SenhaInvalidaException();
		case SALDO_INSUFICIENTE:
			throw new InsuficienteException();
		case CARTAO_INEXISTENTE:
			throw new InexistenteException();
		default:
			return null;
		}
	}
}

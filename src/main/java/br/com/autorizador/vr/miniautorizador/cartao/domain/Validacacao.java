package br.com.autorizador.vr.miniautorizador.cartao.domain;

public enum Validacacao {

	SALDO_INSUFICIENTE {
		@Override
		public String MensagemErro() {
			return "SALDO_INSUFICIENTE";
		}
	},
	SENHA_INVALIDA {
		@Override
		public String MensagemErro() {
			return "SENHA_INVALIDA";
		}
	},
	CARTAO_INEXISTENTE {
		@Override
		public String MensagemErro() {
			return "CARTAO_INEXISTENTE";
		}
	};

	public abstract String MensagemErro();

}

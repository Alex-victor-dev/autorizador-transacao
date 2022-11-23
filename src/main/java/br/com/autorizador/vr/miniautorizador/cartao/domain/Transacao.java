package br.com.autorizador.vr.miniautorizador.cartao.domain;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.Valid;

import br.com.autorizador.vr.miniautorizador.cartao.application.api.TransacaoRequest;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "transacao")
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Transacao {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(columnDefinition = "uuid", name = "idTransacao", updatable = false, unique = true, nullable = false)
	private UUID idTransacao;
	private StatusCompra statusCompra;
	private Double valorCompra;
	private String numeroCartao;
	private String senha;
	private Double limiteCartao;

	public Transacao(@Valid TransacaoRequest transacaoRequest) {
		this.valorCompra = transacaoRequest.getValorCompra();
		this.limiteCartao = transacaoRequest.getLimiteCartao();
	}

}

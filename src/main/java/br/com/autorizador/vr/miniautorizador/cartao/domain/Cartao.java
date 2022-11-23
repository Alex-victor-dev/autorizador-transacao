package br.com.autorizador.vr.miniautorizador.cartao.domain;

import java.time.LocalDate;
import java.util.Random;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.autorizador.vr.miniautorizador.cartao.application.api.CartaoRequest;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "cartao")
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Cartao {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(columnDefinition = "uuid", name = "idCartao", updatable = false, unique = true, nullable = false)
	private UUID idCartao;
	@NotNull
	@Column(columnDefinition = "uuid", name = "idCartaoCliente", nullable = false)
	private UUID idCartaoCliente;
	@NotNull
	private String numeroCartao;
	@NotNull
	@Size(max = 4)
	private String senha;
	private Double limiteCartao;
	private LocalDate validadeCartao;
	private LocalDate dataHoraCriacaoCartao;

	public Cartao(UUID idCliente, @Valid CartaoRequest cartaoRequest) {
		this.idCartaoCliente = idCliente;
		this.numeroCartao = gerarDigitosAleatorios(16);
		this.senha = cartaoRequest.getSenha();
		this.limiteCartao = 500.0;
		this.validadeCartao = LocalDate.now().plusYears(3).plusMonths(5);
		this.dataHoraCriacaoCartao = LocalDate.now();
	}

	private String gerarDigitosAleatorios(int digitos) {
		StringBuilder text = new StringBuilder();
		Random random = new Random();
		for (int i = 0; i < digitos; i++) {
			text.append(random.nextInt(10));
		}
		return text.toString();
	}

}

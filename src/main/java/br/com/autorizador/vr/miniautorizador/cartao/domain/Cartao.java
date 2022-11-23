package br.com.autorizador.vr.miniautorizador.cartao.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Cartao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private UUID idCartao;
	private UUID idCartaoCliente;
	private String numeroCartao;
	@NotNull
	@Size(max = 4)
	private String senha;
	private Double limiteCartao;
	private LocalDate validadeCartao;
	private LocalDateTime dataHoraCriacaoCartao;

}

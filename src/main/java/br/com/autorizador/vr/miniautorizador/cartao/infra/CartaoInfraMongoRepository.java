package br.com.autorizador.vr.miniautorizador.cartao.infra;

import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.autorizador.vr.miniautorizador.cartao.domain.Cartao;

public interface CartaoInfraMongoRepository extends MongoRepository<Cartao, UUID> {

	Cartao findByNumeroCartao(String numeroCartao);
}

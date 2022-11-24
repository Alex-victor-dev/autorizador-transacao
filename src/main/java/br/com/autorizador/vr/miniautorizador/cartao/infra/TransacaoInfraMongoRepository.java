package br.com.autorizador.vr.miniautorizador.cartao.infra;

import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.autorizador.vr.miniautorizador.cartao.domain.Transacao;

public interface TransacaoInfraMongoRepository extends MongoRepository<Transacao, UUID>{

}

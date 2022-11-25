package br.com.autorizador.vr.miniautorizador.cliente.infra;

import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.autorizador.vr.miniautorizador.cliente.domain.Cliente;

public interface ClienteInfraMongoRepository extends MongoRepository<Cliente, UUID>{

}

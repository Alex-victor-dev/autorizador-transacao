package br.com.autorizador.vr.miniautorizador.cliente.infra;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.autorizador.vr.miniautorizador.cliente.domain.Cliente;

public interface ClienteInfraJpaRepository extends JpaRepository<Cliente, UUID>{

}

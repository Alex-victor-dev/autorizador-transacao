package br.com.autorizador.vr.miniautorizador.cartao.infra;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.autorizador.vr.miniautorizador.cartao.domain.Cartao;

public interface CartaoInfraJpaRepository extends JpaRepository<Cartao, UUID> {

}

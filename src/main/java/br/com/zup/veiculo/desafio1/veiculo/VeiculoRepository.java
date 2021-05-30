package br.com.zup.veiculo.desafio1.veiculo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VeiculoRepository extends CrudRepository<Veiculo, Long> {

    List<Veiculo> findByUsuarioId(Long id);
}

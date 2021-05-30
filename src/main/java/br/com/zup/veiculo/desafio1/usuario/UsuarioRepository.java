package br.com.zup.veiculo.desafio1.usuario;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario,Long> {

    Optional<Usuario> findByCpfOrEmail(String cpf, String email);
}

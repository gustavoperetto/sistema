package soft.com.peretto.projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import soft.com.peretto.projeto.entity.UsuarioEntity;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity,Long> {

    Optional<UsuarioEntity> findByLogin(String login);

}

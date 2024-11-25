package soft.com.peretto.projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import soft.com.peretto.projeto.entity.UsuarioVerificadorEntity;

import java.util.Optional;
import java.util.UUID;

public interface UsuarioVerificadorRepository extends JpaRepository<UsuarioVerificadorEntity,Long> {

    public Optional<UsuarioVerificadorEntity> findByUuid(UUID uuid);
}

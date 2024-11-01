package soft.com.peretto.projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import soft.com.peretto.projeto.entity.UsuarioEntity;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity,Long> {

}

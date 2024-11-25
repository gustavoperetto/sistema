package soft.com.peretto.projeto.entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "TTO_USUARIO_VERIFICADOR")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class UsuarioVerificadorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private UUID uuid;

    @Column(nullable = false)
    private Instant dataExpiracao;

    @ManyToOne
    @JoinColumn(name = "ID_USUARIO", referencedColumnName = "ID", unique = true)
    private UsuarioEntity usuario;
}

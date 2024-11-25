package soft.com.peretto.projeto.entity;

import jakarta.persistence.*;
import org.springframework.beans.BeanUtils;
import soft.com.peretto.projeto.dto.RecursoDTO;
import soft.com.peretto.projeto.entity.enums.TipoSituacaoUsuario;

import java.util.Objects;

@Entity
@Table(name = "TTO_RECURSO")
public class RecursoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String chave;

    public RecursoEntity(RecursoDTO recurso) {
        BeanUtils.copyProperties(recurso, this);
    }

    public RecursoEntity() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getChave() {
        return chave;
    }

    public void setChave(String chave) {
        this.chave = chave;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        RecursoEntity that = (RecursoEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}

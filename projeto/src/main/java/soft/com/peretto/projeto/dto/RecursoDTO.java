package soft.com.peretto.projeto.dto;

import org.springframework.beans.BeanUtils;
import soft.com.peretto.projeto.entity.RecursoEntity;

import java.util.Objects;

public class RecursoDTO {

    private Long id;
    private String nome;
    private String chave;

    public RecursoDTO() {

    }

    public RecursoDTO(RecursoEntity recurso) {
        BeanUtils.copyProperties(recurso, this);
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
        RecursoDTO that = (RecursoDTO) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}

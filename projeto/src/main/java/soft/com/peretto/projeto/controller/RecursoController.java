package soft.com.peretto.projeto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import soft.com.peretto.projeto.dto.RecursoDTO;
import soft.com.peretto.projeto.service.RecursoService;

import java.util.List;

@RestController
@RequestMapping(value = "/recurso")
@CrossOrigin
public class RecursoController {

    @Autowired
    private RecursoService recursoService;

    @GetMapping
    public List<RecursoDTO> listarTodos() {
        return recursoService.listarTodos();
    }

    @PostMapping
    public void inserir(@RequestBody RecursoDTO recurso) {
        recursoService.inserir(recurso);
    }

    @PutMapping
    public RecursoDTO alterar(@RequestBody RecursoDTO recurso) {
        return recursoService.alterar(recurso);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable("id") Long id) {
        recursoService.excluir(id);
        return ResponseEntity.ok().build();
    }
}

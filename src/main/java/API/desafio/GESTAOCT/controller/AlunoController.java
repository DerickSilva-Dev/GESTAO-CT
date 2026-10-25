package API.desafio.GESTAOCT.controller;


import API.desafio.GESTAOCT.dto.AlunoRequestDTO;
import API.desafio.GESTAOCT.dto.AlunoResponseDTO;
import API.desafio.GESTAOCT.model.Aluno;
import API.desafio.GESTAOCT.service.AlunoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Aluno")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    @PostMapping("/cadastro")
    public ResponseEntity<Void> cadastrar(@Valid @RequestBody AlunoRequestDTO request) {

        Aluno aluno = new Aluno();
        aluno.setNome(request.getNome());
        aluno.setModalidade(request.getModalidade());
        aluno.setGraduacao(request.getGraduacao());
        aluno.setAtivo(request.isAtivo());

        alunoService.adicionarAluno(aluno);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/listar")
    public ResponseEntity<List<AlunoResponseDTO>> listar() {

        List<AlunoResponseDTO> response = alunoService.buscarTodosAlunos();

        return ResponseEntity.ok(response);
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<AlunoResponseDTO> buscarPorId(@PathVariable Long id) {

        AlunoResponseDTO response = alunoService.buscarAluno(id);

        if (response != null) {
            return ResponseEntity.ok(response);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/listar/modalidade/{modalidade}")
    public ResponseEntity<List<AlunoResponseDTO>> buscarPorModalidade(@PathVariable String modalidade) {

        List <AlunoResponseDTO> response = alunoService.buscarPorModalidade(modalidade);

        if (!response.isEmpty()) {
            return ResponseEntity.ok(response);
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/alterar/{id}")
    public ResponseEntity<AlunoResponseDTO> alterar(@Valid @RequestBody AlunoRequestDTO request, @PathVariable Long id) {

        Aluno alunoAlterado = alunoService.alterar(id, request);

        if (alunoAlterado == null) {
            return ResponseEntity.notFound().build();
        }

        AlunoResponseDTO response = new  AlunoResponseDTO(
                alunoAlterado.getNome(),
                alunoAlterado.getModalidade(),
                alunoAlterado.getGraduacao(),
                alunoAlterado.isAtivo()
        );

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {

        boolean foiExcluido = alunoService.remover(id);

        if (foiExcluido) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }

}

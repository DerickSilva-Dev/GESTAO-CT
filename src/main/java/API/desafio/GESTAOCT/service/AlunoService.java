package API.desafio.GESTAOCT.service;

import API.desafio.GESTAOCT.dto.AlunoRequestDTO;
import API.desafio.GESTAOCT.dto.AlunoResponseDTO;
import API.desafio.GESTAOCT.model.Aluno;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Service
public class AlunoService {

    private final Map<Long, Aluno> alunos = new ConcurrentHashMap<>();
    private AtomicLong idAtual = new AtomicLong(1L);

    public void adicionarAluno(Aluno aluno) {
        aluno.setId(idAtual.getAndIncrement());
        alunos.put(aluno.getId(), aluno);
    }

    public AlunoResponseDTO buscarAluno(Long idAluno) {
        Aluno aluno = alunos.get(idAluno);

        if (aluno == null) {
            return null;
        }
        return new AlunoResponseDTO(
                aluno.getNome(),
                aluno.getModalidade(),
                aluno.getGraduacao(),
                aluno.isAtivo()
        );
    }

    public List<AlunoResponseDTO> buscarPorModalidade(String modalidade) {

        return alunos.values().stream()
                .filter(aluno -> aluno.getModalidade().equalsIgnoreCase(modalidade))
                .map(aluno -> new AlunoResponseDTO(
                        aluno.getNome(),
                        aluno.getModalidade(),
                        aluno.getGraduacao(),
                        aluno.isAtivo()
                ))
                .collect(Collectors.toList());
    }

    public List<AlunoResponseDTO> buscarTodosAlunos() {

        return alunos.values().stream()
                .map(aluno -> new AlunoResponseDTO(
                        aluno.getNome(),
                        aluno.getModalidade(),
                        aluno.getGraduacao(),
                        aluno.isAtivo()
                )).collect(Collectors.toList());
    }

    public Aluno alterar(Long id, AlunoRequestDTO request) {
        Aluno aluno = alunos.get(id);
        if (aluno == null) {
            return null;
        }

        aluno.setNome(request.getNome());
        aluno.setModalidade(request.getModalidade());
        aluno.setGraduacao(request.getGraduacao());
        aluno.setAtivo(request.isAtivo());

        return aluno;
    }

    public boolean remover(Long id) {
        return alunos.remove(id) != null;
    }
}

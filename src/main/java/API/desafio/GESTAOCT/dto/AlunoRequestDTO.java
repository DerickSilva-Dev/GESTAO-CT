package API.desafio.GESTAOCT.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class AlunoRequestDTO {
    @NotBlank(message = "Nome do aluno é obrigatório!")
    private String nome;
    @NotBlank(message = "Modalidade do aluno é obrigatória!")
    private String modalidade;
    @NotBlank(message = "Graduação do aluno é obrigatória!")
    private String graduacao;
    private boolean ativo;
}

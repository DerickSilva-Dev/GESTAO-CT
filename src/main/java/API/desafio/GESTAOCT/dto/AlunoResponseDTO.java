package API.desafio.GESTAOCT.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AlunoResponseDTO {
    private String nome;
    private String modalidade;
    private String graduacao;
    private boolean ativo;
}
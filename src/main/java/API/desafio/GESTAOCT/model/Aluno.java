package API.desafio.GESTAOCT.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Aluno {
    private Long id;
    private String nome;
    private String modalidade;
    private String graduacao;
    private boolean ativo;
}

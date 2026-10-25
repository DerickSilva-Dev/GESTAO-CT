# Gestão CT - API para Centro de Treinamento

Uma API RESTful desenvolvida em Java com Spring Boot para o gerenciamento de alunos em um centro de treinamento de artes marciais. O projeto implementa um banco de dados em memória *thread-safe*, garantindo consistência de dados e prevenção de falhas em cenários de alta concorrência.

## Tecnologias e Práticas Utilizadas
*   **Java 17 & Spring Boot 3:** Base do ecossistema backend.
*   **Lombok:** Redução de código boilerplate.
*   **Jakarta Validation:** Validação rigorosa dos dados de entrada (DTOs).
*   **ConcurrentHashMap & AtomicLong:** Gerenciamento de estado em memória com proteção nativa contra colisões em requisições simultâneas.
*   **Java Stream API:** Lógica de filtragem avançada de coleções no *Service*.
*   **Arquitetura em Camadas:** Separação estrutural entre `Controller`, `Service`, `Model` e `DTO`.

## Endpoints da API

O caminho base para todas as requisições é `http://localhost:8080/Aluno`.

### 1. Cadastrar Aluno
*   **Método:** `POST /cadastro`
*   **Corpo da Requisição (JSON):**
```json
{
  "nome": "João Silva",
  "modalidade": "Pencak Silat",
  "graduacao": "Iniciante",
  "ativo": true
}
```
*   **Retorno:** `201 Created`

### 2. Listar Todos os Alunos
*   **Método:** `GET /listar`
*   **Retorno:** `200 OK` (Lista de Alunos)

### 3. Buscar Aluno por ID
*   **Método:** `GET /listar/{id}`
*   **Retorno:** `200 OK` ou `404 Not Found`

### 4. Buscar Alunos por Modalidade
*   **Método:** `GET /listar/modalidade/{modalidade}`
*   **Exemplo:** `/listar/modalidade/Jiu-Jitsu`
*   **Retorno:** `200 OK` (Lista filtrada) ou `404 Not Found`

### 5. Alterar Aluno
*   **Método:** `PUT /alterar/{id}`
*   **Corpo da Requisição (JSON):**
```json
{
  "nome": "João Silva",
  "modalidade": "Pencak Silat",
  "graduacao": "Intermediário",
  "ativo": true
}
```
*   **Retorno:** `200 OK` (Retorna o JSON do aluno atualizado) ou `404 Not Found`

### 6. Excluir Aluno
*   **Método:** `DELETE /excluir/{id}`
*   **Retorno:** `204 No Content` ou `404 Not Found`

## ⚙️ Como Executar o Projeto

1. Clone o repositório em seu ambiente local:
   ```bash
   git clone [https://github.com/SEU-USUARIO/NOME-DO-REPOSITORIO.git](https://github.com/DerickSilva-Dev/GESTAO-CT.git)
   ```
2. Abra o projeto na sua IDE (IntelliJ IDEA, Eclipse, etc.).
3. Certifique-se de que o **JDK 17** está configurado como SDK do projeto e no Language Level.
4. Execute o download das dependências do Maven (Sync/Reload).
5. Inicie o servidor executando a classe `GestaoctApplication`.
6. Utilize um *API Client* como Postman ou Insomnia para realizar as requisições na porta `8080`.

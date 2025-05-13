# 📚 Cadastro de Alunos

Projeto desenvolvido em Java 17 com Spring Boot, com o objetivo de gerenciar o cadastro de alunos. A aplicação oferece uma API RESTful documentada com SpringDoc (OpenAPI 3).

## 🔧 Tecnologias utilizadas

- Java 17
- Spring Boot
- Spring Web
- SpringDoc OpenAPI (Swagger)
- Maven

## 📌 Funcionalidades

- ✅ Cadastrar um novo aluno
- ✅ Listar todos os alunos
- ✅ Buscar aluno por ID
- ✅ Buscar aluno por Nome
- ✅ Buscar aluno por Idade
- ✅ Atualizar dados de um aluno
- ✅ Deletar um aluno
- ✅ Documentação automática com Swagger UI

## 📄 Estrutura do projeto

```
src
└── main
└── java
└── com.mentorama.cadastroaluno
├── exception
│ ├── AlunoNotFoundException.java
│ └── GlobalExceptionHandler.java
├── service
│ └── AlunoService.java
├── Aluno.java
├── CadastroAlunoApplication.java
├── CadastroAlunoController.java
└── ServletInitializer.java
```

---

## ✅ Funcionalidades

- ✅ Cadastro de alunos  
- ✅ Listagem de alunos com filtro por nome e idade  
- ✅ Busca de aluno por ID  
- ✅ Atualização de dados de aluno  
- ✅ Remoção de aluno  

---

## 🔗 Endpoints

| Método HTTP | Endpoint        | Descrição                              |
|-------------|------------------|----------------------------------------|
| `POST`      | `/aluno`         | Adiciona um novo aluno                 |
| `GET`       | `/aluno`         | Lista todos os alunos (com filtros)    |
| `GET`       | `/aluno/{id}`    | Busca um aluno específico pelo ID      |
| `PUT`       | `/aluno/{id}`    | Atualiza os dados de um aluno existente|
| `DELETE`    | `/aluno/{id}`    | Remove um aluno do sistema             |

---

## 🛠️ Implementações

### Refatoração

- Separação da lógica de negócio na camada `AlunoService`.
- A controller (`CadastroAlunoController`) tornou-se responsável apenas por lidar com as requisições HTTP.
- Aplicação do padrão de arquitetura em camadas: **Controller → Service**.

### Tratamento de Exceções

- Exceção personalizada: `AlunoNotFoundException`, para casos de aluno não encontrado.
- Manipulador global: `GlobalExceptionHandler`, responsável por centralizar o tratamento de erros.
- Respostas com **HTTP 404** e mensagens informativas em casos apropriados.

---

## ▶️ Como executar

1. Clone o repositório:
```bash
git clone https://github.com/LuisHenriqueSantos/Cad-Aluno.git
```
2. Execute o projeto
```bash
cd cadastro-aluno
```
3. Execute a Class de inicialização

# 🌐 Acessando a API
Após subir a aplicação, acesse:
- Documentação: [Acesse a documentação aqui](http://localhost:8080/v3/api-docs)

# 🧑‍💻 Autor
- Desenvolvido por **Luis Henrique Santos**


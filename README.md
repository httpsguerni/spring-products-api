# Products API - Java + Spring Boot + PostgreSQL

[Português](#portugues) | [English](#english)

---


API RESTful para gerenciamento de produtos desenvolvida com Java e Spring Boot, seguindo boas práticas de desenvolvimento backend. O projeto demonstra proficiência em arquitetura em camadas, integração com banco de dados, tratamento de erros e validação de dados.

### Tecnologias

| Tecnologia | Versão |
|---|---|
| Java | 17 |
| Spring Boot | 4.0.6 |
| Spring Data JPA | 4.0.5 |
| Hibernate | 7.2.12 |
| PostgreSQL | 18.3 |
| Maven | 3.x |

### Arquitetura

O projeto segue o padrão de **arquitetura em camadas**, separando as responsabilidades em camadas distintas:

```
Controller  ->  Service  ->  Repository  ->  Banco de Dados
     |               |             |
  API REST       Regras de      Acesso a
  (HTTP)          Negócio         Dados
```

```
src/
└── main/
    ├── java/com/example/demo/
    │   ├── controller/        # Endpoints REST
    │   ├── service/           # Regras de negócio
    │   ├── repository/        # Acesso a dados (JPA)
    │   ├── model/             # Entidades
    │   └── exception/         # Tratamento de erros
    └── resources/
        └── application.properties
```

### Endpoints

| Método | Endpoint | Descrição |
|---|---|---|
| `GET` | `/produtos` | Lista todos os produtos |
| `GET` | `/produtos/{id}` | Busca produto por ID |
| `POST` | `/produtos` | Cria novo produto |
| `PUT` | `/produtos/{id}` | Atualiza produto |
| `DELETE` | `/produtos/{id}` | Remove produto |

### Exemplo de requisição - POST /produtos

```json
{
    "nome": "Notebook",
    "preco": 3500.00
}
```

### Exemplo de resposta - 200 OK

```json
{
    "id": 1,
    "nome": "Notebook",
    "preco": 3500.00
}
```

### Respostas de erro

400 Bad Request:
```json
{
    "nome": "Nome é obrigatório"
}
```

404 Not Found:
```json
{
    "erro": "Produto não encontrado com id: 99"
}
```

### Como rodar localmente

**Pré-requisitos:** Java 17+, PostgreSQL, Maven

```bash
# 1. Clone o repositório
git clone https://github.com/httpsguerni/spring-products-api.git
cd products-api

# 2. Crie o banco de dados
psql -U postgres -c "CREATE DATABASE loja_db;"

# 3. Configure o application.properties
spring.datasource.url=jdbc:postgresql://localhost:5432/loja_db
spring.datasource.username=postgres
spring.datasource.password=sua_senha
spring.jpa.hibernate.ddl-auto=update

# 4. Execute
./mvnw spring-boot:run
```

A API estará disponível em `http://localhost:8080`

### Conceitos aplicados

- **Arquitetura em camadas** - Controller, Service, Repository, Model
- **Design RESTful** - uso correto de verbos HTTP e status codes
- **JPA/Hibernate** - criação automática de tabelas e mapeamento ORM
- **Tratamento global de erros** - `@RestControllerAdvice` retornando status HTTP corretos
- **Validação de dados** - `@Valid`, `@NotBlank`, `@Positive` com mensagens de erro claras
- **Injeção de dependência** - `@Autowired` e container IoC do Spring

---


RESTful API for product management built with Java and Spring Boot, following industry best practices for backend development. This project demonstrates proficiency in layered architecture, database integration, error handling, and input validation.

### Technologies

| Technology | Version |
|---|---|
| Java | 17 |
| Spring Boot | 4.0.6 |
| Spring Data JPA | 4.0.5 |
| Hibernate | 7.2.12 |
| PostgreSQL | 18.3 |
| Maven | 3.x |

### Architecture

The project follows a **layered architecture** pattern, separating responsibilities across distinct layers:

```
Controller  ->  Service  ->  Repository  ->  Database
     |               |             |
  REST API       Business        Data
  (HTTP)           Logic         Access
```

### Endpoints

| Method | Endpoint | Description |
|---|---|---|
| `GET` | `/produtos` | List all products |
| `GET` | `/produtos/{id}` | Get product by ID |
| `POST` | `/produtos` | Create new product |
| `PUT` | `/produtos/{id}` | Update product |
| `DELETE` | `/produtos/{id}` | Delete product |

### Request example - POST /produtos

```json
{
    "nome": "Notebook",
    "preco": 3500.00
}
```

### Response example - 200 OK

```json
{
    "id": 1,
    "nome": "Notebook",
    "preco": 3500.00
}
```

### Error responses

400 Bad Request:
```json
{
    "nome": "Nome é obrigatório"
}
```

404 Not Found:
```json
{
    "erro": "Produto não encontrado com id: 99"
}
```

### How to run locally

**Prerequisites:** Java 17+, PostgreSQL, Maven

```bash
# 1. Clone the repository
git clone https://github.com/httpsguerni/spring-products-api.git
cd products-api

# 2. Create the database
psql -U postgres -c "CREATE DATABASE loja_db;"

# 3. Configure application.properties
spring.datasource.url=jdbc:postgresql://localhost:5432/loja_db
spring.datasource.username=postgres
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update

# 4. Run
./mvnw spring-boot:run
```

The API will be available at `http://localhost:8080`

### Key concepts applied

- **Layered architecture** - Controller, Service, Repository, Model
- **RESTful design** - correct use of HTTP methods and status codes
- **JPA/Hibernate** - automatic table creation and ORM mapping
- **Global error handling** - `@RestControllerAdvice` returning proper HTTP status codes
- **Input validation** - `@Valid`, `@NotBlank`, `@Positive` with meaningful error messages
- **Dependency Injection** - `@Autowired` and Spring IoC container

---


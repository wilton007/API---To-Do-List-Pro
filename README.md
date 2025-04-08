# API---To-Do-List-Pro

📘 Documentação da API – To-Do List Pro
🧾 Descrição do Projeto
A To-Do List Pro API é uma aplicação backend desenvolvida com Java + Spring Boot com o objetivo de gerenciar tarefas pessoais. A API permite o cadastro de usuários, autenticação via JWT e operações completas de CRUD (Criar, Ler, Atualizar, Deletar) em tarefas associadas a cada usuário.

🛠️ Tecnologias Utilizadas
Java 21+

Spring Boot

Spring Data JPA (Hibernate)

Spring Security (com JWT)

MySQL 

Maven

Swagger (Springdoc OpenAPI)

JUnit + Mockito


## 📂 Estrutura das Entidades

### 📌 Usuário

| Campo     | Tipo   | Descrição              |
|-----------|--------|-------------------------|
| id        | Long   | Identificador único     |
| nome      | String | Nome do usuário         |
| email     | String | Email único             |
| senha     | String | Senha criptografada     |



### ✅ Tarefa

| Campo       | Tipo       | Descrição                     |
|-------------|------------|-------------------------------|
| id          | Long       | Identificador único           |
| titulo      | String     | Título da tarefa              |
| descricao   | String     | Descrição detalhada           |
| dataLimite  | LocalDate  | Prazo para conclusão          |
| status      | Enum       | Status: PENDENTE, CONCLUIDA   |
| usuario     | Usuario    | Referência ao dono da tarefa  |


 Autenticação e Segurança
A autenticação é baseada em JWT. O token deve ser enviado no cabeçalho de cada requisição protegida:

makefile
Copy
Edit
Authorization: Bearer <token>

#### 👤 Usuário

| Método | Endpoint              | Descrição                         | Autenticação |
|--------|------------------------|-----------------------------------|--------------|
| POST   | /api/usuarios          | Criar novo usuário                | ❌           |
| POST   | /api/auth/login        | Autenticar usuário e gerar JWT    | ❌           |
| GET    | /api/usuarios/me       | Ver dados do usuário logado       | ✅           |
| PUT    | /api/usuarios/me       | Atualizar dados pessoais          | ✅           |
| DELETE | /api/usuarios/me       | Deletar conta do usuário          | ✅           |


#### ✅ Tarefas

| Método | Endpoint                          | Descrição                   | Autenticação |
|--------|-----------------------------------|-----------------------------|--------------|
| POST   | /api/tarefas                      | Criar nova tarefa           | ✅           |
| GET    | /api/tarefas                      | Listar tarefas do usuário   | ✅           |
| GET    | /api/tarefas/{id}                 | Obter uma tarefa específica | ✅           |
| PUT    | /api/tarefas/{id}                 | Atualizar tarefa            | ✅           |
| PATCH  | /api/tarefas/{id}/concluir        | Marcar como concluída       | ✅           |
| DELETE | /api/tarefas/{id}                 | Deletar tarefa              | ✅           |


🗄️ Estrutura do Banco de Dados


#### 🔹 Tabela `usuarios`

| Coluna | Tipo SQL      | Restrições                     |
|--------|---------------|--------------------------------|
| id     | BIGINT        | PRIMARY KEY, AUTO_INCREMENT    |
| nome   | VARCHAR(100)  | NOT NULL                       |
| email  | VARCHAR(100)  | NOT NULL, UNIQUE               |
| senha  | VARCHAR(255)  | NOT NULL                       |

#### 🔹 Tabela `tarefas`

| Coluna      | Tipo SQL      | Restrições                                 |
|-------------|---------------|---------------------------------------------|
| id          | BIGINT        | PRIMARY KEY, AUTO_INCREMENT                |
| titulo      | VARCHAR(150)  | NOT NULL                                   |
| descricao   | TEXT          |                                             |
| data_limite | DATE          |                                             |
| status      | VARCHAR(20)   | NOT NULL (Ex: "PENDENTE", "CONCLUIDA")     |
| usuario_id  | BIGINT        | FOREIGN KEY → usuarios(id)                 |


Relacionamento
Um Usuário pode ter várias Tarefas → Relacionamento OneToMany

Cada Tarefa pertence a um único Usuário → Relacionamento ManyToOne


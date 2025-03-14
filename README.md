# Microsserviço BFF (Backend For Frontend)

Este microsserviço, desenvolvido em Java com Spring Boot e **Maven**, atua como um Backend For Frontend (BFF) para agregar e orquestrar as funcionalidades dos microsserviços de usuários, tarefas e notificações. Ele fornece uma API simplificada e otimizada para os clientes front-end, centralizando a lógica de negócio e reduzindo a complexidade do lado do cliente.

## Tecnologias Utilizadas

* **Java:** Linguagem de programação principal.
* **Maven:** Sistema de build automatizado.
* **Spring Boot:** Framework para desenvolvimento rápido de aplicações Java.
* **Spring Web:** Para criação de APIs REST.
* **Spring Security:** Framework para segurança de aplicações.
* **JWT (JSON Web Tokens):** Para autenticação e autorização.
* **Feign Client:** Para comunicação com os outros microsserviços.
* **Swagger/OpenAPI:** Para documentação da API.

## Pré-requisitos

* Java JDK 17 ou superior.
* Maven 3.6 ou superior.
* Os microsserviços de usuários, tarefas e notificações devem estar em execução.

## Endpoints da API

### Usuários

* **`POST /usuario`**: Cadastra um novo usuário.
* **`POST /usuario/login`**: Autentica um usuário e retorna um token JWT.
* **`GET /usuario?email={email}`**: Busca um usuário por email.
* **`DELETE /usuario/{email}`**: Deleta um usuário por email.
* **`PUT /usuario`**: Atualiza dados de um usuário.
* **`PUT /usuario/endereco?id={id}`**: Atualiza um endereço.
* **`PUT /usuario/telefone?id={id}`**: Atualiza um telefone.
* **`POST /usuario/endereco`**: Cadastra um endereço para um usuário.
* **`POST /usuario/telefone`**: Cadastra um telefone para um usuário.
* **`GET /usuario/endereco/{cep}`**: Busca dados de endereço por CEP utilizando ViaCEP.

### Tarefas

* **`POST /tarefas`**: Grava uma nova tarefa.
* **`GET /tarefas/eventos`**: Busca uma lista de tarefas por período.
* **`GET /tarefas`**: Busca tarefas por email do usuário autenticado.
* **`DELETE /tarefas`**: Deleta uma tarefa por ID.
* **`PATCH /tarefas`**: Altera o status de notificação de uma tarefa.
* **`PUT /tarefas`**: Atualiza uma tarefa por ID.

### Notificações

* As notificações são enviadas automaticamente pelo microsserviço de tarefas quando necessário, através do microsserviço de notificação.

## Segurança

* A API utiliza JWT para autenticação e autorização.
* Os endpoints protegidos requerem um token JWT válido no cabeçalho `Authorization`.

## Documentação da API

* A documentação da API pode ser acessada através do Swagger UI em `/swagger-ui/index.html` após a execução da aplicação.

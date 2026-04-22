# 📦 Sistema de Gestão - Backend

API REST desenvolvida com **Java + Spring Boot** para gerenciamento de **Produtos e Fornecedores**, utilizando arquitetura em camadas (Controller, Service, Repository, DTO).

---

## 🚀 Tecnologias utilizadas

- ☕ Java 21
- 🌱 Spring Boot
- 🗄️ Spring Data JPA
- 🐘 PostgreSQL
- 🔄 Maven
- 🔍 Hibernate

---

## 📁 Estrutura do Projeto

```
sistema-gestao
│
├── controller
├── service
├── repository
├── model
├── dto
├── mapper
├── enums
└── resources
```

---

## 📌 Funcionalidades

### 👤 Fornecedor
- Criar fornecedor
- Buscar fornecedor por ID
- Listar fornecedores
- Atualizar fornecedor
- Deletar fornecedor

### 📦 Produto
- Criar produto vinculado a fornecedor
- Listar produtos
- Buscar produto por ID
- Atualizar produto
- Deletar produto

---

## ⚙️ Configuração

### Banco de Dados

```sql
CREATE DATABASE bd_sistema_gestao;
```

### application.properties

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/bd_sistema_gestao
spring.datasource.username=postgres
spring.datasource.password=123
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

---

## ▶️ Como executar

```bash
mvn clean install
mvn spring-boot:run
```

---

## 🌐 Acesso

http://localhost:8080

---

## 📬 Exemplo de Payload

```json
{
  "nome": "Produto Teste",
  "preco": 100.00,
  "categoria": "ELETRONICOS",
  "fornecedorId": 1
}
```

---

## 📚 Melhorias futuras

- JWT Authentication
- Swagger
- Testes
- Paginação

---

## 👨‍💻 Autor

Projeto para fins de estudo com Spring Boot.

## 🚧 Status do Projeto

Este projeto está em fase de desenvolvimento ativo e pode sofrer alterações frequentes.
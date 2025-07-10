**API de Gerenciamento Universitário**

**📝 Descrição do Projeto**
Este projeto consiste em uma API RESTful desenvolvida em Spring Boot como parte de uma atividade de fixação de conhecimento. O objetivo é criar um sistema de gerenciamento para uma universidade, permitindo o controle de professores, estudantes, cursos, escritórios e matrículas. A aplicação foi desenhada para ser robusta, escalável e seguir as melhores práticas de desenvolvimento de APIs.

**✔️ Requisitos Atendidos**
O projeto foi desenvolvido para atender a uma lista específica de requisitos técnicos, demonstrando proficiência em diversas áreas do ecossistema Spring:

**CRUD Completo:** Operações de Criar, Ler, Atualizar e Excluir para todas as 5 entidades do sistema.

**Relacionamentos JPA:** Implementação de todos os tipos de mapeamento:

**@OneToOne:** Entre Professor e Escritorio.

**@OneToMany / @ManyToOne:** Entre Estudante/Curso e Incrição.

**@ManyToMany:** Relação entre Student e Course gerenciada pela entidade de junção Enrollment.

**Tipos de Dados Diversificados:** Uso de String, Long, LocalDateTime, LocalDate, BigDecimal e Enum.

**Chave Composta:** Utilização de @EmbeddedId na entidade Inscrição.

**Tratamento Global de Exceções:** Implementação de um GlobalExceptionHandler com @RestControllerAdvice para retornar respostas de erro padronizadas.

**Padrão DTO (Forms):** Uso de Data Transfer Objects para receber dados nas requisições (/forms) e aplicar validações com jakarta.validation.

**JPA Query Methods:** Demonstração de uma vasta gama de métodos de consulta do Spring Data JPA (findBy, findByBetween, deleteBy, etc.).

**Uso de Streams e Lambdas:** Lógica de negócio implementada com funcionalidades modernas do Java.

**🚀 Tecnologias Utilizadas**
**Linguagem:** Java 21

**Framework:** Spring Boot 3.3.1

**Dependências:**

**Spring Web:** Para a construção de APIs REST.

**Spring Data JPA:** Para persistência de dados.

**Spring Boot DevTools:** Para auto-reload em ambiente de desenvolvimento.

**Validation:** Para validação de DTOs.

**Banco de Dados:** H2 Database (em memória).

**Build Tool:** Maven

**Utilitários:** Lombok

**Endpoints da API**
Abaixo está uma lista dos principais endpoints disponíveis na API.

![Design sem nome](https://github.com/user-attachments/assets/ae5ba5f6-8157-47c2-a10d-b6d918a5e672)


**✒️ Autor**
Projeto desenvolvido como parte de uma atividade de fixação.

Sthefany Aparecida de Souza

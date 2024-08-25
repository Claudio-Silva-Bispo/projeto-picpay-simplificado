# Projeto Java com Spring Boot
Este projeto foi desenvolvido em Java, utilizando Lombok, Spring Boot, JPA e uma API RESTful, 
com base em uma atividade proposta pelo PICPAY. 

O objetivo é demonstrar o conhecimento adquirido e aplicado em Java através da implementação 
de uma solução completa.

No decorrer deste repositório, serão apresentados todos os passos e decisões tomadas durante 
o desenvolvimento do projeto, com o intuito de evidenciar a proficiência em Java e as 
boas práticas adotadas.

***Documentação para demonstrar o que foi feito com base no meu conhecimento e ajuda da documentação***

# Usar o SPRING INITIALIZR para gerar o projeto

    $ https://start.spring.io/

## Dependências utilizadas

1. Spring Web
2. JPA
3. Lombok
4. Dev Tools
5. H2 Database - Dessa vez não será utilizado um comum pois não precisamos ver no banco os dados.
6. Projeto em Maven
7. Versão 17 do Java
8. Swagger para avaliar e criar documentação da API

    ```bash
       <dependency>
           <groupId>org.springdoc</groupId>
           <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
           <version>2.6.0</version>
       </dependency>
    ```

# Criar estrutura do meu projeto

1. Package domain.usuario dentro do main > java
2. Usuario / Model / Entity
2.1. Usuario
2.2. UsuarioTipo
3. Transacao 
3.1. Transacao
4. Repository
4.1. UsuarioRepositorio
4.2. TransacaoRepositorio
5. Service
5.1. UsuarioService
6. Controller
7. Infra
7.1. Usei aqui para criar um Bean específico.

# Conexão com o banco H2

1. No documento application.properties

```bash
   spring.application.name=picpaysimplificado
  
  # conexão com o banco
   spring.datasource.url=jdbc:h2:mem:testedb
   spring.datasource.driver-class-name=org.h2.Driver
   
   # nome do usuário do banco
   spring.datasource.username=claudio
   
   # senha de acesso ao banco
   spring.datasource.password=
   
   # uso do Hibernate
   spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
   
   # Para visualizar no terminal/console
   spring.h2.console.enabled=true
```









# API  (Adiantamento de Despesa de Viagem)

- Essa é uma API Java RESTFul, que foi desenvolvida simulando um cenário onde as organizações/empresas disponibilizam recursos financeiros
  para seus colaboradores viajarem (a trabalho), custeando assim despesas com hotéis, refeições, locomoção, etc.
  Isso possibilita que essas despesas sejam lançadas e armazenadas na base de dados para enventuais auditorias.

## Tecnologias utilizadas

- Java 17
- Git/GitHub
- Spring Boot 3
- Spring Data JPA
- H2
- Postgres
- OpenAPI (Swagger)
- Railway
  
## Diagrama de classe 

```mermaid
classDiagram
    class AdiantamentoDespesaViagem {
        -Long id
        -Integer numero
        -String nomeColaborador
        -String status
        -BigDecimal valor
    }

    class Despesa {
        -Long id
        -Integer numero
        -String descricao
        -BigDecimal valor
        -AdiantamentoDespesaViagem adiantamentoDespesaViagem
    }

 AdiantamentoDespesaViagem "1" *-- "0..*" Despesa

```

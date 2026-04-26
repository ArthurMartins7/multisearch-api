# MultiSearch API (Spring Boot)

API REST desenvolvida com Spring Boot para consulta de dados de múltiplas fontes do domínio (materiais, equipamentos, ordens de compra, ordens de venda e mão de obra), incluindo uma rota de busca consolidada.

## Visão geral do projeto

O backend está na pasta `multisearch/` e segue uma estrutura simples em camadas:

- `controller`: expõe os endpoints HTTP.
- `service`: aplica as regras de negócio.
- `model/repository`: lê os dados (neste projeto, os dados vêm de arquivos JSON no classpath).
- `config`: configurações globais, como CORS.
- `src/main/resources/data`: arquivos JSON usados como fonte de dados.

## Tecnologias utilizadas

- Java 17
- Spring Boot 4
- Maven
- Lombok

## Como rodar localmente

### 1) Pré-requisitos

- Java 17 instalado
- Maven instalado (ou usar o Maven Wrapper, se existir no seu ambiente)

### 2) Executar a API

No diretório `multisearch/`, rode:

```bash
mvn spring-boot:run
```

Por padrão, o profile ativo é `dev`, então:

- A porta será `8080` (ou a porta definida pela variável `PORT`).
- O CORS aceitará requisições de `http://localhost:5173` (frontend local).

### 3) URL base local

Com a API rodando localmente, a base será:

`http://localhost:8080/multisearch`

## URLs do projeto (produção)

- **Frontend (Vercel)**: `https://multisearch-web.vercel.app`
- **Backend (Railway)**: `https://multisearch-api-production.up.railway.app/multisearch`

## Profiles, CORS e porta (local x remoto)

O projeto foi preparado para alternar comportamento automaticamente entre ambiente local e hospedagem remota.

### `application.properties` (configuração base)

- `spring.profiles.active=${SPRING_PROFILES_ACTIVE:dev}`
- `server.port=${PORT:8080}`
- `server.servlet.context-path=/multisearch`

Significa que:

- Se `SPRING_PROFILES_ACTIVE` **não** for definido, o profile padrão será `dev`.
- Em plataformas como Railway, a variável `PORT` é usada automaticamente.

### `application-dev.properties`

- `app.cors.origins=http://localhost:5173`

### `application-prod.properties`

- `app.cors.origins=https://multisearch-web.vercel.app`

### Classe de CORS (`WebConfig`)

A origem permitida é lida da propriedade:

- `@Value("${app.cors.origins}")`

Assim, ao trocar o profile (`dev`/`prod`), a API muda automaticamente a origem liberada no CORS.

## Como acessar remotamente (ex.: Railway + Vercel)

### Backend no Railway

No serviço do Railway, configure:

- `SPRING_PROFILES_ACTIVE=prod`
- `PORT` já é fornecida pelo Railway (normalmente não precisa configurar manualmente)

### Frontend já publicado

O frontend oficial deste projeto está em:

`https://multisearch-web.vercel.app`

No profile de produção, o backend já está configurado para aceitar CORS dessa origem:

- `app.cors.origins=https://multisearch-web.vercel.app`

Resultado: somente esse frontend publicado pode consumir a API em produção.

### Acessar a API publicada

A URL base do backend em produção é:

`https://multisearch-api-production.up.railway.app/multisearch`

## Endpoints disponíveis

Considerando o contexto `/multisearch`:

- `GET /multisearch/material`
- `GET /multisearch/equipment`
- `GET /multisearch/purchaseorder`
- `GET /multisearch/salesorder`
- `GET /multisearch/workforce`
- `GET /multisearch/filter?query=termo`

Exemplo completo local:

`http://localhost:8080/multisearch/filter?query=abc`

## Execução com profile específico

Se quiser forçar profile manualmente local:

```bash
# Windows (PowerShell)
$env:SPRING_PROFILES_ACTIVE="prod"
mvn spring-boot:run
```

```bash
# Linux/macOS
SPRING_PROFILES_ACTIVE=prod mvn spring-boot:run
```

## Fluxo recomendado de uso

1. Rodar o backend local (`dev`).
2. Rodar o frontend em `http://localhost:5173`.
3. Testar integração via endpoints.
4. Validar as chamadas no frontend publicado (`https://multisearch-web.vercel.app`).
5. Usar o backend publicado no Railway (`https://multisearch-api-production.up.railway.app/multisearch`) com profile `prod`.

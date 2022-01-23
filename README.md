<div align="center">
    <h1>Perseverance</h1>
</div>

---

## 🚀 Como executar o projeto

### Pré-requisitos

Antes de começar, você vai precisar ter instalado em sua máquina as seguintes ferramentas:
[Git](https://git-scm.com), [Docker-compose](https://docs.docker.com/compose/install) (Apenas para ambiente de desenvolvimento).

#### 🎲 Rodando

```bash
Ex.:

# Clone este repositório
$ git clone https://github.com/caiaffa/perseverance-java-clean-architecture.git

# Acesse a pasta do projeto no terminal/cmd
$ cd perseverance-java-clean-architecture

# Instale as dependências
$ make build

# Execute a aplicação
$ make run

# O servidor inciará na porta:8080 - acesse http://localhost:8080
```

#### 🎲 API

```bash
Ex.:

# Cria e envia a sonda para a posição inicial.
$ curl --location --request POST 'localhost:8080/v1/probes' --header 'Content-Type: application/json' --data-raw '{
    "name": "mark 1",
    "position": {
        "x": 0,
        "y": 0
    },
    "direction": "N"
}'

# Exibe as coordenadas atuais x e y da sonda.
$ curl --location --request GET 'localhost:8080/v1/probes/1'

# Movimenta a sonda.
$ curl --location --request PATCH 'localhost:8080/v1/probes/move/1' --header 'Content-Type: application/json' --data-raw '{   
    "commands": "MMRMMRMRRM"
}'

# Lista todas as sondas.
$ curl --location --request GET 'localhost:8080/v1/probes/1'

# Deleta uma sonda.
$ curl --location --request DELETE 'localhost:8080/v1/probes/1'

```

## 🛠 Tecnologias

As seguintes ferramentas foram usadas na construção do projeto:

**Back-End**  ([Spring boot](https://spring.io/)  )

> Veja o arquivo pom.xml

---
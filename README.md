# Antonio Ladeia -  Wex PREPAG


A aplicação Wex Prepag é uma API onde é possível emitir cartões de forma simplificada, e autorizar transações financeiras utilizando estes cartões.

## A API:

### Criar Cartão

POST /api/card

Content-Type: application/json

	{
		"name": "Layne Stanley",
		"balance": 300
	}

Endpoint para criar novos Cartões

Response de exemplo

	{
	    "name": "Layne Stanley",
	    "number": "5447318541794326",
	    "validity": "08/21",
	    "password": "8011",
	    "balance": 300,
	    "cvv": "768"
	}

### Criar Autorização

POST /api/authorize

Content-Type: application/json

	{
	    "card": "5447318541794326",
	    "validity": "08/21",
	    "password": "8011",
	    "cvv": "768",
	    "store": "americanas",
	    "value": 200
	}

Response de exemplo

	{
	    "code": "00",
	    "cardBalance": 167,
	    "message": null
	}

### Listar todos os cartões

GET /api/cards

Response example

	[
	    {
		"id": 1,
		"holderName": "Chris Cornell",
		"cardNumber": "5447317206147840",
		"cardValidity": "2021-08-20",
		"cardPassword": "9211",
		"cardBalance": 500
	    },
	    {
		"id": 2,
		"holderName": "Jerry Cantrell",
		"cardNumber": "5447318541794326",
		"cardValidity": "2021-08-20",
		"cardPassword": "8011",
		"cardBalance": 300
	    }
	]

## Como rodar este app incrível?

Para executar a aplicação faça: 

### Antes de rodar a aplicação

- Criar banco de dados no postgres com o nome wexprepag;
- Criar usuário *prepagdb* com senha *psipos81kr*
- Dar permissão ao usuário no banco criado

### Rodando a aplicação

	mvn package
	mvn spring-boot:run

## Como rodar os testes

	mvn test

## Tech Stack

    Java 8
    Postgre Sql
    Spring Framework
    Maven

## Design

A aplicação conta com alguns pacotes:

- controller - onde encontra-se a classe responsável por atender as requisições;
- domain - onde encontram-se as classes que possuem as regras de negócio, como validar os cartões, como emitir cartões, etc;
- http - onde encontram-se as abstrações de request e response da solução;
- models - onde encontra-se a classe de abstração do banco de dados;
- repository - onde encontra-se a classe para fazer consultas ao banco de dados;

Obs: O pacote de testes encontra-se em outra hierarquia, mas segue a mesma estrutura de pastas.

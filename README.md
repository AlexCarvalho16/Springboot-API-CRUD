# API para crud Produtos e Vendedores

# Resumo

Projeto criado com a intenção de praticar os conhecimentos aprendidos com as aulas de Spring Boot, além de aprender novos assuntos relacionados ao JAVA e desenvolvimento WEB. Nesse projeto será encontrado, configuração do arquivo POM.xml, applications.properties, para o uso do MySQL, tratamento de exceções personalizadas, Padão DTO, Annotations e outros assunstos que envolvem o JAVA Spring boot.

# Funcionamento da API

## A API conta com os seguintes endpoints:

Para vendedores

- `POST /vendedores` para criar vendedores.
- `GET /vendedores` para pegar e listar todos os vendedores.
- `GET /vendedores/{id}` para pegar e listar apenas o vendedor que contenha o id passado.
- `DELETE /vendedores/{id}` para excluir do banco de dados o vendedor que contenha o mesmo id passado .
- `PUT /vendedores/{id}` para fazer atualizações no vendedor.

Para produtos

- `POST /produtos` para criar vendedores.
- `GET /produtos` para pegar e listar todos os vendedores.
- `GET /produtos/{id}` para pegar e listar apenas o vendedor que contenha o id passado.
- `DELETE /produtos/{id}` para excluir do banco de dados o vendedor que contenha o mesmo id passado .
- `PUT /produtos/{id}` para fazer atualizações no vendedor.

## Corpo das requisiçãos

Para algumas requisições, são necessárias o envio de um JSON no body da requisição, são elas:

POST /vendedores:  
``` 
{
  "nome": "nome da empresa"
}
```
- Caso o nome já esteje cadastrado, retornará um status code 409 e não persistirá o vendedor.
<br>

PUT /vendedores/{id}:

``` 
{
  "nome": "novo nome da empresa"
}
```
- Caso o nome já esteje cadastrado, retornará um status code 409 e não persistirá o vendedor.
- Caso o id do vendedor não exista no banco de dados retornará um status code 404 e não persistirá o vendedor.
<br>

POST /produtos
``` 
{
  "vendedor": 1,
  "nome": "nome do produto",
  "preco": 200.00,
  "desconto": 0.0,
  "quantidadeEmEstoque": 100,
  "tiposProdutosEnums": 0
}
```
- No exemplo acima o vendedor possui o ID 1, preço de 200,00, desconto de 0%, 100 unidades de produtos e tipo 0, mas podem ser editados como desejar.
- Não são obrigadores a serem enviados os campos, `desconto` e `quantidadeEmEstoque`, quando não passados, os mesmos assumem o valor 0.
- `tiposProdutosEnums` podemos assumir, nesse projeto, os valores: 
  - 0: INFORMÁTICA
  - 1: MÓVEIS
  - 2: BRINQUEDOS
  - 3: ANIMAIS
  - 4: COMIDAS
<br>
PUT /produtos/{id}

``` 
{
  "vendedor": 1,
  "nome": "novo nome do produto",
  "preco": 200.00,
  "desconto": 0.0,
  "quantidadeEmEstoque": 100,
  "tiposProdutosEnums": 0
}
```
# Teste Java para EQUIPLANO!

Olá, obrigado por avaliar o pequeno sistema que desenvolvi para o teste na EQUIPLANO, espero que atinja as expectativas para o cargo! 

## Tecnologias
### Backend
* Banco MySql
* Java Spring Boot
* Spring Data Jpa
* Flyway

### Frontend
* Angular 

## Como executar

Primeiramente ao executar via arquivo jar ou war, será preciso uma base de dados mysql em execução:
**database**: segplano
**usuário**: root
**senha**: root

Se o sistema conseguir se conectar corretamente, a base de dados e as tabelas serão criadas/populadas de forma automática pelo **Flyway**.

Executando o jar:
através da linha de comando execute:
` java -jar segplano.jar`

É possível setar os dados do banco utilizando variáveis de ambiente com o profile spring **prod**: 
` java -jar -DSEGPLANO_HOST=localhost -DSEGPLANO_DATABASE=segplano -DSEGPLANO_USER=root -DSEGPLANO_PASSWORD=root segplano.jar --spring.profiles.active=prod`

Também é possível executar o arquivo .war em um tomcat local.

Pode-se testar a API utilizando o Postman importando o arquivo:
`SegPlano.postman_collection.json`

Caso queira também utilizei o swagger para facilitar a visualização da API:

Ex: 
(http://localhost:8080/swagger-ui/) / (http://localhost:8080/segplano/swagger-ui/)

Descrição da API:

**Cliente**
* POST http://localhost:8080/api/clientes -> Salva um novo cliente
* GET http://localhost:8080/api/clientes -> Lista todos os clientes
* DELETE http://localhost:8080/api/clientes/{idCliente} -> Deleta um cliente por seu id
* PATCH http://localhost:8080/api/clientes -> Edita dados de um cliente

**Apólice**
* POST http://localhost:8080/api/apolices -> Salva uma apólice
* PATCH http://localhost:8080/api/apolices -> Edita uma apólice
* DELETE http://localhost:8080/api/apolices/{idApolice} -> Deleta uma apólice por seu id
* GET http://localhost:8080/api/apolices -> Lista todas as apólices
* GET http://localhost:8080/api/apolices/numero/{numeroApolice} -> Exibe uma apólice por seu número
* GET http://localhost:8080/api/apolices/placa/{placaVeiculo} -> Exibe uma apólice por sua placa
* GET http://localhost:8080/api/apolices/vencidas -> Exibe todas as apólices vencidas

**Cidade**
* GET http://localhost:8080/api/cidades -> Lista todas as cidades
* GET http://localhost:8080/api/cidades/estado/{idEstado} -> Lista todas as cidades por id do estado

**Estado**
* GET http://localhost:8080/api/estados -> Lista todos os estados


obs: Tive algumas dificuldades em gerar uma imagem docker no doker hub. Portanto vou ficar devendo esse ponto extra.

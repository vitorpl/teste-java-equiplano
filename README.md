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


obs: Tive algumas dificuldades em gerar um container docker no doker hub. Portanto vou ficar devendo esse ponto extra.
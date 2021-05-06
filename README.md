# Teste Java para EQUIPLANO!

Olá, obrigado por avaliar o pequeno sistema que desenvolvi para o teste na EQUIPLANO, espero que atinja as expectativas para o cargo! 

## Tecnologias
### Backend
* Banco MySql
* Java Spring Boot
* Flyway

###Frontend
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

Também é possível executar o arquivo .war em um tomcat local.
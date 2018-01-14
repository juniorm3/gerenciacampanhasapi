# gerenciacampanhasapi
Gerenciamento de campanhas
1) Expor o serviço de Campanha, seguindo as regras de CRUD (Create, Read, Update e Delete).

Eu, como usuário, quero administrar os dados da Campanha e fornecer mecanismos (APIs) para INCLUIR, CONSULTAR, ATUALIZAR, DELETAR as 
campanhas. Para tanto, os critérios de aceite dessa história são:

•	As campanhas deverão ser cadastradas de forma que o serviço retorne essas campanhas seguindo a estrutura abaixo:
o	Nome Da Campanha;
o	ID do Time do Coração;
o	Data de Vigência;
•	O Sistema não deverá retornar campanhas que estão com a data de vigência vencidas;
•	No cadastramento de uma nova campanha, deve-se verificar se já existe uma campanha ativa para aquele período (vigência), 
caso exista uma campanha ou N campanhas associadas naquele período, o sistema deverá somar um dia no término da vigência de cada campanha 
já existente. Caso a data final da vigência seja igual a outra campanha, deverá ser acrescido um dia a mais de forma que as campanhas não 
tenham a mesma data de término de vigência. Por fim, efetuar o cadastramento da nova campanha.

Foram utilizado nesse projeto o frameworks Spring MVC para desenvolviemnto de APIs REST, bem como um banco de dados em memoria o H2 Database,
e persistencia de dados atraves do udo do projeto Spring Data JPA

O Mapeamento para cadastro de Times é : 
   - /times, GET para Listar os registros;
   - /times, POST para incluir um novo registro;
   - /times/id, GET para buscar um registro;
   - /times/id, PUT para atualiar um rgistro;
   - /times/id, DELETE para apagar um registro;


O Mapeamento para cadastro de Campanhas é : 
   - /campanhas, GET para Listar os registros;
   - /campanhas/vigentes, GET para listar os registros vigentes;
   - /campanhas, POST para incluir um novo registro;
   - /campanhas/id, GET para buscar um registro;
   - /campanhas/id, PUT para atualiar um rgistro;
   - /campanhas/id, DELETE para apagar um registro;

# OpAbilities

O projeto OpAbilities é desenvolvido por um mestre de RPG de Ordem Paranormal que queria facilitar tanto sua vida como a de seus jogadores para procurar habilidades e itens. Conforme as campanhas de RPG vão acontecendo, o sistema vai sendo atualizado, itens e poderes homebrews vão sendo adicionados pelo mestre e gerando a famosa pergunta: "Em que livro está tal poder?". O projeto OpAbilites surgiu justamente para facilitar todo esse processo unificando em um só lugar todos os itens e habilidades em um só lugar sendo uma aplicação web constituída por:

- <u>**Backend:**</u> construído com Java/Spring

- <u>**Frontend:**</u> construído com Angular

- <u>**Banco de dados:**</u> Postgres

O intúito desse projeto é fazer uma aplicação onde seja possível cadastrar itens e habilidades de forma manual ou automatizada com a seleção de páginas em um pdf e sua classificação baseada em "tags" para procura mais eficiênte e categorizada.

## Arquitetura
A API segue uma arquitetura de camadas, onde cada camada possui suas responsabilidades e funções se interconectando através da injeção de componentes.

### Entities
As entities ou entidades são a base estrutural de dados dos sistemas. Elas definem o que é armazenado, quais dados estão aninhados, tipos e relacionamentos, sendo elas transcritas em tabelas no banco de dados.

### Repositories
O repository é a camada responsável por realizar o acesso ao banco de dados. Nela são feitas as consultas (SQL e JPQL) que retornam as entidades e seus dados. Comunicasse exclusivamente com o service.

### Services
O service é a camada responsavel por fazer o processamento de dados, e a comunicação entre o repository e o controller. Nele é feita a conversão das entidade em DTOs (Data Transfer Objects).

### Controllers
O controller é a camada mais externa da API, sendo ele o responsável pela criação dos endpoints e pela filtragem de dados, parêmetros de URL e outros elementos da requisição.

## Poderes Paranormais - (ParanormalPower)

## Item - (Item)

## Habilidades - (Ability)

## Classes - (Archetype)

## Tipos de dano - (DamageKind)

## Propriedades de Itens - (ItemProp)

## Elementos - (Element)
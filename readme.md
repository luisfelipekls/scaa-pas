# SCAA

## Documentação

### Camadas da Aplicação

#### Application

É responsável por coordenar a lógica de negócios do domínio e garantir que os casos de uso sejam executados corretamente. Ela atua como um intermediário entre o domínio (que contém as regras de negócios) e as interfaces externas (como interfaces de usuário e APIs).

Os recursos da aplicação podem ser observados nessa
camada (*Use cases em Clean Architecture).

Não contém regras de negócio específicas, é um grande
coordenador, delega para o Domain e portanto depende do
Domain e da Infrastructure (através do Domain).

##### Nessa camada implementaremos:

- Serviços que provém às funcionalidades da aplicação (casos de uso)

#### Domain

- Responsável pela definição das entidades da aplicação e grande parte das regras de negócio.

O coração do aplicativo.

É a camada onde estão incluídas todas as regras de
negócios relacionadas ao problema a ser resolvido.

Essa camada deve ser independente, bibliotecas de
terceiros não devem ser adicionadas o máximo possível

##### Nessa camada implementaremos:
- Entidades (modelos) e VO's
- Regra de negócio

#### Infraestructure

- Realiza o acesso e recepção de recurso externo à aplicação.

A camada que acessa os serviços externos como bancos de
dados, sistemas de mensagens e serviços de e-mail.

As interfaces desenhadas na camada de Domain e
utilizadas na camada de Application serão implementadas
nesta camada.

##### /persistence

- Repository

##### /web

- Controllers




# PRODOC UNICAP:: Manual do Programador

Projeto de desenvolvimento da aplicação **PRODOC UNICAP** . Este módulo é implementado em linguagem de programação Java.

Este projeto usa as seguintes tecnologias:
- [Java 8](https://www.oracle.com/technetwork/pt/java/javase/downloads/jdk8-downloads-2133151.html)
- [SQLite](https://www.sqlite.org/)
- [j forms]

## 1- Ferramentas e Configurações

### 1.1- Eclipse

**Instalação**

Baixar e descompactar um dos pacotes (Win ou Linux 64-bit) da versão `Eclipse IDE for Java Developers` que pode ser encontrado [aqui](https://www.eclipse.org/downloads/packages/).

**Importação do Projeto (Git)**

Após abrir o Eclipse, importar projeto do Git:

1. _File_ -> _Import..._ -> _Projects from Git_ -> _Clone URI_
2. URI: `git@github.com:rodrigorjsf/ProdocUnicapProject.git` -> _Next_
3. Escolher _branch_ `master`
4. _Local destination_: `pasta-do-workspace`
5. _Import as general project_ -> _Next_ -> _Finish_

**Configuração do Projeto**

Para Intellij

1. Adicionar o arquivo _sqlite-jdbc-3.27.2.1.jar_ na pasta _src_ -> _dbUtil_
2. Clicar com botão direito no projeto -> _File_ -> _Project_Structure_  -> _Libraries..._
2. Apertar no `+` e selecionar a pasta _dbUtil_
3. OK 

Incluir `Run Configurations`:

**Java Application** (para rodar a aplicação localmente)
- _New launch configuration_:
  - _Main_
    - _Name_: `prodoc-unicap`
    - _Project_: `selecionar-nome-do-projeto`
    - _Main class_: `Main.Main`

### 1.2- DB Browser (SQLite)

Ferramenta de gerenciamento de BDs SQLite. Para baixar o DB Browser (SQLite), clique [aqui](https://sqlitebrowser.org/dl/).


## 2- Arquitetura do Sistema

Este projeto segue um padrão arquitetural em camadas [[1](https://www.oreilly.com/library/view/software-architecture-patterns/9781491971437/ch01.html),[2](https://en.wikipedia.org/wiki/Multitier_architecture)] para fornecer uma API REST [[3](https://dzone.com/articles/intro-rest),[4](https://www.quora.com/What-are-RESTful-APIs-and-how-do-they-work),[5](https://blog.caelum.com.br/rest-principios-e-boas-praticas/)] ao módulo _frontend_ da aplicação. A camada mais externa do sistema (_Service_) implementa os serviços REST (JAX-RS), tendo esta camada a responsabilidade de validar os dados de entrada, assim como realizar as restrições de segurança necessárias (autenticação/autorização) no acesso aos serviços disponibilizados. 


A organização e significado de cada um dos pacotes do projeto segue abaixo:

```
src
├── ADM 								                  -> classe e FXML do adiministrador
├── Atividades 							               -> classe das atividades
├── dbUtil                                -> classe e arquivo jar da camada de persistência de dados
├── DOC                                   -> classe e FXML de docentes
├── Login                                 -> classe e FXML de controle de login
├── Main                              	  -> classe e FXML da inicialização da aplicação
├── Model                                 -> classe e FXML dos models

```

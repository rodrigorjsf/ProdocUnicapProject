# PRODOC UNICAP:: Manual do Programador :: V1.0

Projeto de desenvolvimento da aplicação **PRODOC UNICAP** . Este módulo é implementado em linguagem de programação Java.

- Equipe envolvida no desenvolvimento do projeto:
  - João Pedro de Melo Cabana
  - Rodrigo Jorge de Santana França
  - Vitor Viana

Este projeto usa as seguintes tecnologias:
- [Java 8](https://www.oracle.com/technetwork/pt/java/javase/downloads/jdk8-downloads-2133151.html)
- [SQLite](https://www.sqlite.org/)
- [j forms]

## 1- Ferramentas e Configurações

### 1.1- Eclipse

**Instalação**

- Baixar e descompactar um dos pacotes (Win ou Linux 64-bit) da versão `Eclipse IDE for Java Developers` que pode ser encontrado [aqui](https://www.eclipse.org/downloads/packages/).
OU
- Baixar e Instalar o `Intellij` que pode ser encontrado [aqui](https://www.jetbrains.com/idea/download/#section=windows)

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

Este projeto segue um padrão arquitetural MVC onde é que um padrão de arquitetura de software, separando sua aplicação em 3 camadas. A camada de interação do usuário(view), a camada de manipulação dos dados(model) e a camada de controle(controller).Para criação da view foi utilizado o _J_ _Forms_ utiliza FXML para criação da exibição de dados. A manipulação de dados e regras de negócio é através do Java seguindo o paradigma da _orientação_ _a_ _objetos_, é responsável pela leitura e escrita de dados, e também de suas validações.
Foi desenvolvida de maneira centralizada com aplicação local, utilizando base de dados SQLite local.



A organização e significado de cada um dos pacotes do projeto segue abaixo:

```
src
├── ADM                                   -> classe e FXML do adiministrador
├── Atividades                            -> classe das atividades
├── dbUtil                                -> classe e arquivo jar da camada de persistência de dados
├── DOC                                   -> classe e FXML de docentes
├── Login                                 -> classe e FXML de controle de login
├── Main                              	  -> classe e FXML da inicialização da aplicação
├── Model                                 -> classe e FXML dos models

```
**Para cada pacote:**
 -ADM
  -ADM.fxml
  -ADMController
 -Atividades
  -AtividadesDAO
 -dbUtil
  -dbConection
 -DOC
  -DocenteCOntroller
  -DocenteView.fxml
  -usuarioDAO
 -Login
  -LoginController
  -LoginDAO
  -LoginView.fxml
 -Main
  -Main
  -MainController
  -MainDAO
  -MainView.fxml
 -Model
  -AtividadeModel
  -DocenteModel


## 3- Regras de negócio

### 3.1 Entidades com Manutenção (CRUD)

#### Usuário (tabela `tbUsuario`)

- Inclusão
  - Não permitir a inclusão de um novo registro cujo código já se encontra cadastrado;
  - Preencher o campo de nome (`nome`) com o nome atual do usuário;
  - Preencher o campo de título (`titulo`) com o título atual do usuário;
  - Preencher o campo de tempo de experiência (`tempoXP`) com o tempo de exercício na instituição do usuário;
  - Preencher o campo de cargo (`cargo`) com o cargo atual do usuário;
  - Preencher o campo de senha (`senha`) com a senha do usuário;
  - Preencher o campo de usuário (`usuario`) com o nome de usuário que será utilizado para identificar o mesmo;
  - Preencher o campo de tipo de usuário (`tipo`) com o tipo de usuário: Docente ou Administrador;
- Alteração
  - Não permitir a alteração de um registro cujo código não está cadastrado;
  - Permitir atualização do campo nome (`name`).
  - Permitir atualização do campo usuário (`usuario`).
  - Permitir atualização do campo senha (`senha`).
- Exclusão 
  - Não permitir a remoção de um registro;

#### Atividade (tabela `tbAtividades`)

- Inclusão
  - Não permitir a inclusão de um novo registro cujo código já se encontra cadastrado;
  - Gera um código de Atividade auto-increment (`codAtiv`);
  - Preencher o campo descrição (`descricao`) com a descrição da atividade cadastrada;
  - Preencher o campo pontuação (`pontuacao`) com um valor da pontuação da atividade;
  - Preencher o campo status (`status`) com o status da atividade;
  - Associar um Professor à atividade através da chave estrangeira (`codProf`);
  
- Alteração
  - Não permitir a alteração de um registro cujo identificador não está cadastrado;
  - Alteração é feita através da aprovação de uma atividade por um adiministrador, essa alteração é feita nos campos (`pontuacao`) e (`status`);
- Exclusão
  - Não permitir a remoção de um registro;
  
  ## 4 - MER
  
  ![Alt text](https://github.com/rodrigorjsf/ProdocUnicapProject/blob/master/docs/pos-app-mer.jpg)


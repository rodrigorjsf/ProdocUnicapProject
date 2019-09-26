# PRODOC UNICAP :: Manual do Usuário

## 1- Usabilidade (Por tela)

### Início

Na tela inicial da aplicação é mostrado ao usuário dois botões: Docente e Administrador
![Alt text](https://github.com/rodrigorjsf/ProdocUnicapProject/blob/master/docs/manualUsuario/Telas/telaInicial.jpg)

- Botão Docente
	- Botão a ser utilizado pelos docentes UNICAP para realizar seu login no sistema e assim administrar suas atividades, informações da conta e requisições de pontuação em atividades;
	
- Botão Administrativo
	- Botão a ser utlizado pelo usuário administrador a fim de monitorar os professores cadastrados no sistema e as requisições de pontuação em atividades feitas pelos docentes, oferecendo o poder de avaliar essas atividades e validar as mesmas. Também permite o cadastro de novos docentes.

## 2- Módulos

### 2.1 Docente

Após clicar no botão `Docente`, o sistema irá pedir as informações cadastrais (Usuário e Senha) do docente para que ele faça o login no módulo de docentes.
![Alt text](https://github.com/rodrigorjsf/ProdocUnicapProject/blob/master/docs/manualUsuario/Telas/senhaDocente.jpg)

- Feito o Login, na tela do docente irá ser informado seu Usuário e Cargo acima das iterações disponíveis. 
![Alt text](https://github.com/rodrigorjsf/ProdocUnicapProject/blob/master/docs/manualUsuario/Telas/mainMenu.jpg)
	- Na área "Atualizar Dados" é permitido ao usuário a atualização de seus dados cadastrais (usuário, nome e senha).
	![Alt text](https://github.com/rodrigorjsf/ProdocUnicapProject/blob/master/docs/manualUsuario/Telas/attDadosDoc.jpg)
	- Ao lado, será exibido uma tabela onde mostra todas as requisições de atividades feitas pelo docente, onde nessa tabela é informado para cada requisição o código do professor, descrição, pontuação, status e código da atividade.
	![Alt text](https://github.com/rodrigorjsf/ProdocUnicapProject/blob/master/docs/manualUsuario/Telas/docenteAtividades.jpg)
	- No canto inferior esquerdo da tela, na área "Solicitação análise de atividade" é possível fazer uma requisição de avaliação de uma atividade a ser pontuada.
	![Alt text](https://github.com/rodrigorjsf/ProdocUnicapProject/blob/master/docs/manualUsuario/Telas/novaAtividade.jpg)

### 2.2 Administrador

Após clicar no botão `Administrador`, o sistema irá pedir as informações cadastrais (Usuário e Senha) do usuário Administrador para que ele faça o login no módulo Administrador.
![Alt text](https://github.com/rodrigorjsf/ProdocUnicapProject/blob/master/docs/manualUsuario/Telas/senhaDocente.jpg)

- Feito o Login, na tela do administrador irá ser mostrado telas para gerenciamento da aplicação.
![Alt text]()
	- Na área Atividades será informado todas as Atividades, independente de status, de um docente selecionado. Entre as informações estão: Código do Professor, Descrição, Pontuação, Status e Código da atividade.
	![Alt text]()
	- Na área Professor será informado todos os docentes cadastrados no sistema da aplicação. Entre as informações estão: ID, Usuário, Nome, Cargo, Título e tempo de Experiência.
	![Alt text]()
	- No canto inferior esquerdo, na área "Atualizar atividade" é possível atualizar o Status e Pontuação de uma atividade selecionada através de seu código.
	![Alt text]()
	- No canto inferior direito, na área "Cadastrar professor" é possível cadastrar um novo docente ao sistema informando seu Usuário, Nome, Cargo, Título, Tempo de Experiência e Senha.
	![Alt text]()

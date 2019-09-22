package ADM;

import Atividades.AtividadesDAO;
import DOC.usuarioDAO;
import Model.AtividadeModel;
import Model.DocenteModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;

public class ADMController implements Initializable {

    //Declarações
    usuarioDAO usuarioDAO;
    AtividadesDAO atividadesDAO;
    DocenteModel objAuxiliar;
    @FXML private TextField txtprofUser;
    @FXML private TextField txtprofNome;
    @FXML private TextField txtProfCargo;
    @FXML private TextField txtProfTitulo;
    @FXML private TextField txtProfTempXP;
    @FXML private PasswordField txtProfSenha;
    @FXML private Button btnCadastrar;
    @FXML private TableView<AtividadeModel> tbAtiv;
    @FXML private TableColumn<AtividadeModel, Integer> col_codProf;
    @FXML private TableColumn<AtividadeModel, String> col_descricao;
    @FXML private TableColumn<AtividadeModel, Integer> col_pontuacao;
    @FXML private TableColumn<AtividadeModel, String> col_status;
    @FXML private TableColumn<AtividadeModel, Integer> col_codAtiv;
    @FXML private TableView<DocenteModel> tbProf;
    @FXML private TableColumn<DocenteModel, Integer> col_ProfID;
    @FXML private TableColumn<DocenteModel, String> col_ProfUser;
    @FXML private TableColumn<DocenteModel, String> col_ProfNome;
    @FXML private TableColumn<DocenteModel, String> col_ProfCargo;
    @FXML private TableColumn<DocenteModel, String> col_ProfTitulo;
    @FXML private TableColumn<DocenteModel, Integer> col_ProfXP;
    @FXML private TextField txtAtuCodAtiv;
    @FXML private ComboBox cmbStatus;
    @FXML private TextField txtAtuPont;
    @FXML private Button btnAtualizar;
    ObservableList<DocenteModel> objList = FXCollections.observableArrayList();
    ObservableList<AtividadeModel> objListAtiv = FXCollections.observableArrayList();
    //Métodos e Funções
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.usuarioDAO = usuarioDAO.GETINSTANCE();
        this.atividadesDAO = new AtividadesDAO();
        cmbStatus.getItems().clear();
        cmbStatus.getItems().addAll("PENDENTE","EM ANÁLISE", "APROVADA", "SUSPENSA");
        cmbStatus.setValue("PENDENTE");
        mtPopulaTableprof();
    }
    @FXML void Atualizar(ActionEvent event) {
        AtividadeModel atividadeModel;
        try{
            if(txtAtuCodAtiv.getText().isEmpty() || txtAtuPont.getText().isEmpty()){
                exibeMensagemErro("Erro ao atualizar atividade!", "Preencha todos os campos!");
            }else{
                atividadeModel = new AtividadeModel();
                atividadeModel.setCodAtiv(Integer.parseInt(txtAtuCodAtiv.getText()));
                atividadeModel.setPontucao(Integer.parseInt(txtAtuPont.getText()));
                atividadeModel.setStatus(cmbStatus.getValue().toString());
                if(atividadesDAO.mtUpdate(atividadeModel)){
                    exibeMensagem("Atualização concluída!");
                }else{
                    exibeMensagemErro("Falha ao atualizar!","");
                }
                mtPopulaTableAtiv(objAuxiliar);
            }
        }catch (Exception ex){
            exibeMensagemErro("Ocorreu um erro inesperado!","Entre em contato com o suporte para mais informações");
        }
    }
    @FXML void Cadastro(ActionEvent event) {
        DocenteModel objCadastro;
        try{
            if(txtprofUser.getText().isEmpty() || txtProfCargo.getText().isEmpty() || txtProfTitulo.getText().isEmpty()
                    || txtProfTempXP.getText().isEmpty() || txtProfSenha.getText().isEmpty() || txtprofNome.getText().isEmpty()){
                    exibeMensagemErro("Falha no Cadastro!", "Todos os campos devem ser preenchidos");
            }else{
                objCadastro = new DocenteModel();
                objCadastro.setUsuario(txtprofUser.getText());
                objCadastro.setNome(txtprofNome.getText());
                objCadastro.setSenha(txtProfSenha.getText());
                objCadastro.setCargo(txtProfCargo.getText());
                objCadastro.setTitulo(txtProfTitulo.getText());
                objCadastro.setTempoXP(Integer.parseInt(txtProfTempXP.getText()));
                usuarioDAO.setObjDados(objCadastro);
                if(usuarioDAO.mtInserir()){
                    exibeMensagem("Docente cadastrado com sucesso!");
                }else{
                    exibeMensagemErro("Erro!","Falha ao solicitar Docente!");
                }
                mtPopulaTableprof();
            }
        }catch (Exception ex){
            exibeMensagemErro("Ocorreu um erro inesperado!","Entre em contato com o suporte para mais informações");
        }
    }

    private void mtPopulaTableprof() {
        LinkedList<DocenteModel> Lista;

        try {
            tbProf.getItems().clear();
            Lista = usuarioDAO.mtConsultaTodos();
            for (DocenteModel a : Lista){
                objList.add(a);
            }
            col_ProfID.setCellValueFactory(new PropertyValueFactory<>("id"));
            col_ProfUser.setCellValueFactory(new PropertyValueFactory<>("usuario"));
            col_ProfNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
            col_ProfCargo.setCellValueFactory(new PropertyValueFactory<>("cargo"));
            col_ProfTitulo.setCellValueFactory(new PropertyValueFactory<>("titulo"));
            col_ProfXP.setCellValueFactory(new PropertyValueFactory<>("tempoXP"));

            tbProf.setOnMousePressed(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                        objAuxiliar = tbProf.getSelectionModel().getSelectedItem();
                        mtPopulaTableAtiv(objAuxiliar);
                }
            });
            tbProf.setItems(objList);

        } catch (Exception ex) {
                exibeMensagemErro("Erro inesperado!","Falha ao carregar Grid");
        }
    }

    private void mtPopulaTableAtiv(DocenteModel p_obj){
        LinkedList<AtividadeModel> Lista;
        AtividadesDAO atividadesDAO;

        try{
            tbAtiv.getItems().clear();
            atividadesDAO = new AtividadesDAO();
            Lista = atividadesDAO.mtConsulta(p_obj);
            for (AtividadeModel a:Lista) {
                objListAtiv.add(a);
            }
            col_codProf.setCellValueFactory(new PropertyValueFactory<>("CodProf"));
            col_descricao.setCellValueFactory(new PropertyValueFactory<>("descricao"));
            col_pontuacao.setCellValueFactory(new PropertyValueFactory<>("pontucao"));
            col_status.setCellValueFactory(new PropertyValueFactory<>("status"));
            col_codAtiv.setCellValueFactory(new PropertyValueFactory<>("codAtiv"));
            tbAtiv.setItems(objListAtiv);

        }catch (Exception ex){

        }
    }



    private void exibeMensagem(String nome){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Aviso");
        alert.setHeaderText(null);
        alert.setContentText(nome);
        alert.showAndWait();
    }
    private void exibeMensagemErro(String Header, String Content){
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Erro");
        alert.setHeaderText(Header);
        alert.setContentText(Content);
        alert.showAndWait();
    }


}

package DOC;

import Atividades.AtividadesDAO;
import Model.AtividadeModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;

public class DocenteController implements Initializable {

    //Declarações



    @FXML private Button btnAtualizar;
    @FXML private TableView<AtividadeModel> tableAti;
    @FXML private Label lblUsuario;
    @FXML private Label lblCargo;
    @FXML private TableColumn<AtividadeModel, Integer> Col_codProf;
    @FXML private TableColumn<AtividadeModel, String> Col_desc;
    @FXML private TableColumn<AtividadeModel, Integer> Col_pont;
    @FXML private TableColumn<AtividadeModel, String> Col_Status;
    @FXML private TableColumn<AtividadeModel, Integer> Col_CodAtiv;
    @FXML private TextField atuUsuario;
    @FXML private TextField atuNome;
    @FXML private PasswordField atuSenha;
    @FXML private Button btnSolicitar;
    @FXML private TextField txtSolicitar;


    private usuarioDAO dModel;
    ObservableList<AtividadeModel> objList = FXCollections.observableArrayList();


    //Métodos e Funções
    @Override public void initialize(URL location, ResourceBundle resources){
        this.dModel =  usuarioDAO.GETINSTANCE();
        try{
            lblCargo.setText("Cargo: " + dModel.getObjDados().getCargo());
            lblUsuario.setText("Usuário: "+ dModel.getObjDados().getUsuario());
            mtPopulaTable();
        }catch (Exception ex){
            System.err.println("Deu merlin!"+ "Ex: " + ex.getMessage());
        }

    }


    @FXML void btnAtu(ActionEvent event){
        try{
            if(atuNome.getText().isEmpty() != true) {
                dModel.getObjDados().setNome(atuNome.getText());
            }
            if(atuUsuario.getText().isEmpty() != true) {
                dModel.getObjDados().setUsuario(atuUsuario.getText());
            }
            if(atuSenha.getText().isEmpty() != true) {
                dModel.getObjDados().setSenha(atuSenha.getText());
            }
            if( dModel.mtAtualizar()) {
                exibeMensagem("Dados atualizados!");
            }else {
                exibeMensagemErro("Erro ao atualizar", "");
            }

            lblUsuario.setText("Usuário: "+ dModel.getObjDados().getUsuario());
            lblCargo.setText("Cargo: " +dModel.getObjDados().getCargo());
        }catch (Exception ex){
            exibeMensagemErro("Erro ao atualizar", ex.getMessage());
        }
    }
    @FXML void btnSolicitar(ActionEvent event){
        AtividadeModel objAux;
        AtividadesDAO objAtiv;
        try{
            if(txtSolicitar.getText().isEmpty() != true) {

                objAux = new AtividadeModel();
                objAux.setCodProf(dModel.getObjDados().getId());
                objAux.setDescricao(txtSolicitar.getText());
                objAux.setStatus("PENDENTE");

                objAtiv = new AtividadesDAO();
               if(objAtiv.mtInserir(objAux, dModel.getObjDados())){
                   exibeMensagem("Solicitação cadastrada com sucesso!");
               }else{
                   exibeMensagemErro("Erro!","Falha ao solicitar atividade");
               }
               mtPopulaTable();

            }
        }catch (Exception ex){
            exibeMensagemErro("Ocorreu um erro inesperado!","Entre em contato com o suporte para mais informações");
        }
    }
    private void mtPopulaTable(){
        LinkedList<AtividadeModel> Lista;
        AtividadesDAO atividadesDAO;

        try{
            tableAti.getItems().clear();
            atividadesDAO = new AtividadesDAO();
            Lista = atividadesDAO.mtConsulta(dModel.getObjDados());
            for (AtividadeModel a:Lista) {
                objList.add(a);
            }
            Col_codProf.setCellValueFactory(new PropertyValueFactory<>("CodProf"));
            Col_desc.setCellValueFactory(new PropertyValueFactory<>("descricao"));
            Col_pont.setCellValueFactory(new PropertyValueFactory<>("pontucao"));
            Col_Status.setCellValueFactory(new PropertyValueFactory<>("status"));
            Col_CodAtiv.setCellValueFactory(new PropertyValueFactory<>("codAtiv"));
            tableAti.setItems(objList);

        }catch (Exception ex){

        }
    }








    //Métodos auxiliares
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

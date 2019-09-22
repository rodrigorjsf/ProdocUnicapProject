package Login;

import DOC.DocenteController;
import Model.DocenteModel;
import DOC.usuarioDAO;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    //Declarações
    private LoginDAO loginDAO;
    private String tpLogin;
    @FXML private TextField txtUser;
    @FXML private PasswordField txtPass;
    @FXML private Label dbstatus;
    @FXML private Button btnLogin;

    //Construtor
    public LoginController(){
        this.loginDAO = new LoginDAO();
    }


    //Métodos e Funções
    public void initialize(URL location, ResourceBundle resources){
        if (this.loginDAO.isDataBaseConected()){
            this.dbstatus.setText("Status: online ");
        }else{
            this.dbstatus.setText("Status: offline");
        }

    }
    @FXML private void FazerLogin() throws Exception {
        DocenteModel objAux;
        try {
            Stage stage = (Stage) btnLogin.getScene().getWindow();


            objAux = loginDAO.mtCapturaDocente(txtUser.getText(), txtPass.getText(), tpLogin);


            if (objAux != null) {
                //Mensagem de Bem vindo
                exibeMensagem(objAux.getNome());

                switch (tpLogin){
                    case "DOC":
                        loginDocente(objAux);
                        break;
                    case "ADM":
                        loginADM(objAux);
                        break;
                }

                //fecha a tela de login
                stage.close();
            } else {
                exibeMensagemErro("Não foi possível realizar o login",
                        "Confira se suas credenciais estão corretas!");
            }
        }catch (Exception ex){
            exibeMensagemErro("Erro inesperado ocorreu, entre em contato com o suporte", ex.getMessage());
        }
    }
    public void initData(String tpLogin){
        this.setTpLogin(tpLogin);
    }
    public void loginDocente(DocenteModel p_obj){
        try{
            usuarioDAO obj_controller = usuarioDAO.GETINSTANCE();
            obj_controller.setObjDados(p_obj);


            FXMLLoader loader = new FXMLLoader();
            AnchorPane root = (AnchorPane)loader.load(getClass().getResource("/DOC/DocenteView.fxml"));

            DocenteController docenteController = loader.getController();

            Stage userStage = new Stage();
            Scene scene = new Scene(root);
            userStage.setScene(scene);
            userStage.setTitle("Menu do docente ");
            userStage.setResizable(false);
            userStage.show();

        }catch(IOException ex){
            ex.printStackTrace();
        }
    }
    public void loginADM(DocenteModel p_obj){
        try{
            usuarioDAO obj_controller = usuarioDAO.GETINSTANCE();
            obj_controller.setObjDados(p_obj);
            FXMLLoader loader = new FXMLLoader();
            AnchorPane root = (AnchorPane)loader.load(getClass().getResource("/ADM/ADM.fxml"));
            DocenteController docenteController = loader.getController();

            Stage userStage = new Stage();
            Scene scene = new Scene(root);
            userStage.setScene(scene);
            userStage.setTitle("Menu do docente ");
            userStage.setResizable(false);
            userStage.show();

        }catch(IOException ex){
            ex.printStackTrace();
        }
    }
    private void exibeMensagem(String nome){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Usuário logado");
        alert.setHeaderText(null);
        alert.setContentText("Bem vindo " + nome +"!");
        alert.showAndWait();
    }
    private void exibeMensagemErro(String Header, String Content){
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Erro");
        alert.setHeaderText(Header);
        alert.setContentText(Content);
        alert.showAndWait();
    }
    //Getters e setters
    public String getTpLogin() {
        return tpLogin;
    }
    public void setTpLogin(String tpLogin) {
        this.tpLogin = tpLogin;
    }




}

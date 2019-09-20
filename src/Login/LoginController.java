package Login;

import Docente.DocenteController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    private LoginModel loginModel;
    private String tpLogin;


    @FXML private TextField txtUser;
    @FXML private PasswordField txtPass;
    @FXML private Label dbstatus;
    @FXML private Button btnLogin;


    public LoginController(){
        this.loginModel = new LoginModel();
    }

    public void initialize(URL location, ResourceBundle resources){
        if (this.loginModel.isDataBaseConected()){
            this.dbstatus.setText("Status: online");
        }else{
            this.dbstatus.setText("Status: offline");
        }


        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Tipo de login");
        alert.setHeaderText(null);
        alert.setContentText(tpLogin + " Selecionado");
        alert.showAndWait();


    }

    void initData(String tpLogin){
        this.setTpLogin(tpLogin);
    }


    @FXML
    private void FazerLogin() throws Exception {

        try {

            Stage stage = (Stage) btnLogin.getScene().getWindow();

            if (loginModel.isLogin(txtUser.getText(), txtPass.getText())) {

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Usuário logado");
                alert.setHeaderText(null);
                alert.setContentText("Bem vindo");
                alert.showAndWait();



                stage.close();
            } else {

                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Erro");
                alert.setHeaderText("Não foi possível realizar o login");
                alert.setContentText("Confira se suas credenciais estão corretas!");
                alert.showAndWait();

            }
        }catch (Exception ex){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Erro");
            alert.setHeaderText("Erro inesperado ocorreu, entre em contato com o suporte");
            alert.setContentText(ex.getMessage());
            alert.showAndWait();
        }

    }


    public void loginDocente(){
        try{
            Stage userStage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            AnchorPane root = (AnchorPane)loader.load(getClass().getResource("/Docente/DocenteView.fxml").openStream());
            DocenteController DocenteController = (DocenteController)loader.getController();

            Scene scene = new Scene(root);
            userStage.setScene(scene);
            userStage.setTitle("Student Dashboard");
            userStage.setResizable(false);
            userStage.show();
        }catch(IOException ex){
            ex.printStackTrace();
        }
    }


    public String getTpLogin() {
        return tpLogin;
    }

    public void setTpLogin(String tpLogin) {
        this.tpLogin = tpLogin;
    }



}

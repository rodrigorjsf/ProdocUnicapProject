package Login;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    LoginModel loginModel = new LoginModel();

    @FXML private TextField txtUser;
    @FXML private PasswordField txtPass;
    @FXML private Label dbstatus;
    @FXML private Button btnLogin;


    public void initialize(URL location, ResourceBundle resources){
        if (this.loginModel.isDataBaseConected()){
            this.dbstatus.setText("Status: online");
        }else{
            this.dbstatus.setText("Status: offline");
        }
    }

    @FXML
    private void FazerLogin() throws Exception {

        try {

            Stage stage = (Stage) btnLogin.getScene().getWindow();

            if (loginModel.isLogin(txtUser.getText(), txtPass.getText())) {

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Usuário logado");
                alert.setHeaderText(null);
                alert.setContentText("Bem vindo!");
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



}

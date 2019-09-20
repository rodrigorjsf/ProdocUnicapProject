package Main;

import Login.LoginController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import sun.rmi.runtime.Log;

import java.io.File;
import java.io.IOException;

public class MainController {

    private MainModel mainModel = new MainModel();

    @FXML
    private Label dbStatus;

    @FXML
    private Button btnDocente;

    @FXML
    private Button btnAdm;

    @FXML
    private Button btnAuxiliar;

    @FXML
    private ImageView imagem;

    public void initialize(){

        File file = new File("main.png");
        Image image = new Image(file.toURI().toString());
        ImageView imageView;
        imagem.setImage(image);

        if (this.mainModel.isDataBaseConected()){
            this.dbStatus.setText("Status: online");
        }else{
            this.dbStatus.setText("Status: offline");
        }

    }


    public void btnEventDocente(javafx.event.ActionEvent event) {
        try{

            SelecionaMenu("Docente");

        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }


    public void SelecionaMenu(String tipoLogin){
        try{
            switch (tipoLogin){
                case "Docente":
                    menuDocente();
                    break;
                case "ADM":

                    break;
            }
        }catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Erro");
            alert.setHeaderText("Erro inesperado ocorreu, entre em contato com o suporte");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }



    }

    public void menuDocente() throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Login/LoginView.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();

        LoginController loginController = fxmlLoader.<LoginController>getController();
        //loginController("Docente");

        Stage stage = new Stage();
        stage.setTitle("Fazer login");
        stage.setScene(new Scene(root1));
        stage.show();
    }


}




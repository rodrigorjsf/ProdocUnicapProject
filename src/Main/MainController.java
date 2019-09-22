package Main;

import Login.LoginController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class MainController {

    private MainDAO mainDAO = new MainDAO();

    @FXML private Label dbStatus;
    @FXML private Button btnDocente;
    @FXML private Button btnAdm;
    @FXML private Button btnAuxiliar;
    @FXML private ImageView imagem;


    public void initialize(){

        File file = new File("main.png");
        Image image = new Image(file.toURI().toString());
        ImageView imageView;
        imagem.setImage(image);

        if (this.mainDAO.isDataBaseConected()){
            this.dbStatus.setText("Status: online");
        }else{
            this.dbStatus.setText("Status: offline");
        }

    }


    public void btnEventDocente(javafx.event.ActionEvent event) {
        try{
            ChamaMenu("DOC");
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    public void btnEventADM(javafx.event.ActionEvent event) {
        try{
            ChamaMenu("ADM");
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    public void btnEventAUX(javafx.event.ActionEvent event) {
        try{
            ChamaMenu("AUX");
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }


    public void ChamaMenu(String tipo) throws IOException {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Login/LoginView.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();

            LoginController loginController = fxmlLoader.getController();
            loginController.initData(tipo);

            Stage stage = new Stage();
            stage.setTitle("Fazer login");
            stage.setScene(new Scene(root1));
            stage.show();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

}




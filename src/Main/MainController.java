package Main;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.File;
import java.io.IOException;

public class MainController {

    MainModel mainModel = new MainModel();

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


    public void menuDocente(javafx.event.ActionEvent event) {
        try{
            chamaMenu();

        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }


    public void chamaMenu() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Login/LoginView.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setTitle("Fazer login");
        stage.setScene(new Scene(root1));

        stage.show();
    }
}

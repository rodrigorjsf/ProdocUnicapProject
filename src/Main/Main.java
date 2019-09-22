package Main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    private static Stage stage;


    public static Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        Main.stage = stage;
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("MainView.fxml"));
        primaryStage.setTitle("PRODOC UNICAP 2019");
        primaryStage.setScene(new Scene(root, 543, 361));
        primaryStage.setResizable(false);
        primaryStage.show();
        setStage(stage);
    }


    public static void main(String[] args) {
        launch(args);
    }
}

package myChatApp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;


public class MyChatApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        try {
            URL resource = getClass().getResource("/GUI/myChatGUI.fxml");
            if (resource == null) {
                System.err.println("Không thể tìm thấy tệp FXML.");
                System.exit(1);
            }
            stage.setTitle("myChatApp");
            Parent root = FXMLLoader.load(resource);
            Scene scene = new Scene(root, 400, 600);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

        public static void main(String[] args) {
            launch(args);
        }
}
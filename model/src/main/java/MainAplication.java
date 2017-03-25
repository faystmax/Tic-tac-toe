/**
 * Created with IntelliJ IDEA
 * User: Maxim Amosov <faystmax@gmail.com>
 * Date: 25.03.2017
 * Time: 22:09
 */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class MainAplication extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Tic-tac-toe");
        primaryStage.getIcons().add(new Image("tic-tac.png"));
        initRootLayout(primaryStage);
    }

    /**
     * Инициализирует корневой макет.
     */
    public void initRootLayout(Stage primaryStage) {
        try {
            // Загружаем корневой макет из fxml файла.
            // FXMLLoader loader = new FXMLLoader();
            // loader.setLocation(getClass().getClassLoader().getResource("fxml/view.fxml"));
            // BorderPane rootLayout =  loader.load();

            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/view.fxml"));
            // Отображаем сцену, содержащую корневой макет.
            primaryStage.setScene(new Scene(root, 500, 430));
            primaryStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * Created with IntelliJ IDEA
 * User: Maxim Amosov <faystmax@gmail.com>
 * Date: 25.03.2017
 * Time: 22:21
 */
public class Controller {
    @FXML
    private MenuItem menuEndGame;
    @FXML
    private MenuItem menuStartGame;
    @FXML
    private Button btn_0_0;
    @FXML
    private Button btn_0_1;
    @FXML
    private Button btn_0_2;
    @FXML
    private Button btn_1_0;
    @FXML
    private Button btn_1_1;
    @FXML
    private Button btn_1_2;
    @FXML
    private Button btn_2_0;
    @FXML
    private Button btn_2_1;
    @FXML
    private Button btn_2_2;
    @FXML
    private MenuItem menuClose;
    @FXML
    private MenuBar myMenuBar;


    private MainLogic mainLogic;
    private Boolean turn = false;

    @FXML
    public void initialize() {
        mainLogic = new MainLogic();
        mainLogic.setDemension(3);
        mainLogic.setCountToWin(3);
        clearButtonsImage();
    }

    public void clearButtonsImage() {
        btn_0_0.setGraphic(null);
        btn_0_1.setGraphic(null);
        btn_0_2.setGraphic(null);
        btn_1_0.setGraphic(null);
        btn_1_1.setGraphic(null);
        btn_1_2.setGraphic(null);
        btn_2_0.setGraphic(null);
        btn_2_1.setGraphic(null);
        btn_2_2.setGraphic(null);

    }

    public void ExitButtonAction(ActionEvent event) {
        Stage stage = (Stage) myMenuBar.getScene().getWindow();
        stage.close();
    }

    public void startGame() {
        mainLogic.setDemension(3);
        mainLogic.setCountToWin(3);
        mainLogic.startGame();
        turn = false;
    }

    public void stopGame() {
        mainLogic.stopGame();
        clearButtonsImage();
    }


    public void btn_0_0_Action(ActionEvent e) {
        btnHandler((Button) e.getSource(), 0, 0);
    }

    public void btn_0_1_Action(ActionEvent e) {
        btnHandler((Button) e.getSource(), 0, 1);
    }

    public void btn_0_2_Action(ActionEvent e) {
        btnHandler((Button) e.getSource(), 0, 2);
    }

    public void btn_1_0_Action(ActionEvent e) {
        btnHandler((Button) e.getSource(), 1, 0);
    }

    public void btn_1_1_Action(ActionEvent e) {
        btnHandler((Button) e.getSource(), 1, 1);
    }

    public void btn_1_2_Action(ActionEvent e) {
        btnHandler((Button) e.getSource(), 1, 2);
    }

    public void btn_2_0_Action(ActionEvent e) {
        btnHandler((Button) e.getSource(), 2, 0);
    }

    public void btn_2_1_Action(ActionEvent e) {
        btnHandler((Button) e.getSource(), 2, 1);
    }

    public void btn_2_2_Action(ActionEvent e) {
        btnHandler((Button) e.getSource(), 2, 2);
    }


    public void btnHandler(Button button, int x, int y) {
        int result = 0;
        if (mainLogic.isStart()) {
            if (turn == false) {
                result = mainLogic.moveAt(x, y, 1);

                Image imageDecline = new Image(getClass().getResourceAsStream("Krest.png"));
                ImageView imageView = new ImageView(imageDecline);
                imageView.setFitHeight(100);
                imageView.setFitWidth(100);
                button.setGraphic(imageView);
            } else {
                result = mainLogic.moveAt(x, y, 2);

                Image imageDecline = new Image(getClass().getResourceAsStream("krug.png"));
                ImageView imageView = new ImageView(imageDecline);
                imageView.setFitHeight(100);
                imageView.setFitWidth(100);
                button.setGraphic(imageView);
            }
            turn = !turn;
            if (result == 1) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Победитель");
                alert.setHeaderText(null);
                alert.setContentText("Крестики победили!");

                alert.showAndWait();
                stopGame();
            } else if (result == 2) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Победитель");
                alert.setHeaderText(null);
                alert.setContentText("Нолики победили!");

                alert.showAndWait();
                stopGame();
            } else if (result == 3) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Ничья");
                alert.setHeaderText(null);
                alert.setContentText("Победила дружба!");

                alert.showAndWait();
                stopGame();
            }
        }
    }

}

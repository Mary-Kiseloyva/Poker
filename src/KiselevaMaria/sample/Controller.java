package KiselevaMaria.sample;

import java.io.*;


import java.net.Socket;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import KiselevaMaria.common.Player;
import javafx.fxml.FXML;

import javafx.fxml.FXMLLoader;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Controller {
    private static final BufferedReader Br = new BufferedReader(new InputStreamReader(System.in));

    private List<Player> players = new ArrayList<>();
    private static String name =  null;
    private static int n = 0;
   /* private Stage stage;

    private FXMLLoader nextSceneLoader;*/

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button StartTheGame;

    @FXML
    private TextField TextName;

    @FXML
    private TextField NumberOfPlayers;

    public Socket s;

    OutputStream outputStream;
    BufferedReader in;

    public void setN(int n) {
        this.n = n;
    }


    @FXML
    void initialize() throws IOException {

        if (TextName != null && NumberOfPlayers != null) {


            StartTheGame.setOnAction(actionEvent -> {

                name = TextName.getText();
                setN(Integer.parseInt(NumberOfPlayers.getText()));
                StartTheGame.getScene().getWindow().hide();
                //

                    // создать клиента и начинать игру
                AppClient appClient = new AppClient("localhost", 9999);
                try {
                    appClient.start();
                } catch (IOException e) {
                    e.printStackTrace();
                }


                //
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/KiselevaMaria/sample/sample2.fxml"));
                try {
                    loader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Parent root = loader.getRoot();
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.showAndWait();

            });
        }

    }


   /* private void StartTheGame2(ActionEvent event) throws IOException {

            Parent gameUi = nextSceneLoader.load();
            NewController gameController = nextSceneLoader.getController();

            gameController.startGame();
            Scene gameScene = new Scene(gameUi, 450, 250);

            stage.setScene(gameScene);
            stage.show();

    }*/

    public ResourceBundle getResources() {
        return resources;
    }

    public void setResources(ResourceBundle resources) {
        this.resources = resources;
    }

    public URL getLocation() {
        return location;
    }

    //
   /* public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void setNextSceneLoader(FXMLLoader nextSceneLoader) {
        this.nextSceneLoader = nextSceneLoader;
    }*/
//
    public void setLocation(URL location) {
        this.location = location;
    }

    public TextField getNumberOfPlayers() {
        return NumberOfPlayers;
    }

    public void setNumberOfPlayers(TextField numberOfPlayers) {
        NumberOfPlayers = numberOfPlayers;
    }

    public Button getStartTheGame() {
        return StartTheGame;
    }

    public void setStartTheGame(Button startTheGame) {
        StartTheGame = startTheGame;
    }

    public TextField getTextName() {
        return TextName;
    }

    public void setTextName(TextField textName) {
        TextName = textName;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public String getName() {
        return name;
    }

    public int getN() {
        return n;
    }
}

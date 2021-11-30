package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ru.vsu.cs.KiselevaMaria.ConsoleTable;

import java.io.IOException;
import java.util.Scanner;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Poker");
        primaryStage.setScene(new Scene(root, 700, 575));
        primaryStage.show();
    }



    public static void main(String[] args){

         launch(args);


    }
}

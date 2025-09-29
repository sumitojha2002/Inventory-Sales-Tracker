package com.ist;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage stage)throws Exception {
     FXMLLoader dashBoardLoader = new FXMLLoader(getClass().getResource("/fxml/dashboard.fxml"));
     Scene scene = new Scene(dashBoardLoader.load());
     stage.setTitle("Inventory & Sales Tracker Dashboard");
     stage.setScene(scene);
     stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

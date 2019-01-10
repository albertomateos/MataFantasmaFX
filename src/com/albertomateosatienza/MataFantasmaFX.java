/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.albertomateosatienza;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.shape.Circle;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;



 
 
    public class MataFantasmaFX extends Application {
    
    @Override
    public void start(Stage primaryStage) {   
    StackPane root = new StackPane();
    Scene scene = new Scene(root, 600, 400);
    primaryStage.setTitle("PONGFX");
    primaryStage.setScene(scene);
    primaryStage.show();
    
    Circle circleBall = new Circle(10,30,7);
    root.getChildren().add(circleBall);
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}

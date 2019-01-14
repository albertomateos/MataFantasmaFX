/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.albertomateosatienza;

import javafx.application.Application; 
import javafx.scene.Group;
import javafx.scene.Scene; 
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color; 
import javafx.scene.shape.Arc; 
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;
import javafx.stage.Stage; 



 
 
    public class MataFantasmaFX extends Application {
    
    @Override public void start(Stage primaryStage) {
        Pane root = new Pane();
        Scene scene = new Scene(root, 600,400,Color.BLUE);
        primaryStage.setTitle("MataFantasma");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        Arc arc = new Arc(90, 50, 25, 25, 0, 180); 
        arc.setType(ArcType.OPEN); 
        arc.setStrokeWidth(50); 
        arc.setStroke(Color.RED); 
        arc.setStrokeType(StrokeType.INSIDE); 
        arc.setFill(null); 
        root.getChildren().add(arc);
        
        Rectangle pata1 = new Rectangle();
        pata1.setX(100);
        pata1.setY(100);
        pata1.setWidth(50);
        pata1.setHeight(20);
        pata1.setFill(Color.BLACK);
    } 
    /**
     * 
     * @param args the commant line arguments
     */
    public static void main(String[] args) { launch(args); } 
} 
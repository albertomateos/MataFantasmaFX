/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.albertomateosatienza;

import java.util.Random;
import javafx.animation.AnimationTimer;
import javafx.application.Application; 
import javafx.scene.Group;
import javafx.scene.Scene; 
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color; 
import javafx.scene.shape.Arc; 
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;
import javafx.stage.Stage; 



 
 
    public class MataFantasmaFX extends Application {
        int medusaCenterX = 90;
        int disparador = 85;
        int lado1 = 70;
        int lado2 = 85;
        int lado3 = 100; 
        int velocidadx = 2;
        int medusaX = 0;
        int murcielagoy =0;
        int velocidady = 2;
        int murcielagoX = 0;
       
        
        
                
    
    @Override public void start(Stage primaryStage) {
        Pane root = new Pane();
        Scene scene = new Scene(root, 600,400,Color.BLACK);
        primaryStage.setTitle("MataFantasma");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        Image bat = new Image(getClass().getResourceAsStream("images/Bat.png"));
        ImageView batview = new ImageView(bat);
        batview.setScaleX(0.3);
        batview.setScaleY(0.3);
        batview.setLayoutX(-50);
        batview.setLayoutY(-100);
        root.getChildren().add(batview);
        
        Arc arc = new Arc(medusaCenterX,50, 25, 25, 0, 180); 
        arc.setType(ArcType.OPEN); 
        arc.setStrokeWidth(50); 
        arc.setStroke(Color.RED); 
        arc.setStrokeType(StrokeType.INSIDE); 
        arc.setFill(null); 
        
        
        Rectangle pata1 = new Rectangle();
        pata1.setX(lado1);
        pata1.setY(50);
        pata1.setWidth(10);
        pata1.setHeight(40);
        pata1.setFill(Color.YELLOW);
        
        
        Rectangle pata2 = new Rectangle();
        pata2.setX(lado2);
        pata2.setY(50);
        pata2.setWidth(10);
        pata2.setHeight(40);
        pata2.setFill(Color.YELLOW);
       
        
        Rectangle pata3 = new Rectangle();
        pata3.setX(lado3);
        pata3.setY(50);
        pata3.setWidth(10);
        pata3.setHeight(40);
        pata3.setFill(Color.YELLOW);
        
        
        Rectangle boca = new Rectangle();
        boca.setX(disparador);
        boca.setY(20);
        boca.setWidth(10);
        boca.setHeight(10);
        boca.setFill(Color.RED);
        
        
        Group groupPerson = new Group();
        groupPerson.getChildren().add(arc);
        groupPerson.getChildren().add(pata1);
        groupPerson.getChildren().add(pata2);
        groupPerson.getChildren().add(pata3);
        groupPerson.getChildren().add(boca);
        groupPerson.setLayoutX(0);
        groupPerson.setLayoutY(300);
        
        
        
        root.getChildren().add(groupPerson);
        
        
        
        
        AnimationTimer animationmedusa;
            animationmedusa = new AnimationTimer(){
                @Override
                public void  handle(long now){
                    groupPerson.setLayoutX(medusaX);
                    medusaX+= velocidadx;
                    
                    if (medusaX >=475){
                        velocidadx = -2;
                        
                    }
                    if (medusaX <=-50){
                        velocidadx = 2;
                    }
                    batview.setLayoutY(murcielagoy);
                    batview.setLayoutX(murcielagoX);
                    murcielagoy += velocidady;
                    velocidady = 2;
                    
                    if(murcielagoy >=400){
                        murcielagoy = 0;
                    }
                
                };
            };
               
         animationmedusa.start();
          
        
        
    } 
    /**
     * 
     * @param args the commant line arguments
     */
    public static void main(String[] args) { launch(args); } 
} 
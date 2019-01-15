/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.albertomateosatienza;

import javafx.animation.AnimationTimer;
import javafx.application.Application; 
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene; 
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
        int velocidad = 3;
        
                
    
    @Override public void start(Stage primaryStage) {
        Pane root = new Pane();
        Scene scene = new Scene(root, 600,400,Color.BLACK);
        primaryStage.setTitle("MataFantasma");
        primaryStage.setScene(scene);
        primaryStage.show();
        
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
        groupPerson.setLayoutX(medusaCenterX);
        groupPerson.setLayoutY(50);
        
        
        root.getChildren().add(groupPerson);
        
        AnimationTimer animationmedusa;
            animationmedusa = new AnimationTimer(){
                @Override
                public void  handle(long now){
                    medusaCenterX++;
                    arc.setCenterX(medusaCenterX);
                    medusaCenterX += velocidad;
                    if (medusaCenterX >= 600){
                        velocidad = -3;
                    }
                    if (medusaCenterX <= 0){
                        velocidad = 3;
                    }
                    
                    
                    disparador++;
                    boca.setX(disparador);
                    disparador += velocidad;
                    if(disparador >= 600){
                        velocidad = -3;
                    }
                    if(disparador <= 0){
                        velocidad = 3;
                    }
                    
                    lado1++;
                    pata1.setX(lado1);
                    lado1 += velocidad;
                    if(lado1 >= 600){
                        velocidad = -3;
                    }
                    if(lado1 <= 0){
                        velocidad = 3;
                    }
                    
                    lado2++;
                    pata2.setX(lado2);
                    lado2 += velocidad;
                    if(lado2 >= 600){
                        velocidad = -3;
                    }
                    if(lado2 <= 0){
                        velocidad = 3;
                    }
                    
                    
                    lado3++;
                    pata3.setX(lado3);
                    lado3 += velocidad;
                    if(lado3 >= 600){
                        velocidad = -3;
                    }
                    if(lado3 <= 0){
                        velocidad = 3;
                    }
                    
                    
                    
                   System.out.println(medusaCenterX);
                   System.out.println(disparador);
                   System.out.println(lado1);
                   System.out.println(lado2);
                   System.out.println(lado3);
                    
                    
                    
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
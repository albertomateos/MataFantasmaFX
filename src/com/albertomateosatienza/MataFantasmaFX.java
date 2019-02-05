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
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color; 
import javafx.scene.shape.Arc; 
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.shape.StrokeType;
import javafx.stage.Stage; 



 
 
    public class MataFantasmaFX extends Application {
        int medusaCenterX = 90;
        int disparador = 85;
        int lado1 = 70;
        int lado2 = 85;
        int lado3 = 100; 
        int velocidadx = 2;
        int medusaX = 40;
        int murcielagoy =0;
        int velocidady = 2;
        int murcielagoX = 0;
        int stickCurrentSpeed = 0;
        int ballX = 115;
        int ballY = 300;
        int velocidadball = 0;
        int movimiento = 0;
        
        
                
    
    @Override public void start(Stage primaryStage) {
        Pane root = new Pane();
        Scene scene = new Scene(root, 600,400,Color.BLACK);
        primaryStage.setTitle("MataFantasma");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        Image ball = new Image(getClass().getResourceAsStream("images/bola de dragon1.png"));
        ImageView ballview = new ImageView(ball);
        ballview.setLayoutX(50);
        ballview.setLayoutY(30);
        
        
                
        Image bat = new Image(getClass().getResourceAsStream("images/Bat.png"));
        ImageView batview = new ImageView(bat);
        batview.setScaleX(0.3);
        batview.setScaleY(0.3);
        batview.setLayoutX(-10);
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
        
        Rectangle murcielago = new Rectangle();
        murcielago.setWidth(60);
        murcielago.setHeight(30);
        murcielago.setFill(Color.YELLOW);
        root.getChildren().add(murcielago);
        
        
        Group grupoMurcielago = new Group();
        grupoMurcielago.getChildren().add(murcielago);
        grupoMurcielago.getChildren().add(batview);
        root.getChildren().add(grupoMurcielago);
        
        
        Group groupPerson = new Group();
        groupPerson.getChildren().add(arc);
        groupPerson.getChildren().add(pata1);
        groupPerson.getChildren().add(pata2);
        groupPerson.getChildren().add(pata3);
        groupPerson.getChildren().add(boca);
        groupPerson.setLayoutX(0);
        groupPerson.setLayoutY(300);
       
        
        
        root.getChildren().add(groupPerson);
        
       Random random = new Random();
        
        
        
        AnimationTimer animationmedusa;
            animationmedusa = new AnimationTimer(){
                
                
                
                @Override
                public void  handle(long now){
                    
                   
                    groupPerson.setLayoutX(medusaX);
                    medusaX+= movimiento;
                    
                    if (medusaX <-50){
                        medusaX = -50;
                        
                    }
                    if (medusaX >475){
                        medusaX = 475;
                    }
                    batview.setLayoutY(murcielagoy);
                    batview.setLayoutX(murcielagoX);
                    murcielagoy += velocidady;
                    velocidady = 4;
                    
                    if(murcielagoy >=400){
                        murcielagoy = -100;
                        murcielagoX = random.nextInt(450);
                    System.out.println(murcielagoX);
                    } 
                    
                    ballview.setLayoutX(ballX);
                    ballview.setLayoutY(ballY);
                    ballY+= velocidadball;
                    velocidadball = -4;
                    
                    
                    if(ballY <=-10){
                       ballY = 300;
                       
                        root.getChildren().remove(ballview);
                    }
                //Shape rectStick = null;
                //Shape shapeColision = Shape.intersect(arc, rectStick
                //);
                //boolean colisionVacia = shapeColision.getBoundsInLocal().isEmpty();
                
                //if(colisionVacia == false){
                  //  stickCurrentSpeed = -3;
                //}
                //Shape shapeColision = Shape.intersect(murcielago, rectStick
                //);
                 //boolean colisionVacia = shapeColision.getBoundsInLocal().isEmpty();
                
                //if(colisionVacia == false){
                  //  stickCurrentSpeed = -3;
               // }
                     
                        
                    
                };
            };
        
         animationmedusa.start(); 
        scene.setOnKeyPressed((KeyEvent event) -> {
            switch(event.getCode()){
                case RIGHT:
                    movimiento = 10;
                    break;
                case LEFT:
                    movimiento = -10;
                    break;
                case SPACE:
                    ballX = medusaX+75;
                    ballY = 300;
                    root.getChildren().add(ballview);
                    break;
                    
            }
        });
        scene.setOnKeyReleased((KeyEvent event) -> {
            movimiento = 0;
        });
        
    }
   
    /**
     * 
     * @param args the commant line arguments
     */
    public static void main(String[] args) { 
        launch(args);
    } 
} 
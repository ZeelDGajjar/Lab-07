/*
 * Github: https://github.com/ZeelDGajjar/Lab-07.git
 */
package lab.pkg07;

import java.awt.Button;
import javafx.animation.FadeTransition;
import javafx.animation.ParallelTransition;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author 2474008
 */
public class Lab07 extends Application{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Pane root = new Pane() ;
        
        // Buttons
        Button start = new Button("Start");
        Button reset = new Button("Reset");
        Button exit = new Button("Exit");
        
        // Part 1: Animation A: Path animation
        Rectangle rectangle = new Rectangle(50, 50, 50, 50);
        rectangle.setFill(Color.CADETBLUE);
        
        TranslateTransition right = new TranslateTransition(new Duration(2000), rectangle);
        right.setToX(400);
        right.play();
        
        TranslateTransition down = new TranslateTransition(new Duration(2000), rectangle);
        right.setToX(400);
        down.setToY(400);
        down.play();
        
        TranslateTransition left = new TranslateTransition(new Duration(2000), rectangle);
        left.setToX(0);
        down.setToY(400);
        left.play();
        
        TranslateTransition up = new TranslateTransition(new Duration(2000), rectangle);
        up.setToX(0);
        up.setToY(0);
        up.play();
        
        SequentialTransition seq1 = new SequentialTransition(right, down, left, up);
        seq1.play();
        
        // Part 2: Animation B: Sequential animation
        Circle circle = new Circle(250, 350, 25);
        circle.setFill(Color.BLACK);
        
        FadeTransition fade = new FadeTransition(new Duration(2000), circle);
        fade.setAutoReverse(true);
        fade.setFromValue(1.0);
        fade.setToValue(0.5);
        fade.setCycleCount(2);
        
        ScaleTransition scale = new ScaleTransition(new Duration(2000), circle);
        scale.setAutoReverse(true);
        scale.setToX(2.0);
        scale.setToY(2.0);
        
//        RotateTransition rotation = new RotateTransition(new Duration(2000), circle);
//        rotation.setAutoReverse(true);
//        rotation.play();
//        
//        TranslateTransition upCircle = new TranslateTransition(new Duration(2000), circle);
//        upCircle.setAutoReverse(true);
//        upCircle.setToX(100);
//        upCircle.setToY(300);
//        upCircle.play();
        
        SequentialTransition seq2 = new SequentialTransition(fade, scale);
        seq2.play();
        
//        ParallelTransition para = new ParallelTransition(seq1, seq2);
//        para.play();
        
        root.getChildren().addAll(rectangle, circle);
        Scene scene = new Scene(root, 700, 700);
        stage.setScene(scene);
        stage.show();
    }
}

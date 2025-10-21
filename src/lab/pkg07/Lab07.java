/*
 * Github: https://github.com/ZeelDGajjar/Lab-07.git
 */
package lab.pkg07;

import javafx.animation.FadeTransition;
import javafx.animation.ParallelTransition;
import javafx.animation.PathTransition;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import static javafx.application.Platform.exit;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
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
        
        start.setLayoutX(55);
        start.setLayoutY(500);
        reset.setLayoutX(105);
        reset.setLayoutY(500);
        exit.setLayoutX(160);
        exit.setLayoutY(500);
        
        // Part 1: Animation A: Path animation
        Rectangle rectangle = new Rectangle(50, 50, 400, 400);
        rectangle.setFill(Color.WHITE);
        rectangle.setStroke(Color.BLACK);
        
        Rectangle rectangleObj = new Rectangle(50, 50, 50, 50);
        rectangleObj.setFill(Color.CADETBLUE);
        
        PathTransition pathTrans = new PathTransition();
        pathTrans.setDuration(new Duration(16000));
        pathTrans.setPath(rectangle);
        pathTrans.setNode(rectangleObj);
        
        // Part 2: Animation B: Sequential animation
        Ellipse ellipse = new Ellipse(250, 350, 25, 20);
        ellipse.setFill(Color.BLUEVIOLET);
        
        FadeTransition fade = new FadeTransition(new Duration(2000), ellipse);
        fade.setAutoReverse(true);
        fade.setFromValue(1.0);
        fade.setToValue(0.5);
        fade.setCycleCount(2);
        
        ScaleTransition scale = new ScaleTransition(new Duration(2000), ellipse);
        scale.setAutoReverse(true);
        scale.setToX(2.0);
        scale.setToY(2.0);
        
        RotateTransition rotation = new RotateTransition(new Duration(2000), ellipse);
        rotation.setByAngle(360);
        rotation.setAutoReverse(true);
        
        TranslateTransition upCircle = new TranslateTransition(new Duration(2000), ellipse);
        upCircle.setAutoReverse(true);
        upCircle.setToY(-200);
        
        SequentialTransition seq2 = new SequentialTransition(fade, scale, rotation, upCircle);

        ParallelTransition para = new ParallelTransition(pathTrans, seq2);
        
        // Buttons logic 
        start.setOnAction(e -> {
            para.play();
        });
        reset.setOnAction(e -> {
           para.stop();
           para.play();
           para.stop();
        });
        exit.setOnAction(e -> {
            exit();
        });

        root.getChildren().addAll(rectangle, rectangleObj, ellipse, start, reset, exit);
        Scene scene = new Scene(root, 700, 700);
        stage.setScene(scene);
        stage.show();
    }
}

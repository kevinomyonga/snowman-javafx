package com.kevinomyonga.snowman;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.time.Year;

public class SnowmanApplication extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Initialize the pane where the components will be placed
        Pane pane = new Pane();

        // Set the background color using the gradient
        pane.setStyle("-fx-background-color: " + "linear-gradient(from 0% 0% to 0% 100%, #1E90FF, #FFA500);");

        // Lay the components on the canvas
        road(pane);
        trees(pane);
        snowman(pane);
        copyright(pane);

        // Set up the scene and stage
        Scene scene = new Scene(pane, 800, 600);
        primaryStage.setTitle("Snowman Project By Kevin Omyonga");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * Draw the ground and a curved road
     * @param pane: Pane to hold the component(s) created.
     */
    public void road(Pane pane) {
        // Draw the ground
        Rectangle ground = new Rectangle(0, 300, 800, 300);
        ground.setFill(Color.GREEN);
        pane.getChildren().add(ground);

        // Draw the road (curved line)
        QuadCurve road = new QuadCurve(0, 350, 700, 600, 800, 550);
        road.setStroke(Color.GRAY);
        road.setStrokeWidth(70);
        road.setFill(null);
        pane.getChildren().add(road);
    }

    /**
     * Draw the trees by the side of the road alternating between near and far.
     * @param pane: Pane to hold the component(s) created.
     */
    public void trees(Pane pane) {
        for (int i = 0; i < 5; i++) {

            int k = 0;

            if(i % 2 == 0) {
                k = 30;
            }

            // Draw tree trunk
            Rectangle trunk = new Rectangle(180 + (i * 120), 220 + k, 40, 100);
            trunk.setFill(Color.SADDLEBROWN);

            // Draw tree leaves
            Polygon leaves = new Polygon(
                    200 + (i * 120), 50 + k,
                    150 + (i * 120), 220 + k,
                    250 + (i * 120), 220 + k
            );
            leaves.setFill(Color.DARKGREEN);

            pane.getChildren().addAll(trunk, leaves);
        }
    }

    /**
     * Draw the snowman
     * @param pane: Pane to hold the component(s) created.
     */
    public void snowman(Pane pane) {
        arms(pane);
        body(pane);
        eyes(pane);
        nose(pane);
        mouth(pane);
    }

    /**
     * Draw the snowman's body and accessories such as the top hat and buttons
     * @param pane: Pane to hold the component(s) created.
     */
    public void body(Pane pane) {
        // Draw the snowman's body
        Circle bottomCircle = new Circle(300, 420, 55, Color.WHITE);
        Circle middleCircle = new Circle(300, 350, 40, Color.WHITE);
        Circle topCircle = new Circle(300, 295, 25, Color.WHITE);
        pane.getChildren().addAll(bottomCircle, middleCircle, topCircle);

        // Draw buttons on the snowman's torso
        Circle button1 = new Circle(300, 340, 3, Color.BLACK);
        Circle button2 = new Circle(300, 360, 3, Color.BLACK);
        pane.getChildren().addAll(button1, button2);

        // Draw a top hat on the snowman's head
        Rectangle topHatBase = new Rectangle(280, 265, 40, 10);
        Rectangle topHatTop = new Rectangle(285, 245, 30, 20);
        topHatBase.setFill(Color.BLACK);
        topHatTop.setFill(Color.BLACK);
        pane.getChildren().addAll(topHatBase, topHatTop);
    }

    /**
     * Draw the snowman's eyes
     * @param pane: Pane to hold the component(s) created.
     */
    public void eyes(Pane pane) {
        // Draw the snowman's eyes
        Circle leftEye = new Circle(290, 285, 2, Color.BLACK);
        Circle rightEye = new Circle(310, 285, 2, Color.BLACK);
        pane.getChildren().addAll(leftEye, rightEye);
    }

    /**
     * Draw the snowman's nose
     * @param pane: Pane to hold the component(s) created.
     */
    public void nose(Pane pane) {
        // Draw the snowman's nose (as an orange triangle)
        Polygon nose = new Polygon();
        nose.getPoints().addAll(300.0, 290.0,
                300.0, 300.0,
                320.0, 295.0
        );
        nose.setFill(Color.ORANGE);
        pane.getChildren().add(nose);
    }

    /**
     * Draw the snowman's mouth using small circles
     * @param pane: Pane to hold the component(s) created.
     */
    public void mouth(Pane pane) {
        for (int i = 0; i < 5; i++) {
            Circle smileCircle = new Circle(295 + i * 2, 310, 1, Color.BLACK);
            pane.getChildren().add(smileCircle);
        }
    }

    /**
     * Draw the snowman's arms
     * @param pane: Pane to hold the component(s) created.
     */
    public void arms(Pane pane) {
        Line leftArm = new Line(265, 330, 210, 310);
        leftArm.setStrokeWidth(5);
        Line rightArm = new Line(335, 330, 390, 310);
        rightArm.setStrokeWidth(5);
        pane.getChildren().addAll(leftArm, rightArm);
    }

    /**
     * Draw a copyright symbol, the current year and my name at the bottom-left
     * @param pane: Pane to hold the component(s) created.
     */
    public void copyright(Pane pane) {
        Text copyrightText = new Text("© " + Year.now().getValue() + " Kevin Omyonga");
        copyrightText.setFont(Font.font(12));
        copyrightText.setFill(Color.WHITE);
        copyrightText.setLayoutX(10);
        copyrightText.setLayoutY(590);

        pane.getChildren().add(copyrightText);
    }

    public static void main(String[] args) {
        launch();
    }
}

package edu.ntnu.idatt2003.cardgame;

import edu.ntnu.idatt2003.cardgame.models.DeckOfCards;
import edu.ntnu.idatt2003.cardgame.models.HandOfCards;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class CardGameApp extends Application {

    private final DeckOfCards deckOfCards = new DeckOfCards();
    private HandOfCards currentHand;

    private Label handLabel;
    private TextField sumField;
    private TextField heartsField;
    private TextField flushField;
    private TextField queenOfSpadesField;

    @Override
    public void start(Stage stage) {
        BorderPane root = new BorderPane();
        root.setPadding(new Insets(20));

        Label titleLabel = new Label("Card Game");
        titleLabel.setFont(Font.font(22));
        BorderPane.setAlignment(titleLabel, Pos.CENTER);
        root.setTop(titleLabel);

        handLabel = new Label("No cards dealt yet");
        handLabel.setWrapText(true);
        handLabel.setFont(Font.font(20));
        handLabel.setAlignment(Pos.CENTER);

        StackPane handPane = new StackPane(handLabel);
        handPane.setMinSize(550, 320);
        handPane.setStyle("""
                -fx-border-color: black;
                -fx-border-width: 1;
                -fx-padding: 20;
                -fx-background-color: white;
                """);

        Button dealHandButton = new Button("Deal hand");
        dealHandButton.setPrefWidth(140);
        dealHandButton.setPrefHeight(40);

        Button checkHandButton = new Button("Check hand");
        checkHandButton.setPrefWidth(140);
        checkHandButton.setPrefHeight(40);

        VBox buttonBox = new VBox(20, dealHandButton, checkHandButton);
        buttonBox.setAlignment(Pos.CENTER);
        buttonBox.setPadding(new Insets(0, 0, 0, 30));

        BorderPane centerPane = new BorderPane();
        centerPane.setCenter(handPane);
        centerPane.setRight(buttonBox);
        centerPane.setPadding(new Insets(20, 0, 20, 0));

        root.setCenter(centerPane);

        sumField = createReadOnlyTextField();
        heartsField = createReadOnlyTextField();
        flushField = createReadOnlyTextField();
        queenOfSpadesField = createReadOnlyTextField();

        heartsField.setPrefWidth(180);

        GridPane resultGrid = new GridPane();
        resultGrid.setHgap(12);
        resultGrid.setVgap(12);
        resultGrid.setPadding(new Insets(10, 0, 0, 0));

        resultGrid.add(new Label("Sum of the faces:"), 0, 0);
        resultGrid.add(sumField, 1, 0);

        resultGrid.add(new Label("Cards of hearts:"), 2, 0);
        resultGrid.add(heartsField, 3, 0);

        resultGrid.add(new Label("Flush:"), 0, 1);
        resultGrid.add(flushField, 1, 1);

        resultGrid.add(new Label("Queen of spades:"), 2, 1);
        resultGrid.add(queenOfSpadesField, 3, 1);

        root.setBottom(resultGrid);

        dealHandButton.setOnAction(event -> dealHand());
        checkHandButton.setOnAction(event -> checkHand());

        Scene scene = new Scene(root, 900, 550);
        stage.setTitle("Card Game");
        stage.setScene(scene);
        stage.show();
    }


    private TextField createReadOnlyTextField() {
        TextField textField = new TextField();
        textField.setEditable(false);
        textField.setFocusTraversable(false);
        return textField;
    }



    private void dealHand() {
        currentHand = deckOfCards.dealHand(5);
        handLabel.setText(currentHand.toString());

        sumField.clear();
        heartsField.clear();
        flushField.clear();
        queenOfSpadesField.clear();
    }


    private void checkHand() {
        if (currentHand == null) {
            handLabel.setText("Deal a hand first");
            return;
        }

        sumField.setText(String.valueOf(currentHand.sumOfFaces()));
        heartsField.setText(currentHand.heartsAsString());
        flushField.setText(currentHand.hasFlush() ? "Yes" : "No");
        queenOfSpadesField.setText(currentHand.containsQueenOfSpades() ? "Yes" : "No");
    }

    public static void main(String[] args) {
        launch(args);
    }
}
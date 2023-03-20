package com.example.fxproject;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Quiz1 extends Application {

    private Parent createContent(){
        // 위
        VBox vBox = new VBox();
        HBox top = new HBox();

        HBox menuBox = new HBox(50);
        menuBox.setPadding(new Insets(20,20,20,20));
        Label menu = new Label();
        menu.setText("메뉴");
        menuBox.getChildren().add(menu);

        HBox homeBox = new HBox(50);
        Label home = new Label();
        home.setText("홈");
        menuBox.getChildren().add(home);

        HBox loginBox = new HBox(50);
        Label login = new Label();
        login.setText("로그인");
        menuBox.getChildren().add(login);

        top.getChildren().addAll(menuBox,homeBox,loginBox);

        vBox.getChildren().add(top);

        // 중간

        HBox middle = new HBox();

        HBox leftBox = new HBox();
        Button leftBtn = new Button("메뉴 나열");
        leftBox.set
        leftBox.getChildren().add(leftBtn);
//
        HBox middleBox = new HBox();
        Button middleBtn = new Button("내용 들어가는 곳");

        middleBox.getChildren().add(leftBtn);

//
        HBox rightBox = new HBox();
        Button rightBtn = new Button("로그인");
        rightBox.getChildren().add(leftBtn);
//
        middle.getChildren().addAll(leftBox,middleBox,rightBox);
//
        vBox.getChildren().add(middle);

        return vBox;
    }


    @Override
    public void start(Stage stage) throws Exception {
        stage.setScene(new Scene(createContent(),300,300));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

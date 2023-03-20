package com.example.fxproject;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

import java.util.ArrayList;

public class FlowPane01 extends Application {
//    public FlowPane01(){}

    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage stage) throws Exception {
        Button button1 = new Button("버튼입니다");
        Button button2 = new Button("버튼2");
        Button button3 = new Button("버튼3");

        FlowPane flow = new FlowPane();
        ArrayList<Button> buttons = new ArrayList<>();

        // 숫자 깨짐 문제 해
        for(int i = 0;i<15;i++){
            buttons.add(new Button("버튼"+(i+1)));
            flow.getChildren().add(buttons.get(i));
        }

        stage.setScene(new Scene(flow, 200, 100));
        stage.show();
    }
}

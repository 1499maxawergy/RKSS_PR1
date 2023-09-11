package ru.maxawergy.rkss_pr1;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;

public class MainApp extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        VBox root = new VBox();
        root.setPadding(new Insets(10));
        root.setSpacing(10);
        root.setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));
        Scene scene = new Scene(root, 600, 1000);
        stage.setTitle("Milko Maxim IKBO-16-20 | PR1");
        stage.setScene(scene);

        Label infoOf13 = new Label("13. Выяснить, существует ли треугольник с координатами вершин А(x1,y1), В(x2,y2), C(x3,y3).");
        infoOf13.setStyle("-fx-text-fill: white;");
        infoOf13.setWrapText(true);

        HBox aBox = new HBox();
        aBox.setSpacing(10);

        TextField Ax = new TextField();
        Ax.setPromptText("Х1");

        TextField Ay = new TextField();
        Ay.setPromptText("У1");

        aBox.getChildren().addAll(Ax, Ay);

        HBox bBox = new HBox();
        bBox.setSpacing(10);

        TextField Bx = new TextField();
        Bx.setPromptText("Х2");

        TextField By = new TextField();
        By.setPromptText("У2");

        bBox.getChildren().addAll(Bx, By);

        HBox cBox = new HBox();
        cBox.setSpacing(10);

        TextField Cx = new TextField();
        Cx.setPromptText("Х3");

        TextField Cy = new TextField();
        Cy.setPromptText("У3");

        cBox.getChildren().addAll(Cx, Cy);

        Button buttonOf13 = new Button("Выяснить");
        buttonOf13.setStyle("-fx-background-color: #555555; -fx-text-fill: white;");

        Label answerTo13 = new Label();
        answerTo13.setStyle("-fx-text-fill: white;");
        answerTo13.setWrapText(true);

        buttonOf13.setOnAction(event -> {
            try{
                if (bookOfSolution.isTriangleExists(Integer.parseInt(Ax.getText()), Integer.parseInt(Ay.getText()),
                        Integer.parseInt(Bx.getText()), Integer.parseInt(By.getText()), Integer.parseInt(Cx.getText()),
                        Integer.parseInt(Cy.getText()))){
                    answerTo13.setStyle("-fx-text-fill: lime;");
                    answerTo13.setText("Существует");
                } else {
                    answerTo13.setStyle("-fx-text-fill: orange;");
                    answerTo13.setText("Не существует");
                }
            } catch (Exception e){
                answerTo13.setStyle("-fx-text-fill: red;");
                answerTo13.setText("Ошибка выполнения");
            } finally {
                Ax.clear();
                Ay.clear();
                Bx.clear();
                By.clear();
                Cx.clear();
                Cy.clear();
            }
        });


        Label infoOf16 = new Label("16. Даны площадь квадрата S1 и круга S2. Определить поместится ли круг в квадрат и наоборот.");
        infoOf16.setStyle("-fx-text-fill: white;");
        infoOf16.setWrapText(true);

        HBox box16 = new HBox();
        box16.setSpacing(10);

        TextField areaOfSquare = new TextField();
        areaOfSquare.setPromptText("Площадь квадрата");

        TextField areaOfCircle = new TextField();
        areaOfCircle.setPromptText("Площадь круга");

        box16.getChildren().addAll(areaOfSquare, areaOfCircle);

        Label answerTo16 = new Label();
        answerTo16.setStyle("-fx-text-fill: white;");
        answerTo16.setWrapText(true);

        HBox box16SC = new HBox();
        box16SC.setSpacing(10);

        Button buttonSC = new Button("Квадрат в круг");
        buttonSC.setStyle("-fx-background-color: #555555; -fx-text-fill: white;");
        buttonSC.setOnAction(event -> {
            try {
                if (bookOfSolution.canSquareFitInCircle(Double.parseDouble(areaOfSquare.getText()),
                        Double.parseDouble(areaOfCircle.getText()))){
                    answerTo16.setStyle("-fx-text-fill: lime;");
                    answerTo16.setText("Квадрат влезает в круг");
                } else {
                    answerTo16.setStyle("-fx-text-fill: orange;");
                    answerTo16.setText("Квадрат не влезает в круг");
                }
            } catch (Exception e){
                answerTo16.setStyle("-fx-text-fill: red;");
                answerTo16.setText("Ошибка выполнения");
            }
        });

        Button buttonCS = new Button("Круг в квадрат");
        buttonCS.setOnAction(event -> {
            try {
                if (bookOfSolution.canCircleFitInSquare(Double.parseDouble(areaOfSquare.getText()),
                        Double.parseDouble(areaOfCircle.getText()))){
                    answerTo16.setStyle("-fx-text-fill: lime;");
                    answerTo16.setText("Круг влезает в квадрат");
                } else {
                    answerTo16.setStyle("-fx-text-fill: orange;");
                    answerTo16.setText("Круг не влезает в квадрат");
                }
            } catch (Exception e){
                answerTo16.setStyle("-fx-text-fill: red;");
                answerTo16.setText("Ошибка выполнения");
            } finally {
                areaOfCircle.clear();
                areaOfSquare.clear();
            }
        });
        buttonCS.setStyle("-fx-background-color: #555555; -fx-text-fill: white;");

        box16SC.getChildren().addAll(buttonSC, buttonCS);


        Label infoOf19 = new Label("19. Даны действительные числа А,В,С,D. Выяснить, можно ли уместить прямоугольник со сторонами А,В внутри прямоугольника со сторонами C,D.");
        infoOf19.setStyle("-fx-text-fill: white;");
        infoOf19.setWrapText(true);

        HBox box19 = new HBox();
        box19.setSpacing(10);

        TextField a19 = new TextField();
        a19.setPromptText("Длина А");
        TextField b19 = new TextField();
        b19.setPromptText("Длина B");
        TextField c19 = new TextField();
        c19.setPromptText("Длина C");
        TextField d19 = new TextField();
        d19.setPromptText("Длина D");

        box19.getChildren().addAll(a19, b19, c19, d19);

        Label answerTo19 = new Label();
        infoOf19.setWrapText(true);

        Button button19 = new Button("Уместится ли");
        button19.setStyle("-fx-background-color: #555555; -fx-text-fill: white;");
        button19.setOnAction(event -> {
            try{
                if (bookOfSolution.canFitRectangle(Double.parseDouble(a19.getText()),
                        Double.parseDouble(b19.getText()), Double.parseDouble(c19.getText()),
                        Double.parseDouble(d19.getText()))){
                    answerTo19.setStyle("-fx-text-fill: lime;");
                    answerTo19.setText("Уместится");
                } else {
                    answerTo19.setStyle("-fx-text-fill: orange;");
                    answerTo19.setText("Не уместится");
                }
            } catch (Exception e){
                answerTo19.setStyle("-fx-text-fill: red;");
                answerTo19.setText("Ошибка выполнения");
            } finally {
                a19.clear();
                b19.clear();
                c19.clear();
                d19.clear();
            }
        });

        // 19 suda


        Label infoOf22 = new Label("22. Проверить, какие из чисел А,В,С,D не принадлежат интервалу (3,15).");
        infoOf22.setStyle("-fx-text-fill: white;");
        infoOf22.setWrapText(true);

        HBox box22 = new HBox();
        box22.setSpacing(10);

        TextField a22 = new TextField();
        a22.setPromptText("A");
        TextField b22 = new TextField();
        b22.setPromptText("B");
        TextField c22 = new TextField();
        c22.setPromptText("C");
        TextField d22 = new TextField();
        d22.setPromptText("D");

        box22.getChildren().addAll(a22, b22, c22, d22);

        Label answerTo22 = new Label();
        answerTo22.setStyle("-fx-text-fill: white;");
        answerTo22.setWrapText(true);

        Button checkInInterval = new Button("Проверить интервал");
        checkInInterval.setStyle("-fx-background-color: #555555; -fx-text-fill: white;");
        checkInInterval.setOnAction(event -> {
            try{
                if (bookOfSolution.checkInterval(Double.parseDouble(a22.getText()))){
                    answerTo22.setText("Число A входит в интервал");
                } else {
                    answerTo22.setText("Число A не входит в интервал");
                }
                if (bookOfSolution.checkInterval(Double.parseDouble(b22.getText()))){
                    answerTo22.setText(answerTo22.getText() + "\nЧисло B входит в интервал");
                } else {
                    answerTo22.setText(answerTo22.getText() + "\nЧисло B не входит в интервал");
                }
                if (bookOfSolution.checkInterval(Double.parseDouble(c22.getText()))){
                    answerTo22.setText(answerTo22.getText() + "\nЧисло C входит в интервал");
                } else {
                    answerTo22.setText(answerTo22.getText() + "\nЧисло C не входит в интервал");
                }
                if (bookOfSolution.checkInterval(Double.parseDouble(d22.getText()))){
                    answerTo22.setText(answerTo22.getText() + "\nЧисло D входит в интервал");
                } else {
                    answerTo22.setText(answerTo22.getText() + "\nЧисло D не входит в интервал");
                }
            } catch (Exception e){
                answerTo22.setText("Ошибка выполнения");
            } finally {
                a22.clear();
                b22.clear();
                c22.clear();
                d22.clear();
            }
        });

        Label infoOf25 = new Label("25. Выяснить, существует ли треугольник с длинами сторон А,В,С. Если да, то найти его площадь.");
        infoOf25.setStyle("-fx-text-fill: white;");
        infoOf25.setWrapText(true);

        HBox box25 = new HBox();
        box25.setSpacing(10);

        TextField a25 = new TextField();
        a25.setPromptText("Сторона А");
        TextField b25 = new TextField();
        b25.setPromptText("Сторона Б");
        TextField c25 = new TextField();
        c25.setPromptText("Сторона В");

        box25.getChildren().addAll(a25, b25, c25);

        Label answerOf25 = new Label();
        answerOf25.setStyle("-fx-text-fill: white;");
        answerOf25.setWrapText(true);

        Button button25 = new Button("Найти площадь треугольника");
        button25.setStyle("-fx-background-color: #555555; -fx-text-fill: white;");
        button25.setOnAction(event -> {
            try{
                if (bookOfSolution.isTriangleExists(Double.parseDouble(a25.getText()),
                        Double.parseDouble(b25.getText()), Double.parseDouble(c25.getText()))){
                    answerOf25.setText("Площадь треугольника: " + bookOfSolution.calculateTriangleArea(
                            Double.parseDouble(a25.getText()),
                            Double.parseDouble(b25.getText()), Double.parseDouble(c25.getText())
                    ));
                } else {
                    answerOf25.setText("Треугольника с данными сторонами не существует");
                }
            } catch (Exception e){
                answerOf25.setText("Ошибка выполнения");
            } finally {
                a25.clear();
                b25.clear();
                c25.clear();
            }
        });



        root.getChildren().addAll(infoOf13, aBox, bBox, cBox, buttonOf13, answerTo13, infoOf16, box16, box16SC, answerTo16,infoOf19, box19, button19, answerTo19, infoOf22, box22, checkInInterval, answerTo22, infoOf25, box25, button25, answerOf25);

        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}